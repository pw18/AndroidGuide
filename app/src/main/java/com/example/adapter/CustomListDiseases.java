package com.example.adapter;

import java.util.ArrayList;

import com.example.androidguide.R;
import com.example.items.MyListDiseasesItem;
import com.example.items.MyListMenuItem;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.style.SuperscriptSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

@SuppressWarnings("unused")
public class CustomListDiseases extends ArrayAdapter<MyListDiseasesItem>{
	
	Context context;
	ArrayList<MyListDiseasesItem>item;

	public CustomListDiseases(Context context, int resource, ArrayList<MyListDiseasesItem> item) {
		super(context, resource, item);
		this.item = item;
		this.context = context;

	}
	
	@Override
	public View getView (int position, View convertView, ViewGroup parent) {
		
		if (convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.custom_listview_listdiseases,null);
		}
		
		TextView _name = (TextView) convertView.findViewById(R.id.textView_listview_listdiseases);
		
		MyListDiseasesItem data = item.get(position);
		_name.setText(data.getText());
		
		return convertView;
	
}
	}
