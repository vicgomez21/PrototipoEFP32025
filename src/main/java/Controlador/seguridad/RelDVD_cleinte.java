/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.seguridad;

/**
 *
 * @author VICTOR
 */
public class RelDVD_cleinte {

    int id_video;
    int id_cliente;
    String fecha_alquiler;
    String fecha_caducidad;
    String total;

    @Override
    public String toString() {
        return "RelDVD_cleinte{" + "id_video=" + id_video + ", id_cliente=" + id_cliente + ", fecha_alquiler=" + fecha_alquiler + ", fecha_caducidad=" + fecha_caducidad + ", total=" + total + '}';
    }

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(String fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public RelDVD_cleinte(int id_video, int id_cliente, String fecha_alquiler, String fecha_caducidad, String total) {
        this.id_video = id_video;
        this.id_cliente = id_cliente;
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_caducidad = fecha_caducidad;
        this.total = total;
    }

    public RelDVD_cleinte() {
    }
    
}
