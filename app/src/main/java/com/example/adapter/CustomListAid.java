package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.androidguide.R;
import com.example.items.MyListAid;



public class CustomListAid extends ArrayAdapter<MyListAid> {
	Context context;
	ArrayList<MyListAid>item;

	public CustomListAid(Context context, int resource, ArrayList<MyListAid> item) {
		super(context, resource, item);
		this.item = item;
		this.context = context;
		// TODO Auto-generated constructor stub
	}
	
	public View getView (int position, View convertView, ViewGroup parent) {
		
		if (convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.custom_listview_listaid,null);
	}
		
TextView _name = (TextView) convertView.findViewById(R.id.textView_listview_listaid);
		
		MyListAid data = item.get(position);
		_name.setText(data.getText());
		
		return convertView;
}
	}
