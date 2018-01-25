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

    public static final String ENTRY_ID_KEY = "ID";
    Toolbar toolbar;
    ActionBar actionBar;
    NotizCard notizCard;
    EditText titleTxt,contentTxt;
    Button updateBtn,deleteBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notizdetails);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        Button share = (Button) findViewById(R.id.button_share);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Intent i=getIntent();

        final String title = i.getExtras().getString("TITLE");
        final String content = i.getExtras().getString("CONTENT");
        final long id = i.getExtras().getLong("ID");

        updateBtn = (Button) findViewById(R.id.button_update);
        deleteBtn = (Button) findViewById(R.id.button_delete);
        titleTxt = (EditText) findViewById(R.id.detail_title);
        contentTxt = (EditText) findViewById(R.id.detail_content);

        titleTxt.setText(title);
        contentTxt.setText(content);

        /*updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(id,nameTxt.getText().toString(),posTxt.getText().toString());
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(id);
            }
        });*/



        /*this.notizCard = DatabaseHelper.getInstance(this).readEntry(id);
        title.setText(notizCard.getTitle());
        content.setText(notizCard.getContent());*/


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                if(content == null){
                    String text = title;
                    intent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(intent, "Teile deinen Tag mit:"));}
                else {String text = title + ":\n" + content;
                    intent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(intent, "Teile deinen Tag mit:"));}
            }
        });
    }

    /*private void update(int id,String newName,String newPos)
    {
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        long result=db.UPDATE(id,newName,newPos);

        if(result>0)
        {
            nameTxt.setText(newName);
            nameTxt.setText(newPos);
            Toast.make(nameTxt,"Updated Sucesfully",Snackbar.LENGTH_SHORT).show();
        }else
        {
            Snackbar.make(nameTxt,"Unable to Update",Snackbar.LENGTH_SHORT).show();
        }

        db.close();
    }*/






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // Locate MenuItem with ShareActionProvider
        return true;}
}