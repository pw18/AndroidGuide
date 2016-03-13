package com.example.adapter;
import java.util.ArrayList;

import com.example.androidguide.R;
import com.example.items.MyListMenuItem;

import android.content.Context;
import android.media.Image;
import android.provider.Telephony.Sms.Conversations;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressWarnings("unused")
public class CustomListMenu extends ArrayAdapter<MyListMenuItem>{
	
	Context context;
	ArrayList<MyListMenuItem> item;

	public CustomListMenu(Context context, int resource, ArrayList<MyListMenuItem> item) {
		super(context, resource, item);
		this.item = item;
		this.context = context;
	
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.custom_listview_menu_listmenu,null);
		}
		
		TextView _name = (TextView) convertView.findViewById(R.id.textView_title_listmenu);
		ImageView _image = (ImageView) convertView.findViewById(R.id.imageView_listmenu);
		
		MyListMenuItem data = item.get(position);
		_name.setText(data.getText());
		_image.setImageDrawable(getContext().getResources().getDrawable(data.getImg()));
		
		 
		return convertView;
		
	}

}
