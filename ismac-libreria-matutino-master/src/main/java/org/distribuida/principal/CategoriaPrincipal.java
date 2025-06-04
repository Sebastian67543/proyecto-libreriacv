package org.distribuida.principal;
import org.distribuida.entities.Categoria;
public class CategoriaPrincipal {
    public static void main(String[] args) {

        Categoria categoria = new Categoria(1,"terror", "hecho reales");
        System.out.println(categoria.toString());
    }


}
