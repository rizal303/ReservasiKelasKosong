/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entitas.EntitasDosen;
import Interface.InterfaceDosen;
import Koneksi.KoneksiDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herie-PC
 */
public class ImplementDosen implements InterfaceDosen {
    private String query;
    private boolean status;
    private Statement st;
    private ResultSet rs;
    private List<EntitasDosen> list;
    
    @Override
    public boolean insertDosen(EntitasDosen e) {
        status = false;
        try{
        String isql = "select max(right(nik,2)) from tb_dosen";
        KoneksiDB koneksiDb= new KoneksiDB();
        koneksiDb.AutoNumber(isql, "DS");
        e.setNik(koneksiDb.getHasil());
        query = "insert into tb_dosen values ('"+e.getNik()+"','"+e.getNama()+"','"+e.getAlamat()
                +"','"+new SimpleDateFormat("yyyy-MM-dd").format(e.getTglLahir())+"','"+e.getJkel()
                +"','"+e.getTelp()+"','"+e.getEmail()+"')";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se + e.getNik());
        }
        return status;
    }

    @Override
    public boolean updateDosen(EntitasDosen e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "update tb_dosen set nama='"+e.getNama()+"', alamat='"+e.getAlamat()
                +"', tgl_Lahir='"+new SimpleDateFormat("yyyy-MM-dd").format(e.getTglLahir())
                +"',jkel='"+e.getJkel()+"', telp='"+e.getTelp()+"', email='"+e.getEmail()
                +"' where nik='"+e.getNik()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se + e.getNik());
        }
        return status;
    }

    @Override
    public boolean deleteDosen(EntitasDosen e) {
        status = false;
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "delete from tb_dosen where nik='"+e.getNik()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        return status;
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public List selectDosen() {
        KoneksiDB koneksiDb= new KoneksiDB();
        try {
            query = "select * from tb_dosen";
            st = koneksiDb.getKoneksi().createStatement();
            rs = st.executeQuery(query);
        //status = db.eksekusiQuery(query, true);

            //rsDosen=db.getRs();
            list = new ArrayList<EntitasDosen>();

            while (rs.next()) {
                EntitasDosen d = new EntitasDosen();
                d.setNik(rs.getString(1));
                d.setNama(rs.getString(2));
                d.setAlamat(rs.getString(3));
                d.setTglLahir(rs.getDate(4));
                d.setJkel(rs.getString(5));
                d.setTelp(rs.getString(6));
                d.setEmail(rs.getString(7));
                list.add(d);
            }
            rs.close();
            return list;

        } catch (SQLException ex) {
            System.out.println("gagal" + ex.getMessage());
            return null;
        }
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public List cariDosen(EntitasDosen e) {
         KoneksiDB koneksiDb= new KoneksiDB();
        try {
            query = "select * from tb_dosen where nama like '"+e.getNama()+'%'+"'";
            st = koneksiDb.getKoneksi().createStatement();
            rs = st.executeQuery(query);
        //status = db.eksekusiQuery(query, true);

            //rsDosen=db.getRs();
            list = new ArrayList<EntitasDosen>();

            while (rs.next()) {
                EntitasDosen d = new EntitasDosen();
                d.setNik(rs.getString(1));
                d.setNama(rs.getString(2));
                d.setAlamat(rs.getString(3));
                d.setTglLahir(rs.getDate(4));
                d.setJkel(rs.getString(5));
                d.setTelp(rs.getString(6));
                d.setEmail(rs.getString(7));
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
