package com.example.adapter;

import java.util.ArrayList;

import com.example.androidguide.R;
import com.example.items.MyListDiseasesItem;
import com.example.items.MyListMedicineTraditionalItem;
import com.example.items.MyListPharmaceuticalItem;
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
	
//	Context context;
	ArrayList<MyListMedicineTraditionalItem>items;

	public CustomListMedicineTraditional( ArrayList<MyListMedicineTraditionalItem> items) { this.items = items;}

	@Override
	public MyListMedicineTraditionalItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.custom_listview_listmedicinetraditional, parent, false);
		return new MyListMedicineTraditionalItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(MyListMedicineTraditionalItemViewHolder holder, int position) {
		MyListMedicineTraditionalItem item = items.get(position);
		holder.txt.setText(item.getText());
	}

	@Override
	public int getItemCount() {
		if (items != null)
			return  items.size();
		return 0;
	}
	
}

