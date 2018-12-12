package com.example.toby.my_journal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLDisplay;

public class New_Entry extends AppCompatActivity {
    Button clearButton;
    EditText dateET;
    EditText titleET;
    EditText contentET;
    Button addButton;
    DBHelper mDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        mDataBaseHelper = new DBHelper(this);

        titleET = (EditText) findViewById(R.id.titleET);
        contentET = (EditText) findViewById(R.id.contentET);
        clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateET.setText("");
                titleET.setText("");
                contentET.setText("");
            }
        });

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = titleET.getText().toString();
                /** Check and make sure that you are not adding an empty ID entry
                 * into the databse.
                 */
                if (titleET.length() != 0){
                    addEntry(newEntry);
                    titleET.setText("");
                    contentET.setText("");
                } else {
                    toastMessage("You must include a title!");
                }
            }
        });


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

    public void addEntry(String newEntry) {
        boolean insertData = mDataBaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Entry Successfully Added!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
