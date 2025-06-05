package Modelo.seguridad;

import Controlador.seguridad.Equipo;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class ControladorCampeonato {
    private ArrayList<Equipo> equipos;
    
    public ControladorCampeonato() {
        equipos = new ArrayList<>();
    }

    public void agregarEquipo(String nombre) {
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        equipos.add(equipo);
        almacenarEquipoEnBD(equipo);
    }

    private void almacenarEquipoEnBD(Equipo equipo) {
        String sql = "INSERT INTO equipos (nombre, puntos) VALUES ( ?,?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, equipo.getNombre());
            pstmt.setInt(2, equipo.getPuntos());
            

            pstmt.executeUpdate();
            System.out.println("Candidato almacenado en la base de datos: " + equipo.getNombre());

        } catch (SQLException e) {
            System.err.println("Error al almacenar el candidato en la base de datos: " + e.getMessage());
        }
    }

    public void generarVotacionAleatoria() {
        Random rand = new Random();
        int totalVotos = 100; // Total de votos a distribuir
        
        // Distribuir votos aleatorios entre los candidatos
        for (Equipo candidato : equipos) {
            int votos = rand.nextInt(totalVotos / 2); // Asigna hasta la mitad de los votos
            candidato.setPuntos(votos);
            totalVotos -= votos;
            
            // Actualizar en BD
            actualizarEquipoEnBD(candidato);
        }
        
        // Asignar los votos restantes al último candidato
        if (!equipos.isEmpty()) {
            Equipo ultimo = equipos.get(equipos.size() - 1);
            ultimo.setPuntos(ultimo.getPuntos() + totalVotos);
            actualizarEquipoEnBD(ultimo);
        }
    }

    private void actualizarEquipoEnBD(Equipo equipo) {
        String sql = "UPDATE equipos SET puntos = ? WHERE nombre = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, equipo.getPuntos());
            pstmt.setString(2, equipo.getNombre());

            pstmt.executeUpdate();
            System.out.println("Candidato actualizado en la base de datos: " + equipo.getNombre());

        } catch (SQLException e) {
            System.err.println("Error al actualizar el candidato en la base de datos: " + e.getMessage());
        }
    }

    public ArrayList<Equipo> getEquipos() {
        equipos.sort((e1, e2) -> Integer.compare(e2.getPuntos(), e1.getPuntos()));
        return equipos;
    }
}