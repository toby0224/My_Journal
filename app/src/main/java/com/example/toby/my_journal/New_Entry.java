package com.example.toby.my_journal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class New_Entry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:      //switch to Home screen
                    Intent intent = new Intent(New_Entry.this, MainActivity.class);
                    startActivity(intent);
                    break;

                case R.id.navigation_entry:     //stay in New_Entry screen
                    break;

                case R.id.navigation_calendar:  //switch to Calendar screen
                    Intent intent1 = new Intent(New_Entry.this, Calendar.class);
                    startActivity(intent1);
                    break;

                case R.id.navigation_maps:      //switch to Maps screen
                    Intent intent2 = new Intent(New_Entry.this, Maps.class);
                    startActivity(intent2);
                    break;

            }
            return false;
        }
    };

}
