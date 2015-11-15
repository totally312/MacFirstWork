package com.example.huangst.macfirstwork;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by huangst on 15/10/4.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resoureseid;

    private LayoutInflater layout;


    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context,textViewResourceId,objects);
        layout=LayoutInflater.from(getContext());
        resoureseid=textViewResourceId;

    }
    public View getView(int position,View convertView,ViewGroup parent){
        final Fruit fruit = MyListViewActivity.fruitList.get(position);//获取当前项的Fruit实例
        final ViewHolder viewHolder;

        if(convertView == null) {
            convertView = layout.inflate(resoureseid, null);
            viewHolder = new ViewHolder();
            viewHolder.fruitimage = (ImageView) convertView.findViewById(R.id.imageid);
            viewHolder.fruitname = (TextView) convertView.findViewById(R.id.name);
            viewHolder.fruitbutton = (Button) convertView.findViewById(R.id.buttonid);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.fruitname.setText(fruit.getname());
        viewHolder.fruitimage.setImageResource(fruit.getImageid());
        viewHolder.fruitbutton.setText(fruit.getButtonname());

        viewHolder.fruitname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), fruit.getname(), Toast.LENGTH_LONG).show();
            }
        });

        viewHolder.fruitimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),fruit.getname(),Toast.LENGTH_LONG).show();
            }
        });



        viewHolder.fruitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.fruitbutton.getText() == "apple") {
                    Toast.makeText(getContext(), "apple", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "banana", Toast.LENGTH_LONG).show();
                }
            }
        });


        return convertView;

    }


    class ViewHolder{
        ImageView fruitimage;
        TextView fruitname;
        Button fruitbutton;
    }
}
