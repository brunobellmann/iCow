package com.android.icow;




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
    Button colorbutton;
    TextView ändern;
    int colornum = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        final Button colorbutton = (Button)findViewById(R.id.colorbutton);
        colorbutton.setText("grau");
        colorbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color();
                colornum++;

            }
        });}

        private void color ()   {
        final Button colorbutton = (Button)findViewById(R.id.colorbutton);
        switch (colornum) {
            case 1:
                colorbutton.setText("blau");
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.cardview_dark_background);
                break;
            case 2:
                colorbutton.setText("weiß");
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.colorPrimary);
                break;
            case 3:
                colorbutton.setText("grau");
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.cardview_light_background);
                colornum=0;
                break;
        }

        }
    }



