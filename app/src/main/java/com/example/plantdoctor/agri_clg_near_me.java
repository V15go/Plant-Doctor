package com.example.plantdoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import soup.neumorphism.NeumorphCardView;

public class agri_clg_near_me extends AppCompatActivity {
    private AutoCompleteTextView city_select;

    ArrayAdapter<String> arrayAdapter;

    BottomNavigationView bottomNavigationView;

    FloatingActionButton floatingActionButton;

   NeumorphCardView tnau_card, chidambaram_card, theni_card, Visalur_card, Pollachi_card, Vellore_card, Thanjavur_card, Arakkonam_card, karikudi_card, not_listed_card;

    Button coimb_btn, chidambaram_btn, theni_btn, Visalur_btn, Pollachi_btn, Vellore_btn, Thanjavur_btn, Arakkonam_btn, karikudi_btn, not_listed_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agri_clg_near_me);


        city_select = findViewById(R.id.select_city);

        tnau_card = findViewById(R.id.tnau_card);
        chidambaram_card  = findViewById(R.id.chidambaram_card);
        theni_card = findViewById(R.id.theni_card);
        Visalur_card = findViewById(R.id.Visalur_card);

        Pollachi_card = findViewById(R.id.Pollachi_card);
        Vellore_card = findViewById(R.id.Vellore_card);
        Thanjavur_card = findViewById(R.id.Thanjavur_card);
        Arakkonam_card = findViewById(R.id.Arakkonam_card);
        karikudi_card = findViewById(R.id.karikudi_card);
        not_listed_card = findViewById(R.id.not_listed_card);



        coimb_btn = findViewById(R.id.navig_TNAU);
        chidambaram_btn  = findViewById(R.id.navig_annamali);
        theni_btn = findViewById(R.id.navig_theni);
        Visalur_btn = findViewById(R.id.navig_kudumiyanmalai);

        Pollachi_btn = findViewById(R.id.navig_pollachi);
        Vellore_btn = findViewById(R.id.navig_Vellore);
        Thanjavur_btn = findViewById(R.id.navig_Thanjavur);
        Arakkonam_btn = findViewById(R.id.navig_Arakkonam);
        karikudi_btn = findViewById(R.id.navig_karikudi);
        not_listed_btn = findViewById(R.id.navig_not_listed);



        bottomNavigationView = findViewById(R.id.bottom_agri);
        floatingActionButton = findViewById(R.id.fab_agri);


        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(1).setEnabled(true);
        bottomNavigationView.getMenu().getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                Intent intent = new Intent(agri_clg_near_me.this, MainActivity.class);
                startActivity(intent);
                return false;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(agri_clg_near_me.this, detection_page.class);
                startActivity(intent);
            }
        });




        ArrayList<String> city = new ArrayList<>();


        city.add("Coimbatore");
        city.add("Chidambaram");
        city.add("Theni");
        city.add("Visalur");
        city.add("Vellore");
        city.add("Pollachi");
        city.add("Thanjavur");
        city.add("Arakkonam");
        city.add("Karaikudi");
        city.add("None of the above");

        arrayAdapter = new ArrayAdapter<>(this,R.layout.list_dropdown,city);

        city_select.setAdapter(arrayAdapter);

        String city_selected = city_select.getText().toString();

        if(city_selected.equals("Coimbatore")){
            tnau_card.setVisibility(View.VISIBLE);
        }



        city_select.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        tnau_card.setVisibility(View.VISIBLE);

                    case 2:
                        chidambaram_card.setVisibility(View.VISIBLE);

                    case 3:
                        theni_card.setVisibility(View.VISIBLE);

                    case 4:
                        Visalur_card.setVisibility(View.VISIBLE);

                    case 5:
                        Vellore_card.setVisibility(View.VISIBLE);
                    case 6:
                        Pollachi_card.setVisibility(View.VISIBLE);

                    case 7:
                        Thanjavur_card.setVisibility(View.VISIBLE);

                    case 8:
                        Arakkonam_card.setVisibility(View.VISIBLE);
                        break;
                    case 9:
                        karikudi_card.setVisibility(View.VISIBLE);
                        break;
                    case 10:
                        not_listed_card.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

       switch (city_selected){
           case "Coimbatore":
               tnau_card.setVisibility(View.VISIBLE);

           case "Chidambaram":
               chidambaram_card.setVisibility(View.VISIBLE);

           case "Theni":
               theni_card.setVisibility(View.VISIBLE);

           case "Visalur":
               Visalur_card.setVisibility(View.VISIBLE);

           case "Vellore":
               Vellore_card.setVisibility(View.VISIBLE);
           case "Pollachi":
               Pollachi_card.setVisibility(View.VISIBLE);

           case "Thanjavur":
               Thanjavur_card.setVisibility(View.VISIBLE);

           case "Arakkonam":
               Arakkonam_card.setVisibility(View.VISIBLE);
               break;
           case "Karaikudi":
               karikudi_card.setVisibility(View.VISIBLE);
               break;
           case "None of the above":
               not_listed_card.setVisibility(View.VISIBLE);
               break;
       }



       if(tnau_card.getVisibility() == View.VISIBLE){
            coimb_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/fLBygSKoLUqmJFWS6"));
                    startActivity(intent);
                }
            });
       }

        if(chidambaram_card.getVisibility() == View.VISIBLE){
            chidambaram_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/uZoxJ4Fa2bbSvBa1A"));
                    startActivity(intent);
                }
            });

        }

        if(theni_card.getVisibility() == View.VISIBLE){
            theni_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/uNMW7bQhE1Ro2t8v7"));
                    startActivity(intent);
                }
            });

        }

        if(Visalur_card.getVisibility() == View.VISIBLE){
            Visalur_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/8rkFNKQzP622JCkE6"));
                    startActivity(intent);
                }
            });

        }

        if(Vellore_card.getVisibility() == View.VISIBLE){
            Vellore_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/feSUuaP2boCcDzPXA"));
                    startActivity(intent);
                }
            });

        }
        if(Pollachi_card.getVisibility() == View.VISIBLE){
            Pollachi_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/kDWWCzMhpzNYLjCi7"));
                    startActivity(intent);
                }
            });

        }
        if(Thanjavur_card.getVisibility() == View.VISIBLE){
            Thanjavur_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/h97hWfUXtnnUSVJn6"));
                    startActivity(intent);
                }
            });

        }

        if(Arakkonam_card.getVisibility() == View.VISIBLE){
            Arakkonam_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/czmDJLLgstaMtYxEA"));
                    startActivity(intent);
                }
            });

        }

        if(karikudi_card.getVisibility() == View.VISIBLE){
            karikudi_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/wTBcpoUjf2rRSMe97"));
                    startActivity(intent);
                }
            });

        }
        if(not_listed_btn.getVisibility() == View.VISIBLE){
            not_listed_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tnau.ac.in/affiliated-colleges/"));
                    startActivity(intent);
                }
            });

        }

    }


}