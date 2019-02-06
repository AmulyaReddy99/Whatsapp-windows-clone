package com.basics.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    String[] last_message; String[] names; String[] time;
    LayoutInflater mInflater;
    public ItemAdapter(Context c, String[] n, String[] l, String[] t){
        last_message = l;
        names = n;
        time = t;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTV= (TextView) v.findViewById(R.id.name);
        TextView messageTV= (TextView) v.findViewById(R.id.message);
        TextView timeTV= (TextView) v.findViewById(R.id.time);

        String nm = names[i];
        String lm = last_message[i];
        String tm = time[i];

        nameTV.setText(nm);
        messageTV.setText(lm);
        timeTV.setText(tm);
        return v;
    }

}
