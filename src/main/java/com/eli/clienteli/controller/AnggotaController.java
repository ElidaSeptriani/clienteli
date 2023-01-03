/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eli.clienteli.controller;

import com.eli.clienteli.FormAnggota;
import com.eli.clienteli.model.Anggota;
import com.eli.clienteli.service.AnggotaService;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class AnggotaController {
    private AnggotaService anggotaService;
    private FormAnggota formAnggota;

    public AnggotaController(FormAnggota formAnggota){
        this.formAnggota = formAnggota;
        anggotaService = new AnggotaService();
    }
    
    public void bersihForm(){
        formAnggota.getTxtIdAnggota().setText("");
        formAnggota.getTxtNama().setText("");
        formAnggota.getTxtAlamat().setText("");
    }
    
    public Anggota saveAnggota(){
        Anggota anggota = new Anggota();
        anggota.setNama(formAnggota.getTxtNama().getText());
        anggota.setAlamat(formAnggota.getTxtAlamat().getText());
        return anggotaService.saveAnggota(anggota);
    }
    
    public Anggota getAnggotaId(){
        Long id = Long.parseLong(formAnggota.getTxtIdAnggota().getText());
        Anggota anggota = anggotaService.getAnggota(id);
        if (anggota!=null){
            formAnggota.getTxtNama().setText(anggota.getNama());
            formAnggota.getTxtAlamat().setText(anggota.getAlamat());
        }else{
            JOptionPane.showMessageDialog(formAnggota, "Data tidak ada");
        }
        return anggota;
    }
    
    public void updateAnggota(){
        Anggota anggota = new Anggota();
        anggota.setAnggotaId(Long.parseLong(formAnggota.getTxtIdAnggota().getText()));
        anggota.setNama(formAnggota.getTxtNama().getText());
        anggota.setAlamat(formAnggota.getTxtAlamat().getText());
        anggota = anggotaService.updateAnggota(anggota);
        if(anggota != null){
            formAnggota.getTxtIdAnggota().setText(anggota.getAnggotaId().toString());
            JOptionPane.showMessageDialog(formAnggota, "Update Data Berhasil");
        }else{
            JOptionPane.showMessageDialog(formAnggota, "Update Data Gagal");
        }
    }
    
    public void deleteAnggota(){
        Long id=Long.parseLong(formAnggota.getTxtIdAnggota().getText());
        anggotaService.deleteAnggota(id);
        JOptionPane.showMessageDialog(formAnggota, "Update Data Berhasil");
    }
    
    public void viewTabel(){
        DefaultTableModel tabelModel = (DefaultTableModel)
                formAnggota.getTableAnggota().getModel();
        tabelModel.setRowCount(0);
        List<Anggota> anggotaList = anggotaService.getAllAnggota();
        for (Anggota anggota : anggotaList){
            Object[] row = {
                anggota.getAnggotaId(),
                anggota.getNama(),
                anggota.getAlamat()
            };
            tabelModel.addRow(row);
        }
    }
}
