package com.aulanosa.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edTxtNombre = findViewById(R.id.edtxtNombre);
        final EditText edTxtApellidos = findViewById(R.id.edtxtApellidos);

        final Button botonGuardar = findViewById(R.id.btnGuardar);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferencias = getSharedPreferences("Datos",
                        Context.MODE_PRIVATE);
                String nombre = edTxtNombre.getText().toString();
                String apellidos = edTxtApellidos.getText().toString();
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("nombre", nombre);
                editor.putString("apellidos", apellidos);

                editor.commit();
    //guarda en las preferencias los datos de nombre y apellidos
                Toast.makeText(MainActivity.this,
                        "DATOS GUARDADOS !!!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        final Button botonMostrar =  findViewById(R.id.btnMostrar);
        botonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cambioVentana;
                cambioVentana = new Intent(MainActivity.this, Mostrar.class);
                startActivity(cambioVentana);

            }
        });

        final Button botonPreferencias =  findViewById(R.id.btnPreferencias2);
        botonPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cambioVentana;
                cambioVentana = new Intent(MainActivity.this, Preferencias.class);
                startActivity(cambioVentana);

            }
        });

    }
}
