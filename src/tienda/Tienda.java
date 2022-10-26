/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.DAO;
import tienda.servicios.ServicioProducto;

/**
 *
 * @author Usuario
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ServicioProducto sp=new ServicioProducto();
        Collection<Producto> productos = new ArrayList<>();
        Scanner leer = new Scanner(System.in);
         Producto producto = new Producto();
         System.out.println("1-Listar los productos por nombre"+"\n"
                +"2-Listar productos por nombre y precio"+"\n"+"3-Listar productos por precio entre 120 y 202"
                +"\n"+"4-Filtrar producto por nombre Portatil"+"\n"+"5-Filtrar producto por el menor precio");
        int aux = leer.nextInt();
        switch (aux) {
            case 1:
                sp.listarProductosNombre(productos);
                for (Producto aux1 : productos) {
                    System.out.println(aux1.getNombre());
                }
                break;
            case 2:
                sp.listarProductosNombreYPrecio(productos);
                for (Producto aux2 : productos) {
                    System.out.println("Producto:" + aux2.getNombre() + "/Precio: " + aux2.getPrecio());
                }
                break;
            case 3:
                sp.filtrarPrecio(productos);
                for (Producto aux2 : productos) {
                    System.out.println("Producto:" + aux2.getNombre() + "/Precio: " + aux2.getPrecio());
                }
                break;
            case 4:
                sp.filtrarNombrePortatil(productos);
                for (Producto aux1 : productos) {
                    System.out.println(aux1.getNombre());
                }
                break;
            case 5:
                sp.filtrarPrecioMin(productos);
                for (Producto aux2 : productos) {
                    System.out.println("Producto:" + aux2.getNombre() + "/Precio: " + aux2.getPrecio());
                }
                break;
            case 6:
                sp.agregarProductoaBase(50,"ASUS asuss",53.60,1);
                for (Producto producto1 : productos) {
                    System.out.println(producto1);
                }
        }

}
}