package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.androidguide.R;
import com.example.items.MyListDiseasesItem;
import com.example.items.MyListMedicineTraditionalItem;
import com.example.items.MyListPharmaceuticalItem;
import com.example.model.TraditionalModel;
import com.example.view.MyListMedicineTraditionalItemViewHolder;
import com.example.view.MyListPharmaceuticalItemViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

@SuppressWarnings("unused")
public class CustomListMedicineTraditional extends RecyclerView.Adapter<MyListMedicineTraditionalItemViewHolder>{
	

	List<TraditionalModel> items;

	public CustomListMedicineTraditional( List<TraditionalModel> items) {
		this.items = items;}

	@Override
	public MyListMedicineTraditionalItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.custom_listview_listmedicinetraditional, parent, false);
		return new MyListMedicineTraditionalItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(MyListMedicineTraditionalItemViewHolder holder, int position) {
		TraditionalModel item = items.get(position);
		holder.txt.setText(item.getName());
	}

	@Override
	public int getItemCount() {
		if (items != null)
			return  items.size();
		return 0;
	}
	
}

