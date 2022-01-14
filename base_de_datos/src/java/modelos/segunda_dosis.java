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
public class segunda_dosis {
     private int id_registro,id_dosis;
  private conexion cn;

    public segunda_dosis(int id_registro, int id_dosis) {
        this.id_registro = id_registro;
        this.id_dosis = id_dosis;
    }

    public segunda_dosis() {
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getId_dosis() {
        return id_dosis;
    }

    public void setId_dosis(int id_dosis) {
        this.id_dosis = id_dosis;
    }
  public int Agregar(){
        int FilasAgregadas=0;
        try {
            cn=new conexion();
            PreparedStatement ps;
            String Sentencia="insert into registros_dosis(id_registro,id_dosis,fecha_dosis)values(?,?,sysdate)";
            cn.abrirConexion();
            ps=(PreparedStatement)cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, this.getId_registro());
            ps.setInt(2, (this.getId_dosis()+1));
            FilasAgregadas=ps.executeUpdate();
            cn.Cerrar();
        } catch (SQLException e) {
            System.out.println("Error registrosegundaadosis::: "+e.getMessage());
            return 0;
        }
        return FilasAgregadas;
    }
     public int idRegistradoprimeradosis(int idInscripcion) {
        int Resultado = 0;
        try {
            cn = new conexion();
            ResultSet rs;
            PreparedStatement ps;
            String Sentencia = "select id_registro as id from Registros where id_inscripcion=? and Dosis_a_aplicada='primera'";
            cn.abrirConexion();
            ps = (PreparedStatement) cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, idInscripcion);
            rs = ps.executeQuery();
            while (rs.next()) {
                Resultado = rs.getInt("id");
            }
            cn.Cerrar();
        } catch (SQLException e) {
            System.out.println("Error idregistroprimera::: " + e.getMessage());
            return 0;
        }
        return Resultado;
    }
     
     
     
     
     public int aplicada(int id_registro) {
           int Resultado = 0;
        try {
            cn = new conexion();
            ResultSet rs;
            PreparedStatement ps;
            String Sentencia = "select id_registro_dosis as id from registros_dosis where id_registro=?";
            cn.abrirConexion();
            ps = (PreparedStatement) cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, id_registro);
            rs = ps.executeQuery();
            while (rs.next()) {
                Resultado = rs.getInt("id");
            }
            cn.Cerrar();
        } catch (SQLException e) {
            System.out.println("Error r::: " + e.getMessage());
            return 0;
        }
        return Resultado;
    }
}
