package models;


public class Producto {

    private String Nombre;
    private int Codigo;
    private int Valor;
    private Boolean Exento;
    private String Descripcion;

    public Producto() {

    }

    public Producto(String nombre, int codigo, int valor, Boolean exento, String descripcion) {
        Nombre = nombre;
        Codigo = codigo;
        Valor = valor;
        Exento = exento;
        Descripcion = descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int valor) {
        Valor = valor;
    }

    public Boolean getExento() {
        return Exento;
    }

    public void setExento(Boolean exento) {
        Exento = exento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
