package com.android.icow;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Notiz_Add extends AppCompatActivity {

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
        setContentView(R.layout.activity_notiz__add);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.notizCard = new NotizCard();

        mTitleEditText = (EditText) findViewById(R.id.detail_title);
        mContentEditText = (EditText) findViewById(R.id.detail_content);
        button = (Button) findViewById(R.id.button_add);

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
                    Toast.makeText(Notiz_Add.this, "Fehler beim speicher, bitte noch ein namen eingeben.", Toast.LENGTH_SHORT).show();
                    return;
                }

                DatabaseHelper.getInstance(Notiz_Add.this).createEntry(notizCard);
                finish();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_item_save:
                if (notizCard.getTitle() == null) {
                    Toast.makeText(Notiz_Add.this, "Fehler beim speichern, bitte noch ein Titel eingeben.", Toast.LENGTH_SHORT).show();

                } else {
                    DatabaseHelper.getInstance(Notiz_Add.this).createEntry(notizCard);
                    finish();
                }return true;


            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
