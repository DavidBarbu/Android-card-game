package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    String[] s1,s2;
    int[] images ={ R.drawable.card11, R.drawable.card2, R.drawable.card3, R.drawable.card4, R.drawable.card5,
            R.drawable.card6, R.drawable.card7, R.drawable.card8, R.drawable.card9, R.drawable.card10,
            R.drawable.card12, R.drawable.card13, R.drawable.card14};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.cards);
        s2 = getResources().getStringArray(R.array.card_descriptions);


        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}