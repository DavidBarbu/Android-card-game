package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {


    ImageView iv_card_left, iv_card_right;
    TextView tv_score_left, tv_score_right;
    Button b_deal,b_reset,b_war,b_share;
    int leftCard=0,rightCard=0;
    int leftCard1=0,rightCard1=0;

    Random r,rr,rrr,rrrr;
    //int[] cards={102,103,104,105,106,107,108,109,110,112,113,114,115,202,203,204,205,206,207,208,209,210,212,213,214,215};
    //List<Integer> list=new ArrayList<Integer>();
    //list.add("cards");
    int leftScore=0, rightScore = 0, simbol1=0,simbol2=0;

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
        b_share= findViewById(R.id.b_share);

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
                simbol1 = r.nextInt(4);
                simbol2 = r.nextInt(4);

                if(simbol1==0) {
                    int leftImage = getResources().getIdentifier("romb" + leftCard, "drawable", getPackageName());
                    iv_card_left.setImageResource(leftImage);
                }else if(simbol1==1){
                    int leftImage = getResources().getIdentifier("inima" + leftCard, "drawable", getPackageName());
                    iv_card_left.setImageResource(leftImage);
                }else if(simbol1==2){
                    int leftImage = getResources().getIdentifier("frunza" + leftCard, "drawable", getPackageName());
                    iv_card_left.setImageResource(leftImage);
                }else if(simbol1==3){
                    int leftImage = getResources().getIdentifier("trefla" + leftCard, "drawable", getPackageName());
                    iv_card_left.setImageResource(leftImage);
                }

                if(simbol2==0) {
                    int leftImage = getResources().getIdentifier("romb" + rightCard, "drawable", getPackageName());
                    iv_card_right.setImageResource(leftImage);
                }else if(simbol2==1){
                    int leftImage = getResources().getIdentifier("inima" + rightCard, "drawable", getPackageName());
                    iv_card_right.setImageResource(leftImage);
                }else if(simbol2==2){
                    int leftImage = getResources().getIdentifier("frunza" + rightCard, "drawable", getPackageName());
                    iv_card_right.setImageResource(leftImage);
                }else if(simbol2==3){
                    int leftImage = getResources().getIdentifier("trefla" + rightCard, "drawable", getPackageName());
                    iv_card_right.setImageResource(leftImage);
                }



                if(leftCard==11)
                    leftCard=15;
                if(rightCard==11)
                    rightCard=15;

                if(leftCard>rightCard){
                    leftScore++;
                }else if(leftCard<rightCard){
                    rightScore++;

                }else if(leftCard==rightCard){
                    Toast.makeText(MainActivity.this, "WAR!", Toast.LENGTH_SHORT).show();
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

                    simbol1 = r.nextInt(4);
                    simbol2 = r.nextInt(4);

                    if(simbol1==0) {
                        int leftImage = getResources().getIdentifier("romb" + leftCard1, "drawable", getPackageName());
                        iv_card_left.setImageResource(leftImage);
                    }else if(simbol1==1){
                        int leftImage = getResources().getIdentifier("inima" + leftCard1, "drawable", getPackageName());
                        iv_card_left.setImageResource(leftImage);
                    }else if(simbol1==2){
                        int leftImage = getResources().getIdentifier("frunza" + leftCard1, "drawable", getPackageName());
                        iv_card_left.setImageResource(leftImage);
                    }else if(simbol1==3){
                        int leftImage = getResources().getIdentifier("trefla" + leftCard1, "drawable", getPackageName());
                        iv_card_left.setImageResource(leftImage);
                    }

                    if(simbol2==0) {
                        int leftImage = getResources().getIdentifier("romb" + rightCard1, "drawable", getPackageName());
                        iv_card_right.setImageResource(leftImage);
                    }else if(simbol2==1){
                        int leftImage = getResources().getIdentifier("inima" + rightCard1, "drawable", getPackageName());
                        iv_card_right.setImageResource(leftImage);
                    }else if(simbol2==2){
                        int leftImage = getResources().getIdentifier("frunza" + rightCard1, "drawable", getPackageName());
                        iv_card_right.setImageResource(leftImage);
                    }else if(simbol2==3){
                        int leftImage = getResources().getIdentifier("trefla" + rightCard1, "drawable", getPackageName());
                        iv_card_right.setImageResource(leftImage);
                    }



                    if(leftCard1==11)
                        leftCard1=15;
                    if(rightCard1==11)
                        rightCard1=15;

                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e) {
                        System.out.println("got interrupted!");
                    }
                }
                //Toast.makeText(MainActivity.this, rightCard1, Toast.LENGTH_LONG).show();

                if(leftCard1>rightCard1){
                    leftScore+=rightCard;
                }else if(leftCard1<rightCard1){
                    rightScore+=rightCard;

                }else if(leftCard1==rightCard1){
                    Toast.makeText(MainActivity.this, "WAR!", Toast.LENGTH_SHORT).show();
                    if(rightScore!=0&&leftScore!=0){b_war.setText("WAR");}
                    b_war.setVisibility(view.VISIBLE);
                    b_war.setEnabled(true);

                }

                tv_score_left.setText(String.valueOf(leftScore));
                tv_score_right.setText(String.valueOf(rightScore));


            }
        });
        b_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Metoda de Share
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Scorul este "+ leftScore+" - "+rightScore);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);


            }
        });

    }
}