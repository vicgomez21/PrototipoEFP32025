/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.seguridad;

/**
 *
 * @author Diana
 */
public class bodegas {

    public bodegas() {
    }
    int pkid ;
    String tipo_de_bodega;
    String Nombre_bode;
    String Direccion_bode;
    String Estado_bode;

    @Override
    public String toString() {
        return "bodegas{" + "pkid=" + pkid + ", tipo_de_bodega=" + tipo_de_bodega + ", Nombre_bode=" + Nombre_bode + ", Direccion_bode=" + Direccion_bode + ", Estado_bode=" + Estado_bode + '}';
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getTipo_de_bodega() {
        return tipo_de_bodega;
    }

    public void setTipo_de_bodega(String tipo_de_bodega) {
        this.tipo_de_bodega = tipo_de_bodega;
    }

    public String getNombre_bode() {
        return Nombre_bode;
    }

    public void setNombre_bode(String Nombre_bode) {
        this.Nombre_bode = Nombre_bode;
    }

    public String getDireccion_bode() {
        return Direccion_bode;
    }

    public void setDireccion_bode(String Direccion_bode) {
        this.Direccion_bode = Direccion_bode;
    }

    public String getEstado_bode() {
        return Estado_bode;
    }

    public void setEstado_bode(String Estado_bode) {
        this.Estado_bode = Estado_bode;
    }

    public bodegas(int pkid, String tipo_de_bodega, String Nombre_bode, String Direccion_bode, String Estado_bode) {
        this.pkid = pkid;
        this.tipo_de_bodega = tipo_de_bodega;
        this.Nombre_bode = Nombre_bode;
        this.Direccion_bode = Direccion_bode;
        this.Estado_bode = Estado_bode;
    }
   
}
