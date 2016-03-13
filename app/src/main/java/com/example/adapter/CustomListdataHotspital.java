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
import com.example.items.MyListMenuItem;
import com.example.items.MyListdataHospital;

@SuppressWarnings("unused")
public class CustomListdataHotspital extends ArrayAdapter<MyListdataHospital> {
	
	Context context;
	ArrayList<MyListdataHospital> item;

	public CustomListdataHotspital(Context context, int resource, ArrayList<MyListdataHospital> item) {
		super(context, resource, item);
		this.item = item;
		this.context = context;

}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.custom_listview_listhospital,null);
		}
		
		TextView _name = (TextView) convertView.findViewById(R.id.textView_namehospital);
		TextView _Address =(TextView) convertView.findViewById(R.id.textView_addresshospital);
		TextView _Phon =(TextView) convertView.findViewById(R.id.textView_phonhospital);
		ImageView _image = (ImageView) convertView.findViewById(R.id.imageView_iconhospital);
		
		MyListdataHospital data = item.get(position);
		_name.setText(data.getText());
		_image.setImageDrawable(getContext().getResources().getDrawable(data.getImg()));
		
		 
		return convertView;
		
	}
}