package com.aulanosa.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuPresenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;

import android.widget.Toast;

public class Preferencias extends PreferenceActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.activity_preferencias);

    }

    @Override protected void onStop () {

        // Siempre llama primero al método de la superclase
        super . onStop ();
    // Muestra un mensaje para saber si pasa por este método
       // Toast. makeText ( getApplicationContext (), "onStop llamado" , Toast . LENGTH_LONG ). show ();
        // cuando sale de la ventana preferencias se activa este método, es aquí donde guardamos los datos

        SharedPreferences preferencias = getSharedPreferences("Datos",
                Context.MODE_PRIVATE);

        boolean opcion = ((CheckBoxPreference)findPreference("opcion1")).isChecked();
      //  String mostrar = "la opcion es " + opcion;
      //  Toast. makeText ( getApplicationContext (), mostrar , Toast . LENGTH_LONG ). show ();
        String txtGenero = ((ListPreference)findPreference("genero")).getEntry().toString();
        String txtPais = ((ListPreference)findPreference("pais")).getEntry().toString();
        String txtEdad = ((EditTextPreference)findPreference("edad")).getText();
        String mostrar = "genero " + txtGenero;
        Toast. makeText ( getApplicationContext (), mostrar , Toast . LENGTH_LONG ). show ();
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("genero", txtGenero);
        editor.putString("pais", txtPais);
        editor.putString("edad", txtEdad);

        editor.commit();
      /*
        Context contexto = getApplicationContext();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(contexto);
        SharedPreferences.OnSharedPreferenceChangeListener mListener = new SharedPreferences.OnSharedPreferenceChangeListener() {

            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
            { if( key.equals("genero") ) {
                String valor = sharedPreferences.getString("genero", "nada");
                EditText campoGenero = (EditText) findViewById(R.id.edtxtGenero);
                campoGenero.setText(valor);
                Toast. makeText ( getApplicationContext (), "genero cambiado" , Toast . LENGTH_LONG ). show ();
            }
            }
        };
        prefs.registerOnSharedPreferenceChangeListener(mListener);
    */
    }

}