/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class ModTblLapor extends AbstractTableModel{

    List<ModLapor> lmb;

    public ModTblLapor(List<ModLapor> lmb) {
        this.lmb = lmb;
    }
    
    @Override
    public int getRowCount() {
        return lmb.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return lmb.get(row).getLokasi();
            case 1:
                return lmb.get(row).getTanggal();
            case 2:
                return lmb.get(row).getWaktu();
            case 3:
                return lmb.get(row).getDeskripsi();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Lokasi";
            case 1:
                return "Tanggal";
            case 2:
                return "Waktu";
            case 3:
                return "Deskripsi";
        }
        return super.getColumnName(column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
