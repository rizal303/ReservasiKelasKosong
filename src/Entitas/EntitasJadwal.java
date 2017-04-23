/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitas;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Herie-PC
 */
public class EntitasJadwal {
    private String kdJadwal;
    private String kdDetailMatkul;
    private String kdDetailRuang;
    private String nik;
    private String namaDosen;
    private String namaMatkul;
    private String kdMatkul;
    private Time WaktuMulai;
    private Time waktuSelesai;
    private String hari;
    private String ruang;
    private Date tgl;

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public String getKdJadwal() {
        return kdJadwal;
    }

    public void setKdJadwal(String kdJadwal) {
        this.kdJadwal = kdJadwal;
    }

    public String getKdDetailMatkul() {
        return kdDetailMatkul;
    }

    public void setKdDetailMatkul(String kdDetailMatkul) {
        this.kdDetailMatkul = kdDetailMatkul;
    }

    public String getKdDetailRuang() {
        return kdDetailRuang;
    }

    public void setKdDetailRuang(String kdDetailRuang) {
        this.kdDetailRuang = kdDetailRuang;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
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

    public String getKdMatkul() {
        return kdMatkul;
    }

    public void setKdMatkul(String kdMatkul) {
        this.kdMatkul = kdMatkul;
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
