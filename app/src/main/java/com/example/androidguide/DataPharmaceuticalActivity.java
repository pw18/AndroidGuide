package com.example.androidguide;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DataPharmaceuticalActivity extends AppCompatActivity {

	private TextView txt1;
	private TextView txt2;
	private TextView txt3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data_pharmaceutical);
		
		setWidget();
		
		Intent intent = getIntent();
		if(intent != null){
			String recive_txt1 = intent.getExtras().getString("text1");
			String recive_txt2 = intent.getExtras().getString("text2");
			String recive_txt3 = intent.getExtras().getString("text3");


			if(recive_txt1 != null && recive_txt2 != null) {
				txt1.setText(recive_txt1);
				txt2.setText(recive_txt2);
				txt3.setText(recive_txt3);

			}
		}
	}
	private void setWidget(){
		txt1 = (TextView) findViewById(R.id.textView_datanamepharmaceutical);
		txt2 = (TextView) findViewById(R.id.textView_dataparallel);
		txt3 = (TextView) findViewById(R.id.textView_datadetails);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.data_pharmaceutical, menu);
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
