/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author javie
 */
public class edades {
    private int edad_inicial,edad_fin;
    private conexion cn;

    public int getEdad_inicial() {
        return edad_inicial;
    }

    public void setEdad_inicial(int edad_inicial) {
        this.edad_inicial = edad_inicial;
    }

    public int getEdad_fin() {
        return edad_fin;
    }

    public void setEdad_fin(int edad_fin) {
        this.edad_fin = edad_fin;
    }

    public edades(int edad_inicial, int edad_fin) {
        this.edad_inicial = edad_inicial;
        this.edad_fin = edad_fin;
    }
    
        public int Agregar(){
        int FilasAgregadas=0;
        try {
            cn=new conexion();
            PreparedStatement ps;
            String Sentencia="INSERT INTO EDADES(EDAD_INICIAL,EDAD_FIN)VALUES(?,?)";
            cn.abrirConexion();
            ps=(PreparedStatement)cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, getEdad_inicial());
            ps.setInt(2, getEdad_fin());
            FilasAgregadas=ps.executeUpdate();
            cn.Cerrar();
        } catch (SQLException e) {
            System.out.println("Error::: "+e.getMessage());
            return 0;
        }
        return FilasAgregadas;
    }
    
    
    
    
}
