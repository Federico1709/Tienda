/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

/**
 *
 * @author Usuario
 */
import tienda.entidades.Producto;
import tienda.persistencia.DAO;

/**
 *
 * @author Usuario
 */
public final class ProductoDAO extends DAO {
    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto==null) {
                throw new Exception("Debe ingresar un producto válido");
            }
            String sql= "INSERT INTO Producto (codigo, nombre, precio, codigoFabricante)"
                    +"VALUES (´" +producto.getCodigo() + "' ,  '" + producto.getNombre()+ "' , '" + producto.getPrecio() + "' ,  '" + producto.getCodigoFabricante() + "' );";
            instarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto==null) {
                throw new Exception("Debes indicar un producto a modificar");
            }
            String sql = "UPDATE Producto SET " + 
                    "nombre = '" + producto.getNombre() + "' WHERE codigo = '" + producto.getCodigo()+ "' );";
            instarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    public void eliminarProducto(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM Producto WHERE codigo = '" + codigo + "'";
            instarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}