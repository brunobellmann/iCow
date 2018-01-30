package com.android.icow;





import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.net.IDN;


public class Settings extends AppCompatActivity {

    View view;
    Toolbar toolbar;
    ActionBar actionBar;
    Switch switch1;
    private int colornum;
    TextView dunkelmodus;

    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String EXTRA_COLORNUM = "icow";
    private boolean switchonoff;

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
        updateViews();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        switch1 = findViewById(R.id.switch1);
        switch1.setChecked(false);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        dunkelmodus = findViewById(R.id.dunkelmodus);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Einstellungen");


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                colornum=1;
            } else {colornum=0;}
                color();
        }


    });



        
    }

    private void loadData() {
        SharedPreferences sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        switchonoff = sp.getBoolean(PREFS_NAME,false);
    }

    private void updateViews() {
        switch1.setChecked(switchonoff);
        color();
    }



    private void color() {
        switch (colornum) {
            case 1:
                view = this.getWindow().getDecorView(); 
                view.setBackgroundResource(R.color.cardview_dark_background);
                dunkelmodus.setTextColor(getResources().getColor(R.color.dunkelmodus_light));
                break;
            default:
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.cardview_light_background);
                dunkelmodus.setTextColor(getResources().getColor(R.color.dunkelmodus_dark));
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("bg", colornum);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(PREFS_NAME, switch1.isChecked());
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

                    switch1 = findViewById(R.id.switch1);
                    if (switch1.isChecked()) {
                        colornum = 1;
                    }else {colornum = 0;}
                    Intent myintent = new Intent(this, MainActivity.class);
                    myintent.putExtra(EXTRA_COLORNUM, colornum);
                    startActivity(myintent);
                    return true;
    }
}


