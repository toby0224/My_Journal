package com.example.toby.my_journal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Maps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:      //switch to Home screen
                    Intent intent = new Intent(Maps.this, MainActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.navigation_entry:     //switch to New_Entry screen
                    Intent intent0 = new Intent(Maps.this, New_Entry.class);
                    startActivity(intent0);
                    break;

                case R.id.navigation_calendar:  //switch to Calendar screen
                    Intent intent1 = new Intent(Maps.this, Calendar.class);
                    startActivity(intent1);
                    break;

                case R.id.navigation_maps:      //stay in Maps screen
                    break;

            }
            return false;
        }
    };




}
