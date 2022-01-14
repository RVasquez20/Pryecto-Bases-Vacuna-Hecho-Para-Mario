/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author javie
 */
public class Ciudadanos {

    private String Nombre, Apellido, FechaNac;
    private int DPI, Telefono;
    private conexion cn;

    public void setDPI(int DPI) {
        this.DPI = DPI;
    }

    public Ciudadanos() {
    }

    public Ciudadanos(String Nombre, String Apellido, String FechaNac, int DPI, int Telefono) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.FechaNac = FechaNac;
        this.DPI = DPI;
        this.Telefono = Telefono;
    }

    public int Registrar() {
        int FilasAgregadas = 0;
        try {
            cn = new conexion();
            PreparedStatement ps;
            String Sentencia = "INSERT INTO CIUDADANOS(DPI,NOMBRE,APELLIDO,FECHA_NAC,TELEFONO)VALUES(?,?,?,?,?)";
            cn.abrirConexion();
            ps = (PreparedStatement) cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, getDPI());
            ps.setString(2, getNombre());
            ps.setString(3, getApellido());
            ps.setString(4, getFechaNac());
            ps.setInt(5, getTelefono());
            FilasAgregadas = ps.executeUpdate();
            cn.Cerrar();
        } catch (SQLException e) {
            System.out.println("Error::: " + e.getMessage());
            return 0;
        }
        return FilasAgregadas;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public int getDPI() {
        return DPI;
    }

    public int getTelefono() {
        return Telefono;
    }

    public int Registrado() {
        int Resultado = 0;
        try {
            cn = new conexion();
            ResultSet rs;
            PreparedStatement ps;
            String Sentencia = "select dpi from ciudadanos where dpi=?";
            cn.abrirConexion();
            ps = (PreparedStatement) cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, getDPI());
            rs = ps.executeQuery();
            while (rs.next()) {
                Resultado = rs.getInt("dpi");
            }
            cn.Cerrar();
        } catch (SQLException e) {
            System.out.println("Error::: " + e.getMessage());
            return 0;
        }
        return Resultado;
    }

    public int Id_edad() {
        int Resultado = 0;
        try {
            cn = new conexion();
            ResultSet rs;
            PreparedStatement ps;
            String Sentencia = "SELECT e.id_edad as id FROM EDADES e,Ciudadanos c WHERE to_number(To_Char(sysdate,'RRRR'))-"
                    + "To_number(To_Char(c.fecha_nac,'RRRR')) "
                    + "BETWEEN e.edad_inicial AND e.edad_fin and c.dpi=?";
            cn.abrirConexion();
            ps = (PreparedStatement) cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, getDPI());
            rs = ps.executeQuery();
            while (rs.next()) {
                Resultado = rs.getInt("id");
            }
            cn.Cerrar();
        } catch (SQLException e) {
            System.out.println("Error::: " + e.getMessage());
            return 0;
        }
        return Resultado;
    }

}
