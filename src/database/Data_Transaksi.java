package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Data_Transaksi {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String no_transaksi;
    public String lama_sewa;
    public String harga;
    public String total;
    
   
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO transaksi(no_transaksi,lama_sewa,harga,total)VALUE(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,no_transaksi);
        pst.setString(2,lama_sewa);
        pst.setString(3,harga);
        pst.setString(4,total);      
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE transaksi set lama_sewa=?, harga=?, total=? where no_transaksi=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,lama_sewa);
        pst.setString(2,harga);
        pst.setString(3,total);
        pst.setString(4,no_transaksi);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from transaksi where no_transaksi=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, no_transaksi);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatedatamobilT()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select no_transaksi,lama_sewa,harga,total from transaksi";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    } 
    
}
