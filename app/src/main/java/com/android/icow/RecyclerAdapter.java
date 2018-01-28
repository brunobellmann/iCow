package com.android.icow;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by Maxet on 06.01.2018.
 */

public class  RecyclerAdapter extends RecyclerView.Adapter<NotizViewHolder> {

    private Context mCtx;
    private List<NotizCard> mNotizCardList;
    private RecyclerView mRecyclerV;
    private NotizCard notizCard;

    public RecyclerAdapter(Context mCtx, List<NotizCard> mNotizCardList) {
        this.mCtx = mCtx;
        this.mNotizCardList = mNotizCardList;
    }

    @Override
    public NotizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_layout, null);
        NotizViewHolder holder = new NotizViewHolder(view);
        return holder;
    }

    @Override /*binds the data to view*/
    public void onBindViewHolder(NotizViewHolder holder, final int position) {

        holder.NotizTitleTxtV.setText(mNotizCardList.get(position).getTitle());
        holder.NotizContentTxtV.setText(mNotizCardList.get(position).getContent());
        holder.NotizLastModTxtV.setText(mNotizCardList.get(position).getLast_modification());
        holder.LocLat.setText(mNotizCardList.get(position).getLatitude());
        holder.LocLon.setText(mNotizCardList.get(position).getLongitude());


        //toast
        holder.RelativeLayoutCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mCtx, "You Clicked " + mNotizCardList.get(position).getId(), Toast.LENGTH_LONG).show();
                Intent i = new Intent(mCtx,NotizDetails.class);

                //LOAD DATA
                i.putExtra("TITLE",mNotizCardList.get(position).getTitle());
                i.putExtra("CONTENT",mNotizCardList.get(position).getContent());
                i.putExtra("ID",mNotizCardList.get(position).getId());

                //START ACTIVITY
                mCtx.startActivity(i); Log.d("showactivity","sucessful");

            }
        });
    }


    @Override
    public int getItemCount() {
        return mNotizCardList.size();
    }
}