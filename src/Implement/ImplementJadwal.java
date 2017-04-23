/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entitas.EntitasJadwal;
import Interface.InterfaceJadwal;
import Koneksi.KoneksiDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Herie-PC
 */
public class ImplementJadwal implements InterfaceJadwal {

    private String query;
    private boolean status;
    private Statement st;
    private ResultSet rs;
    private List<EntitasJadwal> list;
    
    @Override
    public boolean insertJadwal(EntitasJadwal e) {
        status = false;
        try{
        String isql = "select max(right(kode_jadwal,2)) from tb_jadwal";
        KoneksiDB koneksiDb= new KoneksiDB();
        koneksiDb.AutoNumber(isql, "JD");
        e.setKdJadwal(koneksiDb.getHasil());
        query = "insert into tb_jadwal values ('"+e.getKdJadwal()+"','"+e.getKdDetailMatkul()+"','"+e.getKdDetailRuang()+"')";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se+e.getHari());
        }
        return status;
    }

    @Override
    public boolean updateJadwal(EntitasJadwal e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "update tb_jadwal set kode_detail='"+e.getKdDetailMatkul()+"', id_dt_ruang='"+e.getKdDetailRuang()+"' where kode_jadwal='"+e.getKdJadwal()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se+query);
        }
        return status;
    }

    @Override
    public boolean deleteJadwal(EntitasJadwal e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "delete from tb_jadwal where kode_jadwal='"+e.getKdJadwal()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public List selectJadwal(EntitasJadwal e) {
        KoneksiDB koneksiDb= new KoneksiDB();
        try {
            query = "SELECT tb_jadwal.kode_jadwal, tb_jadwal.kode_detail, tb_dt_matkul.nik, tb_dosen.nama, tb_matkul.nama, tb_jadwal.id_dt_ruang, tb_detail_ruang.kode_ruang, tb_jam.waktu_mulai, tb_jam.waktu_selesai, tb_detail_ruang.hari from tb_jadwal"
                    +" join tb_dt_matkul on tb_jadwal.kode_detail=tb_dt_matkul.kode_detail"
                    +" join tb_dosen on tb_dt_matkul.nik=tb_dosen.nik"
                    +" join tb_matkul on tb_dt_matkul.kode_matkul=tb_matkul.id_matkul"
                    +" join tb_detail_ruang on tb_jadwal.id_dt_ruang=tb_detail_ruang.id_dt_ruang"
                    +" join tb_jam on tb_detail_ruang.jam=tb_jam.jam"
                    +" where tb_dosen.nama like '"+e.getNamaDosen()+'%'+"'";
            st = koneksiDb.getKoneksi().createStatement();
            rs = st.executeQuery(query);
        //status = db.eksekusiQuery(query, true);

            //rsDosen=db.getRs();
            list = new ArrayList<EntitasJadwal>();

            while (rs.next()) {
                EntitasJadwal d = new EntitasJadwal();
                d.setKdJadwal(rs.getString(1));
                d.setKdDetailMatkul(rs.getString(2));
                d.setNik(rs.getString(3));
                d.setNamaDosen(rs.getString(4));
                d.setNamaMatkul(rs.getString(5));
                d.setKdDetailRuang(rs.getString(6));
                d.setRuang(rs.getString(7));
                d.setWaktuMulai(rs.getTime(8));
                d.setWaktuSelesai(rs.getTime(9));
                d.setHari(rs.getString(10));
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
    public void autoNik(EntitasJadwal e) {
        try {
      query="SELECT nik, nama FROM tb_matkul WHERE nama like '"+e.getNamaMatkul()+'%'+"'"; 
      KoneksiDB koneksiDb= new KoneksiDB();
      Statement st = koneksiDb.getKoneksi().createStatement();
      rs = st.executeQuery(query);
      rs.next();
      rs.last();
      if(rs!=null)
	{
      if (!rs.next()){
                    
                    JOptionPane.showMessageDialog(null, "tidak ditemukan");

            } else {
                do 
		{     									
		e.setNamaMatkul(rs.getString(1));
                e.setNik(rs.getString(2));
		}while(rs.next());
                
            }
        }
        st.close();
        }
        catch (SQLException sql) {
        JOptionPane.showMessageDialog(null, sql);
        }
    }
    
}
