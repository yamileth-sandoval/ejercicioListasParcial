package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import com.example.ejerciciolistasparcial.R;
import entidades.platosComida;

public class adaptadorComida extends BaseAdapter {
    private List<platosComida> datasource;
    private Context cntx;
    private int IdLayoutPlantilla;

    public List<platosComida> GetData(){
        return this.datasource;
    }

    /**
     * Constructor que permite inicializar las variables de la clase
     * @param context
     * @param IdPlantilla
     * @param sources
     */

    public adaptadorComida(Context context, int IdPlantilla, List<platosComida> sources){
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
    public platosComida getItem(int position) {
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
            TextView labelNombre = convertView.findViewById(R.id.labelNombre);
            TextView labelDescripcion = convertView.findViewById(R.id.labelDescripcion);
            ImageView icono=convertView.findViewById(R.id.icono);

            //Obtenemos el dato a mostrar
            labelNombre.setText(this.datasource.get(position).getNombre());
            labelDescripcion.setText(this.datasource.get(position).getDescripcion());
            icono.setImageResource(this.datasource.get(position).getImg());
        }
        return convertView;
    }
}
