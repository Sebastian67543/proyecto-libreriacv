package org.distribuida.entities;


import java.util.Date;


public class Libro {
    private int idlibro;
    private String titulo;
    private String editorial;
    private int numpaginas;
    private String edicion;
    private String idioma;
    private Date fechapublicacion;
    private String descipcion;
    private String tipopasta;
    private String isbn;
    private int numejemplares;
    private String portada;
    private String presentacion;
    private Double precio;
    private Categoria categoria;
    private Autor autor;

    public Libro() {
    }


    public Libro(int idlibro, String titulo, String editorial, int numpaginas, String edicion, String idioma, Date fechapublicacion, String descipcion, String tipopasta, String isbn, int numejemplares, String portada, String presentacion, Double precio, Categoria categoria, Autor autor) {
        this.idlibro = idlibro;
        this.titulo = titulo;
        this.editorial = editorial;
        this.numpaginas = numpaginas;
        this.edicion = edicion;
        this.idioma = idioma;
        this.fechapublicacion = fechapublicacion;
        this.descipcion = descipcion;
        this.tipopasta = tipopasta;
        this.isbn = isbn;
        this.numejemplares = numejemplares;
        this.portada = portada;
        this.presentacion = presentacion;
        this.precio = precio;
        this.categoria = categoria;
        this.autor = autor;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumpaginas() {
        return numpaginas;
    }

    public void setNumpaginas(int numpaginas) {
        this.numpaginas = numpaginas;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Date getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(Date fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public String getTipopasta() {
        return tipopasta;
    }

    public void setTipopasta(String tipopasta) {
        this.tipopasta = tipopasta;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumejemplares() {
        return numejemplares;
    }

    public void setNumejemplares(int numejemplares) {
        this.numejemplares = numejemplares;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idlibro=" + idlibro +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", numpaginas=" + numpaginas +
                ", edicion='" + edicion + '\'' +
                ", idioma='" + idioma + '\'' +
                ", fechapublicacion=" + fechapublicacion +
                ", descipcion='" + descipcion + '\'' +
                ", tipopasta='" + tipopasta + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numejemplares=" + numejemplares +
                ", portada='" + portada + '\'' +
                ", presentacion='" + presentacion + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
