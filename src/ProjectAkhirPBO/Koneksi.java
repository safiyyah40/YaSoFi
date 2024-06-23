/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectAkhirPBO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Aryanto Pratama
 */
public class Koneksi {
    private static Connection mysqlkonek;
    public static Connection koneksiDB() throws SQLException{
        if (mysqlkonek == null) {
            try{
            String DB = "jdbc:mysql://localhost:3306/java_user_db";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlkonek = DriverManager.getConnection(DB, user, pass);
            }catch (Exception e){
                System.out.println("Gagal");
                e.printStackTrace();
            }
        }
        return mysqlkonek;
    }
}
