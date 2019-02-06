package com.basics.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CallList extends BaseAdapter {

    String[] names; String[] time;
    LayoutInflater mInflater;
    public CallList(Context c, String[] n, String[] t){
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
        View v = mInflater.inflate(R.layout.my_calllist_detail, null);
        TextView nameTV= (TextView) v.findViewById(R.id.name);
        TextView timeTV= (TextView) v.findViewById(R.id.time);

        String nm = names[i];
        String tm = time[i];

        nameTV.setText(nm);
        timeTV.setText(tm);
        return v;
    }
}
