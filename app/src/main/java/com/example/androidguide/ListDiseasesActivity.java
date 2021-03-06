package com.example.androidguide;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
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
import com.example.Mydatabase.DatabaseGuide;
import com.example.adapter.CustomListDiseases;
import com.example.controller.MyWebService;
import com.example.controller.MyWebServiceListener;
import com.example.controller.listener.RecyclerItemClickListener;
import com.example.items.MyListDiseasesItem;
import com.example.model.DiseasesModel;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ListDiseasesActivity extends Fragment implements  SearchView.OnQueryTextListener /*,TextWatcher*/{

    private CustomListDiseases custom_adapter;
    private RecyclerView recyclerView;


    private String url = "http://192.168.1.134/services/diseases.php";

    private List<DiseasesModel> items;
    private List<DiseasesModel> n_item;
    private CRUD crud;

    private SearchView searchView = null;

    public static ListDiseasesActivity newInstance() {
        ListDiseasesActivity fragment = new ListDiseasesActivity();

        return fragment;
    }

    public ListDiseasesActivity() {

    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem n_item) {
//        switch (n_item.getItemId()){
//            case R.id.action_search:
//                return  false;
//            case R.id.recyclerView_diseases_listdiseases:
//                return  true;
//            default:
//                break;
//        }
//        return  false;
//
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_diseases, container, false);
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

//        MyWebServiceListener listener = new MyWebServiceListener() {
//
//            @Override
//            public void myWebServiceOK(String result) throws Exception {
//                if (result != null && !"".equals(result)) {
//                    JSONArray jsonArray = new JSONArray(result);
//                    if (jsonArray != null && jsonArray.length() != 0) {
//                        for (int i = 0; i < jsonArray.length(); i++) {
//
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void myWebServiceFailed() {
//
//            }
//        };
//
//        new MyWebService(getActivity(), listener, "GET", url).execute();

        items = crud.selectDiseasesAll();
        n_item = crud.selectDiseasesAll();

        custom_adapter = new CustomListDiseases(items);

        recyclerView.setAdapter(custom_adapter);



        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), DataDiseasesActivity.class);
                intent.putExtra("text1", items.get(position).getName());
                intent.putExtra("text2", items.get(position).getSysptom());
                intent.putExtra("text3", items.get(position).getCause());
                intent.putExtra("text4", items.get(position).getSysptomInstant());
                startActivity(intent);
            }
        }));

        /*
        lv_menu.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // Toast.makeText(getApplicationContext(), "List : "+position,
                // Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(),
                        DataDiseasesActivity.class);
                intent.putExtra("text1", items.get(position).getText());
                intent.putExtra("text2", "position : " + position);
                startActivity(intent);

            }
        });
        */
    }

    private void setWidget(View view) {
        // TODO Auto-generated method stub
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_diseases_listdiseases);


    }

//    @Override
//    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//    }
//
//    @Override
//    public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//    }
//
//    @Override
//    public void afterTextChanged(Editable s) {
//
//    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
//        MenuItem search = menu.findItem(R.id.action_search);
//        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
//
//        if (search != null)
//            searchView = (SearchView) search.getActionView();
//        if (searchView != null)
//            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
//        searchView.setOnQueryTextListener(this);
//
//        super.onCreateOptionsMenu(menu, inflater);
//    }
    final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed
                        custom_adapter.setFilter(n_item);
                        return true; // Return true to collapse action view
                    }
                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });
    }
        @Override
    public boolean onQueryTextChange(String newText) {
        final List<DiseasesModel> filteredModelList = filter(n_item, newText);
            custom_adapter.setFilter(filteredModelList);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<DiseasesModel> filter(List<DiseasesModel> models, String query) {
        query = query.toLowerCase();

        final List<DiseasesModel> filteredModelList = new ArrayList<>();
        for (DiseasesModel model : models) {
            final String text = model.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
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

//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextChange(String newText) {
//        int txtlength = newText.length();
//        if (n_item != null) {
//            if (txtlength > 0) {
//                List<DiseasesModel> appListSort = new ArrayList<>();
//
//                for (int i = 0; i < n_item.size(); i++) {
//                    String sApp = n_item.get(i).getName();
//                    if (txtlength <= sApp.length()) {
//                        if (newText.equalsIgnoreCase((String) sApp
//                                .subSequence(0, txtlength))) {
//                            appListSort.add(n_item.get(i));
//                        }
//                    }
//                }
//
//                items.clear();
//                for (int i = 0; i < appListSort.size(); i++) {
//                    items.add(appListSort.get(i));
//                }
//
//            } else {
//                items.clear();
//                for (int i = 0; i < n_item.size(); i++) {
//                    items.add(n_item.get(i));
//                }
//            }
//            custom_adapter.notifyDataSetChanged();
//        }
//        return true;
//    }
}
