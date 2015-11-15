package com.example.huangst.macfirstwork;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;



public class BlankFragment extends Fragment {



    public BlankFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.fragment_blank, container, false);
//
//        ScaleAnimation sa = new ScaleAnimation(0,1,0,1);
//        sa.setDuration(5000);
//        LayoutAnimationController lac=new LayoutAnimationController(sa,0.5f);
//
//        rootView.setLayoutAnimation(lac);


        return rootView;
    }







}
