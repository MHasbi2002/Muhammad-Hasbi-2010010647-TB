package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Data_Penyewa {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_penyewa;
    public String nama_penyewa;
    public String alamat;
    public String no_hp;
    public String no_ktp;
    public String status;
   
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO data_penyewa(id_penyewa,nama_penyewa,alamat,no_hp,no_ktp,status)VALUE(?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_penyewa);
        pst.setString(2,nama_penyewa);
        pst.setString(3,alamat);
        pst.setString(4,no_hp);      
        pst.setString(5,no_ktp);
        pst.setString(6,status);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE data_penyewa set nama_penyewa=?, alamat=?, no_hp=?, no_ktp=?, status=? where id_penyewa=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama_penyewa);
        pst.setString(2,alamat);
        pst.setString(3,no_hp);
        pst.setString(4,no_ktp);
        pst.setString(5,status);
        pst.setString(6,id_penyewa);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from data_penyewa where id_penyewa=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_penyewa);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatedatamobilT()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_penyewa,nama_penyewa,alamat,no_hp,no_ktp,status from data_penyewa";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    } 
    
}

