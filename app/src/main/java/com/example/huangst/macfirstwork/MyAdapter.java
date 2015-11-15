package com.example.huangst.macfirstwork;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by huangst on 15/10/20.
 */
class MyAdapter extends RecyclerView.Adapter<MyAdapter.Viewholder> {





    private Fruit[] f ;

    public MyAdapter(Fruit[] fruit){
        super();
        f = fruit;

    }

    class Viewholder extends RecyclerView.ViewHolder {

        View root;
        TextView name;
        ImageView image;
        Button button;

        public Viewholder(View root) {
            super(root);

            name=(TextView)root.findViewById(R.id.name);
            image=(ImageView) root.findViewById(R.id.imageid);
            button=(Button)root.findViewById(R.id.buttonid);




        }

        public Button getButton() {
            return button;
        }

        public ImageView getImage() {
            return image;
        }

        public TextView getName() {
            return name;
        }
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup viewGroup, int i) {

//        View view = View.inflate(viewGroup.getContext(), android.R.layout.simple_list_item_1, null);
//        15	// 创建一个ViewHolder
//        16	ViewHolder holder = new ViewHolder(view);
//        17	return holder;
//        return new Viewholder(new TextView(viewGroup.getContext()));

        View view = View.inflate(viewGroup.getContext(), R.layout.mylistviewitem, null);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;

//        return new Viewholder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mylistviewitem,null));
    }


    public void onBindViewHolder(Viewholder viewHolder, int i) {
        Viewholder vh = (Viewholder) viewHolder;

        vh.name.setText(f[i].getname());
        vh.getImage().setImageResource(f[i].getImageid());
        vh.getButton().setText(f[i].getButtonname());

    }

    @Override
    public int getItemCount() {
        return f.length;

        //子对象的数量
    }

}
