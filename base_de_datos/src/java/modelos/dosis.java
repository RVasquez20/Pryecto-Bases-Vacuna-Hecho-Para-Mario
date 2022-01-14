/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author javie
 */
public class dosis {
    private int id_vacuna, dosis_vacuna;

    public dosis() {
    }

    public int getId_vacuna() {
        return id_vacuna;
    }

    public int getDosis_vacuna() {
        return dosis_vacuna;
    }

    public dosis(int id_vacuna, int dosis_vacuna) {
        this.id_vacuna = id_vacuna;
        this.dosis_vacuna = dosis_vacuna;
    }
    
    private conexion cn;
    
    public HashMap Vacunas(){
        HashMap<String,String> listaPrimerDosis=new HashMap();
        try {
            String Sentencia="select d.id_dosis as id,v.nombre as vacuna from Dosis d,vacunas v " +
"where v.id_vacuna = d.id_vacuna " +
"and d.dosis_vacuna='primera'";
            cn=new conexion();
            cn.abrirConexion();
            ResultSet rs=cn.conection.createStatement().executeQuery(Sentencia);
            while (rs.next()) {
                listaPrimerDosis.put(rs.getString("id"), rs.getString("vacuna"));
            }
            cn.Cerrar();
        } catch (Exception e) {
            System.out.println("Error dosis::: " + e.getMessage());
        }
        return listaPrimerDosis;
    }
    
     public int iddosis(int idregistro){
        int Resultado = 0;
        try {
            cn = new conexion();
            ResultSet rs;
            PreparedStatement ps;
            String Sentencia = "select id_dosis as id from registros_dosis where id_registro=?";
            cn.abrirConexion();
            ps = (PreparedStatement) cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, idregistro);
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
    
    
}
