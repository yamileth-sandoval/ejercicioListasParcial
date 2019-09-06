package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ejerciciolistasparcial.R;

import entidades.ordenes;
import java.util.List;

public class adaptadorOrdenes extends BaseAdapter {
    private List<ordenes> datasource;
    private Context cntx;
    private int IdLayoutPlantilla;

    public List<ordenes> GetData(){
        return this.datasource;
    }

    /**
     * Constructor que permite inicializar las variables de la clase
     * @param context
     * @param IdPlantilla
     * @param sources
     */

    public adaptadorOrdenes(Context context, int IdPlantilla, List<ordenes> sources){
        //Inicializamos las variables
        this.cntx = context;
        this.IdLayoutPlantilla = IdPlantilla;
        this.datasource = sources;
    }
    @Override
    public int getCount() {
        return this.datasource.size();
    }

    @Override
    public ordenes getItem(int position) {
        return this.datasource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            //Creamos el Administrador de Layout
            LayoutInflater inflater = (LayoutInflater) this.cntx.getSystemService(this.cntx.LAYOUT_INFLATER_SERVICE);
            //Le damos vida al archivo xml ahora es un Layout
            convertView = inflater.inflate(this.IdLayoutPlantilla,null);

            //Buscamos los controles de nuestra plantilla
            TextView txvGenero = convertView.findViewById(R.id.txvGenero);
            TextView txvEdad = convertView.findViewById(R.id.txvEdad);
            TextView txvComida=convertView.findViewById(R.id.txvComida);
            TextView txvUbicacion=convertView.findViewById(R.id.txvUbicacion);
            ImageView image=convertView.findViewById(R.id.image);

            //Obtenemos el dato a mostrar
            txvGenero.setText(this.datasource.get(position).getGenero());
            txvEdad.setText(this.datasource.get(position).getEdad());
            txvComida.setText(this.datasource.get(position).getComida());
            txvUbicacion.setText(this.datasource.get(position).getUbicacion());
            image.setImageResource(this.datasource.get(position).getImg());
        }
        return convertView;
    }
}
