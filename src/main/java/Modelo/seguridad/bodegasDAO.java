/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Controlador.seguridad.bodegas;
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
public class bodegasDAO {
    
    private static final String SQL_SELECT = "SELECT pkid , tipo_de_bodega, Nombre_bode, Direccion_bode, Estado_bode FROM bodega";
    private static final String SQL_INSERT = "INSERT INTO bodega ( pkid , tipo_de_bodega, Nombre_bode, Direccion_bode, Estado_bode) VALUES(?, ?, ?, ?, ?)";
    //   private static final String SQL_UPDATE = "UPDATE tbl_articulos SET fecha_ingreso=?, nombre_articulo=?, talla_articuloXS=?, talla_articuloS=?, talla_articuloM=?, talla_articuloL=?, talla_articuloXL=?,  color_articulo=?, nombre_proveedor=?, existencia_articulo=?  WHERE PK_id_articulo = ?";
    private static final String SQL_UPDATE = "UPDATE bodega SET  tipo_de_bodega=?, Nombre_bode=?, Direccion_bode=?, Estado_bode=? WHERE pkid=?";
    private static final String SQL_DELETE = "DELETE FROM bodega WHERE pkid=?";
    private static final String SQL_QUERY = "SELECT ID_ENTRENADOR, NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, FECHA_NACIMIENTO FROM entrenador WHERE ID_ENTRENADOR = ?";

    
    
    
    
    
    
    public List<bodegas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        bodegas clientes = null;
        List<bodegas> clientesls = new ArrayList<bodegas>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int pkid = rs.getInt("pkid");
                String tipo_de_bodega = rs.getString("tipo_de_bodega");
                String Nombre_bode = rs.getString("Nombre_bode");
                String Direccion_bode = rs.getString("Direccion_bode");
                String Estado_bode = rs.getString("Estado_bode");
               
               
                

                clientes = new bodegas();
                clientes.setPkid(pkid);
                clientes.setTipo_de_bodega(tipo_de_bodega);
                clientes.setNombre_bode(Nombre_bode);
                clientes.setDireccion_bode(Direccion_bode);
                clientes.setEstado_bode(Estado_bode);
              
               
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

    public int insert(bodegas clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

           
            stmt.setInt(1, clientes.getPkid());
            stmt.setString(2, clientes.getTipo_de_bodega());
            stmt.setString(3, clientes.getNombre_bode());
            stmt.setString(4, clientes.getDireccion_bode());
            stmt.setString(5, clientes.getEstado_bode());
          
            

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

    public bodegas query(bodegas clientes) {
      Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<bodegas> clientesls = new ArrayList<bodegas>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1,clientes.getPkid());
            rs = stmt.executeQuery();
             while (rs.next()) {

                  int pkid = rs.getInt("pkid");
                String tipo_de_bodega = rs.getString("tipo_de_bodega");
                String Nombre_bode = rs.getString("Nombre_bode");
                String Direccion_bode = rs.getString("Direccion_bode");
                String Estado_bode = rs.getString("Estado_bode");
                
               
                
                

                clientes = new bodegas();
                clientes.setPkid(pkid);
                clientes.setTipo_de_bodega(tipo_de_bodega);
                clientes.setNombre_bode(Nombre_bode);
                clientes.setDireccion_bode(Direccion_bode);
                clientes.setEstado_bode(Estado_bode);
                
                
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

    public int delete(bodegas cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getPkid());
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

    public int update(bodegas cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

           
            stmt.setString(1, cliente.getTipo_de_bodega());
            stmt.setString(2, cliente.getNombre_bode());
            stmt.setString(3, cliente.getDireccion_bode());
            stmt.setString(4, cliente.getEstado_bode());
           
            //WHERE
            stmt.setInt(5, cliente.getPkid());
            

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
