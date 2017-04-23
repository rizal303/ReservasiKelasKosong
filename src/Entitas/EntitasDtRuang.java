/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitas;

import java.sql.Time;


/**
 *
 * @author Herie-PC
 */
public class EntitasDtRuang {
 private String kdDtRuang;
 private String kdRuang;
 private String jam;
 private String hari;
 private Time mulai;
 private Time selesai;

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getKdDtRuang() {
        return kdDtRuang;
    }

    public void setKdDtRuang(String kdDtRuang) {
        this.kdDtRuang = kdDtRuang;
    }

    public String getKdRuang() {
        return kdRuang;
    }

    public void setKdRuang(String kdRuang) {
        this.kdRuang = kdRuang;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public Time getMulai() {
        return mulai;
    }

    public void setMulai(Time mulai) {
        this.mulai = mulai;
    }

    public Time getSelesai() {
        return selesai;
    }

    public void setSelesai(Time selesai) {
        this.selesai = selesai;
    }
 
 
}
