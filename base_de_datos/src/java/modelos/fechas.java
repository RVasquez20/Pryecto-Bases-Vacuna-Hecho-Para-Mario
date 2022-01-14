/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class fechas {
private conexion cn;
    public fechas() {
    }
  

    public int fechavalidaPrimeraDosis(int id) {
         int Resultado = 0;
        try {
            cn = new conexion();
            ResultSet rs;
            PreparedStatement ps;
            String Sentencia = "select id_registro as id from Registros where id_inscripcion=? and Dosis_a_aplicada='primera' " +
"and sysdate>=fecha";
            cn.abrirConexion();
            ps = (PreparedStatement) cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Resultado = rs.getInt("id");
            }
            cn.Cerrar();
        } catch (SQLException e) {
            System.out.println("Errorf::: " + e.getMessage());
            return 0;
        }
        return Resultado;
    }
    
     public int fechavalidaSegundaDosis(int id) {
         int Resultado = 0;
        try {
            cn = new conexion();
            ResultSet rs;
            PreparedStatement ps;
            String Sentencia = "select id_registro as id from Registros where id_inscripcion=? and Dosis_a_aplicada='segunda' " +
"and sysdate>=fecha";
            cn.abrirConexion();
            ps = (PreparedStatement) cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Resultado = rs.getInt("id");
            }
            cn.Cerrar();
        } catch (SQLException e) {
            System.out.println("Errorf::: " + e.getMessage());
            return 0;
        }
        return Resultado;
    }
}
