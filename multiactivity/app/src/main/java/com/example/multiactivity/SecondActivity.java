package com.example.multiactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView wiadomosc;
    private Button powrot;
    private EditText poleImie, poleEmail, poleNumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        powrot = findViewById(R.id.przycisk_powrot);
        wiadomosc = findViewById(R.id.tekst_powitalny);
        poleImie = findViewById(R.id.pole_imie);
        poleEmail = findViewById(R.id.pole_email);
        poleNumer = findViewById(R.id.pole_numer);

        String tekstWiadomosci = getIntent().getStringExtra("wiadomosc");
        wiadomosc.setText(tekstWiadomosci);

        powrot.setOnClickListener(view -> {
            String imie = poleImie.getText().toString().trim();
            String email = poleEmail.getText().toString().trim();
            String numer = poleNumer.getText().toString().trim();

            if (imie.isEmpty() || email.isEmpty() || numer.isEmpty()) {
                Toast.makeText(SecondActivity.this, "Wszystkie pola muszą być wypełnione!", Toast.LENGTH_LONG).show();
                return;
            }

            if (numer.length() != 9) {
                Toast.makeText(SecondActivity.this, "Numer telefonu musi zawierać 9 cyfr!", Toast.LENGTH_LONG).show();
                return;
            }

            if (!email.contains("@")) {
                Toast.makeText(SecondActivity.this, "Adres email musi zawierać znak @!", Toast.LENGTH_LONG).show();
                return;
            }

            Intent intent = new Intent(SecondActivity.this, SecondActivity.class);
            intent.putExtra("imie", imie);
            intent.putExtra("email", email);
            intent.putExtra("numer", numer);
            startActivity(intent);
        });
    }
}