package entidades;

public class platosComida {
    private String nombre;
    private String descripcion;
    private int img;

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public String getDescripcion(){
        return this.descripcion;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }
}
