/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danil
 */
public class PersonaDAO implements CRUD{
    // Definicion de diferentes elementos para su posterior uso
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p = new Persona();
    
    //Método para recuperar las rows de la base datos
    @Override
    public List listar() {
       ArrayList<Persona> list = new ArrayList<>();
       String sql = "select * from `db`.tabla_clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setValorPrestamo(rs.getDouble("valor_prestamo"));
                persona.setMes(rs.getInt("mes"));
                list.add(persona);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    //Método para recuperar los datos de una persona, según el id
    @Override
    public Persona list(int id) {
       String sql = "select * from `db`.tabla_clientes where id="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setValorPrestamo(rs.getDouble("valor_prestamo"));
                p.setMes(rs.getInt("mes"));
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    //Método para agregar una persona a la base de datos
    @Override
    public boolean add(Persona persona) {
        String sql="INSERT INTO `db`.tabla_clientes VALUES ("+persona.getId()+",'"+persona.getNombre()+"','"+persona.getApellido()+"',"+persona.getValorPrestamo()+","+persona.getMes()+")";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    //Método para editar/actualizar una persona en la base de datos, segun el id
    @Override
    public boolean edit(Persona persona) {
        String sql="update `db`.tabla_clientes set nombre='"+persona.getNombre()+"',apellido='"+persona.getApellido()+"',valor_prestamo="+persona.getValorPrestamo()+",mes="+persona.getMes()+" where id="+persona.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    //Método para eliminar una row de la base de datos, segun el id
    @Override
    public boolean eliminar(int id) {
        String sql="delete from `db`.tabla_clientes where id="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    //Método para cambiar el valor de la deuda y el mes, segun el id
    @Override
    public boolean pagar(Persona persona) {
        String sql="update `db`.tabla_clientes set valor_prestamo="+persona.getValorPrestamo()+",mes="+persona.getMes()+" where id="+persona.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
