package com.example.androidguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class ListDiseasesActivity extends Fragment implements TextWatcher{

    private CustomListDiseases custom_adapter;
    private RecyclerView recyclerView;
    private EditText et_search;

    private String url = "http://192.168.1.134/services/diseases.php";

    private List<DiseasesModel> items;
    private List<DiseasesModel> n_item;
    private CRUD crud;

    public static ListDiseasesActivity newInstance() {
        ListDiseasesActivity fragment = new ListDiseasesActivity();

        return fragment;
    }

    public ListDiseasesActivity() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        et_search.addTextChangedListener(this);

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
        et_search = (EditText) view.findViewById(R.id.editText_search_diseases);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String search = et_search.getText().toString();
        int txtlength = search.length();
        if (n_item != null) {
            if (txtlength > 0) {
                List<DiseasesModel> appListSort = new ArrayList<>();

                for (int i = 0; i < n_item.size(); i++) {
                    String sApp = n_item.get(i).getName();
                    if (txtlength <= sApp.length()) {
                        if (search.equalsIgnoreCase((String) sApp
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
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
