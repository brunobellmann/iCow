package com.android.icow;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    CardView cd1;
    List<NotizCard> notizCards;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    FloatingActionButton button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Einkaufsliste");


        this.recyclerView = findViewById(R.id.recycler_view);
        this.notizCards = DatabaseHelper.getInstance(this).readAllEntries();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new RecyclerAdapter(this, notizCards);
        this.recyclerView.setAdapter(adapter);



        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotizCard notizCard = new NotizCard(
                        1, "lol", "lol", "1.12.1222", null, null,null);

                notizCards.add(notizCard);
                Intent intent = new Intent(getApplicationContext(), NotizDetails.class);
                startActivity(intent);
            }
        });





        // test der Add funktion
        // for(int i = 0; i<= 5; i++){
        //   NotizCard notizCard = new NotizCard(
        //            i+1, "lol"+i, "lol"+1, "1.12.1222", R.drawable.controller);

        //     notizCardListist.add(notizCard);


        //   adapter = new RecyclerAdapter(this, notizCardListist);
        //   recyclerView.setAdapter(adapter);


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
}