package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author rizqi
 */
public class KoneksiDB {
    private static Connection conn;

    public static Connection getKoneksi() {
        if (conn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_gt3"; 
                String user = "root"; 
                String pass = ""; 

                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("Koneksi ke database berhasil.");
            } catch (SQLException e) {
                System.out.println("Koneksi gagal: " + e.getMessage());
            }
        }
        return conn;
    }
}

