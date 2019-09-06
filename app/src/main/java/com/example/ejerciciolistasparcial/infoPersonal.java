package com.example.ejerciciolistasparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.ejerciciolistasparcial.MainActivity.itemOrden;

public class infoPersonal extends AppCompatActivity {
    private EditText txtUbicacion,txtEdad;
    private RadioButton btnFemenino,btnMasculino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_personal);
        //inicializar las variables
        this.txtUbicacion=findViewById(R.id.txtUbicacion);
        this.txtEdad=findViewById(R.id.txtEdad);
        this.btnFemenino=findViewById(R.id.btnFemenino);
        this.btnMasculino=findViewById(R.id.btnMasculino);
    }

    public void clickSiguiente(View v){
        if(this.guardarDatos()){
            Intent categoria=new Intent(this,categComida.class);
            startActivity(categoria);
            finish();
        }
    }

    private boolean guardarDatos(){
        boolean guardado=false;
        if(!txtUbicacion.getText().toString().isEmpty() && !txtEdad.getText().toString().isEmpty()){
            if(btnMasculino.isChecked() || btnFemenino.isChecked()){
                itemOrden.setUbicacion(txtUbicacion.getText().toString());
                itemOrden.setEdad(txtEdad.getText().toString());
                if(btnMasculino.isChecked()){itemOrden.setGenero(btnMasculino.getText().toString());}
                if(btnFemenino.isChecked()){itemOrden.setGenero(btnFemenino.getText().toString());}
                guardado=true;
            }else {
                Toast.makeText(this,"Seleccione un genero",Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this,"Llene todos los campos",Toast.LENGTH_LONG).show();
        }
        return guardado;
    }
}
