package com.example.ejerciciolistasparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import entidades.ordenes;

public class MainActivity extends AppCompatActivity {
    public static ordenes itemOrden;
    public static List<ordenes> listaOrdenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemOrden=new ordenes();
        this.listaOrdenes=new ArrayList<>();
    }

    public void clickEncuestar(View v){
        Intent info=new Intent(this,infoPersonal.class);
        startActivity(info);
    }

    public void clickProcesar(View v){
        if(listaOrdenes==null || listaOrdenes.isEmpty()){
            Toast.makeText(this,"No hay elementos que mostrar",Toast.LENGTH_LONG).show();
        }else {
            Intent lista=new Intent(this,listaOrdenes.class);
            startActivity((lista));
        }
    }
}
