package com.example.myapplication;
import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Collection;
import java.util.Collections;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {


    private List<CardsClass> cardsList;
    private List<CardsClass> cardsListFull;

    public MyAdapter(List<CardsClass> cardsList) {
        this.cardsList = cardsList;
        cardsListFull = new ArrayList<>(cardsList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CardsClass currentItem= cardsList.get(position);
        holder.myText1.setText(currentItem.getText1());
        holder.myText2.setText(currentItem.getText2());
        holder.myImage.setImageResource(currentItem.getImageResource());

    }

    @Override
    public int getItemCount() {
        return cardsList.size();
    }

    @Override
    public Filter getFilter() {
        return cardsFilter;
    }
    private Filter cardsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CardsClass> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(cardsListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (CardsClass item : cardsListFull) {
                    if (item.getText2().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            cardsList.clear();
            cardsList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView myImage;
        TextView myText1, myText2;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            myText1=itemView.findViewById(R.id.myText1);
            myText2=itemView.findViewById(R.id.myText2);
            myImage=itemView.findViewById(R.id.myImageView);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view){
           //Toast.makeText(view.getContext(),data2.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }

}