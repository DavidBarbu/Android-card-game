package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import androidx.recyclerview.widget.DividerItemDecoration;

import java.util.Arrays;
import java.util.List;

public class SearchActivity extends AppCompatActivity {




    RecyclerView recyclerView;
    MyAdapter myAdapter;

    private List<CardsClass> cardsList = new ArrayList<>();
    private MyAdapter adapter;

    //ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        fillCardsList();
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new MyAdapter(cardsList);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {

        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.search_icon_filter);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    private void fillCardsList() {
        cardsList.add(new CardsClass(R.drawable.romb11, "A", "A romb"));
        cardsList.add(new CardsClass(R.drawable.romb2, "2", "2 romb"));
        cardsList.add(new CardsClass(R.drawable.romb3, "3", "3 romb"));
        cardsList.add(new CardsClass(R.drawable.romb4, "4", "4 romb"));
        cardsList.add(new CardsClass(R.drawable.romb5, "5", "5 romb"));
        cardsList.add(new CardsClass(R.drawable.romb6, "6", "6 romb"));
        cardsList.add(new CardsClass(R.drawable.romb7, "7", "7 romb"));
        cardsList.add(new CardsClass(R.drawable.romb8, "8", "8 romb"));
        cardsList.add(new CardsClass(R.drawable.romb9, "9", "9 romb"));
        cardsList.add(new CardsClass(R.drawable.romb10, "10", "10 romb"));
        cardsList.add(new CardsClass(R.drawable.romb12, "J", "J romb"));
        cardsList.add(new CardsClass(R.drawable.romb13, "Q", "Q romb"));
        cardsList.add(new CardsClass(R.drawable.romb14, "K", "K romb"));

        cardsList.add(new CardsClass(R.drawable.inima11, "A", "A inima"));
        cardsList.add(new CardsClass(R.drawable.inima2, "2", "2 inima"));
        cardsList.add(new CardsClass(R.drawable.inima3, "3", "3 inima"));
        cardsList.add(new CardsClass(R.drawable.inima4, "4", "4 inima"));
        cardsList.add(new CardsClass(R.drawable.inima5, "5", "5 inima"));
        cardsList.add(new CardsClass(R.drawable.inima6, "6", "6 inima"));
        cardsList.add(new CardsClass(R.drawable.inima7, "7", "7 inima"));
        cardsList.add(new CardsClass(R.drawable.inima8, "8", "8 inima"));
        cardsList.add(new CardsClass(R.drawable.inima9, "9", "9 inima"));
        cardsList.add(new CardsClass(R.drawable.inima10, "10", "10 inima"));
        cardsList.add(new CardsClass(R.drawable.inima12, "J", "J inima"));
        cardsList.add(new CardsClass(R.drawable.inima13, "Q", "Q inima"));
        cardsList.add(new CardsClass(R.drawable.inima14, "K", "K inima"));

        cardsList.add(new CardsClass(R.drawable.frunza11, "A", "A frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza2, "2", "2 frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza3, "3", "3 frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza4, "4", "4 frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza5, "5", "5 frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza6, "6", "6 frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza7, "7", "7 frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza8, "8", "8 frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza9, "9", "9 frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza10, "10", "10 frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza12, "J", "J frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza13, "Q", "Q frunza"));
        cardsList.add(new CardsClass(R.drawable.frunza14, "K", "K frunza"));

        cardsList.add(new CardsClass(R.drawable.trefla11, "A", "A trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla2, "2", "2 trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla3, "3", "3 trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla4, "4", "4 trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla5, "5", "5 trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla6, "6", "6 trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla7, "7", "7 trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla8, "8", "8 trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla9, "9", "9 trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla10, "10", "10 trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla12, "J", "J trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla13, "Q", "Q trefla"));
        cardsList.add(new CardsClass(R.drawable.trefla14, "K", "K trefla"));

        cardsList.add(new CardsClass(R.drawable.back, "Spate", "Spatele Cartilor"));
    }
}
