package com.example.toby.my_journal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.view.MenuItem;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:      //switch to Home screen
                    Intent intent = new Intent(Calendar.this, MainActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.navigation_entry:     //switch to New_Entry screen
                    Intent intent0 = new Intent(Calendar.this, New_Entry.class);
                    startActivity(intent0);
                    break;

                case R.id.navigation_calendar:  //stay in Calendar screen
                    break;

                case R.id.navigation_maps:      //switch to Maps screen
                    Intent intent2 = new Intent(Calendar.this, Maps.class);
                    startActivity(intent2);
                    break;

            }
            return false;
        }
    };
}
