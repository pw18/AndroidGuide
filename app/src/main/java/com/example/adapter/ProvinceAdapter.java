package com.example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.androidguide.R;
import com.example.model.HospitalModel;
import com.example.model.HospitalProvinceModel;
import com.example.model.ProvinceModel;

import java.util.List;

/**
 * Created by Administrator on 5/7/2016.
 */
public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder> {

    private List<HospitalModel> items;

    public ProvinceAdapter(List<HospitalModel> items){
        this.items = items;
    }

    @Override
    public ProvinceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_province, parent, false);
        return new ProvinceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProvinceViewHolder holder, int position) {
        holder.txtTitle.setText(items.get(position).getTitle());
        holder.setSpinnerAdapter(items.get(position).getProvinceList());
    }

    @Override
    public int getItemCount() {
        if(items != null)
            return items.size();
        return 0;
    }

    static class ProvinceViewHolder extends RecyclerView.ViewHolder{

        public TextView txtTitle;
        public Spinner spinner;
        private Context context;

        public ProvinceViewHolder(View view) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            spinner = (Spinner) view.findViewById(R.id.spinnerHospital);
            context = view.getContext();
        }

        public void setSpinnerAdapter(List<ProvinceModel> item){
            SpinnerProvinceAdapter adapter = new SpinnerProvinceAdapter(context, 0, item);
            spinner.setAdapter(adapter);
        }
    }
}
