package com.example.tugasprak2kalkulatorsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button tombolSubmit;
    private EditText inNama, inNIM, inNilai;
    String hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inNama = findViewById(R.id.inNama);
        inNIM = findViewById(R.id.inNIM);
        inNilai = findViewById(R.id.inNilai);

        tombolSubmit = findViewById(R.id.Submit);
        tombolSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String aNilai = inNilai.getText().toString().trim();
                    String aNama = inNama.getText().toString().trim();
                    String aNIM = inNIM.getText().toString().trim();

                    if (aNama.trim().equals("")){
                        inNama.setError("Nama Tidak Boleh Kosong");
                    } else if (aNIM.trim().equals("")){
                        inNIM.setError("NIM Tidak Boleh Kosong");
                    } else if (aNilai.trim().equals("")){
                        inNilai.setError("Nilai Tidak Boleh Kosong");
                    } else {
                        double nilai = Double.parseDouble(aNilai);

                        if (nilai <= 4 && nilai >3.66) {
                            hasil = String.valueOf('A');
                        } else if (nilai <= 3.66 && nilai >3.33){
                            hasil = "A-";
                        } else if (nilai <= 3.33 && nilai >3.00) {
                            hasil = "B+";
                        } else if (nilai <= 3.00 && nilai >2.66) {
                            hasil = "B";
                        } else if (nilai <= 2.66 && nilai >2.33) {
                            hasil = "B-";
                        } else if (nilai <= 2.33 && nilai >2.00) {
                            hasil = "C+";
                        } else if (nilai <= 2.00 && nilai >1.66) {
                            hasil = "C";
                        } else if (nilai <= 1.66 && nilai >1.33) {
                            hasil = "C-";
                        } else if (nilai <= 1.33 && nilai >1.00) {
                            hasil = "D+";
                        } else if (nilai <= 1.00) {
                            hasil = "D";
                        } else {
                            inNilai.setError("Masukkan nilai yang benar!");
                        }

                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                        intent.putExtra("nama", aNama);
                        intent.putExtra("nim", aNIM);
                        intent.putExtra("ini_nilai", hasil);

                        startActivity(intent);
                    }
                }catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(),"Field Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}