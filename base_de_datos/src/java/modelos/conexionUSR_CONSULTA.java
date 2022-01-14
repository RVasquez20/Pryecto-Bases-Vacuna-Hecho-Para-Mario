/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author javie
 */
public class conexionUSR_CONSULTA {

    public Connection conection;
    public final String link = "jdbc:oracle:thin:@localhost:1521:xe";
    public final String usuario = "USR_CONSULTA";
    public final String contrasena = "m1226";

    public Connection abrirConexionUSR_CONSULTA() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conection = DriverManager.getConnection(link, usuario, contrasena);
            System.out.println("Exitosisimo");
        } catch (Exception e) {
            System.out.println("Error al conectar : " + e.getMessage());
        }
        return conection;
    }
    public void CerrarUSR_CONSULTA() throws SQLException{
        conection.close();
    }

}
