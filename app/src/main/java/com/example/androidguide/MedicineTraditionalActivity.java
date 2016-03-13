package com.example.androidguide;

import java.util.ArrayList;

import com.example.adapter.CustomListMedicineTraditional;
import com.example.items.MyListMedicineTraditionalItem;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MedicineTraditionalActivity extends ActionBarActivity {
	
	ArrayAdapter<MyListMedicineTraditionalItem> adapter;
	ListView lv_menu;
	EditText et_search;
	
	String[] txt = {"กระเพาะปัสสาวะอักเสบ","กรดไหลย้อน","กลาก","เกลื้อน","กุ้งยิง","ไข้หวัด","คลื่นไส้อาเจียน","เชื้อราที่ง่ามนิ้วเท้า","เชื้อราที่เล็บ","ตกขาว","ท้องผูก","ท้องร่วง","ปวดประจำเดือน","ปวดฟัน"
			,"ปวดศีรษะไมเกรน","แผลพุพอง","ผื่นแพ้","แผลร้อนใน","ผิวหนังอักเสบจากพิษแมลง","แผลอักเสบติดเชื้อ","แผลในกระเพาะอาหาร","พยาธิ","เริม","เลือดกำเดาไหล","ลมพิษ","เลือดออกตามไรฟัน","เวียนศีรษะ"
			,"หัด","หัดเยอรมัน	","หิด"};
	
	ArrayList<MyListMedicineTraditionalItem> items;
	ArrayList<MyListMedicineTraditionalItem> n_item;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medicine_traditional);
		setWidget();
		items = new ArrayList<MyListMedicineTraditionalItem>();
		n_item = new ArrayList<MyListMedicineTraditionalItem>();
		
		
		for(int i=0; i<txt.length; i++){
			MyListMedicineTraditionalItem data = new MyListMedicineTraditionalItem();
			data.setText(txt[i]);
			items.add(data);
			n_item.add(data);

		}
		
		CustomListMedicineTraditional custom_adapter = new CustomListMedicineTraditional(getApplicationContext(), R.layout.activity_medicine_traditional, items);
		adapter = custom_adapter;
		lv_menu.setAdapter(custom_adapter);
		
		et_search.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			
				String search = et_search.getText().toString();
				int txtlength = search.length();
				if(n_item != null){
					if(txtlength > 0){
						ArrayList<MyListMedicineTraditionalItem> appListSort = new ArrayList<MyListMedicineTraditionalItem>();
			
						for(int i=0; i<n_item.size(); i++){
							String sApp = n_item.get(i).getText();
							if(txtlength <= sApp.length()){
								if(search.equalsIgnoreCase((String) sApp.subSequence(0, txtlength))){
									appListSort.add(n_item.get(i));
								}
							}
						}
						items.clear();
						for(int i=0; i<appListSort.size(); i++){
							items.add(appListSort.get(i));
						}
						
					}else{
						items.clear();
						for(int i=0; i<n_item.size(); i++){
							items.add(n_item.get(i));
						}
					}
					adapter.notifyDataSetChanged();
				}
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		
		});
		
		lv_menu.setOnItemClickListener(new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//Toast.makeText(getApplicationContext(), "List : "+position, Toast.LENGTH_LONG).show();
				Intent intent = new Intent(getApplicationContext(), Data_medicinetraditionalActivity.class);
				intent.putExtra("text1", txt[position]);
				intent.putExtra("text2", "position : "+position);
				startActivity(intent);
				
				}
			});
	}
	
	private void setWidget() {
		// TODO Auto-generated method stub
		lv_menu = (ListView) findViewById(R.id.listView_medicine_traditional_listdiseases);
		et_search = (EditText) findViewById(R.id.editText_search_medicinetraditional);
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
