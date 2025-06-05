/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Controlador.seguridad.RelDVD_cleinte;
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
 * 
 */
public class RelDvdClienteDAO1 {
    
    private static final String SQL_SELECT = "SELECT id_video , Id_cliente, FechaAlquiler, FechaCaducidad,Total FROM tbl_registrosatrasados";
    private static final String SQL_INSERT = "INSERT INTO tbl_registrosatrasados (id_video, Id_cliente, FechaAlquiler,FechaCaducidad,Total) VALUES(?,?,?,?,?)";
    //   private static final String SQL_UPDATE = "UPDATE tbl_articulos SET fecha_ingreso=?, nombre_articulo=?, talla_articuloXS=?, talla_articuloS=?, talla_articuloM=?, talla_articuloL=?, talla_articuloXL=?,  color_articulo=?, nombre_proveedor=?, existencia_articulo=?  WHERE PK_id_articulo = ?";
    private static final String SQL_UPDATE = "UPDATE tbl_registrosatrasados SET FechaAlquiler=?, FechaCaducidad=?, Total=? WHERE id_video=?,Id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_registrosatrasados WHERE id_video=?,Id_cliente=?";
    private static final String SQL_QUERY = "SELECT id_video , id_cliente, FechaAlquiler, FechaCaducidad,Total FROM tbl_registrosatrasados WHERE id_video = ?,Id_cliente=?";

    
    
    
    
    
    
    public List<RelDVD_cleinte> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        RelDVD_cleinte dvd = null;
        List<RelDVD_cleinte> dvdsls = new ArrayList<RelDVD_cleinte>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id_video = rs.getInt("id_video");
                int id_cliente = rs.getInt("Id_cliente");
                String FechaAlquiler = rs.getString("FechaAlquiler");
                String FechaCaducidad = rs.getString("FechaCaducidad");
                String Total =rs.getString("Total");
                

                dvd = new RelDVD_cleinte();
                dvd.setId_video(id_video);
                dvd.setId_cliente(id_cliente);
                dvd.setFecha_alquiler(FechaAlquiler);
                dvd.setFecha_caducidad(FechaCaducidad);
                dvd.setTotal(Total);
               
                dvdsls.add(dvd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return dvdsls;
    }

    public int insert(RelDVD_cleinte dvd) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

           
            stmt.setInt(1, dvd.getId_video());
            stmt.setInt(2, dvd.getId_cliente());
            stmt.setString(3,dvd.getFecha_alquiler());
               stmt.setString(4,dvd.getFecha_caducidad());
                  stmt.setString(5,dvd.getTotal());
           
            

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

    public RelDVD_cleinte query(RelDVD_cleinte dvd) {
      Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RelDVD_cleinte> dvdls = new ArrayList<RelDVD_cleinte>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1,dvd.getId_video());
            stmt.setInt(2,dvd.getId_cliente());
            rs = stmt.executeQuery();
             while (rs.next()) {

                int id_video = rs.getInt("id_video");
                int id_cliente = rs.getInt("id_cliente");
                String FechaAlquiler = rs.getString("FechaAlquiler");
                String FechaCaducidad = rs.getString("FechaCaducidad");
                String Total =rs.getString("Total");
                

                dvd = new RelDVD_cleinte();
                dvd.setId_video(id_video);
                dvd.setId_cliente(id_cliente);
                dvd.setFecha_alquiler(FechaAlquiler);
                dvd.setFecha_caducidad(FechaCaducidad);
                dvd.setTotal(Total);
              
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dvd;
    }

    public int delete(RelDVD_cleinte dvd) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, dvd.getId_video());
             stmt.setInt(1, dvd.getId_cliente());
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

    public int update(RelDVD_cleinte dvd) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, dvd.getFecha_alquiler());
            stmt.setString(2, dvd.getFecha_caducidad());
            stmt.setString(3, dvd.getTotal());
            
            //WHERE
            stmt.setInt(4, dvd.getId_video());
            stmt.setInt(5, dvd.getId_cliente());
            

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
