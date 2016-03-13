package com.example.androidguide;

import java.util.ArrayList;

import com.example.items.MyListHospital;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Spinner;
import android.widget.Toast;

public class HospitalActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
	
	ArrayAdapter<MyListHospital> adapter;
	
	private Spinner Realm;
	private Spinner Bkk;
	private Spinner North;
	private Spinner South;
	private Spinner East;
	private Spinner West;
	private Spinner NorthEast;
	
	String[] txt_Realm = {"�������","�����ҹ�","��طû�ҡ��"};
	
	String[] txt_Bkk = {"��ا෾��ҹ��","��ᾧྪ�","��¹ҷ","��û��","������ä�","��ù�¡","�ԨԵ�","��ɳ��š","ྪú�ó�","ž����",
						"��ط�ʧ����","��ط��Ҥ�","��к���","�ԧ�����","��⢷��","�ؾ�ú���","��ظ��","��ҧ�ͧ","ͷ�¸ҹ�"};
	
	String[] txt_North = {"��§���","��§����","��ҹ","�����","���","�����ͧ�͹","�ӻҧ","�Ӿٹ","�صôԵ��"};
	
	String[] txt_South = {"��к��","�����","��ѧ","�����ո����Ҫ","��Ҹ����","�ѵ�ҹ�","�ѧ��","�ѷ�ا","����","����","�йͧ","ʧ���","ʵ��","����ɯ�ҹ�"};
	
	String[] txt_East = {"�ѹ�����","���ԧ���","�ź���","��Ҵ","��Ҩչ����","���ͧ","������"};
	
	String[] txt_West = {"��í������","�ҡ","��ШǺ���բѹ��","ྪú���","�Ҫ����"};
	
	String[] txt_NorthEast = {"����Թ���","�͹��","�������","��þ��","����Ҫ����","���������","�֧���","�����ä���","�ء�����","��ʸ�","�������","���","�������",
						"ʡŹ��","���Թ���","˹ͧ���","˹ͧ�������","�ӹҨ��ԭ","�شøҹ�","�غ��Ҫ�ҹ�"};
	
	
	ArrayList<MyListHospital> items;

	//test commit git

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hospital);
	
			Realm = (Spinner) findViewById(R.id.spinner_hosrealm);
			Bkk = (Spinner) findViewById(R.id.spinner_hosbkk);
			North = (Spinner) findViewById(R.id.spinner_hosnorth);
			South = (Spinner) findViewById(R.id.spinner_hossouth);
			East = (Spinner) findViewById(R.id.spinner_hoseast);
			West = (Spinner) findViewById(R.id.spinner_hoswest);
			NorthEast = (Spinner) findViewById(R.id.spinner_hosnortheast);
			
			ArrayAdapter<String> adapter_Realm = new ArrayAdapter<String>(getApplicationContext(),
					android.R.layout.simple_spinner_dropdown_item, txt_Realm);
			
			ArrayAdapter<String> adapter_Bkk = new ArrayAdapter<String>(getApplicationContext(),
					android.R.layout.simple_spinner_dropdown_item, txt_Bkk);
			
			ArrayAdapter<String> adapter_North = new ArrayAdapter<String>(getApplicationContext(),
					android.R.layout.simple_spinner_dropdown_item, txt_North);
			
			ArrayAdapter<String> adapter_South = new ArrayAdapter<String>(getApplicationContext(),
					android.R.layout.simple_spinner_dropdown_item, txt_South);
			
			ArrayAdapter<String> adapter_East = new ArrayAdapter<String>(getApplicationContext(),
					android.R.layout.simple_spinner_dropdown_item, txt_East);
			
			ArrayAdapter<String> adapter_West = new ArrayAdapter<String>(getApplicationContext(),
					android.R.layout.simple_spinner_dropdown_item, txt_West);
			
			ArrayAdapter<String> adapter_NorthEast= new ArrayAdapter<String>(getApplicationContext(),
					android.R.layout.simple_spinner_dropdown_item, txt_NorthEast);
			
		items = new ArrayList<MyListHospital>();
		
		Realm.setAdapter(adapter_Realm);
		Bkk.setAdapter(adapter_Bkk);
		North.setAdapter(adapter_North);
		South.setAdapter(adapter_South);
		East.setAdapter(adapter_East);
		West.setAdapter(adapter_West);
		NorthEast.setAdapter(adapter_NorthEast);

		Realm.setOnItemSelectedListener(this);
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

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		switch (parent.getId()){
			case R.id.spinner_hosrealm:
				if(position == 0)
					Toast.makeText(HospitalActivity.this, "Test", Toast.LENGTH_SHORT).show();
				else if(position == 1)
					Toast.makeText(HospitalActivity.this, "Test1", Toast.LENGTH_SHORT).show();
				break;
			case R.id.spinner_hosbkk:
				Toast.makeText(HospitalActivity.this, "Test11111", Toast.LENGTH_SHORT).show();
				break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
