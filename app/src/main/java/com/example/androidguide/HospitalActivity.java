package com.example.androidguide;

import java.util.ArrayList;
import com.example.items.MyListHospital;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class HospitalActivity extends Fragment implements AdapterView.OnItemSelectedListener {

	private Spinner Realm;
	private Spinner Bkk;
	private Spinner North;
	private Spinner South;
	private Spinner East;
	private Spinner West;
	private Spinner NorthEast;

	String[] txt_Realm;
	String[] txt_Bkk;
	String[] txt_North;
	String[] txt_South;
	String[] txt_East;
	String[] txt_West ;
	String[] txt_NorthEast;


	ArrayList<MyListHospital> items;

	public static HospitalActivity newInstance() {
		HospitalActivity fragment = new HospitalActivity();

		return fragment;
	}

	public HospitalActivity() {

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		txt_Realm = new String[]{
				getResources().getString(R.string.strProvinceNonthaburi),getResources().getString(R.string.strProvinceSamutPrakan),
				getResources().getString(R.string.strProvincePathumThani)
		};
		txt_Bkk = new String[] {
				getResources().getString(R.string.strProvinceBangkok),getResources().getString(R.string.strProvinceKamphaengPhet),
				getResources().getString(R.string.strProvinceChainat),getResources().getString(R.string.strProvinceNakhonNayok),
				getResources().getString(R.string.strProvinceNakhonPathom), getResources().getString(R.string.strProvinceNakhonSawan),
				getResources().getString(R.string.strProvincePhraNakhonSriAyutthaya),getResources().getString(R.string.strProvincePichit),
				getResources().getString(R.string.strProvincePhitsanulok),getResources().getString(R.string.strProvincePhetchabun),
				getResources().getString(R.string.strProvinceLopburi),getResources().getString(R.string.strProvinceSamutSongkhram),
				getResources().getString(R.string.strProvinceSamutsakorn),getResources().getString(R.string.strProvinceSingburi),
				getResources().getString(R.string.strProvinceSukhothai),getResources().getString(R.string.strProvinceSuphanBuri)
		};
		txt_North = new String[]{
				getResources().getString(R.string.strProvinceChiangRai),getResources().getString(R.string.strProvinceChiangMai),
				getResources().getString(R.string.strProvinceNan),getResources().getString(R.string.strProvincePayao),
				getResources().getString(R.string.strProvincePhrae),getResources().getString(R.string.strProvinceMaeHongSon),
				getResources().getString(R.string.strProvinceLampang),getResources().getString(R.string.strProvinceLamphun),
				getResources().getString(R.string.strProvinceUttaradit),

		};
		txt_South = new String[]{
				getResources().getString(R.string.strProvinceKrabi),getResources().getString(R.string.strProvinceChumphon),
				getResources().getString(R.string.strProvinceTrang),getResources().getString(R.string.strProvinceNakhonSiThammarat),
				getResources().getString(R.string.strProvinceNarathiwat),getResources().getString(R.string.strProvincePattani),
				getResources().getString(R.string.strProvincePhangnga),getResources().getString(R.string.strProvincePhatthalung),
				getResources().getString(R.string.strProvincePhuket),getResources().getString(R.string.strProvinceRanong),
				getResources().getString(R.string.strProvinceSatun),getResources().getString(R.string.strProvinceSongkhla),
				getResources().getString(R.string.strProvinceSuratThani),getResources().getString(R.string.strProvinceYala),
		};
		txt_East = new String[]{
				getResources().getString(R.string.strProvinceChanthaburi),getResources().getString(R.string.strProvinceChachoengsao),
				getResources().getString(R.string.strProvinceChonBuri),getResources().getString(R.string.strProvinceTrad),
				getResources().getString(R.string.strProvincePrachinburi),getResources().getString(R.string.strProvinceRayong),
				getResources().getString(R.string.strProvinceSaKaeo),
		};
		txt_West = new String[]{
				getResources().getString(R.string.strProvinceKanchanaburi),
				getResources().getString(R.string.strProvincePrachuapKhiriKhan),
				getResources().getString(R.string.strProvinceTak), getResources().getString(R.string.strProvincePhetchaburi),
				getResources().getString(R.string.strProvinceRatchaburi),
		};
		txt_NorthEast = new String[]{
				getResources().getString(R.string.strProvinceKalasin),getResources().getString(R.string.strProvinceKhonKaen),
				getResources().getString(R.string.strProvinceChaiyaphum),getResources().getString(R.string.strProvinceNakhonPhanom),
				getResources().getString(R.string.strProvinceNakhonRatchasima),getResources().getString(R.string.strProvinceBungKan),
				getResources().getString(R.string.strProvinceBuriram),getResources().getString(R.string.strProvinceMahaSarakham),
				getResources().getString(R.string.strProvinceMukdahan),getResources().getString(R.string.strProvinceYasothon),
				getResources().getString(R.string.strProvinceRoiEt),getResources().getString(R.string.strProvinceLoei),
				getResources().getString(R.string.strProvinceSakonNakhon),getResources().getString(R.string.strProvinceSurin),
				getResources().getString(R.string.strProvinceSisaket),getResources().getString(R.string.strProvinceNongkhai),
				getResources().getString(R.string.strProvinceNongbualamphu),getResources().getString(R.string.strProvinceUdonThani),
				getResources().getString(R.string.strProvinceUbonRatchathani),getResources().getString(R.string.strProvinceAmnatCharoen),
		};
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_hospital, container, false);

		setWidget(view);

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
		Realm = (Spinner) view.findViewById(R.id.spinner_hosrealm);
		Bkk = (Spinner) view.findViewById(R.id.spinner_hosbkk);
		North = (Spinner) view.findViewById(R.id.spinner_hosnorth);
		South = (Spinner) view.findViewById(R.id.spinner_hossouth);
		East = (Spinner) view.findViewById(R.id.spinner_hoseast);
		West = (Spinner) view.findViewById(R.id.spinner_hoswest);
		NorthEast = (Spinner) view.findViewById(R.id.spinner_hosnortheast);
	}

}
