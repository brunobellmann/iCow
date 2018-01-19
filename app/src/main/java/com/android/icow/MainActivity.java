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
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    /*RecyclerView.Adapter adapter;*/
    RecyclerAdapter adapter;
    FloatingActionButton button;
    DatabaseHelper myDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Einkaufsliste");


        recyclerView = findViewById(R.id.recycler_view);
        /*recyclerView.setHasFixedSize(true);/*(keine Ahnung warum)*/
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        /*List<NotizCard> notizenliste = new ArrayList<>();
        myDB = new DatabaseHelper(this);
        NotizCard notiz;

        Cursor data = myDB.getListContents();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                notizlist.add(data.getString(1));//Col2 = 1
                adapter = new RecyclerAdapter(this,notizlist);
                recyclerView.setAdapter(adapter);
            }
        }
*/



        /*notizCardListist.add(
                new NotizCard(1, "Titel", "Content Content Content Content", "12.12.1221", R.drawable.controller));

        adapter = new RecyclerAdapter(this, notizCardListist);
        recyclerView.setAdapter(adapter);*/




        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*NotizCard notizCard = new NotizCard(
                        1, "lol", "lol", "1.12.1222", R.drawable.controller);

                notizCardListist.add(notizCard);
                recyclerView.setAdapter(adapter);*/
                Intent intent = new Intent(getApplicationContext(), NotizDetails.class);
                startActivity(intent);
            }
        });

//populate an ArrayList<String> from the database and then view it














        // test der Add funktion
        // for(int i = 0; i<= 5; i++){
        //   NotizCard notizCard = new NotizCard(
        //            i+1, "lol"+i, "lol"+1, "1.12.1222", R.drawable.controller);

        //     notizCardListist.add(notizCard);


        //   adapter = new RecyclerAdapter(this, notizCardListist);
        //   recyclerView.setAdapter(adapter);


    }






        /*cd1 = (CardView) findViewById(R.id.card1);
        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You clicked Card 1", Toast.LENGTH_LONG).show();
            }
        });

        //CardView ClickEvent to new Activity
        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NotizDetails.class);
                startActivity(intent);
            }
        });*/


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




    //Inhalt


