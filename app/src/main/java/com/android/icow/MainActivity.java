package com.android.icow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.List;
import android.support.design.widget.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    List<NotizCard> notizCards;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_activity_main);


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

 //   @Override
 /*   protected void onStop() {
        super.onStop();
        Intent myintent = getIntent();
        int colornum = myintent.getIntExtra(Settings.EXTRA_COLORNUM,0);
        color();

    } */

    @Override
    protected void onResume() {
        super.onResume();
        refreshRecyclerView();
        color();
    }

    private void refreshRecyclerView() {
        notizCards.clear();
        notizCards.addAll(DatabaseHelper.getInstance(this).readAllEntries());
        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_item_camera:
                Intent intentqrscanner = new Intent(this, qrscanner.class);
                startActivity(intentqrscanner);
                return true;

            case R.id.menu_item_settings:
                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void color ()   {
        Intent myintent = getIntent();
        int colornum = myintent.getIntExtra(Settings.EXTRA_COLORNUM,0);
        switch (colornum) {
            case 1:
                view = MainActivity.this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.cardview_dark_background);
                break;
            default:
                view = MainActivity.this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.cardview_light_background);
                break;
        }

    }
}