package com.basics.chatapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    ListView listView;
    String[] last_message; String[] names; String[] time;

    public void navigation(){
        Button chats = (Button) findViewById(R.id.chats);
        Button calls = (Button) findViewById(R.id.calls);
        Button status = (Button) findViewById(R.id.status);

        chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chatsActivity = new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(chatsActivity);
            }
        });
        calls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callsActivity = new Intent(getApplicationContext(), CallActivity.class);
                startActivity(callsActivity);
            }
        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent statusActivity = new Intent(getApplicationContext(), StatusActivity.class);
                startActivity(statusActivity);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation();

        Resources res = getResources();
        listView = findViewById(R.id.my_listview);

        names = res.getStringArray(R.array.names);
        last_message = res.getStringArray(R.array.last_message);
        time = res.getStringArray(R.array.time);

        ItemAdapter itemAdapter = new ItemAdapter(this, names, last_message, time);
        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.basics", i);
                startActivity(showDetailActivity);
            }
        });
    }
}
