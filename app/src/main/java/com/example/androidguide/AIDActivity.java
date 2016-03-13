package com.example.androidguide;

import java.util.ArrayList;

import com.example.adapter.CustomListAid;
import com.example.items.MyListAid;

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

public class AIDActivity extends ActionBarActivity {
	
	ArrayAdapter<MyListAid> adapter;
	ListView lv_menu;
	EditText et_search;
	
//	String[] txt = {"�����л�������ѡ�ʺ","�ô�����͹","��ҡ","����͹","����ԧ","����Ѵ","�����������¹","�����ҷ������������","�����ҷ�����","�����","��ͧ�١","��ͧ��ǧ","�Ǵ��Ш���͹","�Ǵ�ѹ"
//			,"�Ǵ��������ù","�žؾͧ","�����","����͹�","���˹ѧ�ѡ�ʺ�ҡ�����ŧ","���ѡ�ʺ�Դ����","��㹡����������","��Ҹ�","����","���ʹ�������","�����","���ʹ�͡����ÿѹ","���¹�����"
//			,"�Ѵ","�Ѵ�����ѹ	","�Դ"};
	String[] txt = {"test1","test2","test3","test4"};
	
	ArrayList<MyListAid> items;
	ArrayList<MyListAid> n_item;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aid);
		setWidget();
		
		items = new ArrayList<MyListAid>();
		n_item = new ArrayList<MyListAid>();
		
		for(int i=0; i<txt.length; i++){
			MyListAid data = new MyListAid();
			data.setText(txt[i]);
			items.add(data);
			n_item.add(data);
			
		}
		
		CustomListAid custom_adapter = new CustomListAid(getApplicationContext(), R.layout.activity_aid, items);
		adapter = custom_adapter;
		lv_menu.setAdapter(custom_adapter);
		
		et_search.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			
				String search = et_search.getText().toString();
				int txtlength = search.length();
				if(n_item != null){
					if(txtlength > 0){
						ArrayList<MyListAid> appListSort = new ArrayList<MyListAid>();
			
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
				Intent intent = new Intent(getApplicationContext(), Data_aidActivity.class);
				intent.putExtra("text1", txt[position]);
				intent.putExtra("text2", "position : "+position);
				startActivity(intent);
				
				}
			});
	}
	
	private void setWidget() {
		// TODO Auto-generated method stub
		lv_menu = (ListView) findViewById(R.id.listView_listaid);
		et_search = (EditText) findViewById(R.id.editText_search_aid);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aid, menu);
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
