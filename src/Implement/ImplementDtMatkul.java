/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entitas.EntitasDtMatkul;
import Interface.InterfaceDtMatkul;
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
public class ImplementDtMatkul implements InterfaceDtMatkul {

    private String query;
    private boolean status;
    private Statement st;
    private ResultSet rs;
    private List<EntitasDtMatkul> list;
    
    @Override
    public boolean insertDetail(EntitasDtMatkul e) {
        status = false;
        try{
        String isql = "select max(right(kode_detail,2)) from tb_dt_matkul";
        KoneksiDB koneksiDb= new KoneksiDB();
        koneksiDb.AutoNumber(isql, "DT");
        e.setKdDetail(koneksiDb.getHasil());
        query = "insert into tb_dt_matkul values ('"+e.getKdDetail()+"','"+e.getNik()+"','"+e.getKdMatkul()+"')";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    public boolean updateDetail(EntitasDtMatkul e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "update tb_dt_matkul set nik='"+e.getNik()+"',kode_matkul='"+e.getKdMatkul()+"' where kode_detail='"+e.getKdDetail()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se+query);
        }
        return status;
    }

    @Override
    public boolean deleteDetail(EntitasDtMatkul e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "delete from tb_dt_matkul where kode_detail='"+e.getKdDetail()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    public void autoNik(EntitasDtMatkul e) {
        
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public List selectDtMatkul(EntitasDtMatkul e) {
        KoneksiDB koneksiDb= new KoneksiDB();
        try {
            query = "SELECT tb_dt_matkul.kode_detail, tb_dt_matkul.kode_matkul, tb_matkul.nama, tb_dt_matkul.nik, tb_dosen.nama from tb_dt_matkul"
                    +" join tb_matkul on tb_dt_matkul.kode_matkul=tb_matkul.id_matkul"
                    +" join tb_dosen on tb_dt_matkul.nik=tb_dosen.nik"
                    +" where tb_dt_matkul.kode_detail like '"+e.getKdDetail()+'%'+"'";
            st = koneksiDb.getKoneksi().createStatement();
            rs = st.executeQuery(query);
        //status = db.eksekusiQuery(query, true);

            //rsDosen=db.getRs();
            list = new ArrayList<EntitasDtMatkul>();

            while (rs.next()) {
                EntitasDtMatkul d = new EntitasDtMatkul();
                d.setKdDetail(rs.getString(1));
                d.setKdMatkul(rs.getString(2));
                d.setNamaMatkul(rs.getString(3));
                d.setNik(rs.getString(4));
                d.setNamaDosen(rs.getString(5));
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
