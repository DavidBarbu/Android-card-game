package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.inputmethod.EditorInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.widget.EditText;
import android.widget.Toast;
import androidx.recyclerview.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchActivity extends AppCompatActivity {




    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<String> s1= new ArrayList<>();
    List<String> s2= new ArrayList<>();
    int[] images ={
            R.drawable.romb11, R.drawable.romb2, R.drawable.romb3, R.drawable.romb4, R.drawable.romb5,
            R.drawable.romb6, R.drawable.romb7, R.drawable.romb8, R.drawable.romb9, R.drawable.romb10,
            R.drawable.romb12, R.drawable.romb13, R.drawable.romb14,

            R.drawable.inima11, R.drawable.inima2, R.drawable.inima3, R.drawable.inima4, R.drawable.inima5,
            R.drawable.inima6, R.drawable.inima7, R.drawable.inima8, R.drawable.inima9, R.drawable.inima10,
            R.drawable.inima12, R.drawable.inima13, R.drawable.inima14,

            R.drawable.frunza11, R.drawable.frunza2, R.drawable.frunza3, R.drawable.frunza4, R.drawable.frunza5,
            R.drawable.frunza6, R.drawable.frunza7, R.drawable.frunza8, R.drawable.frunza9, R.drawable.frunza10,
            R.drawable.frunza12, R.drawable.frunza13, R.drawable.frunza14,

            R.drawable.trefla11, R.drawable.trefla2, R.drawable.trefla3, R.drawable.trefla4, R.drawable.trefla5,
            R.drawable.trefla6, R.drawable.trefla7, R.drawable.trefla8, R.drawable.trefla9, R.drawable.trefla10,
            R.drawable.trefla12, R.drawable.trefla13, R.drawable.trefla14,

            R.drawable.back
    };

    //ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        recyclerView = findViewById(R.id.recyclerView);

        s1 = Arrays.asList(getResources().getStringArray(R.array.cards));
        s2 = Arrays.asList(getResources().getStringArray(R.array.card_descriptions));

        //arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,s1);

        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
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
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}
