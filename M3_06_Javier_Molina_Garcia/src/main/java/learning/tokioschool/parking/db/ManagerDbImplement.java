package learning.tokioschool.parking.db;

import learning.tokioschool.parking.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

public class ManagerDbImplement extends ManagerDbAbstract {
    public ManagerDbImplement() {}

    @Override
    public int update(final String matricula, final LocalDateTime horaSalida) {
        int filasAfectadas = 0;

        // 1. Abrimos conexión y preparamos la sentencia SQL que heredamos (UPDATE)
        try (Connection conn = iniConexion();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {

            // 2. Sustituimos las interrogaciones (?) por los datos.
            // OJO: El orden de los números (1, 2) corresponde al orden de las ? en la constante UPDATE
            pstmt.setTimestamp(1, Timestamp.valueOf(horaSalida));
            pstmt.setString(2, matricula);

            // 3. Ejecutamos la consulta. executeUpdate() devuelve cuántas filas se han modificado.
            filasAfectadas = pstmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al actualizar el vehículo: " + e.getMessage());
        }

        return filasAfectadas;
    }

    @Override
    public int insert(final String matricula, final Coche coche) {
        int filasAfectadas = 0;
        // 1. Preparamos la conexión y la constante INSERT que nos dieron
        try (Connection conn = iniConexion();
             PreparedStatement pstmt = conn.prepareStatement(INSERT)) {

            // 2. Mapeamos los datos del objeto Coche a las ? de la consulta SQL
            pstmt.setString(1, matricula);
            pstmt.setString(2, coche.getMarca());
            pstmt.setString(3, coche.getModelo());
            // Convertimos LocalDateTime de Java a Timestamp de SQL
            pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(coche.getHoraEntrada()));

            // OJO: La hora de salida puede ser nula si el coche acaba de entrar
            if (coche.getHoraSalida() != null) {
                pstmt.setTimestamp(5, java.sql.Timestamp.valueOf(coche.getHoraSalida()));
            } else {
                // Le decimos a SQL explícitamente que inserte un NULL en este campo
                pstmt.setNull(5, java.sql.Types.TIMESTAMP);
            }

            // 3. Ejecutamos la inserción
            filasAfectadas = pstmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al insertar el coche: " + e.getMessage());
        }
        return filasAfectadas;
    }

    @Override
    public Coche search(final String matricula) {
        Coche coche = null;

        try (Connection conn = iniConexion();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_MATRICULA)) {

            pstmt.setString(1, matricula);

            // 1. Ejecutamos la consulta. Para los SELECT se usa executeQuery(), que devuelve un ResultSet
            try (java.sql.ResultSet rs = pstmt.executeQuery()) {
                // 2. rs.next() mueve el cursor a la primera fila. Si devuelve true, es que encontró el coche
                if (rs.next()) {
                    String marca = rs.getString("Marca");
                    String modelo = rs.getString("Modelo");
                    LocalDateTime horaEntrada = rs.getTimestamp("HoraEntrada").toLocalDateTime();

                    // Comprobamos si la hora de salida es nula en la base de datos
                    java.sql.Timestamp tsSalida = rs.getTimestamp("HoraSalida");
                    LocalDateTime horaSalida = null;
                    if (tsSalida != null) {
                        horaSalida = tsSalida.toLocalDateTime();
                    }

                    // 3. Reconstruimos el objeto Coche con los datos de la base de datos
                    coche = new Coche(marca, modelo, horaEntrada, horaSalida);
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al buscar el coche: " + e.getMessage());
        }

        return coche; // Devolverá el coche, o null si no encontró esa matrícula
    }

    @Override
    public Map<String, Coche> searchAll() {
        // En lugar del Map guardado en memoria que tenías antes, creamos uno nuevo en cada consulta
        Map<String, Coche> todosLosCoches = new java.util.HashMap<>();

        try (Connection conn = iniConexion();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
             java.sql.ResultSet rs = pstmt.executeQuery()) { // Ejecutamos directamente sin parámetros

            // Bucle while: mientras haya filas (coches) en la tabla, sigue extrayendo
            while (rs.next()) {
                String matricula = rs.getString("Matricula"); // En este SELECT sí pedimos la matrícula
                String marca = rs.getString("Marca");
                String modelo = rs.getString("Modelo");
                LocalDateTime horaEntrada = rs.getTimestamp("HoraEntrada").toLocalDateTime();

                java.sql.Timestamp tsSalida = rs.getTimestamp("HoraSalida");
                LocalDateTime horaSalida = (tsSalida != null) ? tsSalida.toLocalDateTime() : null;

                Coche coche = new Coche(marca, modelo, horaEntrada, horaSalida);
                todosLosCoches.put(matricula, coche); // Lo añadimos al Map
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al recuperar todos los coches: " + e.getMessage());
        }

        return todosLosCoches;
    }

    @Override
    public Map<String, Coche> searchAllFilterHoraSalida() {
        Map<String, Coche> cochesDentro = new java.util.HashMap<>();

        // Es idéntico a searchAll(), pero usando la constante que filtra los nulos
        try (Connection conn = iniConexion();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_WITHOUT_HORA_SALIDA);
             java.sql.ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String matricula = rs.getString("Matricula");
                String marca = rs.getString("Marca");
                String modelo = rs.getString("Modelo");
                LocalDateTime horaEntrada = rs.getTimestamp("HoraEntrada").toLocalDateTime();

                // Como filtramos por los que no han salido, sabemos que aquí no habrá hora de salida
                Coche coche = new Coche(marca, modelo, horaEntrada, null);
                cochesDentro.put(matricula, coche);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al recuperar coches en el parking: " + e.getMessage());
        }

        return cochesDentro;
    }
}
