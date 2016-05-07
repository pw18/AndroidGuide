package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.androidguide.R;
import com.example.items.MyListAid;
import com.example.items.MyListMedicineTraditionalItem;
import com.example.model.AidModel;
import com.example.view.MyListAidItemViewHolder;
import com.example.view.MyListMedicineTraditionalItemViewHolder;


public class CustomListAid extends RecyclerView.Adapter<MyListAidItemViewHolder> {


	List<AidModel> items;

	public CustomListAid( List<AidModel> items) { this.items = items;}

	@Override
	public MyListAidItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.custom_listview_listaid, parent, false);
		return new MyListAidItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(MyListAidItemViewHolder holder, int position) {
		AidModel item = items.get(position);
		holder.txt.setText(item.getName());
	}

	@Override
	public int getItemCount() {
		if (items != null)
			return  items.size();
		return 0;
	}

}
