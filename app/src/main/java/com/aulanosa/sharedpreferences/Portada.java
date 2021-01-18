package com.aulanosa.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Portada extends AppCompatActivity {



    Button btnPref;
    Button btnReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);

        btnPref = (Button) findViewById(R.id.btnPreferencias);
        btnPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cuando pulsa en el mensaje llama a la pantalla de preferencias
                Intent cambioVentana = new Intent(Portada.this, Preferencias.class);
                startActivity(cambioVentana);
            }
        });

        btnReg = (Button) findViewById(R.id.btnRegistro);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cuando pulsa en el mensaje llama a la pantalla de registro
                Intent cambioVentana = new Intent(Portada.this, MainActivity.class);
                startActivity(cambioVentana);
            }
        });
    }
}