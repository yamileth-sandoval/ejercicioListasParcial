package com.example.ejerciciolistasparcial;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import Adaptadores.adaptadorComida;
import entidades.ordenes;
import entidades.platosComida;
import static com.example.ejerciciolistasparcial.MainActivity.itemOrden;
import static com.example.ejerciciolistasparcial.MainActivity.listaOrdenes;

public class listaComida extends AppCompatActivity {
    TextView txtCategoria;
    ListView lstComida;
    private List<platosComida> lstcarne;
    private List<platosComida> lstpostres;
    private List<platosComida> lstsopas;
    String categoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comida);
        this.txtCategoria=findViewById(R.id.txtCategoria);
        this.lstComida=findViewById(R.id.lstComida);
        categoria="LISTA DE: "+itemOrden.getCategoria();
        txtCategoria.setText(categoria);
        itemOrden.setComida("");
        if(itemOrden.getCategoria().equals("Carnes")){
            this.CargarCarnes();
            this.lstComida.setAdapter(new adaptadorComida(this,R.layout.plantilla_comida,this.lstcarne));
        }
        if(itemOrden.getCategoria().equals("Sopas")){
            this.Cargarsopas();
            this.lstComida.setAdapter(new adaptadorComida(this,R.layout.plantilla_comida,this.lstsopas));
        }
        if(itemOrden.getCategoria().equals("Postres")){
            this.CargarPostres();
            this.lstComida.setAdapter(new adaptadorComida(this,R.layout.plantilla_comida,this.lstpostres));
        }

        //obteniendo la seleccion del item seleccionado
        this.lstComida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                platosComida platoSel=new platosComida();
                if(itemOrden.getCategoria().equals("Carnes") && position>=0){
                    platoSel=lstcarne.get(position);
                }
                if(itemOrden.getCategoria().equals("Sopas") && position>=0){
                    platoSel=lstsopas.get(position);
                }
                if(itemOrden.getCategoria().equals("Postres") && position>=0){
                    platoSel=lstpostres.get(position);
                }
                if(platoSel != null) {
                    itemOrden.setComida(platoSel.getNombre());
                    itemOrden.setImg(platoSel.getImg());
                }
            }
        });
    }

    private void CargarCarnes() {
        //Inicializamos la lista de departamentos
        this.lstcarne = new ArrayList<>();

        //Creamos un nuevo departamento
        platosComida nuevoPlato = new platosComida();
        nuevoPlato.setNombre("Carne Asada");
        nuevoPlato.setDescripcion("Esta es una descripcion del plato");
        nuevoPlato.setImg(R.drawable.carnes1);
        this.lstcarne.add(nuevoPlato);

        nuevoPlato = new platosComida();
        nuevoPlato.setNombre("Carne a la parrilla");
        nuevoPlato.setDescripcion("Esta incluye papas");
        nuevoPlato.setImg(R.drawable.carnes2);
        this.lstcarne.add(nuevoPlato);

        nuevoPlato = new platosComida();
        nuevoPlato.setNombre("Carne frita");
        nuevoPlato.setDescripcion("con verderas medias cocidas");
        nuevoPlato.setImg(R.drawable.carnes3);
        this.lstcarne.add(nuevoPlato);
    }

    private void CargarPostres() {
        //Inicializamos la lista de departamentos
        this.lstpostres = new ArrayList<>();

        //Creamos un nuevo departamento
        platosComida nuevoPlato = new platosComida();
        nuevoPlato.setNombre("Vaso de frutas picadas");
        nuevoPlato.setDescripcion("fresas, uva, papaya, manzana");
        nuevoPlato.setImg(R.drawable.postre1);
        this.lstpostres.add(nuevoPlato);

        nuevoPlato = new platosComida();
        nuevoPlato.setNombre("pastel de fresas");
        nuevoPlato.setDescripcion("trizo de pastel grande");
        nuevoPlato.setImg(R.drawable.postre2);
        this.lstpostres.add(nuevoPlato);

        nuevoPlato = new platosComida();
        nuevoPlato.setNombre("Vasos de chocolate");
        nuevoPlato.setDescripcion("Vasos extrarande completamente lleno de chocolate");
        nuevoPlato.setImg(R.drawable.postre3);
        this.lstpostres.add(nuevoPlato);
    }

    private void Cargarsopas() {
        //Inicializamos la lista de departamentos
        this.lstsopas = new ArrayList<>();

        //Creamos un nuevo departamento
        platosComida nuevoPlato = new platosComida();
        nuevoPlato.setNombre("sopa de especial 1");
        nuevoPlato.setDescripcion("Es de la que hace la abuela");
        nuevoPlato.setImg(R.drawable.sopa1);
        this.lstsopas.add(nuevoPlato);

        nuevoPlato = new platosComida();
        nuevoPlato.setNombre("sopa de gallina");
        nuevoPlato.setDescripcion("Esta es con huevo");
        nuevoPlato.setImg(R.drawable.sopa2);
        this.lstsopas.add(nuevoPlato);

        nuevoPlato = new platosComida();
        nuevoPlato.setNombre("sopa de pollo");
        nuevoPlato.setDescripcion("Esta es con huevo");
        nuevoPlato.setImg(R.drawable.sopa3);
        this.lstsopas.add(nuevoPlato);
    }
    public void clickFinalizar(View v){
        if(itemOrden.getComida().isEmpty() || itemOrden.getComida()==null || itemOrden.getComida().equals("")){
            Toast.makeText(this,"Elija un plato",Toast.LENGTH_LONG).show();
        }else {
            if(guardarOrden()){
                finish();
            }else {
                Toast.makeText(this,"No se pudo guardar",Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean guardarOrden(){
        boolean guardado=false;
        if(!itemOrden.getGenero().isEmpty() && !itemOrden.getUbicacion().isEmpty() &&
                !itemOrden.getComida().isEmpty() && !itemOrden.getEdad().isEmpty()){
            listaOrdenes.add(itemOrden);
            itemOrden=new ordenes();
            guardado=true;
        }
        return guardado;
    }
}
