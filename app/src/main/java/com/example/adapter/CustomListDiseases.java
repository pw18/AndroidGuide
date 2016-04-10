package com.example.adapter;

import java.util.ArrayList;

import com.example.androidguide.R;
import com.example.items.MyListDiseasesItem;
import com.example.items.MyListMenuItem;
import com.example.view.MyListDiseasesItemViewHolder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.style.SuperscriptSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

@SuppressWarnings("unused")
public class CustomListDiseases extends RecyclerView.Adapter<MyListDiseasesItemViewHolder>{

	ArrayList<MyListDiseasesItem> items;

	public CustomListDiseases(ArrayList<MyListDiseasesItem> items){
		this.items = items;
	}

	@Override
	public MyListDiseasesItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.custom_listview_listdiseases, parent, false);
		return new MyListDiseasesItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(MyListDiseasesItemViewHolder holder, int position) {
		MyListDiseasesItem item = items.get(position);
		holder.txt.setText(item.getText());
	}

	@Override
	public int getItemCount() {
		if(items != null)
			return items.size();
		return 0;
	}
}
