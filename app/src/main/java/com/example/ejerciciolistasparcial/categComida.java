package com.example.ejerciciolistasparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import static com.example.ejerciciolistasparcial.MainActivity.itemOrden;
public class categComida extends AppCompatActivity {
    private RadioButton btnCarnes,btnSopas,btnPostres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categ_comida);
        this.btnCarnes=findViewById(R.id.btnCarnes);
        this.btnSopas=findViewById(R.id.btnSopas);
        this.btnPostres=findViewById(R.id.btnPostres);
    }

    public void clickSiguiente(View v){
       Intent lista=new Intent(this,listaComida.class);
        if(btnCarnes.isChecked()){
            itemOrden.setCategoria(btnCarnes.getText().toString());
            startActivity(lista);
            finish();
        }else if(btnSopas.isChecked()){
            itemOrden.setCategoria(btnSopas.getText().toString());
            startActivity(lista);
            finish();
        }else if(btnPostres.isChecked()){
            itemOrden.setCategoria(btnPostres.getText().toString());
            startActivity(lista);
            finish();
        }else {
            Toast.makeText(this,"Elija una categoria",Toast.LENGTH_LONG).show();
        }
    }
}
