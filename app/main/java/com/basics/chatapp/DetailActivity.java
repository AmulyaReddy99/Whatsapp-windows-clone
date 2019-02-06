package com.basics.chatapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class DetailActivity extends AppCompatActivity {
    ListView chat_listview;

    public void update(ArrayList<String>message_list){
//        TextView chatText = findViewById(R.id.chat_text);
//        chatText.setGravity(Gravity.RIGHT);
        chat_listview.setAdapter(new ArrayAdapter<String>(this, R.layout.my_chat_list_detail, message_list));
        chat_listview.setSelection(chat_listview.getAdapter().getCount()-1);
//        chat_listview.getAdapter();
//        chatText.setBackgroundColor(Color.rgb(11, 50, 73));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Resources res = getResources();
        chat_listview = findViewById(R.id.chat_list);
        String[] messages = res.getStringArray(R.array.messages);
        final ArrayList<String> message_list = new ArrayList<String>(Arrays.asList(messages));
        chat_listview.setAdapter(new ArrayAdapter<String>(this, R.layout.my_chat_list_detail, message_list));

        final TextInputEditText entertext = findViewById(R.id.entertext);
        entertext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                String message = entertext.getText().toString();
                message_list.add(message);
                update(message_list);
                return true;
            }
            return false;
          }
        });

        TextView details = findViewById(R.id.my_name);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showIDetailActivity = new Intent(getApplicationContext(), IndividualDetailActivity.class);
                startActivity(showIDetailActivity);
            }
        });
    }
}