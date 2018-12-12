package com.example.toby.my_journal;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Item_Content extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_content);
        TextView titleView = (TextView) findViewById(R.id.titleView);
        TextView contentView = (TextView) findViewById(R.id.contentView);

        Intent i = getIntent();
        // getting attached intent data
        String title = i.getStringExtra("team");
        // displaying selected product name
        titleView.setText(title);


    }
}
