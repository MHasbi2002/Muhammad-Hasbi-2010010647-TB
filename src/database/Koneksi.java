package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Koneksi {
    private static Connection Koneksi;
    public static Connection getKoneksi(){
        if(Koneksi==null){
            try{
                String url;
                url="jdbc:mysql://localhost:3306/rentalmobil";
                String username = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                Koneksi=DriverManager.getConnection(url,username,password);
            }catch (SQLException t){
                JOptionPane.showMessageDialog(null, "Error Koneksi ");
            }
        }return Koneksi;
    }static Object getConnection(){
        throw new UnsupportedOperationException ("Not yet implemented");
    }
}
