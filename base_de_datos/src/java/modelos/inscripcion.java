/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javie
 */
public class inscripcion {
    private int dpi, id_edad,id_inscipion;
    private conexion cn;
    private conexionUSR_CONSULTA cnC;

    public int getId_inscipion() {
        return id_inscipion;
    }

    public void setId_inscipion(int id_inscipion) {
        this.id_inscipion = id_inscipion;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public inscripcion() {
    }

    public inscripcion(int dpi, int id_edad) {
        this.dpi = dpi;
        this.id_edad = id_edad;
    }

    public int getDpi() {
        return dpi;
    }

    public int getId_edad() {
        return id_edad;
    }
    
    
public int Registrar() {
        int FilasAgregadas = 0;
        try {
            cn = new conexion();
            PreparedStatement ps;
            String Sentencia = "INSERT INTO INSCRIPCION(DPI,ID_EDAD,FECHA_INSCRIPCION)VALUES(?,?,SYSDATE)";
            cn.abrirConexion();
            ps = (PreparedStatement) cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, getDpi());
            ps.setInt(2, getId_edad());
            FilasAgregadas = ps.executeUpdate();
            cn.Cerrar();
        } catch (SQLException e) {
            System.out.println("Error::: " + e.getMessage());
            return 0;
        }
        return FilasAgregadas;
    }
//saber si el ciudadano esta inscrito
   public int Registrado() {
        int Resultado = 0;
        try {
            cn = new conexion();
            ResultSet rs;
            PreparedStatement ps;
            String Sentencia = "select id_inscripcion as id from inscripcion where dpi=?";
            cn.abrirConexion();
            ps = (PreparedStatement) cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, getDpi());
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
    public int idRegistro(int id) {
        int Resultado = 0;
        try {
            cn = new conexion();
            ResultSet rs;
            PreparedStatement ps;
            String Sentencia = "select id_registro as id from registros where id_inscripcion=? and dosis_a_aplicada='primera'";
            cn.abrirConexion();
            ps = (PreparedStatement) cn.conection.prepareStatement(Sentencia);
            ps.setInt(1, id);
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

 public DefaultTableModel ConstanciaRegistros(){
     DefaultTableModel Registro=new DefaultTableModel();
     try {
         cnC=new conexionUSR_CONSULTA();
         cnC.abrirConexionUSR_CONSULTA();
         ResultSet rs;
            PreparedStatement ps;
         String Sentencia="SELECT NOMBRE,APELLIDO,DPI,TO_CHAR(FECHA_NAC,'DD/MM/RRRR') AS FECHA,TELEFONO FROM CONSTANCIA_REGISTROS " +
"WHERE DPI=?";
         String[] PrimerLinea={"NOMBRE","APELLIDO","DPI","FECHA DE NACIMIENTO","TELEFONO"};
         
            ps = (PreparedStatement) cnC.conection.prepareStatement(Sentencia);
            ps.setInt(1, this.getDpi());
            rs = ps.executeQuery();
            Registro.setColumnIdentifiers(PrimerLinea);
            String[] Registros=new String[5];
            while (rs.next()) {
             Registros[0]=rs.getString("NOMBRE");
             Registros[1]=rs.getString("APELLIDO");
             Registros[2]=rs.getString("DPI");
             Registros[3]=rs.getString("FECHA");
             Registros[4]=rs.getString("TELEFONO");
             Registro.addRow(Registros);
            }
                 
                 cnC.CerrarUSR_CONSULTA();
                
     } catch (Exception e) {
         System.out.println("Error ConsultaRegistro:::"+e.getMessage());
     }
      return Registro;
 }
    
   public DefaultTableModel ConstanciaVacunas(){
     DefaultTableModel Registro=new DefaultTableModel();
     try {
         cnC=new conexionUSR_CONSULTA();
         cnC.abrirConexionUSR_CONSULTA();
         ResultSet rs;
            PreparedStatement ps;
         String Sentencia="SELECT DOSIS_A_APLICADA,NOMBRE_VACUNA,TO_CHAR(FECHA_VACUNACION,'DD/MM/RRRR') AS FECHA FROM CONSTANCIA_VACUNACION WHERE DPI=?";
         String[] PrimerLinea={"DOSIS ADMINISTRADA","NOMBRE DE LA VACUNA","FECHA DE APLICACION"};
         
            ps = (PreparedStatement) cnC.conection.prepareStatement(Sentencia);
            ps.setInt(1, this.getDpi());
            rs = ps.executeQuery();
            Registro.setColumnIdentifiers(PrimerLinea);
            String[] Registros=new String[3];
            while (rs.next()) {
             Registros[0]=rs.getString("DOSIS_A_APLICADA");
             Registros[1]=rs.getString("NOMBRE_VACUNA");
             Registros[2]=rs.getString("FECHA");
             Registro.addRow(Registros);
            }
                 
                 cnC.CerrarUSR_CONSULTA();
                
     } catch (Exception e) {
         System.out.println("Error ConsultaVACUNAS:::"+e.getMessage());
     }
      return Registro;
 }  
    
    
}
