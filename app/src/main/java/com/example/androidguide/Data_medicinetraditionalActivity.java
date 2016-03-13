package com.example.androidguide;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Data_medicinetraditionalActivity extends AppCompatActivity {
	
	TextView txt1, txt2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data_medicinetraditional);
		setWidget();
		
		Intent intent = getIntent();
		if(intent != null){
			String recive_txt1 = intent.getExtras().getString("text1");
			String recive_txt2 = intent.getExtras().getString("text2");
			
			txt1.setText(recive_txt1);
			txt2.setText(recive_txt2);
		}
	}
	
	private void setWidget(){
		txt1 = (TextView) findViewById(R.id.txt1_datamedicinetraditional);
		txt2 = (TextView) findViewById(R.id.txt2_datamedicinetraditional);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.data_medicinetraditional, menu);
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
