package org.distribuida.principal;
import org.distribuida.entities.Autor;


public class AutorPrincipal {
    public static void main(String[] args) {

        Autor autor = new Autor(1, "Roberto", "Perez", "Ecuador", "cumbaya", "911", "pepe@gmail.com");
        System.out.println(autor.toString());
    }
}
