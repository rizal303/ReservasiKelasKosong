/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entitas.EntitasPermintaan;
import Interface.InterfacePermintaan;
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
public class ImplementPermintaan implements InterfacePermintaan {

    private String query;
    private boolean status;
    private Statement st;
    private ResultSet rs;
    private List<EntitasPermintaan> list;
    
    @Override
    public boolean insertPermintaan(EntitasPermintaan e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "insert into tb_permintaan values ('"+e.getHari()+"','"+e.getJam()
                +"','"+new SimpleDateFormat("yyyy-MM-dd").format(e.getTgl())
                +"','"+e.getRuang()+"','"+e.getNik()+"')";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    public boolean updatePermintaan(EntitasPermintaan e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "update tb_permintaan set hari='"+e.getHari()+"',jam='"+e.getJam()
                +"',tgl='"+new SimpleDateFormat("yyyy-MM-dd").format(e.getTgl())
                +"',ruang='"+e.getRuang()+"' where nik='"+e.getNik()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    public boolean deletePermintaan(EntitasPermintaan e) {
        status = false;
        try{
        KoneksiDB koneksiDb= new KoneksiDB();
        query = "delete from tb_permintaan where nik='"+e.getNik()+"'";
        status = koneksiDb.eksekusiQuery (query, false);    
        } catch (Exception se) {
            System.out.println(se);
        }
        return status;
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public List selectPermintaan(EntitasPermintaan e) {
        KoneksiDB koneksiDb= new KoneksiDB();
        try {
            query = "SELECT tb_detail_ruang.kode_ruang, tb_jam.waktu_mulai, "
                    +"tb_jam.waktu_selesai, tb_detail_ruang.hari from tb_detail_ruang"
                    +" join tb_jam on tb_detail_ruang.jam=tb_jam.jam"
                    +" left join tb_jadwal on tb_detail_ruang.id_dt_ruang=tb_jadwal.id_dt_ruang"
                    +" where tb_jadwal.id_dt_ruang is null";
            st = koneksiDb.getKoneksi().createStatement();
            rs = st.executeQuery(query);
        //status = db.eksekusiQuery(query, true);

            //rsDosen=db.getRs();
            list = new ArrayList<EntitasPermintaan>();

            while (rs.next()) {
                EntitasPermintaan d = new EntitasPermintaan();
                d.setRuang(rs.getString(1));
                d.setWaktuMulai(rs.getTime(2));
                d.setWaktuSelesai(rs.getTime(3));
                d.setHari(rs.getString(4));
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
    public void autoNik(EntitasPermintaan e) {
        try {
      query="SELECT nik FROM tb_doen WHERE nik like '"+e.getNik()+'%'+"'"; 
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
		e.setNik(rs.getString(1));
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
