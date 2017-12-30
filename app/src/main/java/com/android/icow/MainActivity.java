package com.android.icow;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
                //toolbar aktivieren
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My title");

    }




//button
    public void button(View view) {
        Intent intent = new Intent(this, Notiz.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    return true;}







    //Inhalt


}
