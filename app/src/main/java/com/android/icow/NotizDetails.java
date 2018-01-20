package com.android.icow;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
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
    private NotizCard notizCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notizdetails);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.notizCard = new NotizCard();

        mTitleEditText = (EditText)findViewById(R.id.detail_title);
        mContentEditText = (EditText)findViewById(R.id.detail_content);
        button = (Button)findViewById(R.id.button_add);

        this.mTitleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

            }

            @Override
            public void onTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {
                notizCard.setTitle(editable.toString().length() == 0 ? null : editable.toString());
            }
        });

        this.mContentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

            }

            @Override
            public void onTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {
                notizCard.setContent(editable.toString().length() == 0 ? null : editable.toString());
            }
        });



        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (notizCard.getTitle() == null) {
                    Toast.makeText(NotizDetails.this, "Fehler beim speicher, bitte noch ein namen eingeben.", Toast.LENGTH_SHORT).show();
                    return;
                }

                DatabaseHelper.getInstance(NotizDetails.this).createEntry(notizCard);
                finish();
            }
        });

    /*public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }*/


}}
