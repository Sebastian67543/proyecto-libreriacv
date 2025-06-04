package org.distribuida.entities;

public class FacturaDetalle {

    private int idFacuraDetalle;
    private int cantidad;
    private Double subtotal;
    private Libro libro;
    private Factura factura;
    private Autor autor;

    public FacturaDetalle() {
    }

    public FacturaDetalle(int idFacuraDetalle, int cantidad, Double subtotal, Libro libro, Factura factura, Autor autor) {
        this.idFacuraDetalle = idFacuraDetalle;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.libro = libro;
        this.factura = factura;
        this.autor = autor;
    }

    public int getIdFacuraDetalle() {
        return idFacuraDetalle;
    }

    public void setIdFacuraDetalle(int idFacuraDetalle) {
        this.idFacuraDetalle = idFacuraDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "FacturaDetalle{" +
                "idFacuraDetalle=" + idFacuraDetalle +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", libro=" + libro +
                ", factura=" + factura +
                ", autor=" + autor +
                '}';
    }
}
