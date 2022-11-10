package com.montoyaramirezluis.pmdm02_android_controles_seleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
/*
    Pasos:
    1. Creamos los datos. En nuestro caso una lista de objetos
    2. Creamos y configuramos el adaptador con el layout que mostrará
    3. Asociamos al control spinner el adaptador que hemos configurado
 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creamos una lista de objetos y cargamos algunos valores
        List<Color> listaColores = new ArrayList<>();
        addColores(listaColores); // Método que añade colores a la lista

        // Localizamos el control spinner
        Spinner spinnerColores = findViewById(R.id.spinner);

        // Creamos el adaptador del tipo de objeto Color usando un layout "genérico" de los que
        // que vienen con Android: simple_spinner_item.
        // Este layout no se crea, solo se utiliza. Es apropiado para los Spinner

        // El adaptador necesita un contexto, un layout y la lista de objetos
        ArrayAdapter<Color> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaColores);
        // Asociamos el adaptador al control spinner
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerColores.setAdapter(adaptador); // Asociamos el adaptador al control spinner

        // Creamos un evento anónimo privado para saber que opción del spinner hemos seleccionado
        spinnerColores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Podemos recoger la información de formas distintas:
                Toast.makeText(adapterView.getContext(), "getSelectedItem: " + adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(adapterView.getContext(), "getItemAtPosition: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // cuando no hay nada seleccionado no hacemos nada
            }
        });
        // Otra forma de capturar el evento (Comentada)
        spinnerColores.setOnItemSelectedListener(miEvento);
    }

    /**
     * Este método es parecido al anterior, pero asignamos el adaptador a una variable, y después
     * podemos usarla para capturar el evento Ej:
     * spinnerColores.setOnItemSelectedListener(miEvento);
     *
     * Probar esta manera para onClick
     */
    private final AdapterView.OnItemSelectedListener miEvento = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            // Podemos recoger la información de formas distintas:
            Toast.makeText(adapterView.getContext(), "getSelectedItem: " + adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(adapterView.getContext(), "getItemAtPosition: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    /**
     * Método que añade colores a la lista
     * @param listaColores Lista de colores
     */
    private void addColores(List<Color> listaColores) {
        listaColores.add(new Color("Rojo", "#FF0000"));
        listaColores.add(new Color("Verde", "#00FF00"));
        listaColores.add(new Color("Azul", "#0000FF"));
        listaColores.add(new Color("Amarillo", "#FFFF00"));
        listaColores.add(new Color("Naranja", "#FFA500"));
        listaColores.add(new Color("Rosa", "#FFC0CB"));
        listaColores.add(new Color("Morado", "#800080"));
    }
}