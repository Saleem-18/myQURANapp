package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt_surah;
    TextView txt_parah;
    TextView txt_display;
    Button btn_search;
    Button btn_git;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding
        txt_surah=findViewById(R.id.text_surah);
        txt_parah=findViewById(R.id.text_parah);
        txt_display= findViewById(R.id.textView_display);
        btn_search=findViewById(R.id.btn_search);
        btn_git=findViewById(R.id.btn_git);

        String ayat = new QuranArabicText().QuranArabicText[0];
        btn_git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                golink("https://github.com/Saleem-18/myQURANapp.git");
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int parahNumber = Integer.parseInt(txt_parah.getText().toString())-1;
                int surahNumber = Integer.parseInt(txt_surah.getText().toString())-1;

                txt_display.setText(new QuranArabicText().QuranArabicText[new QDH().getParahStart(parahNumber) + surahNumber]);
            }
        });
    }

    private void golink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}