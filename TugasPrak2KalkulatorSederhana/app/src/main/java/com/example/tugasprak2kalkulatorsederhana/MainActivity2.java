package com.example.tugasprak2kalkulatorsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView outNama, outNIM, outNilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        outNama = findViewById(R.id.outNama);
        outNIM = findViewById(R.id.outNIM);
        outNilai = findViewById(R.id.outNilai);

        Intent intent = getIntent();

        String getNama = intent.getStringExtra("nama");
        String getNIM = intent.getStringExtra("nim");
        String getNilai = intent.getStringExtra("ini_nilai");

        outNama.setText(getNama);
        outNIM.setText(getNIM);
        outNilai.setText(getNilai);
    }
}