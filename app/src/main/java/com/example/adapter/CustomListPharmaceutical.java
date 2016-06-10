package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidguide.R;
import com.example.items.MyListPharmaceuticalItem;
import com.example.model.PhamaceuticalModel;
import com.example.view.MyListPharmaceuticalItemViewHolder;

@SuppressWarnings("unused")
public class CustomListPharmaceutical extends RecyclerView.Adapter<MyListPharmaceuticalItemViewHolder> {

		List<PhamaceuticalModel> items;

		public CustomListPharmaceutical(List<PhamaceuticalModel> items) {
			this.items = items;}

	@Override
	public MyListPharmaceuticalItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.custom_listview_listpharmaceutical, parent, false);
		return new MyListPharmaceuticalItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(MyListPharmaceuticalItemViewHolder holder, int position) {
		PhamaceuticalModel item = items.get(position);
		holder.txt.setText(item.getName());
	}

	@Override
	public int getItemCount() {
		if (items != null)
			return  items.size();
		return 0;
	}
	public void setFilter(List<PhamaceuticalModel> itemsmodel){
		items = new ArrayList<>();
		items.addAll(itemsmodel);
		notifyDataSetChanged();
	}
}

