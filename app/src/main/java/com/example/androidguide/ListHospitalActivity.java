package com.example.androidguide;

import java.util.ArrayList;

import com.example.adapter.CustomListdataHotspital;
import com.example.items.MyListdataHospital;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListHospitalActivity extends AppCompatActivity {
	
	ArrayAdapter<MyListdataHospital> adapter;
	ListView lv_menu;
	
	
	int[]_img ={android.R.drawable.ic_input_add};
	String[] txt = {"test1","test2","test3"};
	
	ArrayList<MyListdataHospital> items;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_hospital);
		setWidget();
		items = new ArrayList<MyListdataHospital>();

		for(int i=0; i<txt.length; i++){
			MyListdataHospital data = new MyListdataHospital();
			data.setImg(_img[i]);
			data.setText(txt[i]);
			items.add(data);
	}

		CustomListdataHotspital custom_adapter = new CustomListdataHotspital(getApplicationContext(), R.layout.activity_list_hospital, items);
		
		lv_menu.setAdapter(custom_adapter);
	}

	private void setWidget() {
		// TODO Auto-generated method stub
		lv_menu = (ListView) findViewById(R.id.listView_listhospital);
		
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_hospital, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
