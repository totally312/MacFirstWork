package com.example.huangst.macfirstwork;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by huangst on 15/10/14.
 */
public class NotificationTest extends Activity {

    static final int TAKE_PHOTO = 1;
    static final int CROP_PHOTO = 2;

    private Uri imageUri;

    private ImageView picture;

    protected void onCreate(Bundle saveInstancestated){
        super.onCreate(saveInstancestated);
        setContentView(R.layout.notification);

        Button sendnotification = (Button)findViewById(R.id.sendnotice);
        sendnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                Notification notification;

                Notification.Builder builder = new Notification.Builder(NotificationTest.this);
//                builder.setTicker("显示于屏幕顶端状态栏的文本");
//                builder.setSmallIcon(R.drawable.apple);

                Intent i = new Intent(NotificationTest.this, ListViewActivity.class);
//该标志位表示如果Intent要启动的Activity在栈顶，则无须创建新的实例
                i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);


                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationTest.this, 100, i, PendingIntent.FLAG_UPDATE_CURRENT);

//                Uri soundUri = Uri.fromFile(new File("/system/storage/sdcard0/kugou/download/蔡依林-日不落.mp3"));




                notification = builder.setContentIntent(pendingIntent).setContentTitle("title").setContentText("text").setTicker("top message").setSmallIcon(R.drawable.apple).build();

//                notification.sound=soundUri;
//                long[] vibrates = {0,3000,1000,1000};
//                notification.vibrate=vibrates;

                notification.defaults = Notification.DEFAULT_ALL;
                manager.notify(1,notification);


            }
        });

        picture = (ImageView)findViewById(R.id.picture);
        Button takephoto = (Button)findViewById(R.id.takephoto);
        takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                File outputImage = new File(Environment.getExternalStorageDirectory(),"output_image.jpg");

                try{
                    if(outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }

                imageUri = Uri.fromFile(outputImage);
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,TAKE_PHOTO);
            }
        });
    }


    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case TAKE_PHOTO:
                if(resultCode ==RESULT_OK){
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri,"image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                    startActivityForResult(intent,CROP_PHOTO);
                }
                break;
            case CROP_PHOTO:
                if(resultCode == RESULT_OK){
                    try{
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }
}
