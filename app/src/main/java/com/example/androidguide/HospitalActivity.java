package com.example.androidguide;

import java.util.ArrayList;
import java.util.List;

import com.example.Mydatabase.CRUD;
import com.example.Mydatabase.DatabaseGuide;
import com.example.adapter.ProvinceAdapter;
import com.example.model.HospitalModel;
import com.example.model.ProvinceModel;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

public class HospitalActivity extends Fragment implements AdapterView.OnItemSelectedListener {

	private String[] titleProvices;
	private List<HospitalModel> items;
	private List<ProvinceModel> listCentralRegion;
	private List<ProvinceModel> listNorth;
	private List<ProvinceModel> listNorthEast;
	private List<ProvinceModel> listWest;
	private List<ProvinceModel> listEast;
	private List<ProvinceModel> listRealm;
	private List<ProvinceModel> listSouth;

	private CRUD crud;
	private RecyclerView recyclerView;
	private ProvinceAdapter adapter;

	public static HospitalActivity newInstance() {
		HospitalActivity fragment = new HospitalActivity();

		return fragment;
	}

	public HospitalActivity() {

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		crud = new CRUD(getContext());
		items = new ArrayList<>();
		titleProvices = getResources().getStringArray(R.array.strTitleProvince);
		listCentralRegion = crud.selectProvince(DatabaseGuide.Central);
		listNorth = crud.selectProvince(DatabaseGuide.North);
		listNorthEast = crud.selectProvince(DatabaseGuide.NorthEast);
		listWest = crud.selectProvince(DatabaseGuide.West);
		listEast = crud.selectProvince(DatabaseGuide.East);
		listRealm = crud.selectProvince(DatabaseGuide.Realm);
		listSouth = crud.selectProvince(DatabaseGuide.South);

		for (int i=0; i<titleProvices.length; i++){
			HospitalModel model = new HospitalModel();
			model.setTitle(titleProvices[i]);
			if(i == 0)
				model.setProvinceList(listRealm);
			else if(i == 1)
				model.setProvinceList(listCentralRegion);
			else if(i == 2)
				model.setProvinceList(listNorth);
			else if(i == 3)
				model.setProvinceList(listSouth);
			else if(i == 4)
				model.setProvinceList(listEast);
			else if(i == 5)
				model.setProvinceList(listWest);
			else
				model.setProvinceList(listNorthEast);

			items.add(model);
		}
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_hospital, container, false);

		setWidget(view);
		init();

		/*
		ArrayAdapter<String> adapter_Realm = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, txt_Realm);

		ArrayAdapter<String> adapter_Bkk = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, txt_Bkk);

		ArrayAdapter<String> adapter_North = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, txt_North);

		ArrayAdapter<String> adapter_South = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, txt_South);

		ArrayAdapter<String> adapter_East = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, txt_East);

		ArrayAdapter<String> adapter_West = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, txt_West);

		ArrayAdapter<String> adapter_NorthEast= new ArrayAdapter<String>(getActivity(),
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
		*/

		return view;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//		switch (parent.getId()){
//			case R.id.spinner_hosrealm:
//				if(position == 0)
//					Toast.makeText(getActivity(), "Test", Toast.LENGTH_SHORT).show();
//				else if(position == 1)
//					Toast.makeText(getActivity(), "Test1", Toast.LENGTH_SHORT).show();
//				break;
//			case R.id.spinner_hosbkk:
//				Toast.makeText(getActivity(), "Test11111", Toast.LENGTH_SHORT).show();
//				break;
//		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}

	private void setWidget(View view) {
		recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewHospital);
		/*
		Realm = (Spinner) view.findViewById(R.id.spinner_hosrealm);
		Bkk = (Spinner) view.findViewById(R.id.spinner_hosbkk);
		North = (Spinner) view.findViewById(R.id.spinner_hosnorth);
		South = (Spinner) view.findViewById(R.id.spinner_hossouth);
		East = (Spinner) view.findViewById(R.id.spinner_hoseast);
		West = (Spinner) view.findViewById(R.id.spinner_hoswest);
		NorthEast = (Spinner) view.findViewById(R.id.spinner_hosnortheast);
		*/
	}

	private void init(){
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		recyclerView.setItemAnimator(new DefaultItemAnimator());

		adapter = new ProvinceAdapter(items);

		recyclerView.setAdapter(adapter);
	}

}
