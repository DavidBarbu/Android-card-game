package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    private Button menu_play;
    private Button menu_exit;
    private Button b_exit;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        menu_play = findViewById(R.id.menu_play);
        menu_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        menu_exit = findViewById(R.id.menu_exit);
        menu_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(1);
            }
        });

        bottomNavigationView=findViewById(R.id.bottomNav);

        bottomNavigationView.setOnItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod=new
            BottomNavigationView.OnNavigationItemSelectedListener(){

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment=null;

                    switch (menuItem.getItemId())
                    {
                        case R.id.game:
                            fragment=new HomeFragment();
                            break;
                        case R.id.search:
                            fragment=new SearchFragment();
                            break;
                        case R.id.home:
                            fragment=new HomeFragment();
                            break;
                        case R.id.info:
                            fragment=new InfoFragment();
                            break;
                        case R.id.exit:
                            fragment=new ExitFragment();
                            break;

                        //11:20


                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

                    return true;
                }



            };

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }



}