/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eli.clienteli.model;

/**
 *
 * @author ASUS
 */
public class Anggota {
    private long anggotaId;
    private String nama;
    private String alamat;
    
    public Anggota(){    
    }

    public long getAnggotaId() {
        return anggotaId;
    }

    public void setAnggotaId(long anggotaId) {
        this.anggotaId = anggotaId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
