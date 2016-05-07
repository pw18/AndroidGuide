package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidguide.R;
import com.example.model.ProvinceModel;

import java.util.List;

/**
 * Created by Administrator on 5/7/2016.
 */
public class SpinnerProvinceAdapter extends ArrayAdapter<ProvinceModel> {

    private Context context;
    private List<ProvinceModel> items;

    public SpinnerProvinceAdapter(Context context, int resource, List<ProvinceModel> items) {
        super(context, resource, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.view_item_province_spinner, parent, false);
            holder = new ViewHolder();
            holder.txt = (TextView) convertView.findViewById(R.id.txtProvince);
        }else
            holder = (ViewHolder) convertView.getTag();

        ProvinceModel model = items.get(position);
        if(model != null) {
            holder.txt.setText(model.getProvince());
        }
        convertView.setTag(holder);
        return convertView;
    }

    static class ViewHolder{
        TextView txt;
    }
}
