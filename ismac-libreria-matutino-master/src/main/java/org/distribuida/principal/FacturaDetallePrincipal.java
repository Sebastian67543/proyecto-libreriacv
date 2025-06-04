package org.distribuida.principal;
import org.distribuida.entities.Autor;
import org.distribuida.entities.Factura;
import org.distribuida.entities.FacturaDetalle;
import org.distribuida.entities.Libro;

public class FacturaDetallePrincipal {

    public static void main(String[] args) {

        FacturaDetalle facturaDetalle = new FacturaDetalle();

        Libro libro = new Libro();
        Factura factura = new Factura();
        Autor autor = new Autor();

        facturaDetalle.setIdFacuraDetalle(1);
        facturaDetalle.setCantidad(2);
        facturaDetalle.setSubtotal(23.23);

        facturaDetalle.setLibro(libro);
        facturaDetalle.setFactura(factura);
        facturaDetalle.setAutor(autor);

        System.out.println(facturaDetalle.toString());

    }
}
