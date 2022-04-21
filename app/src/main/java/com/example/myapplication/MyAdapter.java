package com.example.myapplication;
import android.content.Context;
import android.media.Image;
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


    List<String> data1= new ArrayList<>();
    List<String> data2= new ArrayList<>();

    List<String> exampleListFull= new ArrayList<>();
    int images[];
    Context context;

    int images1[];
    public MyAdapter(Context ct, List<String> s1, List<String> s2, int img[]){
        context=ct;
        data1.addAll(s1);
        data2.addAll(s2);
        images=img;
        exampleListFull.addAll(data2);

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
        holder.myText1.setText(data1.get(position));
        holder.myText2.setText(data2.get(position));
        holder.myImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return data2.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<String> filteredList = new ArrayList<>();
            String charString = constraint.toString();
            if (charString.isEmpty() || charString.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (String item : exampleListFull) {
                    if (item.toLowerCase().contains(filterPattern)) {
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
            data2.clear();
            data2.addAll((List) results.values);
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
            Toast.makeText(view.getContext(),data2.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }

}