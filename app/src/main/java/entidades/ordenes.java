package entidades;

public class ordenes {
    private String Genero;
    private String Edad;
    private String Ubicacion;
    private String categoria;
    private String Comida;
    private int img;

    public void setGenero(String genero) {
        Genero = genero;
    }
    public String getGenero(){
        return this.Genero;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getEdad() {
        return Edad;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setComida(String comida) {
        Comida = comida;
    }

    public String getComida() {
        return Comida;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }
}
