package com.example.adapter;

import java.util.ArrayList;

import com.example.androidguide.R;
import com.example.items.MyListDiseasesItem;
import com.example.items.MyListMedicineTraditionalItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

@SuppressWarnings("unused")
public class CustomListMedicineTraditional extends ArrayAdapter<MyListMedicineTraditionalItem> {
	
	Context context;
	ArrayList<MyListMedicineTraditionalItem>item;
	
	public CustomListMedicineTraditional(Context context,int resource, ArrayList<MyListMedicineTraditionalItem> item){
		super(context, resource, item);
		this.item = item;
		this.context = context;
	}
	
	@Override
	public View getView (int position, View convertView, ViewGroup parent) {
	
	if (convertView == null){
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.custom_listview_listmedicinetraditional,null);
	}
	
	TextView _name = (TextView) convertView.findViewById(R.id.textView_listmedicinetradition);
	
	MyListMedicineTraditionalItem data = item.get(position);
	_name.setText(data.getText());
	
	return convertView;

}
	
}

