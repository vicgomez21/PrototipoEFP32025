/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Controlador.seguridad.Entrenadores;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diana
 */
public class EntrenadoresDAO {
    
    private static final String SQL_SELECT = "SELECT ID_ENTRENADOR, NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, FECHA_NACIMIENTO FROM entrenador";
    private static final String SQL_INSERT = "INSERT INTO entrenador ( NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, FECHA_NACIMIENTO) VALUES(?, ?, ?, ?, ?)";
    //   private static final String SQL_UPDATE = "UPDATE tbl_articulos SET fecha_ingreso=?, nombre_articulo=?, talla_articuloXS=?, talla_articuloS=?, talla_articuloM=?, talla_articuloL=?, talla_articuloXL=?,  color_articulo=?, nombre_proveedor=?, existencia_articulo=?  WHERE PK_id_articulo = ?";
    private static final String SQL_UPDATE = "UPDATE entrenador SET NOMBRE1=?, NOMBRE2=?, APELLIDO1=?, APELLIDO2=?, FECHA_NACIMIENTO=? WHERE ID_ENTRENADOR=?";
    private static final String SQL_DELETE = "DELETE FROM entrenador WHERE ID_ENTRENADOR=?";
    private static final String SQL_QUERY = "SELECT ID_ENTRENADOR, NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, FECHA_NACIMIENTO FROM entrenador WHERE ID_ENTRENADOR = ?";

    
    
    
    
    
    
    public List<Entrenadores> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Entrenadores clientes = null;
        List<Entrenadores> clientesls = new ArrayList<Entrenadores>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id_Entrenador = rs.getInt("ID_ENTRENADOR");
                String nombre1 = rs.getString("NOMBRE1");
                String nombre2 = rs.getString("NOMBRE2");
                String apellido1 = rs.getString("APELLIDO1");
                String apellido2 = rs.getString("APELLIDO2");
                String fecha_nacimiento = rs.getString("FECHA_NACIMIENTO");
               
                

                clientes = new Entrenadores();
                clientes.setId_entrenador(id_Entrenador);
                clientes.setNombre_1(nombre1);
                clientes.setNombre_2(nombre2);
                clientes.setApellido_1(apellido1);
                clientes.setApellido_2(apellido2);
                clientes.setFecha_nacimiento(fecha_nacimiento);
               
                clientesls.add(clientes);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientesls;
    }

    public int insert(Entrenadores clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

           
            stmt.setString(1, clientes.getNombre_1());
            stmt.setString(2, clientes.getNombre_2());
            stmt.setString(3, clientes.getApellido_1());
            stmt.setString(4, clientes.getApellido_2());
            stmt.setString(5, clientes.getFecha_nacimiento());
          
            

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Entrenadores query(Entrenadores clientes) {
      Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Entrenadores> clientesls = new ArrayList<Entrenadores>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1,clientes.getId_entrenador());
            rs = stmt.executeQuery();
             while (rs.next()) {

                  int id_Entrenador = rs.getInt("ID_ENTRENADOR");
                String nombre1 = rs.getString("NOMBRE1");
                String nombre2 = rs.getString("NOMBRE2");
                String apellido1 = rs.getString("APELLIDO1");
                String apellido2 = rs.getString("APELLIDO2");
                String fecha_nacimiento = rs.getString("FECHA_NACIMIENTO");
               
                
                

                clientes = new Entrenadores();
                clientes.setId_entrenador(id_Entrenador);
                clientes.setNombre_1(nombre1);
                clientes.setNombre_2(nombre2);
                clientes.setApellido_1(apellido1);
                clientes.setApellido_2(apellido2);
                clientes.setFecha_nacimiento(fecha_nacimiento);
                
                clientesls.add(clientes);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }

    public int delete(Entrenadores cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getId_entrenador());
            rows = stmt.executeUpdate();
            //System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Entrenadores cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, cliente.getNombre_1());
            stmt.setString(2, cliente.getNombre_2());
            stmt.setString(3, cliente.getApellido_1());
            stmt.setString(4, cliente.getApellido_2());
            stmt.setString(5, cliente.getFecha_nacimiento());
           
            //WHERE
            stmt.setInt(6, cliente.getId_entrenador());
            

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    
    
    
    
}
