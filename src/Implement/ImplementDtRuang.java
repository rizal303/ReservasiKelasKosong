/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entitas.EntitasDtRuang;
import Interface.InterfaceDtRuang;
import Koneksi.KoneksiDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herie-PC
 */
public class ImplementDtRuang implements InterfaceDtRuang {

    private String query;
    private boolean status;
    private Statement st;
    private ResultSet rs;
    private List<EntitasDtRuang> list;
    
    @Override
    public boolean insertDtRuang(EntitasDtRuang e) {
        status = false;
        try{
        String isql = "select max(right(id_dt_ruang,2)) from tb_detail_ruang";
        KoneksiDB koneksiDb= new KoneksiDB();
        koneksiDb.AutoNumber(isql, "DR");
        e.setKdDtRuang(koneksiDb.getHasil());
        query = "insert into tb_detail_ruang values ('"+e.getKdDtRuang()+"','"+e.getKdRuang()+"','"+e.getJam()+"','"+e.getHari()+"')";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se+e.getKdDtRuang());
        }
        return status;
    }

    @Override
    public boolean updateDtRuang(EntitasDtRuang e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "update tb_dt_ruang set kode_ruang='"+e.getKdRuang()+"', jam='"+e.getJam()+"', hari='"+e.getHari()+"'"
                +" where id_dt_ruang='"+e.getKdDtRuang()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se+query);
        }
        return status;
    }

    @Override
    public boolean deleteDtRuang(EntitasDtRuang e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "delete from tb_dt_ruang where kode_jadwal='"+e.getKdDtRuang()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public List selectDtRuang(EntitasDtRuang e) {
        KoneksiDB koneksiDb= new KoneksiDB();
        try {
            query = "SELECT tb_detail_ruang.id_dt_ruang, tb_detail_ruang.kode_ruang, tb_detail_ruang.jam, tb_jam.waktu_mulai, tb_jam.waktu_selesai, tb_detail_ruang.hari from tb_detail_ruang"
                    +" join tb_jam on tb_detail_ruang.jam=tb_jam.jam"
                    +" where tb_detail_ruang.kode_ruang like '"+e.getKdRuang()+'%'+"'";
            st = koneksiDb.getKoneksi().createStatement();
            rs = st.executeQuery(query);
        //status = db.eksekusiQuery(query, true);

            //rsDosen=db.getRs();
            list = new ArrayList<EntitasDtRuang>();

            while (rs.next()) {
                EntitasDtRuang d = new EntitasDtRuang();
                d.setKdDtRuang(rs.getString(1));
                d.setKdRuang(rs.getString(2));
                d.setJam(rs.getString(3));
                d.setMulai(rs.getTime(4));
                d.setSelesai(rs.getTime(5));
                d.setHari(rs.getString(6));
                list.add(d);
            }
            rs.close();
            return list;

        } catch (SQLException ex) {
            System.out.println("gagal" + ex.getMessage());
            return null;
        }
    }
    
}
