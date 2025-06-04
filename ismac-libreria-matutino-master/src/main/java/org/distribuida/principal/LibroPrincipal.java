package org.distribuida.principal;

import org.distribuida.entities.Autor;
import org.distribuida.entities.Categoria;
import org.distribuida.entities.Libro;

import java.util.Date;

public class LibroPrincipal {
    public static void main(String[] args) {
        Libro libro = new Libro();

        Categoria categoria = new Categoria(1,"Accion","Informacion Area 51");
        Autor autor = new Autor(1,"Jose","Perez","Peru","Piura","5314578920","joseperez11@gmail.com");

        libro.setIdlibro(1);
        libro.setTitulo("triangulo");
        libro.setEditorial("Informacion Area 51");
        libro.setNumpaginas(555);
        libro.setEdicion("Cuarta Edicion");
        libro.setIdioma("Español");
        libro.setFechapublicacion( new Date());
        libro.setDescipcion("Informate acerca del Area 51");
        libro.setTipopasta("Amarilla");
        libro.setIsbn("ISBN");
        libro.setNumejemplares(505);
        libro.setPortada("Conoce del Area 51");
        libro.setPresentacion("Lo que no sabias acerca del Area51");
        libro.setPrecio(15.5);
        libro.setCategoria(categoria);
        libro.setAutor(autor);

    }
}
