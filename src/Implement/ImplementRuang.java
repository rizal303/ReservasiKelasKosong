/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entitas.EntitasRuang;
import Interface.InterfaceRuang;
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
public class ImplementRuang implements InterfaceRuang {

    private String query;
    private boolean status;
    private Statement st;
    private ResultSet rs;
    private List<EntitasRuang> list;
    
    @Override
    public boolean insertRuang(EntitasRuang e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "insert into tb_ruang values ('"+e.getKode()+"','"+e.getGedung()+"','"+e.getLantai()+"','"+e.getNomor()+"')";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    public boolean updateRuang(EntitasRuang e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "update tb_ruang set gedung='"+e.getGedung()+"',lantai='"+e.getLantai()+"',nomer='"+e.getNomor()+"' where id_ruang='"+e.getKode()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    public boolean deleteRuang(EntitasRuang e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "delete from tb_ruang where id_ruang='"+e.getKode()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public List selectRuang() {
        KoneksiDB koneksiDb= new KoneksiDB();
        try {
            query = "select * from tb_ruang";
            st = koneksiDb.getKoneksi().createStatement();
            rs = st.executeQuery(query);
            list = new ArrayList<EntitasRuang>();

            while (rs.next()) {
                EntitasRuang d = new EntitasRuang();
                d.setKode(rs.getString(1));
                d.setGedung(rs.getString(2));
                d.setLantai(rs.getString(3));
                d.setNomor(rs.getString(4));
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
