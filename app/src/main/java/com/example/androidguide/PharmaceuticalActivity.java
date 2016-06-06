package com.example.androidguide;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.Mydatabase.CRUD;
import com.example.adapter.CustomListDiseases;
import com.example.adapter.CustomListPharmaceutical;
import com.example.controller.listener.RecyclerItemClickListener;
import com.example.items.MyListPharmaceuticalItem;
import com.example.model.PhamaceuticalModel;
import com.example.model.TraditionalModel;

import java.util.ArrayList;
import java.util.List;


public class PharmaceuticalActivity extends Fragment implements TextWatcher,SearchView.OnQueryTextListener {


	private CustomListPharmaceutical custom_adapter;
	private RecyclerView recyclerView;
	private SearchView searchView = null;

	private List<PhamaceuticalModel> items;
	private List<PhamaceuticalModel> n_item;
	private CRUD crud;

	public static PharmaceuticalActivity newInstance(){
		PharmaceuticalActivity fragment = new PharmaceuticalActivity();

		return fragment;
	}

	public PharmaceuticalActivity(){

	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);

//		txt = new String[]{
//				getResources().getString(R.string.strCystitis),
//				getResources().getString(R.string.strGastroesophagealRefluxDisease),
//				getResources().getString(R.string.strTineaCorporis),
//				getResources().getString(R.string.strTineaVesicolor),
//				getResources().getString(R.string.strHordeolum),
//				getResources().getString(R.string.strCommonCold),
//				getResources().getString(R.string.strNauseaVomitting),
//				getResources().getString(R.string.strTineapedis),
//				getResources().getString(R.string.strTineaungium),
//				getResources().getString(R.string.strLeukorrhea),
//				getResources().getString(R.string.strConstipation),
//				getResources().getString(R.string.strDiarrhea),
//				getResources().getString(R.string.strDysmenorrhea),
//				getResources().getString(R.string.strToothache),
//				getResources().getString(R.string.strMigraine),
//				getResources().getString(R.string.strImpetigo),
//				getResources().getString(R.string.strEczema),
//				getResources().getString(R.string.strAphthousUlcer),
//				getResources().getString(R.string.strPoisoningfromPesticides),
//				getResources().getString(R.string.strSuppurativeWoundInfection),
//				getResources().getString(R.string.strPepticUlcer),
//				getResources().getString(R.string.strGnathostomiasis),
//				getResources().getString(R.string.strHerpesSimplex),
//				getResources().getString(R.string.strEpistaxis),
//				getResources().getString(R.string.strUrticaria),
//				getResources().getString(R.string.strGingivalBleeding),
//				getResources().getString(R.string.strVertigo),
//				getResources().getString(R.string.strMeasles),
//				getResources().getString(R.string.strGermanMeasles),
//				getResources().getString(R.string.strScabiasis)
//		};

	}



	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.activity_pharmaceutical, container, false);
		return view;

	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setWidget(view);
		crud = new CRUD(getContext());
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		recyclerView.setItemAnimator(new DefaultItemAnimator());

		items = crud.selectPhamaceuticalAll();
		n_item = crud.selectPhamaceuticalAll();

		custom_adapter = new CustomListPharmaceutical(items);

		recyclerView.setAdapter(custom_adapter);



		recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {

					@Override
					public void onItemClick(View view, int position) {
						Intent intent = new Intent(getActivity(), DataPharmaceuticalActivity.class);
						intent.putExtra("text1", items.get(position).getName());
						intent.putExtra("text2", items.get(position).getParallel());
						intent.putExtra("text3", items.get(position).getDetails());
						startActivity(intent);
					}
		}));

	}



	private void setWidget(View view) {
		recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_pharmaceutical_listdiseases);

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {

	}

	@Override
	public void afterTextChanged(Editable s) {

	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.main_menu, menu);
		MenuItem search = menu.findItem(R.id.action_search);
		SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);

		if (search != null)
			searchView = (SearchView) search.getActionView();
		if (searchView != null)
			searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
		searchView.setOnQueryTextListener(this);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_search:
				// Not implemented here
				return false;
			default:
				break;
		}
		searchView.setOnQueryTextListener(this);
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		return false;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		int txtlength = newText.length();
		if (n_item != null) {
			if (txtlength > 0) {
				List<PhamaceuticalModel> appListSort = new ArrayList<>();

				for (int i = 0; i < n_item.size(); i++) {
					String sApp = n_item.get(i).getName();
					if (txtlength <= sApp.length()) {
						if (newText.equalsIgnoreCase((String) sApp
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
			custom_adapter.notifyDataSetChanged();
		}
		return true;
	}
}
