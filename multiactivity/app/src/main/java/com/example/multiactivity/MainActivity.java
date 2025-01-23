package com.example.multiactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button przycisk;
    private TextView imie, email, numer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przycisk = findViewById(R.id.przycisk);
        imie = findViewById(R.id.imie);
        email = findViewById(R.id.email);
        numer = findViewById(R.id.numer);

        przycisk.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("wiadomosc", "Witaj w MainActivity2");
            startActivity(intent);
        });

        String imieWiadomosc = getIntent().getStringExtra("imie");
        String emailWiadomosc = getIntent().getStringExtra("email");
        String numerWiadomosc = getIntent().getStringExtra("numer");

        imie.setText("Imię: " + (imieWiadomosc != null ? imieWiadomosc : ""));
        email.setText("Adres email: " + (emailWiadomosc != null ? emailWiadomosc : ""));
        numer.setText("Numer telefonu: " + (numerWiadomosc != null ? numerWiadomosc : ""));
    }
}