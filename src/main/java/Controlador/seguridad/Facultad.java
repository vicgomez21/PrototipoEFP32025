/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.seguridad;

public class Facultad {
    private String nombre;
    private int parcial1;
    private int parcial2;
    private int parcial3;
    private int zona;
    private int total;
    private int promedio;
    private int partidosJugados;

    // Constructor vacío
    public Facultad() {
        this.partidosJugados = 0;
        this.parcial1 = 0;
        this.parcial2 = 0;
        this.parcial3 = 0;
        this.zona = 0;
        this.total = 0;
        this.promedio = 0;
    }
    
    // Constructor sobrecargado
    public Facultad(String nombre, int parcial1, int parcial2, int parcial3, int zona, int total, int promedio) {
        this.nombre = nombre;
        this.parcial1 = parcial1;
        this.parcial2 = parcial2;
        this.parcial3 = parcial3;
        this.zona = zona;
        this.total = total;
        this.promedio = promedio;
        this.partidosJugados = 4; // Asume que si se crea con notas, ya tiene los 4 "exámenes"
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getParcial1() {
        return parcial1;
    }

    public void setParcial1(int parcial1) {
        this.parcial1 = parcial1;
    }

    public int getParcial2() {
        return parcial2;
    }

    public void setParcial2(int parcial2) {
        this.parcial2 = parcial2;
    }

    public int getParcial3() {
        return parcial3;
    }

    public void setParcial3(int parcial3) {
        this.parcial3 = parcial3;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    // Métodos no utilizados (pueden eliminarse si no se necesitan)
    public int getGolesAFavor() {
        return 0;
    }

    public void setGolesAFavor(int i) {
        // No implementado
    }

    public int getGolesEnContra() {
        return 0;
    }

    @Override
    public String toString() {
        return "Facultad{" + 
               "nombre=" + nombre + 
               ", parcial1=" + parcial1 + 
               ", parcial2=" + parcial2 + 
               ", parcial3=" + parcial3 + 
               ", zona=" + zona + 
               ", total=" + total + 
               ", promedio=" + promedio + '}';
    }
}