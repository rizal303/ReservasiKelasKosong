/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entitas.EntitasMatkul;
import Interface.InterfaceMatkul;
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
public class ImplementMatkul implements InterfaceMatkul {

    private String query;
    private boolean status;
    private Statement st;
    private ResultSet rs;
    private List<EntitasMatkul> list;
    
    @Override
    public boolean insertMatkul(EntitasMatkul e) {
        status = false;
        try{
        String isql = "select max(right(id_matkul,2)) from tb_matkul";
        KoneksiDB koneksiDb= new KoneksiDB();
        koneksiDb.AutoNumber(isql, "JD");
        e.setIdMatkul(koneksiDb.getHasil());
        query = "insert into tb_matkul values ('"+e.getIdMatkul()+"','"+e.getNama()+"','"+e.getSemester()+"','"+e.getSks()+"','"+e.getJenis()+"')";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    public boolean updateMatkul(EntitasMatkul e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "update tb_matkul set nama='"+e.getNama()+"',semester='"+e.getSemester()+"',sks='"+e.getSks()+"',jenis='"+e.getJenis()+"' where id_matkul='"+e.getIdMatkul()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    public boolean deleteMatkul(EntitasMatkul e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "delete from tb_matkul where id_matkul='"+e.getIdMatkul()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public List selectMatkul(EntitasMatkul e) {
        KoneksiDB koneksiDb= new KoneksiDB();
        try {
            query = "select * from tb_matkul where nama like '"+e.getNama()+'%'+"'";
            st = koneksiDb.getKoneksi().createStatement();
            rs = st.executeQuery(query);
            list = new ArrayList<EntitasMatkul>();

            while (rs.next()) {
                EntitasMatkul d = new EntitasMatkul();
                d.setIdMatkul(rs.getString(1));
                d.setNama(rs.getString(2));
                d.setSemester(rs.getString(3));
                d.setSks(rs.getString(4));
                d.setJenis(rs.getString(5));
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
