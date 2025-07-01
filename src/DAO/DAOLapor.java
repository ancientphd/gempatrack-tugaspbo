package DAO;

import Model.ModLapor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Koneksi.KoneksiDB; // pastikan import ini sesuai dengan package koneksi kamu

public class DAOLapor implements ImplementLapor {

    Connection connection;
    final String insert = "INSERT INTO laporan (lokasi,tanggal,waktu,deskripsi) VALUES (?,?,?,?)";
    final String select = "SELECT * FROM laporan";
    final String CariLokasi = "SELECT * FROM laporan WHERE lokasi LIKE ?";

    // Konstruktor untuk inisialisasi koneksi
    public DAOLapor() {
        connection = KoneksiDB.getKoneksi();
    }

    @Override
    public void insert(ModLapor mb) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, mb.getLokasi());
            statement.setString(2, mb.getTanggal());
            statement.setString(3, mb.getWaktu());
            statement.setString(4, mb.getDeskripsi());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                mb.setNo(rs.getInt(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<ModLapor> getAll() {
        List<ModLapor> lmb = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {
                ModLapor mb = new ModLapor();
                mb.setNo(rs.getInt("no"));
                mb.setLokasi(rs.getString("lokasi"));
                mb.setTanggal(rs.getString("tanggal"));
                mb.setWaktu(rs.getString("waktu"));
                mb.setDeskripsi(rs.getString("deskripsi"));

                lmb.add(mb); // tambahkan ke list
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmb;
    }

    @Override
    public List<ModLapor> getCariLokasi(String lokasi) {
        List<ModLapor> lmb = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(CariLokasi);
            st.setString(1, "%" + lokasi + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ModLapor mb = new ModLapor();
                mb.setNo(rs.getInt("no"));
                mb.setLokasi(rs.getString("lokasi"));
                mb.setTanggal(rs.getString("tanggal"));
                mb.setWaktu(rs.getString("waktu"));
                mb.setDeskripsi(rs.getString("deskripsi"));

                lmb.add(mb); // tambahkan ke list
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmb;
    }
}
