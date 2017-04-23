/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitas;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Herie-PC
 */
public class EntitasPermintaan {
    private String kdJadwal;
    private String kdDetail;
    private String nik;
    private String namaDosen;
    private String namaMatkul;
    private String kdMatkul;
    private String jam;
    private Time WaktuMulai;
    private Time waktuSelesai;
    private String hari;
    private String ruang;
    private java.util.Date tgl;

    public java.util.Date getTgl() {
        return tgl;
    }

    public void setTgl(java.util.Date tgl) {
        this.tgl = tgl;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public Time getWaktuMulai() {
        return WaktuMulai;
    }

    public void setWaktuMulai(Time WaktuMulai) {
        this.WaktuMulai = WaktuMulai;
    }

    public Time getWaktuSelesai() {
        return waktuSelesai;
    }

    public void setWaktuSelesai(Time waktuSelesai) {
        this.waktuSelesai = waktuSelesai;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getKdMatkul() {
        return kdMatkul;
    }

    public void setKdMatkul(String kdMatkul) {
        this.kdMatkul = kdMatkul;
    }

    public String getKdJadwal() {
        return kdJadwal;
    }

    public void setKdJadwal(String kdJadwal) {
        this.kdJadwal = kdJadwal;
    }

    public String getKdDetail() {
        return kdDetail;
    }

    public void setKdDetail(String kdDetail) {
        this.kdDetail = kdDetail;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }
    
}
