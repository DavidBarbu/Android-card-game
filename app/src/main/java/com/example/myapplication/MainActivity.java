package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ImageView iv_card_left, iv_card_right;
    TextView tv_score_left, tv_score_right;
    Button b_deal,b_reset;

    Random r;

    int leftScore=0, rightScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_card_left= findViewById(R.id.iv_card_left);
        iv_card_right= findViewById(R.id.iv_card_right);
        tv_score_left= findViewById(R.id.tv_score_left);
        tv_score_right= findViewById(R.id.tv_score_right);
        b_deal= findViewById(R.id.b_deal);
        b_reset= findViewById(R.id.b_reset);

        r=new Random();


        b_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftScore=0;
                rightScore=0;

                tv_score_left.setText(String.valueOf(leftScore));
                tv_score_right.setText(String.valueOf(rightScore));

                int leftImage = getResources().getIdentifier("back", "drawable", getPackageName());
                iv_card_left.setImageResource(leftImage);
                int rightImage = getResources().getIdentifier("back", "drawable", getPackageName());
                iv_card_right.setImageResource(rightImage);
            }
        });

        b_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int leftCard = r.nextInt(13)+2;
                int rightCard = r.nextInt(13)+2;

                int leftImage = getResources().getIdentifier("card"+leftCard, "drawable", getPackageName());
                iv_card_left.setImageResource(leftImage);

                int rightImage = getResources().getIdentifier("card"+rightCard, "drawable", getPackageName());
                iv_card_right.setImageResource(rightImage);

                if(leftCard>rightCard){
                    leftScore++;
                }else if(leftCard<rightCard){
                    rightScore++;

                }else{
                    Toast.makeText(MainActivity.this, "WAR!", Toast.LENGTH_SHORT).show();
                }



                tv_score_left.setText(String.valueOf(leftScore));
                tv_score_right.setText(String.valueOf(rightScore));


            }
        });
    }
}