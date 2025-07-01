/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Koneksi.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOLogin implements InterfaceLogin {

    Connection connection;

    public DAOLogin() {
        connection = KoneksiDB.getKoneksi();
    }

    @Override
    public boolean login(String username, String password) {
        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next(); // true jika ditemukan
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

