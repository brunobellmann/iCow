package com.android.icow;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.String.valueOf;

public class NotizDetails extends AppCompatActivity {

    ActionBar actionBar;
    EditText titleTxt, contentTxt;
    Button updateBtn, deleteBtn;
    DatabaseHelper dbh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notizdetails);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        Button share = findViewById(R.id.button_share);
        dbh = new DatabaseHelper(this);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Notiz");

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


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbh.deleteEntry(valueOf(id));
                Intent intent = new Intent(NotizDetails.this, MainActivity.class);
                startActivity(intent);
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbh.updateEntry((valueOf(id)),titleTxt.getText().toString(),contentTxt.getText().toString());
                Intent intent = new Intent(NotizDetails.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}