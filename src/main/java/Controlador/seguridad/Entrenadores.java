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
public class Entrenadores {

    public Entrenadores() {
    }
    int id_entrenador;
    String nombre_1;
    String nombre_2;
    String apellido_1;
    String apellido_2;
    String fecha_nacimiento;
    String id_usuario;

    @Override
    public String toString() {
        return "Entrenadores{" + "id_entrenador=" + id_entrenador + ", nombre_1=" + nombre_1 + ", nombre_2=" + nombre_2 + ", apellido_1=" + apellido_1 + ", apellido_2=" + apellido_2 + ", fecha_nacimiento=" + fecha_nacimiento + ", id_usuario=" + id_usuario + '}';
    }

    public int getId_entrenador() {
        return id_entrenador;
    }

    public void setId_entrenador(int id_entrenador) {
        this.id_entrenador = id_entrenador;
    }

    public String getNombre_1() {
        return nombre_1;
    }

    public void setNombre_1(String nombre_1) {
        this.nombre_1 = nombre_1;
    }

    public String getNombre_2() {
        return nombre_2;
    }

    public void setNombre_2(String nombre_2) {
        this.nombre_2 = nombre_2;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getApellido_2() {
        return apellido_2;
    }

    public void setApellido_2(String apellido_2) {
        this.apellido_2 = apellido_2;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Entrenadores(int id_entrenador, String nombre_1, String nombre_2, String apellido_1, String apellido_2, String fecha_nacimiento, String id_usuario) {
        this.id_entrenador = id_entrenador;
        this.nombre_1 = nombre_1;
        this.nombre_2 = nombre_2;
        this.apellido_1 = apellido_1;
        this.apellido_2 = apellido_2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_usuario = id_usuario;
    }
    
            
}
