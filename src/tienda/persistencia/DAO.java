/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public abstract class DAO {

    protected Connection conexion = null;//por el cual nos conectamos a la BD
    protected Statement sentencia = null;//POR EL CUAL TRAEMOS TODOS LOS DATOS DE LA BD A NETBEANS
    protected ResultSet resultado = null;//IDA Y VUELTA DE LOS DATOS DESDE LA BD A JAVA O VICEVERSA

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
           
            String url = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";

            conexion = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {

            throw ex;
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            if (conexion != null) {
                conexion.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (resultado != null) {
                resultado.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    protected void instarModificarEliminar(String sql) throws SQLException, ClassNotFoundException, Exception{
        try {
            conectarBase();
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sql);
            
        } catch (SQLException | ClassNotFoundException ex) {
            throw ex;
                    }
     finally{
            desconectarBase();
        }
    } 
    protected void consultarBase(String sql) throws Exception{
        try {
            conectarBase();
            sentencia=conexion.createStatement();
           resultado=sentencia.executeQuery(sql);
           
            
        } catch (Exception e) {
            throw e;
        }
    }
}
 