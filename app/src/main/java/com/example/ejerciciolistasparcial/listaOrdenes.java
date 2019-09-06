package com.example.ejerciciolistasparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import Adaptadores.adaptadorOrdenes;

import static com.example.ejerciciolistasparcial.MainActivity.listaOrdenes;

public class listaOrdenes extends AppCompatActivity {
    ListView lstOrdenesComida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ordenes);

        this.lstOrdenesComida=findViewById(R.id.lstOrdenesComida);
        this.lstOrdenesComida.setAdapter(new adaptadorOrdenes(this,R.layout.plantilla_ordenes,listaOrdenes));
    }
}
