package com.android.icow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Maxet on 06.01.2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.NotizViewHolder> {

    private Context mCtx;/*für inflator*/
    private List<NotizCard> notizlist; /*vllt NotizCardList*/

    public RecyclerAdapter(Context mCtx, List<NotizCard> notizlist) {
        this.mCtx = mCtx;
        this.notizlist = notizlist;
    }

    @Override /*Creates Viewholder instance and return an instance of the NotizViewHolder class -> return ViewHolder (UI elements)*/
    public NotizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_layout, null);
        NotizViewHolder holder = new NotizViewHolder(view);
        return holder;
        /*Inline möglich*/
    }

    @Override /*binds the data to view*/
    public void onBindViewHolder(NotizViewHolder holder, int position) {
        NotizCard notiz = notizlist.get(position);

        holder.textViewtitle.setText(notiz.getTitle());
        holder.textViewnotiztext.setText(notiz.getNotiztext());
        holder.textViewdatum.setText(notiz.getDatum());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(notiz.getImage()));
    }

    @Override /*returns the size of the List*/
    public int getItemCount() {
        return notizlist.size(); /*wenn == 0, RecyclerView stellt nichts dar*/
    }







        class NotizViewHolder extends RecyclerView.ViewHolder {
        //variablen: public ImageView itemImage; blablabla

            ImageView imageView;
            TextView textViewtitle, textViewnotiztext, textViewdatum;


        public NotizViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.card_image); /*Möglicherweise muss ein ImageView in der XML vorher definiert werden*/
            textViewtitle = itemView.findViewById(R.id.card_title);
            textViewnotiztext = itemView.findViewById(R.id.card_content);
            textViewdatum = itemView.findViewById(R.id.card_datum);

        }
    }
}


