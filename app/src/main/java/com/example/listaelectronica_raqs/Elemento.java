package com.example.listaelectronica_raqs;
public class Elemento {
    private String nombre;
    private int precio;
    private int imagenResId;
    private int cantidad;

    public Elemento(String nombre, int precio, int imagenResId) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagenResId = imagenResId;
        this.cantidad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
