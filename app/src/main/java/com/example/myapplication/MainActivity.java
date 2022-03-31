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
    Button b_deal,b_reset,b_war;
    int leftCard=0,rightCard=0;
    int leftCard1=0,rightCard1=0;

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
        b_war= findViewById(R.id.b_war);

        r=new Random();



        b_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftScore=0;
                rightScore=0;
                b_war.setVisibility(view.GONE);
                b_war.setText("");
                b_war.setEnabled(true);

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
                b_war.setVisibility(view.GONE);
                b_war.setText("");

                leftCard = r.nextInt(13)+2;
                rightCard = r.nextInt(13)+2;

                int leftImage = getResources().getIdentifier("card"+leftCard, "drawable", getPackageName());
                iv_card_left.setImageResource(leftImage);

                int rightImage = getResources().getIdentifier("card"+rightCard, "drawable", getPackageName());
                iv_card_right.setImageResource(rightImage);

                if(leftCard>rightCard){
                    leftScore++;
                }else if(leftCard<rightCard){
                    rightScore++;

                }else{
                    Toast.makeText(MainActivity.this, "WAR!", Toast.LENGTH_LONG).show();
                    if(rightScore!=0&&leftScore!=0){b_war.setText("WAR");}
                    b_war.setVisibility(view.VISIBLE);
                    b_war.setEnabled(true);

                }

                tv_score_left.setText(String.valueOf(leftScore));
                tv_score_right.setText(String.valueOf(rightScore));


            }
        });
        b_war.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b_war.setEnabled(false);
                b_war.setText("");
                for( int i=0; i<rightCard; i++) {
                    leftCard1 = r.nextInt(13) + 2;
                    rightCard1 = r.nextInt(13) + 2;
                    int leftImage = getResources().getIdentifier("card"+leftCard1, "drawable", getPackageName());
                    iv_card_left.setImageResource(leftImage);

                    int rightImage = getResources().getIdentifier("card"+rightCard1, "drawable", getPackageName());
                    iv_card_right.setImageResource(rightImage);
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e) {
                        System.out.println("got interrupted!");
                    }
                }
                //Toast.makeText(MainActivity.this, rightCard1, Toast.LENGTH_LONG).show();

                rightScore=rightScore+rightCard;

                tv_score_left.setText(String.valueOf(leftScore));
                tv_score_right.setText(String.valueOf(rightScore));


            }
        });

    }
}