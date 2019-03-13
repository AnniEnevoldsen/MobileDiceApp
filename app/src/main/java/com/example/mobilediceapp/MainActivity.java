package com.example.mobilediceapp;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRoll;
    Button btnClear;
    ImageView imgDie1;
    ImageView imgDie2;
    ListView lstViewHistory;
    int count = 0;
    int val1;
    int val2;
    String history;
    Spinner mspin;
    NumberPicker nrp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getItems();

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearHistory();
            }
        });

        mspin= findViewById(R.id.spinner);
        Integer[] items = new Integer[]{1,2,3,4};
        ArrayAdapter<Integer> adapter =
                new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items);
        mspin.setAdapter(adapter);

        nrp = findViewById(R.id.nrpicker);
        nrp.setMinValue(1);
        nrp.setMaxValue(6);
    }

    private void getItems()
    {
        lstViewHistory = findViewById(R.id.lstViewHistory);

        btnRoll = findViewById(R.id.btnRollDice);
        btnClear = findViewById(R.id.btnClear);

        imgDie1 = findViewById(R.id.imgDie1);
        imgDie2 = findViewById(R.id.imgDie2);
    }

    private void rollDice()
    {   count++;
        val1 = randomValue();
        val2 = randomValue();

        history = "" + count + ": You rolled " + val1 + " & " + val2;
        Log.d("XYZ", history);

        changeImage(val1, imgDie1);
        changeImage(val2, imgDie2);
        Log.d("XYZ", "" + nrp.getValue());
    }

    private int randomValue()
    {
        Random r = new Random();
        return r.nextInt(6)+1;
    }

    private void clearHistory()
    {
        count = 0;
        imgDie1.setImageResource(R.drawable.die3d);
        imgDie2.setImageResource(R.drawable.die3d);
    }

    private void changeImage(int value, ImageView imgDice)
    {
        if (value == 1)
        {
            imgDice.setImageResource(R.drawable.one);
        }
        if (value == 2)
        {
            imgDice.setImageResource(R.drawable.two);
        }
        if (value == 3)
        {
            imgDice.setImageResource(R.drawable.three);
        }
        if (value == 4)
        {
            imgDice.setImageResource(R.drawable.four);
        }
        if (value == 5)
        {
            imgDice.setImageResource(R.drawable.five);
        }
        if (value == 6)
        {
            imgDice.setImageResource(R.drawable.six);
        }
    }
}
