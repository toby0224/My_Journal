package com.example.toby.my_journal;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private DBHelper mDatabaseHelper;
    private ListView mListView;
    private static String TAG = "ListData";

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mListView = (ListView) findViewById(R.id.entry_list);
        mDatabaseHelper = new DBHelper(this);

        populateListView();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:      //stay in Home screen
                    break;

                case R.id.navigation_entry:     //switch to New_Entry screen
                    Intent intent0 = new Intent(MainActivity.this, New_Entry.class);
                    startActivity(intent0);
                    break;

                case R.id.navigation_calendar:  //switch to Calendar screen
                    Intent intent1 = new Intent(MainActivity.this, Calendar.class);
                    startActivity(intent1);
                    break;

                case R.id.navigation_maps:      //switch to Maps screen
                    Intent intent2 = new Intent(MainActivity.this, Maps.class);
                    startActivity(intent2);
                    break;
            }
            return false;
        }
    };

    public void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        // get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();


        while(data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
