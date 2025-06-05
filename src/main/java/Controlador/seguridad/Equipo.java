package Controlador.seguridad;

public class Equipo {
    private String nombre;
    private int puntos; // Ahora representa votos
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getPuntos() {
        return puntos;
    }
    
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    // Métodos eliminados o no utilizados en el sistema de votación
    public int getPartidosJugados() { return 0; }
    public void setPartidosJugados(int partidosJugados) {}
    // ... otros métodos relacionados con partidos pueden dejarse vacíos
}