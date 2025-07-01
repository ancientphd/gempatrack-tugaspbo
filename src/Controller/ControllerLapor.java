/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DAOLapor;
import DAO.ImplementLapor;
import Model.ModLapor;
import Model.ModTblLapor;
import View.Lapor;
import View.Histori;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class ControllerLapor {
    Lapor frame;
    Histori history;
    ImplementLapor implLapor;
    List<ModLapor> lmb;

    public ControllerLapor(Histori history) {
        this.history = history;
        implLapor = new DAOLapor();
        lmb = implLapor.getAll();
    }
    public ControllerLapor(Lapor frame) {
        this.frame = frame;
        implLapor = new DAOLapor();
        lmb = implLapor.getAll();
    }
    
    public void setHistory(Histori history) {
        this.history = history;
    }


    public void reset (){
        frame.getTf_lokasi().setText("");
        frame.getTf_tanggal().setText("");
        frame.getTf_waktu().setText("");
        frame.getTf_deskripsi().setText("");
    }
    
    public void isiTable() {
        lmb = implLapor.getAll();
        ModTblLapor mtl = new ModTblLapor(lmb);
        history.getTbl_lapor().setModel(mtl);
    }
    
    public void insert(){
        if(!frame.getTf_lokasi().getText().trim().isEmpty() & !frame.getTf_lokasi().getText().trim().isEmpty()){
            ModLapor mb = new ModLapor();
            
            mb.setLokasi(frame.getTf_lokasi().getText());
            mb.setTanggal(frame.getTf_tanggal().getText());
            mb.setWaktu(frame.getTf_waktu().getText());
            mb.setDeskripsi(frame.getTf_deskripsi().getText());
        
            implLapor.insert(mb);
            JOptionPane.showMessageDialog(null,"Data di Simpan");
        } else {
            JOptionPane.showMessageDialog(null,"Data gagal Simpan");
        }
    }
    
    public void isiTabelCariLokasi(){
        lmb = implLapor.getCariLokasi(history.getTf_carilokasi().getText());
        ModTblLapor mtl = new ModTblLapor(lmb);
        history.getTbl_lapor().setModel(mtl);
    }
    
    public void cariLokasi(){
        if(!history.getTf_carilokasi().getText().trim().isEmpty()){
            implLapor.getCariLokasi(history.getTf_carilokasi().getText());
            isiTabelCariLokasi();
        }else{
            JOptionPane.showMessageDialog(null,"Silahkan Masukan Lokasi");
        }
    }
}
