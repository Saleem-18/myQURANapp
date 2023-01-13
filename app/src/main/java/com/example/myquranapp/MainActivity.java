package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt_surah;
    TextView txt_parah;
    TextView txt_display;
    Button btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding
        txt_surah=findViewById(R.id.text_surah);
        txt_parah=findViewById(R.id.text_parah);
        txt_display= findViewById(R.id.textView_display);
        btn_search=findViewById(R.id.btn_search);

        String ayat = new QuranArabicText().QuranArabicText[0];
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int parahNumber = Integer.parseInt(txt_parah.getText().toString())-1;
                int surahNumber = Integer.parseInt(txt_surah.getText().toString())-1;

                txt_display.setText(new QuranArabicText().QuranArabicText[new QDH().getParahStart(parahNumber) + surahNumber]);
            }
        });
    }
}