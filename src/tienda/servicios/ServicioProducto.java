/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;
import tienda.persistencia.DAO;
import tienda.persistencia.ProductoDAO;

/**
 *
 * @author Usuario
 */
public class ServicioProducto extends DAO {

    Collection<Producto> productos = new ArrayList<>();

    private ProductoDAO DAO;

    public ServicioProducto(ProductoDAO DAO) {
        this.DAO = new ProductoDAO();
    }

    public ServicioProducto() {
    }
    

    public Collection<Producto> listarProductosNombre(Collection<Producto> productos) throws Exception {
        try {
            String sql = "SELECT nombre FROM producto";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");

        }
    }

    public Collection<Producto> listarProductosNombreYPrecio(Collection<Producto> productos) throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");

        }
    }

    public Collection<Producto> filtrarPrecio(Collection<Producto> productos) throws Exception {
        try {
            String sql = "SELECT nombre,precio FROM producto WHERE precio BETWEEN 120 and 202";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");

        }
    }

    public Collection<Producto> filtrarNombrePortatil(Collection<Producto> productos) throws Exception {
        try {
            String sql = "SELECT nombre FROM producto WHERE nombre LIKE '%PORTATIL%'";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");

        }
    }

    public Collection<Producto> filtrarPrecioMin(Collection<Producto> productos) throws Exception {
        try {
            String sql = "SELECT nombre,MIN(precio) FROM producto";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

    public void agregarProductoaBase(int codigo,String nombre, double precio, int codigoFabricante) throws Exception {

        try {
            if (codigo==0) {
                throw new Exception("DEBE INDICAR UN NOMBRE PARA EL PRODUCTO");
            }
            if (nombre == null) {
                throw new Exception("EL CODIGO DEL PRODUCTO DEBE SER DIFERENTE DE CERO");
            }
            if (precio == 0) {
                throw new Exception("EL PRECIO DEL PRODUCTO DEBE SER DIFERENTE DE CERO");
            }
            if (codigoFabricante == 0) {
                throw new Exception("EL CODIGO DEL FABRICANTE DEBE SER DIFERENTE DE CERO");
            }
//          
//            producto.setNombre("LAPTOP ASUS ASPIRE 5");
//            producto.setCodigo(50);
//            producto.setPrecio(25000);
//            producto.setCodigoFabricante(1);
//            System.out.println(producto.getNombre());
//              System.out.println(producto.getPrecio());
//                System.out.println(producto.getCodigoFabricante());
//          System.out.println(producto.getCodigo());
 Producto producto = new Producto();
 producto.setCodigo(codigo);
            DAO.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
        desconectarBase();

    }

}
