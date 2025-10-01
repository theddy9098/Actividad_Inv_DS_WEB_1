package CEA_Indiv.Infrastructure.Persistente;

import CEA_Indiv.Domain.Entitis.Aplicacion;
import CEA_Indiv.Domain.Repositorie.AplicacionRepositori;
import CEA_Indiv.Infrastructure.ConfiBD.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AplicacionRepositoriImp implements AplicacionRepositori {
    
    private Connection connection;
    
    public AplicacionRepositoriImp() {
        this.connection = ConexionBD.getConnection();
    }
    
    @Override
    public boolean crearAplicacion(Aplicacion aplicacion) {
        try {
            String sql = "INSERT INTO aplicacion (nombre, proveedor, categoria, lenguaje_principal, " +
                        "lenguaje_secundario, usa_bd, requiere_conexion_red, num_bits, sistema_operativo, " +
                        "requisitos_hardware, licencia, precio, descripcion, web, correo, tamano_instalador) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aplicacion.getNombre());
            stmt.setString(2, aplicacion.getProveedor());
            stmt.setString(3, aplicacion.getCategoria());
            stmt.setString(4, aplicacion.getLenguajePrincipal());
            stmt.setString(5, aplicacion.getLenguajeSecundario());
            stmt.setBoolean(6, aplicacion.isUsaBd());
            stmt.setBoolean(7, aplicacion.isRequiereConexionRed());
            stmt.setInt(8, aplicacion.getNumBits());
            stmt.setString(9, aplicacion.getSistemaOperativo());
            stmt.setString(10, aplicacion.getRequisitosHardware());
            stmt.setString(11, aplicacion.getLicencia());
            stmt.setDouble(12, aplicacion.getPrecio());
            stmt.setString(13, aplicacion.getDescripcion());
            stmt.setString(14, aplicacion.getWeb());
            stmt.setString(15, aplicacion.getCorreo());
            stmt.setDouble(16, aplicacion.getTamanoInstalador());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean eliminarAplicacion(int id) {
        try {
            String sql = "DELETE FROM aplicacion WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean actualizarAplicacion(int id) {
        try {
            // Primero buscamos la aplicación para obtener sus datos
            Aplicacion aplicacion = buscarAplicacion(id);
            if (aplicacion == null) {
                return false;
            }
            
            String sql = "UPDATE aplicacion SET nombre = ?, proveedor = ?, categoria = ?, " +
                        "lenguaje_principal = ?, lenguaje_secundario = ?, usa_bd = ?, " +
                        "requiere_conexion_red = ?, num_bits = ?, sistema_operativo = ?, " +
                        "requisitos_hardware = ?, licencia = ?, precio = ?, descripcion = ?, " +
                        "web = ?, correo = ?, tamano_instalador = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aplicacion.getNombre());
            stmt.setString(2, aplicacion.getProveedor());
            stmt.setString(3, aplicacion.getCategoria());
            stmt.setString(4, aplicacion.getLenguajePrincipal());
            stmt.setString(5, aplicacion.getLenguajeSecundario());
            stmt.setBoolean(6, aplicacion.isUsaBd());
            stmt.setBoolean(7, aplicacion.isRequiereConexionRed());
            stmt.setInt(8, aplicacion.getNumBits());
            stmt.setString(9, aplicacion.getSistemaOperativo());
            stmt.setString(10, aplicacion.getRequisitosHardware());
            stmt.setString(11, aplicacion.getLicencia());
            stmt.setDouble(12, aplicacion.getPrecio());
            stmt.setString(13, aplicacion.getDescripcion());
            stmt.setString(14, aplicacion.getWeb());
            stmt.setString(15, aplicacion.getCorreo());
            stmt.setDouble(16, aplicacion.getTamanoInstalador());
            stmt.setInt(17, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Aplicacion buscarAplicacion(int id) {
        try {
            String sql = "SELECT * FROM aplicacion WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Aplicacion aplicacion = new Aplicacion();
                aplicacion.setId(rs.getInt("id"));
                aplicacion.setNombre(rs.getString("nombre"));
                aplicacion.setProveedor(rs.getString("proveedor"));
                aplicacion.setCategoria(rs.getString("categoria"));
                aplicacion.setLenguajePrincipal(rs.getString("lenguaje_principal"));
                aplicacion.setLenguajeSecundario(rs.getString("lenguaje_secundario"));
                aplicacion.setUsaBd(rs.getBoolean("usa_bd"));
                aplicacion.setRequiereConexionRed(rs.getBoolean("requiere_conexion_red"));
                aplicacion.setNumBits(rs.getInt("num_bits"));
                aplicacion.setSistemaOperativo(rs.getString("sistema_operativo"));
                aplicacion.setRequisitosHardware(rs.getString("requisitos_hardware"));
                aplicacion.setLicencia(rs.getString("licencia"));
                aplicacion.setPrecio(rs.getDouble("precio"));
                aplicacion.setDescripcion(rs.getString("descripcion"));
                aplicacion.setWeb(rs.getString("web"));
                aplicacion.setCorreo(rs.getString("correo"));
                aplicacion.setTamanoInstalador(rs.getDouble("tamano_instalador"));
                return aplicacion;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public Aplicacion[] listarAplicaciones() {
        List<Aplicacion> aplicaciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM aplicacion";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Aplicacion aplicacion = new Aplicacion();
                aplicacion.setId(rs.getInt("id"));
                aplicacion.setNombre(rs.getString("nombre"));
                aplicacion.setProveedor(rs.getString("proveedor"));
                aplicacion.setCategoria(rs.getString("categoria"));
                aplicacion.setLenguajePrincipal(rs.getString("lenguaje_principal"));
                aplicacion.setLenguajeSecundario(rs.getString("lenguaje_secundario"));
                aplicacion.setUsaBd(rs.getBoolean("usa_bd"));
                aplicacion.setRequiereConexionRed(rs.getBoolean("requiere_conexion_red"));
                aplicacion.setNumBits(rs.getInt("num_bits"));
                aplicacion.setSistemaOperativo(rs.getString("sistema_operativo"));
                aplicacion.setRequisitosHardware(rs.getString("requisitos_hardware"));
                aplicacion.setLicencia(rs.getString("licencia"));
                aplicacion.setPrecio(rs.getDouble("precio"));
                aplicacion.setDescripcion(rs.getString("descripcion"));
                aplicacion.setWeb(rs.getString("web"));
                aplicacion.setCorreo(rs.getString("correo"));
                aplicacion.setTamanoInstalador(rs.getDouble("tamano_instalador"));
                aplicaciones.add(aplicacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aplicaciones.toArray(new Aplicacion[0]);
    }
}
