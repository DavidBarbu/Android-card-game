package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {


    ImageView iv_card_left, iv_card_right;
    TextView tv_score_left, tv_score_right;
    Button b_deal,b_reset,b_war,b_share;
    int i=-1;


    ArrayList<CardsClass> cardDeck = new ArrayList<CardsClass>(56);
    ArrayList<CardsClass> warLeft = new ArrayList<CardsClass>(56);
    ArrayList<CardsClass> warRight = new ArrayList<CardsClass>(56);
    ArrayList<CardsClass> deckLeft = new ArrayList<CardsClass>(56);
    ArrayList<CardsClass> deckRight = new ArrayList<CardsClass>(56);

    Random r;
    int leftScore=26, rightScore = 26, simbol1=0,simbol2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillCardsList(cardDeck);
        Collections.shuffle(cardDeck);
        for(int j=0; j<26 ;j++)
        {
            deckLeft.add(cardDeck.get(j));
            deckRight.add(cardDeck.get(j+26));
        }

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
                b_deal.setEnabled(true);
                b_deal.setText("DEAL");



                leftScore=26;
                rightScore=26;

                b_war.setVisibility(view.GONE);
                b_war.setText("");
                b_war.setEnabled(true);

                tv_score_left.setText(String.valueOf(leftScore));
                tv_score_right.setText(String.valueOf(rightScore));

                int leftImage = getResources().getIdentifier("back", "drawable", getPackageName());
                iv_card_left.setImageResource(leftImage);
                int rightImage = getResources().getIdentifier("back", "drawable", getPackageName());
                iv_card_right.setImageResource(rightImage);
                Collections.shuffle(cardDeck);
                deckLeft.clear();
                deckRight.clear();
                for(int j=0; j<26 ;j++)
                {
                    deckLeft.add(cardDeck.get(j));
                    deckRight.add(cardDeck.get(j+26));
                }
                i=-1;


            }
        });

        b_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b_war.setVisibility(view.GONE);
                b_war.setText("");
                i+=1;
                i= i % ( Math.min(deckLeft.size(), deckRight.size()));
                iv_card_left.setImageResource(deckLeft.get(i).getImageResource());
                iv_card_right.setImageResource(deckRight.get(i).getImageResource());

                    if(deckLeft.get(i).getValue() > deckRight.get(i).getValue() && leftScore>1 && rightScore>1 )
                    {

                        deckLeft.add(deckRight.get(i));
                        deckRight.remove(i);
                        leftScore+=1;
                        rightScore-=1;
                    }else if(deckLeft.get(i).getValue() < deckRight.get(i).getValue() && leftScore>1 && rightScore>1 ) {
                        deckRight.add(deckLeft.get(i));
                        deckLeft.remove(i);
                        rightScore += 1;
                        leftScore -= 1;
                    } else if(deckLeft.get(i).getValue() == deckRight.get(i).getValue() && leftScore>1 && rightScore>1 ){


                        Toast.makeText(MainActivity.this, "WAR!", Toast.LENGTH_SHORT).show();
                        if (rightScore != 0 && leftScore != 0) {
                            b_war.setText("WAR");
                        }
                        b_war.setVisibility(view.VISIBLE);
                        b_war.setEnabled(true);

                    }else if(rightScore<=1) {
                        b_deal.setEnabled(false);
                        b_deal.setText("YOU WON!");
                        Toast.makeText(MainActivity.this, "YOU WON!", Toast.LENGTH_SHORT).show();
                    }else if(leftScore<=1){
                        b_deal.setEnabled(false);
                        b_deal.setText("YOU LOST!");
                        Toast.makeText(MainActivity.this, "YOU LOST!", Toast.LENGTH_SHORT).show();
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

                int x=deckLeft.get(i).getValue();
                x=Math.min(x,Math.min(deckLeft.size()-i-1,deckRight.size()-i-1));
                for (int j = 0; j < x; j++) {
                    warRight.add(deckRight.get(i+j));
                    warLeft.add(deckLeft.get(i+j));
                }
                if(deckRight.get(i+x).getValue()>deckLeft.get(i+x).getValue()){
                    deckRight.addAll(warLeft);
                    deckLeft.removeAll(warLeft);
                    leftScore-=x;
                    rightScore+=x;
                }
                else{
                    deckLeft.addAll(warRight);
                    deckRight.removeAll(warRight);
                    leftScore+=x;
                    rightScore-=x;
                }
                i=-1;






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
        if(rightScore==0)
        {
            b_deal.setEnabled(false);
            Toast.makeText(MainActivity.this, "YOU WON!", Toast.LENGTH_SHORT).show();
        }
        if(leftScore==0){
            b_deal.setEnabled(false);
            Toast.makeText(MainActivity.this, "YOU LOST!", Toast.LENGTH_SHORT).show();
        }

    }

    private void fillCardsList(List<CardsClass> cardsList) {
        cardsList.add(new CardsClass(15, R.drawable.romb11, "A", "A romb"));
        cardsList.add(new CardsClass(2, R.drawable.romb2, "2", "2 romb"));
        cardsList.add(new CardsClass(3, R.drawable.romb3, "3", "3 romb"));
        cardsList.add(new CardsClass(4, R.drawable.romb4, "4", "4 romb"));
        cardsList.add(new CardsClass(5, R.drawable.romb5, "5", "5 romb"));
        cardsList.add(new CardsClass(6, R.drawable.romb6, "6", "6 romb"));
        cardsList.add(new CardsClass(7, R.drawable.romb7, "7", "7 romb"));
        cardsList.add(new CardsClass(8, R.drawable.romb8, "8", "8 romb"));
        cardsList.add(new CardsClass(9, R.drawable.romb9, "9", "9 romb"));
        cardsList.add(new CardsClass(10, R.drawable.romb10, "10", "10 romb"));
        cardsList.add(new CardsClass(12, R.drawable.romb12, "J", "J romb"));
        cardsList.add(new CardsClass(13, R.drawable.romb13, "Q", "Q romb"));
        cardsList.add(new CardsClass(14, R.drawable.romb14, "K", "K romb"));

        cardsList.add(new CardsClass(15, R.drawable.inima11, "A", "A inima"));
        cardsList.add(new CardsClass(2, R.drawable.inima2, "2", "2 inima"));
        cardsList.add(new CardsClass(3, R.drawable.inima3, "3", "3 inima"));
        cardsList.add(new CardsClass(4, R.drawable.inima4, "4", "4 inima"));
        cardsList.add(new CardsClass(5, R.drawable.inima5, "5", "5 inima"));
        cardsList.add(new CardsClass(6, R.drawable.inima6, "6", "6 inima"));
        cardsList.add(new CardsClass(7, R.drawable.inima7, "7", "7 inima"));
        cardsList.add(new CardsClass(8, R.drawable.inima8, "8", "8 inima"));
        cardsList.add(new CardsClass(9, R.drawable.inima9, "9", "9 inima"));
        cardsList.add(new CardsClass(10, R.drawable.inima10, "10", "10 inima"));
        cardsList.add(new CardsClass(12, R.drawable.inima12, "J", "J inima"));
        cardsList.add(new CardsClass(13, R.drawable.inima13, "Q", "Q inima"));
        cardsList.add(new CardsClass(14, R.drawable.inima14, "K", "K inima"));

        cardsList.add(new CardsClass(15, R.drawable.frunza11, "A", "A frunza"));
        cardsList.add(new CardsClass(2, R.drawable.frunza2, "2", "2 frunza"));
        cardsList.add(new CardsClass(3, R.drawable.frunza3, "3", "3 frunza"));
        cardsList.add(new CardsClass(4, R.drawable.frunza4, "4", "4 frunza"));
        cardsList.add(new CardsClass(5, R.drawable.frunza5, "5", "5 frunza"));
        cardsList.add(new CardsClass(6, R.drawable.frunza6, "6", "6 frunza"));
        cardsList.add(new CardsClass(7, R.drawable.frunza7, "7", "7 frunza"));
        cardsList.add(new CardsClass(8, R.drawable.frunza8, "8", "8 frunza"));
        cardsList.add(new CardsClass(9, R.drawable.frunza9, "9", "9 frunza"));
        cardsList.add(new CardsClass(10, R.drawable.frunza10, "10", "10 frunza"));
        cardsList.add(new CardsClass(12, R.drawable.frunza12, "J", "J frunza"));
        cardsList.add(new CardsClass(13, R.drawable.frunza13, "Q", "Q frunza"));
        cardsList.add(new CardsClass(14, R.drawable.frunza14, "K", "K frunza"));

        cardsList.add(new CardsClass(15, R.drawable.trefla11, "A", "A trefla"));
        cardsList.add(new CardsClass(2, R.drawable.trefla2, "2", "2 trefla"));
        cardsList.add(new CardsClass(3, R.drawable.trefla3, "3", "3 trefla"));
        cardsList.add(new CardsClass(4, R.drawable.trefla4, "4", "4 trefla"));
        cardsList.add(new CardsClass(5, R.drawable.trefla5, "5", "5 trefla"));
        cardsList.add(new CardsClass(6, R.drawable.trefla6, "6", "6 trefla"));
        cardsList.add(new CardsClass(7, R.drawable.trefla7, "7", "7 trefla"));
        cardsList.add(new CardsClass(8, R.drawable.trefla8, "8", "8 trefla"));
        cardsList.add(new CardsClass(9, R.drawable.trefla9, "9", "9 trefla"));
        cardsList.add(new CardsClass(10, R.drawable.trefla10, "10", "10 trefla"));
        cardsList.add(new CardsClass(12, R.drawable.trefla12, "J", "J trefla"));
        cardsList.add(new CardsClass(13, R.drawable.trefla13, "Q", "Q trefla"));
        cardsList.add(new CardsClass(14, R.drawable.trefla14, "K", "K trefla"));
    }
}