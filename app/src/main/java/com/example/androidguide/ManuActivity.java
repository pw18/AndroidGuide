package com.example.androidguide;
import java.util.ArrayList;
import com.example.adapter.CustomListMenu;
import com.example.items.MyListMenuItem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ManuActivity extends AppCompatActivity {
	ArrayAdapter<MyListMenuItem> adapter;
	ListView lv_menu;
	
//	int[] _img = {R.drawable.diedeases,R.drawable.pills5,R.drawable.tree,R.drawable.first_aid_kit,R.drawable.hotpitel,R.drawable.information};
int[] _img = {android.R.drawable.ic_input_add,
		android.R.drawable.ic_input_add,
		android.R.drawable.ic_input_add,
		android.R.drawable.ic_input_add,
		android.R.drawable.ic_input_add,
		android.R.drawable.ic_input_add};

	String[] txt = {"test1","test2","test3","test4","test5"};
	ArrayList<MyListMenuItem> items;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manu);
		setWidget();
		items = new ArrayList<MyListMenuItem>();
		
		for(int i=0; i<txt.length; i++){
			MyListMenuItem data = new MyListMenuItem();
			data.setImg(_img[i]);
			data.setText(txt[i]);
			items.add(data);
		}
		CustomListMenu custom_adapter = new CustomListMenu(getApplicationContext(), R.layout.activity_manu, items);
		
		lv_menu.setAdapter(custom_adapter);
		
		lv_menu.setOnItemClickListener(new OnItemClickListener(){

				
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = null;
				switch(position){
					case 0:
						intent = new Intent(ManuActivity.this, ListDiseasesActivity.class);
						break;
					case 1:
						intent = new Intent(ManuActivity.this, PharmaceuticalActivity.class);
						break;
					case 2:
						
						intent = new Intent(ManuActivity.this, MedicineTraditionalActivity.class);
						break;
					case 3:
						intent = new Intent(ManuActivity.this, AIDActivity.class);
						break;
					case 4:
						intent = new Intent(ManuActivity.this, HospitalActivity.class);
						break;
					case 5:
						intent = new Intent(ManuActivity.this, AboutUsActivity.class);
						break;
				}
				startActivity(intent);
			}
			
		});

	}
	
	//view matching
	private void setWidget(){
		lv_menu = (ListView) findViewById(R.id.listView1_menu_listmenu);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manu, menu);
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
