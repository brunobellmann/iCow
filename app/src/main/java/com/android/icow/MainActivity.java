package com.android.icow;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.support.design.widget.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    List<NotizCard> notizCards;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    FloatingActionButton button;
    ShareActionProvider myShareActionProvider;
    View view;
    FloatingActionButton scannerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Notizliste");


        this.recyclerView = findViewById(R.id.recycler_view);
        this.notizCards = DatabaseHelper.getInstance(this).readAllEntries();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new RecyclerAdapter(this, notizCards);
        this.recyclerView.setAdapter(adapter);

        color();

        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotizCard notizCard = new NotizCard();

                notizCards.add(notizCard);
                Intent intent = new Intent(getApplicationContext(), Notiz_Add.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        refreshRecyclerView();
    }

    private void refreshRecyclerView() {
        notizCards.clear();
        notizCards.addAll(DatabaseHelper.getInstance(this).readAllEntries());
        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
        return true;
    }

    private void color ()   {
        Intent myintent = getIntent();
        int colornum = myintent.getIntExtra(Settings.EXTRA_COLORNUM,0);
        switch (colornum) {
            case 1:
                view = MainActivity.this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.cardview_dark_background);
                break;
            case 2:
                view = MainActivity.this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.colorPrimary);
                break;
            default:
                view = MainActivity.this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.cardview_light_background);
                break;
        }

    }
}