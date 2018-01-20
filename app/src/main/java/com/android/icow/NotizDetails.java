package com.android.icow;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotizDetails extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionBar;
    EditText mTitleEditText;
    EditText mContentEditText;
    DatabaseHelper myDB;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notizdetails);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mTitleEditText = (EditText)findViewById(R.id.detail_title);
        mContentEditText = (EditText)findViewById(R.id.detail_content);
        button = (Button)findViewById(R.id.button_add);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                Toast.makeText(getApplicationContext(), "This is my Toast message!",
                        Toast.LENGTH_LONG).show();
            }
        });

    }




    /*@Override
    public void onBackPressed() {
        save();
        super.onBackPressed();
    }*/

    public void save() {
        String title = mTitleEditText.getText().toString().trim();
        String content = mContentEditText.getText().toString().trim();
        myDB = new DatabaseHelper(this);

        NotizCard notiz = new NotizCard(0, null, title, content, null, null, null);
        myDB.saveNewNotiz(notiz);

    }

    /*public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }*/


}
