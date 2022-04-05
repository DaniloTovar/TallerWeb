/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Persona;
import java.util.List;

/**
 *
 * @author danil
 */
public interface CRUD {
    public List listar();
    public Persona list(int id);
    public boolean add(Persona persona);
    public boolean edit(Persona persona);
    public boolean eliminar(int id);
    public boolean pagar(Persona persona);
}
