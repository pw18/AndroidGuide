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

import com.example.adapter.CustomListPharmaceutical;
import com.example.items.MyListPharmaceuticalItem;

import java.util.ArrayList;


public class PharmaceuticalActivity extends Fragment {

	ArrayAdapter<MyListPharmaceuticalItem> adapter;
	ListView lv_menu;
	EditText et_search;
	
	String[] txt = {"�����л�������ѡ�ʺ","�ô�����͹","��ҡ","����͹","����ԧ","����Ѵ","�����������¹","�����ҷ������������","�����ҷ�����","�����","��ͧ�١","��ͧ��ǧ","�Ǵ��Ш���͹","�Ǵ�ѹ"
			,"�Ǵ��������ù","�žؾͧ","�����","����͹�","���˹ѧ�ѡ�ʺ�ҡ�����ŧ","���ѡ�ʺ�Դ����","��㹡����������","��Ҹ�","����","���ʹ�������","�����","���ʹ�͡����ÿѹ","���¹�����"
			,"�Ѵ","�Ѵ�����ѹ	","�Դ"};
	
	ArrayList<MyListPharmaceuticalItem> items;
	ArrayList<MyListPharmaceuticalItem> n_item;

	public static PharmaceuticalActivity newInstance(){
		PharmaceuticalActivity fragment = new PharmaceuticalActivity();

		return fragment;
	}

	public PharmaceuticalActivity(){

	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_pharmaceutical, container, false);

		setwidget(view);
		items = new ArrayList<MyListPharmaceuticalItem>();
		n_item = new ArrayList<MyListPharmaceuticalItem>();


		for(int i=0; i<txt.length; i++){
			MyListPharmaceuticalItem data = new MyListPharmaceuticalItem();
			data.setText(txt[i]);
			items.add(data);
			n_item.add(data);

		}

		CustomListPharmaceutical custom_adapter = new CustomListPharmaceutical(getActivity(), R.layout.activity_pharmaceutical, items);
		adapter = custom_adapter;
		lv_menu.setAdapter(custom_adapter);

		et_search.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence s, int start, int before, int count) {

				String search = et_search.getText().toString();
				int txtlength = search.length();
				if (n_item != null) {
					if (txtlength > 0) {
						ArrayList<MyListPharmaceuticalItem> appListSort = new ArrayList<MyListPharmaceuticalItem>();

						for (int i = 0; i < n_item.size(); i++) {
							String sApp = n_item.get(i).getText();
							if (txtlength <= sApp.length()) {
								if (search.equalsIgnoreCase((String) sApp.subSequence(0, txtlength))) {
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
				Intent intent = new Intent(getActivity(), Data_pharmaceuticalActivity.class);
				intent.putExtra("text1", txt[position]);
				intent.putExtra("text2", "position : " + position);
				startActivity(intent);
			}

		});

		return view;
	}
		
	private void setwidget(View view){
		lv_menu = (ListView) view.findViewById(R.id.listView_pharmaceutical_listdiseases);
		et_search = (EditText) view.findViewById(R.id.editText_search_pharmaceutical);
	}
}
