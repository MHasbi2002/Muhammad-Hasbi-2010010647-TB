package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import database.Koneksi;

public class Data_Mobil {
   Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_mobil;
    public String nama_mobil;
    public String merek_mobil;
    public String no_plat;
    public String harga_mobil;
    public String status;
   
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO data_mobil(id_mobil,nama_mobil,merek_mobil,no_plat,harga_mobil,status)VALUE(?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_mobil);
        pst.setString(2,nama_mobil);
        pst.setString(3,merek_mobil);
        pst.setString(4,no_plat);      
        pst.setString(5,harga_mobil);
        pst.setString(6,status);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE data_mobil set nama_mobil=?, merek_mobil=?, no_plat=?, harga_mobil=?, status=? where id_mobil=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama_mobil);
        pst.setString(2,merek_mobil);
        pst.setString(3,no_plat);
        pst.setString(4,harga_mobil);
        pst.setString(5,status);
        pst.setString(6,id_mobil);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from data_mobil where id_mobil=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_mobil);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatedatamobilT()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_mobil,nama_mobil,merek_mobil,no_plat,harga_mobil,status from data_mobil";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    } 
}
