/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_interface_DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import laboratorios_DAO.DAO_exception;
import laboratorios_DAO.Dt_clases;
import laboratorios_DAO.Dt_clases_por_laboratorio;
import laboratorios_DAO.Dt_clases_por_profesor;
import laboratorios_DAO.Dt_computadoras;
import laboratorios_DAO.Dt_laboratorios;
import laboratorios_DAO.Dt_profesores;
import laboratorios_entities.Clases;
import laboratorios_entities.Laboratorios;

/**
 *
 * @author cchav
 */
public class MySQL_DAO_manager implements DAOManager{
    private Connection conn;
    
    private Clases_interface clases = null;
    
    private Computadoras_interface computadoras = null;
    
    private Laboratorios_interface laboratorios = null;
    
    private Profesores_interface profesores = null;
    
    private Clases_por_laboratorio_interface clases_por_laboratorio = null;
    
    private Clases_por_profesor_interface clases_por_profesor = null;
    
    public MySQL_DAO_manager(String host, String username, String password, String database) throws SQLException{
        conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);
    
    }

    @Override
    public Clases_interface getClases_interface() {
        if (clases == null){
            clases = new Dt_clases(conn);
        }
        
        return clases;
    }

    @Override
    public Computadoras_interface getComputadoras_interface() {
        if (computadoras == null){
            computadoras = new Dt_computadoras(conn);
        }
        
        return computadoras;
    }

    @Override
    public Laboratorios_interface getLaboratorios_interface() {
        if (laboratorios == null){
            laboratorios = new Dt_laboratorios(conn);
        }
        
        return laboratorios;
    }

    @Override
    public Profesores_interface getProfesores_interface() {
        if (profesores == null){
            profesores = new Dt_profesores(conn);
        }
        
        return profesores;
    }
    
    
    
    public static void main(String[] args) throws SQLException, DAO_exception{
        MySQL_DAO_manager man = new MySQL_DAO_manager("localhost", "root", "1234", "laboratorios");
        List<Laboratorios> lab = man.getLaboratorios_interface().obtenerTodos();
        System.out.println(lab);
    }

    @Override
    public Clases_por_laboratorio_interface getClases_por_laboratorio_interface() {
        if (clases_por_laboratorio == null){
            clases_por_laboratorio = new Dt_clases_por_laboratorio(conn);
        }
        
        return clases_por_laboratorio;
        
    }

    @Override
    public Clases_por_profesor_interface getClases_por_profesor_interface() {
        if (clases_por_profesor == null){
            clases_por_profesor = new Dt_clases_por_profesor(conn);
        }
        
        return clases_por_profesor;
    }
    
    
}
