package com.basics.chatapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {

    ListView listView;
    String[] names; String[] time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        listView = findViewById(R.id.my_listview);

        names = res.getStringArray(R.array.names);
        time = res.getStringArray(R.array.time);

        CallList calllist = new CallList(this, names, time);
        listView.setAdapter(calllist);

        ImageView callback = (ImageView) findViewById(R.id.callback);
    }
    public static void main(String[] args) {
        new MainActivity().navigation();
    }
}
