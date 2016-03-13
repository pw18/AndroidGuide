package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidguide.R;
import com.example.items.MyListDiseasesItem;
import com.example.items.MyListMenuItem;
import com.example.items.MyListPharmaceuticalItem;

@SuppressWarnings("unused")
public class CustomListPharmaceutical extends ArrayAdapter<MyListPharmaceuticalItem>{
		Context context;
		ArrayList<MyListPharmaceuticalItem> item;

		public CustomListPharmaceutical(Context context, int resource, ArrayList<MyListPharmaceuticalItem> item) {
			super(context, resource, item);
			this.item = item;
			this.context = context;
		}
		
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				
				if (convertView == null){
					LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					convertView = inflater.inflate(R.layout.custom_listview_listpharmaceutical,null);
				}
				
				TextView _name = (TextView) convertView.findViewById(R.id.textView_listpharmaceutical);
				
				
				MyListPharmaceuticalItem data = item.get(position);
				_name.setText(data.getText());
				
				 
				return convertView;
}
	}
