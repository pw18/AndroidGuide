package com.example.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.androidguide.R;

/**
 * Created by Administrator on 4/10/2016.
 */
public class MyListDiseasesItemViewHolder extends RecyclerView.ViewHolder {

    public TextView txt;

    public MyListDiseasesItemViewHolder(View itemView) {
        super(itemView);
        txt = (TextView) itemView.findViewById(R.id.textView_listview_listdiseases);
    }
}
