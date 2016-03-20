package com.example.androidguide;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutUsActivity extends Fragment {

    public static AboutUsActivity newInstance() {
        AboutUsActivity fragment = new AboutUsActivity();

        return fragment;
    }

    public AboutUsActivity() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_about_us, container, false);

        return view;
    }

}
