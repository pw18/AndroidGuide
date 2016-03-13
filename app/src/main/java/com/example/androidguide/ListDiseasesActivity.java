package com.example.androidguide;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.adapter.CustomListDiseases;
import com.example.controller.MyWebService;
import com.example.controller.MyWebServiceListener;
import com.example.items.MyListDiseasesItem;

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

public class ListDiseasesActivity extends ActionBarActivity {

	ArrayAdapter<MyListDiseasesItem> adapter;
	ListView lv_menu;
	EditText et_search;

	String[] txt = { "กระเพาะปัสสาวะอักเสบ", "กรดไหลย้อน", "กลาก", "เกลื้อน",
			"กุ้งยิง", "ไข้หวัด", "คลื่นไส้อาเจียน", "เชื้อราที่ง่ามนิ้วเท้า",
			"เชื้อราที่เล็บ", "ตกขาว", "ท้องผูก", "ท้องร่วง", "ปวดประจำเดือน",
			"ปวดฟัน", "ปวดศีรษะไมเกรน", "แผลพุพอง", "ผื่นแพ้", "แผลร้อนใน",
			"ผิวหนังอักเสบจากพิษแมลง", "แผลอักเสบติดเชื้อ",
			"แผลในกระเพาะอาหาร", "พยาธิ", "เริม", "เลือดกำเดาไหล", "ลมพิษ",
			"เลือดออกตามไรฟัน", "เวียนศีรษะ", "หัด", "หัดเยอรมัน	", "หิด" };
	
	String url = "http://192.168.1.134/services/diseases.php";

	ArrayList<MyListDiseasesItem> items;
	ArrayList<MyListDiseasesItem> n_item;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_diseases);
		setWidget();
		items = new ArrayList<MyListDiseasesItem>();
		n_item = new ArrayList<MyListDiseasesItem>();
		
		MyWebServiceListener listener = new MyWebServiceListener() {
			
			@Override
			public void myWebServiceOK(String result) throws Exception {
				if(result != null && !"".equals(result)){
					JSONArray jsonArray = new JSONArray(result);
					if(jsonArray != null && jsonArray.length() != 0){
						for(int i=0; i<jsonArray.length(); i++){
							
						}
					}
				}
			}
			
			@Override
			public void myWebServiceFailed() {
				
			}
		};
		
		new MyWebService(ListDiseasesActivity.this, listener, "GET", url).execute();

		for (int i = 0; i < txt.length; i++) {
			MyListDiseasesItem data = new MyListDiseasesItem();
			data.setText(txt[i]);
			items.add(data);
			n_item.add(data);

		}

		CustomListDiseases custom_adapter = new CustomListDiseases(
				getApplicationContext(), R.layout.activity_list_diseases, items);
		adapter = custom_adapter;
		lv_menu.setAdapter(custom_adapter);

		et_search.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				String search = et_search.getText().toString();
				int txtlength = search.length();
				if (n_item != null) {
					if (txtlength > 0) {
						ArrayList<MyListDiseasesItem> appListSort = new ArrayList<MyListDiseasesItem>();

						for (int i = 0; i < n_item.size(); i++) {
							String sApp = n_item.get(i).getText();
							if (txtlength <= sApp.length()) {
								if (search.equalsIgnoreCase((String) sApp
										.subSequence(0, txtlength))) {
									appListSort.add(n_item.get(i));
								}
							}
						}

						items.clear();
						for (int i = 0; i < appListSort.size(); i++) {
							items.add(appListSort.get(i));
						}

					} else {
						items.clear();
						for (int i = 0; i < n_item.size(); i++) {
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
				// Toast.makeText(getApplicationContext(), "List : "+position,
				// Toast.LENGTH_LONG).show();
				Intent intent = new Intent(getApplicationContext(),
						Data_diseasesActivity.class);
				intent.putExtra("text1", items.get(position).getText());
				intent.putExtra("text2", "position : " + position);
				startActivity(intent);

			}
		});
	}

	private void setWidget() {
		// TODO Auto-generated method stub
		lv_menu = (ListView) findViewById(R.id.listView_diseases_listdiseases);
		et_search = (EditText) findViewById(R.id.editText_search_diseases);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_diseases, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			onBackPressed();
		}
		return super.onOptionsItemSelected(item);
	}
}
