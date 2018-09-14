package bys.crm.hbc.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

import bys.crm.hbc.R;
import bys.crm.hbc.models.KeyValue;
import bys.crm.hbc.models.KeyValueData;

/**
 * Created by Admin on 3/5/2018.
 */

public class SpinnerAdapter extends BaseAdapter {
    private ArrayList<KeyValueData> mData;
    private Context mContext;
    private LayoutInflater inflter;

    public SpinnerAdapter(Context context, ArrayList<KeyValueData> data) {
        this.mContext = context;
        this.mData = data;
        inflter = (LayoutInflater.from(mContext));
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflter.inflate(R.layout.spinner_item, null);
        KeyValueData item = mData.get(position);
        TextView names = (TextView) convertView.findViewById(R.id.tv_name);
        if(position == 0){
            names.setTextColor(ContextCompat.getColor(mContext, R.color.hint_color));
        } else {
            names.setTextColor(ContextCompat.getColor(mContext, R.color.text_color_spiner));
        }
        names.setText(item.getValue());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = inflter.inflate(R.layout.spinner_dropdow_item, null);
        KeyValueData item = mData.get(position);
        TextView names = (TextView) convertView.findViewById(R.id.tv_name);
        names.setText(item.getValue());
        return convertView;
    }
}
