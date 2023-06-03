/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uaspbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static uaspbo.DBConnector.connection;

/**
 *
 * @author M IQBAL
 */
public class Transaksi {
    
    public static int id_transaksi;
    public static int no_antrian;
    public static String nama;
    public static float total_belanja;
    public static float uang_dibayar;
    public static float kembalian;
    public static String waktu_transaksi;
    
    public Transaksi(){
        
    }
    
    public Transaksi(int id_transaksi,int no_antrian, String nama, float total_belanja, float uang_dibayar, float kembalian, String waktu_transaksi){
        this.id_transaksi = id_transaksi;
        this.no_antrian = no_antrian;
        this.nama = nama;
        this.total_belanja = total_belanja;
        this.uang_dibayar = uang_dibayar;
        this.kembalian = kembalian;
        this.waktu_transaksi = waktu_transaksi;
    }
    
     public static void simpanDatabase() throws SQLException{
        try{
            Connection conn = DBConnector.initDBConnection();
            String sql = "INSERT INTO transaksi(id_transaksi, no_antrian, nama, total_belanja, uang_dibayar, kembalian, waktu_transaksi) VALUES(?, ?, ?, ?, ?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
           
            stmt.setInt(1,id_transaksi);
            stmt.setInt(2, no_antrian);
            stmt.setString(3, nama);
            stmt.setFloat(4, total_belanja);
            stmt.setFloat(5, uang_dibayar);
            stmt.setFloat(6,kembalian);
            stmt.setString(7, waktu_transaksi);
            stmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.print(e);
        }
    }
     
    public static void resetDatabase() throws SQLException{
        try{
            Connection conn = DBConnector.initDBConnection();
            Statement statement = conn.createStatement();
            statement.executeUpdate("TRUNCATE TABLE transaksi");

            // Mengatur ulang nilai ID menjadi 1
            statement.executeUpdate("ALTER TABLE transaksi AUTO_INCREMENT = 1");

            // Memberikan notifikasi berhasil
            JOptionPane.showMessageDialog(null, "Database telah direset. Silakan close window ini, dan jalankan kembali programnya");    
        } catch(SQLException e){
            System.out.print(e);
        }
    }
    
}
