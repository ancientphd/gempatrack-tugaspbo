/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.*;
import Koneksi.KoneksiDB;

public class AuthController {
    public static boolean login(String username, String password) {
        try {
            Connection conn = KoneksiDB.getKoneksi();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password); // idealnya password hash
            ResultSet rs = ps.executeQuery();
            return rs.next(); // true jika user ditemukan
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

