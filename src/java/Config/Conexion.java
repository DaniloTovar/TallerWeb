/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author danil
 */
public class Conexion {
    //Atributos con driver, dirección de la base de datos, usuario y contraseña
    private static Connection con;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String user = "root";
    private static String pass = "root123";
    private static String url = "jdbc:mysql://localhost:3306/MySQL";
    
    //Método para realizar la conexión con la base de datos
    public Conexion(){
        con = null;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        }catch(Exception e){
            System.err.println("Error"+e);
        }
    }
    
    //Método para retornar la ruta de conexión establecida
    public Connection getConnection(){
        return con;
    }
}
