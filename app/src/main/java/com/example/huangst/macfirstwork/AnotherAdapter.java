package com.example.huangst.macfirstwork;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by huangst on 15/10/22.
 */
public class AnotherAdapter extends RecyclerView.Adapter {

    private List<String> zimu;
    public AnotherAdapter(List<String> zimu){
        this.zimu=zimu;
    }
    class Holder extends RecyclerView.ViewHolder{
        TextView textView;
        public Holder(View view){
            super(view);
            textView= (TextView) view.findViewById(R.id.zimu);
        }
    }


    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.anotherrecyclerviewitem,parent,false);



        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder hr = (AnotherAdapter.Holder) holder;

        hr.textView.setText(zimu.get(position) );

    }

    @Override
    public int getItemCount() {
        return zimu.size();
    }
}
