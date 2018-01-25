package com.android.icow;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Maxet on 25.01.2018.
 */

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

        Log.e("Test Content", "sucessful");

    }
}