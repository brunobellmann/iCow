package com.android.icow;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NotizDetails extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionBar;
    NotizCard notizCard;
    EditText titleTxt, contentTxt;
    Button updateBtn, deleteBtn, teeestbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notizdetails);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        Button share = findViewById(R.id.button_share);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Notiz " + getIntent().getExtras().getLong("ID"));

        //Intent
        Intent i = getIntent();
        final String title = i.getExtras().getString("TITLE");
        final String content = i.getExtras().getString("CONTENT");
        final long id = i.getExtras().getLong("ID");

        updateBtn = (Button) findViewById(R.id.button_update);
        deleteBtn = (Button) findViewById(R.id.button_delete);
        titleTxt = (EditText) findViewById(R.id.detail_title);
        contentTxt = (EditText) findViewById(R.id.detail_content);

        titleTxt.setText(title);
        contentTxt.setText(content);

        //Sharefunktion
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                if (content == null) {
                    String text = title;
                    intent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(intent, "Teile deine Notiz"));
                } else {
                    String text = title + ":\n" + content;
                    intent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(intent, "Teile deine Notiz"));
                }
            }
        });


        /*deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = DatabaseHelper.getInstance(NotizDetails.this);
                db.deleteEntry(notizCard);
                Intent intent = new Intent(NotizDetails.this, MainActivity.class);
                startActivity(intent);
            }
        });*/
    }
}