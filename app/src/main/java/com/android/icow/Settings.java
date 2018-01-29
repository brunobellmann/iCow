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


public class Settings extends AppCompatActivity {

    View view;
    Toolbar toolbar;
    ActionBar actionBar;
    TextView ändern;
    Switch switch1;
    private int colornum;

    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String EXTRA_COLORNUM = "icow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

    /*    SharedPreferences sp = getSharedPreferences(PREFS_NAME, 0);
        colornum = sp.getInt("colornum", colornum);
        switch1 = findViewById(R.id.switch1);
        if (colornum == 1) {
            switch1.setChecked(true);
        } else {
            switch1.setChecked(false);
        }
        color(); */


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Einstellungen");


        switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                colornum=1;
            } else {colornum =0;}

                color();
        }


    });
    }

    private void color() {
        switch (colornum) {
            case 1:
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.cardview_dark_background);
                break;
            default:
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.cardview_light_background);
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("bg", colornum);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sp = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sp.edit();
        if (switch1.isChecked()) {
            editor.putInt("colornum", 1);
        } else editor.putInt("colornum",0);
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


