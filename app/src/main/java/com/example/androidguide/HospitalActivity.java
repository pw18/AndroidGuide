package com.example.androidguide;

import java.util.ArrayList;

import com.example.items.MyListHospital;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import android.widget.Spinner;

public class HospitalActivity extends ActionBarActivity {
	
	ArrayAdapter<MyListHospital> adapter;
	
	private Spinner Realm;
	private Spinner Bkk;
	private Spinner North;
	private Spinner South;
	private Spinner East;
	private Spinner West;
	private Spinner NorthEast;
	
	String[] txt_Realm = {"นนทบุรี","ปทุมทานี","สมุทรปราการ"};
	
	String[] txt_Bkk = {"กรุงเทพมหานคร","กำแพงเพชร","ชัยนาท","นครปฐม","นครสวรรค์","นครนายก","พิจิตร","พิษณุโลก","เพชรบูรณ์","ลพบุรี",
						"สมุทรสงคราม","สมุทรสาคร","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรบุรี","อยุธยา","อ่างทอง","อทัยธานี"};
	
	String[] txt_North = {"เชียงราย","เชียงใหม่","น่าน","พะเยา","แพร่","แม่ฮ่องสอน","ลำปาง","ลำพูน","อุตรดิตถ์"};
	
	String[] txt_South = {"กระบี่","ชุมพร","ตรัง","นครศรีธรรมราช","นราธิวาส","ปัตตานี","พังงา","พัทลุง","ภูเก็ต","ยะลา","ระนอง","สงขลา","สตูล","สุราษฏ์ธานี"};
	
	String[] txt_East = {"จันทบุรี","ฉะเชิงเทรา","ชลบุรี","ตราด","ปราจีนบุรี","ระยอง","สระแก้ว"};
	
	String[] txt_West = {"การญจนบุรี","ตาก","ประจวบคีรีขันธ์","เพชรบุรี","ราชบุรี"};
	
	String[] txt_NorthEast = {"กาฬสินธุ์","ขอนแก่น","ชัยภูมิ","นครพนม","นครราชสีมา","บุรีรัมย์","บึงกาฬ","มหาสารคราม","มุกดาหาร","ยโสธร","ร้อยเอ็ด","เลย","ศรีสะเกษ",
						"สกลนคร","สุรินทร์","หนองคาย","หนองบัวลำภู","อำนาจเจริญ","อุดรธานี","อุบลราชธานี"};
	
	
	ArrayList<MyListHospital> items;
	

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
