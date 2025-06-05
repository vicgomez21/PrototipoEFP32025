package Modelo.seguridad;
import Modelo.Conexion;
import Controlador.seguridad.Facultad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class ControladorFacultad {
    private ArrayList<Facultad> equipos;
    
    public ControladorFacultad() {
        equipos = new ArrayList<>();
    }

    // Agregar un nuevo alumno
    public void agregarEquipo(String nombre) {
        Facultad equipo = new Facultad();
        equipo.setNombre(nombre);
        equipos.add(equipo);
        almacenarEquipoEnBD(equipo);
    }

    // Almacenar alumno en la base de datos
    private void almacenarEquipoEnBD(Facultad equipo) {
        String sql = "INSERT INTO facutades (nombre, parcial1, parcial2, parcial3, zona, total, promedio) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, equipo.getNombre());
            pstmt.setInt(2, equipo.getParcial1());
            pstmt.setInt(3, equipo.getParcial2());
            pstmt.setInt(4, equipo.getParcial3());
            pstmt.setInt(5, equipo.getZona());
            pstmt.setInt(6, equipo.getTotal());
            pstmt.setInt(7, equipo.getPromedio());

            pstmt.executeUpdate();
            System.out.println("Alumno almacenado en la base de datos: " + equipo.getNombre());

        } catch (SQLException e) {
            System.err.println("Error al almacenar el alumno: " + e.getMessage());
        }
    }

    // Generar notas aleatorias para todos los alumnos
    public void generarNotasAleatorias() {
        Random rand = new Random();

        for (Facultad alumno : equipos) {
            // Generar notas solo si no las tiene
            if (alumno.getPartidosJugados() < 4) {
                if (alumno.getParcial1() == 0) {
                    alumno.setParcial1(rand.nextInt(21)); // 0-20
                    alumno.setPartidosJugados(alumno.getPartidosJugados() + 1);
                }
                if (alumno.getParcial2() == 0) {
                    alumno.setParcial2(rand.nextInt(26)); // 0-25
                    alumno.setPartidosJugados(alumno.getPartidosJugados() + 1);
                }
                if (alumno.getParcial3() == 0) {
                    alumno.setParcial3(rand.nextInt(36)); // 0-35
                    alumno.setPartidosJugados(alumno.getPartidosJugados() + 1);
                }
                if (alumno.getZona() == 0) {
                    alumno.setZona(rand.nextInt(21)); // 0-20
                    alumno.setPartidosJugados(alumno.getPartidosJugados() + 1);
                }

                // Calcular total y promedio
                int total = alumno.getParcial1() + alumno.getParcial2() + 
                           alumno.getParcial3() + alumno.getZona();
                alumno.setTotal(total);
                alumno.setPromedio(total / 4);

                // Actualizar en BD
                actualizarEquipoEnBD(alumno);
            }
        }
    }

    // Verificar si todos tienen las 4 notas
    private boolean todosHanHecho4examenes() {
        for (Facultad alumno : equipos) {
            if (alumno.getPartidosJugados() < 4) {
                return false;
            }
        }
        return true;
    }

    // Actualizar datos del alumno en BD
    private void actualizarEquipoEnBD(Facultad alumno) {
        String sql = "UPDATE facutades SET parcial1=?, parcial2=?, parcial3=?, zona=?, total=?, promedio=? WHERE nombre=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, alumno.getParcial1());
            pstmt.setInt(2, alumno.getParcial2());
            pstmt.setInt(3, alumno.getParcial3());
            pstmt.setInt(4, alumno.getZona());
            pstmt.setInt(5, alumno.getTotal());
            pstmt.setInt(6, alumno.getPromedio());
            pstmt.setString(7, alumno.getNombre());

            pstmt.executeUpdate();
            System.out.println("Datos actualizados para: " + alumno.getNombre());

        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    // Obtener lista de alumnos ordenada por promedio
    public ArrayList<Facultad> getAlumnos() {
        equipos.sort((a1, a2) -> Integer.compare(a2.getPromedio(), a1.getPromedio()));
        return equipos;
    }

    // Método adicional para mostrar datos en consola
    public void mostrarAlumnosEnConsola() {
        System.out.println("\n=== LISTA DE ALUMNOS ===");
        for (Facultad alumno : equipos) {
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Notas - Parcial 1: " + alumno.getParcial1() + 
                             ", Parcial 2: " + alumno.getParcial2() + 
                             ", Parcial 3: " + alumno.getParcial3() + 
                             ", Zona: " + alumno.getZona());
            System.out.println("Total: " + alumno.getTotal() + ", Promedio: " + alumno.getPromedio());
            System.out.println("----------------------");
        }
    }
}