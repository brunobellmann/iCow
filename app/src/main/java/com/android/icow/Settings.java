package com.android.icow;




import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Settings extends AppCompatActivity {

    View view ;
    Toolbar toolbar;
    ActionBar actionBar;
    TextView ändern;
    private int colornum;

    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

     /*   SharedPreferences sp = getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("colornum",colornum);
        editor.commit(); */

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button buttonDecrement = findViewById(R.id.decrement);
        Button buttonIncrement = findViewById(R.id.increment);
        ändern = findViewById(R.id.ändern);

       // Loadcolornum();

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
                color();
            }

        });

        buttonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrement();
                color();
            }

        });

        if (savedInstanceState != null){
            colornum = savedInstanceState.getInt("bg");
            ändern.setText(String.valueOf(colornum));
            color();
        }

    }

    private void increment() {
        if (colornum == 2) {
            colornum++;
            ändern.setText(String.valueOf(0));
    } else {
            colornum++;
            ändern.setText(String.valueOf(colornum));
        }

    }
    private void decrement() {
        if (colornum == 0) {
            colornum = 2;
            ändern.setText(String.valueOf(colornum));
        } else {
            colornum--;
            ändern.setText(String.valueOf(colornum));

        }
    }

    private void color ()   {
      //  final Button colorbutton = (Button)findViewById(R.id.colorbutton);
        ändern = findViewById(R.id.ändern);
        colornum = Integer.parseInt(ändern.getText().toString());
        switch (colornum) {
            case 1:
               // colorbutton.setText("blau");
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.cardview_dark_background);
                break;
            case 2:
               // colorbutton.setText("weiß");
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.colorPrimary);
                break;
            default:
             //   colorbutton.setText("grau");
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.cardview_light_background);
                break;
        }

        }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("bg",colornum);
    }

    /*public void Loadcolornum () {
    SharedPreferences sp = getSharedPreferences("MyPrefsFile", Activity.MODE_PRIVATE);
    colornum = sp.getInt("colornum",colornum);
    ändern = findViewById(R.id.ändern);
    colornum = Integer.parseInt(ändern.getText().toString());
} */
}


