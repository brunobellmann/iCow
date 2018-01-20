package com.android.icow;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
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

public class  RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.NotizViewHolder> {

    private Context mCtx;/*für inflator*/
    private List<NotizCard> mNotizCardList; /*vllt NotizCardList*/
    private RecyclerView mRecyclerV;

    public RecyclerAdapter(Context mCtx, List<NotizCard> mNotizCardList) {
        this.mCtx = mCtx;
        this.mNotizCardList = mNotizCardList;
    }


    /*Creates Viewholder instance and return an instance of the NotizViewHolder class -> return ViewHolder (UI elements)*/
    @Override
    public NotizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_layout, null);
        NotizViewHolder holder = new NotizViewHolder(view);
        return holder;
        /*Inline möglich*/
    }

    @Override /*binds the data to view*/
    public void onBindViewHolder(NotizViewHolder holder, int position) {
        final NotizCard notiz = mNotizCardList.get(position);

        holder.NotizTitleTxtV.setText(notiz.getTitle());
        holder.NotizContentTxtV.setText(notiz.getContent());
        holder.NotizLastModTxtV.setText(notiz.getLast_modification());

        /*holder.NotizImageV.setImageDrawable(mCtx.getResources().getDrawable(notiz.getImage()));*/
        holder.LocLat.setText(notiz.getLatitude());
        holder.LocLon.setText(notiz.getLongitude());

        holder.RelativeLayoutCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mCtx, "You Clicked "+notiz.getId(), Toast.LENGTH_LONG).show();
                goToUpdateActivity(String.valueOf(notiz.getId()));
            }
        });



    }




    @Override /*returns the size of the List*/
    public int getItemCount() {
        return mNotizCardList.size(); /*wenn == 0, RecyclerView stellt nichts dar*/
    }

    class NotizViewHolder extends RecyclerView.ViewHolder {

            public ImageView NotizImageV;
            public TextView NotizTitleTxtV, NotizContentTxtV, NotizLastModTxtV, LocLat, LocLon;
            public RelativeLayout RelativeLayoutCardView;

            public View layout;


            public NotizViewHolder(View itemView) {
            super(itemView);

                NotizImageV = itemView.findViewById(R.id.card_image); /*Möglicherweise muss ein ImageView in der XML vorher definiert werden*/
                NotizTitleTxtV = itemView.findViewById(R.id.card_title);
                NotizContentTxtV = itemView.findViewById(R.id.card_content);
                NotizLastModTxtV = itemView.findViewById(R.id.card_datum);
                RelativeLayoutCardView = (RelativeLayout) itemView.findViewById(R.id.RelativeLayoutCardView);
                LocLat = itemView.findViewById(R.id.loc_lat);
                LocLon = itemView.findViewById(R.id.loc_lon);
        }

    }

    public void add(int position, NotizCard notiz) {
        mNotizCardList.add(position, notiz);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mNotizCardList.remove(position);
        notifyItemRemoved(position);
    }

    public RecyclerAdapter(Context mCtx, List<NotizCard> mnotizliste,Context context, RecyclerView recyclerView) {
        mNotizCardList = mnotizliste;
        mCtx = context;
        mRecyclerV = recyclerView;
    }






    private void goToUpdateActivity(String personId){
        Intent goToUpdate = new Intent(mCtx, NotizDetails.class);
        goToUpdate.putExtra("id", personId);
        mCtx.startActivity(goToUpdate);}

}


