package com.aulanosa.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class Mostrar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        final EditText edTxtNombre2 = findViewById(R.id.edtxtNombre2);
        final EditText edTxtApellidos2 = findViewById(R.id.edtxtApellidos2);
        final EditText edTxtGenero = findViewById(R.id.edtxtGenero);
        final EditText edTxtPais = findViewById(R.id.edtxtPais);
        final EditText edTxtEdad = findViewById(R.id.edtxtEdad);

        // en esta ventana muestra los datos guardados en preferencias,
        // nombre y apellidos en la ventana principal y el resto en ventana preferencias

        SharedPreferences preferencias = getSharedPreferences("Datos",
                Context.MODE_PRIVATE);
        String nombreTxt = preferencias.getString("nombre", "cero");
        String apellidosTxt = preferencias.getString("apellidos", "cero");
        String generoTxt = preferencias.getString("genero", "cero");
        String paisTxt = preferencias.getString("pais", "cero");
        String edadTxt = preferencias.getString("edad", "cero");

        edTxtNombre2.setText(nombreTxt);
        edTxtApellidos2.setText(apellidosTxt);
        edTxtGenero.setText(generoTxt);
        edTxtPais.setText(paisTxt);
        edTxtEdad.setText(edadTxt);


    }
}