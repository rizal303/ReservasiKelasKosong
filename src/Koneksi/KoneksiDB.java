/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Herie-PC
 */
public class KoneksiDB {
    private Connection koneksi;
    private ResultSet rs;
    private PreparedStatement ps;
    int noPegawai;
    private String hasil;

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }
    
    
    public Connection getKoneksi(){
         if (koneksi == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    String url = "jdbc:mysql://localhost:3306/db_finalpbo2";
                    koneksi =(Connection) DriverManager.getConnection(url, "root", "");
                } catch (SQLException ex) {
                    System.out.println("Koneksi Gagal " + ex);
                    System.exit(0);
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Class tidak ditemukan " + ex);
                System.exit(0);
            }
        }
        return koneksi;
    }
    
    public boolean  eksekusiQuery(String query, boolean status){
        Connection konek =getKoneksi();
        try {
            ps = konek.prepareStatement(query);
            if (status){
                rs = ps.executeQuery();
            }else{
                ps.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex+query);
            return false;
        }
    }
    
    public void AutoNumber(String query, String kode){
       Statement state;
       ResultSet rss;
        
        try{
	Connection konek =getKoneksi();
	state = konek.createStatement();
			
	rss = state.executeQuery(query);
            while(rss.next()){
		if(rss.first() == false)
                    {
			setHasil(kode+"001");
                    }
		else
		{
                    rss.last();
                    noPegawai =rss.getInt(1) + 1;
                    String no = String.valueOf(noPegawai);
                    int noLong = no.length();
                    for(int a=0;a<2-noLong;a++){
			no = "000" + no;
                    }
			setHasil(kode+ no);
                    }
					
            }
		rss.close();
		state.close();
	}
	catch(Exception ex){
            System.out.println(ex+query);
	}

		
        
    }
}
