package com.example.androidguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.adapter.CustomListMedicineTraditional;
import com.example.items.MyListMedicineTraditionalItem;

import java.util.ArrayList;

public class MedicineTraditionalActivity extends Fragment {
	
	ArrayAdapter<MyListMedicineTraditionalItem> adapter;
	ListView lv_menu;
	EditText et_search;
	String[] txt;

	
	ArrayList<MyListMedicineTraditionalItem> items;
	ArrayList<MyListMedicineTraditionalItem> n_item;

	public static MedicineTraditionalActivity newInstance(){
		MedicineTraditionalActivity fragment = new MedicineTraditionalActivity();

		return fragment;
	}

	public MedicineTraditionalActivity(){

	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		txt = new String[]{
				getResources().getString(R.string.strCystitis),
				getResources().getString(R.string.strGastroesophagealRefluxDisease),
				getResources().getString(R.string.strTineaCorporis),
				getResources().getString(R.string.strTineaVesicolor),
				getResources().getString(R.string.strHordeolum),
				getResources().getString(R.string.strCommonCold),
				getResources().getString(R.string.strNauseaVomitting),
				getResources().getString(R.string.strTineapedis),
				getResources().getString(R.string.strTineaungium),
				getResources().getString(R.string.strLeukorrhea),
				getResources().getString(R.string.strConstipation),
				getResources().getString(R.string.strDiarrhea),
				getResources().getString(R.string.strDysmenorrhea),
				getResources().getString(R.string.strToothache),
				getResources().getString(R.string.strMigraine),
				getResources().getString(R.string.strImpetigo),
				getResources().getString(R.string.strEczema),
				getResources().getString(R.string.strAphthousUlcer),
				getResources().getString(R.string.strPoisoningfromPesticides),
				getResources().getString(R.string.strSuppurativeWoundInfection),
				getResources().getString(R.string.strPepticUlcer),
				getResources().getString(R.string.strGnathostomiasis),
				getResources().getString(R.string.strHerpesSimplex),
				getResources().getString(R.string.strEpistaxis),
				getResources().getString(R.string.strUrticaria),
				getResources().getString(R.string.strGingivalBleeding),
				getResources().getString(R.string.strVertigo),
				getResources().getString(R.string.strMeasles),
				getResources().getString(R.string.strGermanMeasles),
				getResources().getString(R.string.strScabiasis)
		};

	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_medicine_traditional, container, false);

		setWidget(view);
		items = new ArrayList<MyListMedicineTraditionalItem>();
		n_item = new ArrayList<MyListMedicineTraditionalItem>();


		for(int i=0; i<txt.length; i++){
			MyListMedicineTraditionalItem data = new MyListMedicineTraditionalItem();
			data.setText(txt[i]);
			items.add(data);
			n_item.add(data);

		}

		CustomListMedicineTraditional custom_adapter = new CustomListMedicineTraditional(getActivity(), R.layout.activity_medicine_traditional, items);
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
				Intent intent = new Intent(getActivity(), DataMedicinetraditionalActivity.class);
				intent.putExtra("text1", txt[position]);
				intent.putExtra("text2", "position : " + position);
				startActivity(intent);

			}
		});

		return view;
	}
	
	private void setWidget(View view) {
		// TODO Auto-generated method stub
		lv_menu = (ListView) view.findViewById(R.id.listView_medicine_traditional_listdiseases);
		et_search = (EditText) view.findViewById(R.id.editText_search_medicinetraditional);
	}

}
