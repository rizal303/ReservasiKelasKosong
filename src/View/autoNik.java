/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Koneksi.KoneksiDB;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Herie-PC
 */
public final class autoNik extends KeyAdapter {
    private final JTextField txtField;
	@SuppressWarnings("rawtypes")
	private final List daftar;
	
	@SuppressWarnings("rawtypes")
	public autoNik(JTextField txtFieldParam)
	{
		txtField = txtFieldParam;
		daftar = new ArrayList();
		databaseNama();
	}
	
    @Override
	public void keyPressed(KeyEvent key)
	{
		switch(key.getKeyCode())
		{
		case KeyEvent.VK_BACK_SPACE : 
		break;
		case KeyEvent.VK_ENTER : 
		txtField.setText(txtField.getText());
		break;
		default : 
		EventQueue.invokeLater(() -> {
                    // TODO Auto-generated method stub
                    String kt = txtField.getText();
                    autoComplete(kt);
                });
		}
										
	}
	
	public void autoComplete(String kt)
	{
		String complete = "";
		int start = kt.length();
		int last = kt.length();
		int a;
		
		for(a=0;a<daftar.size();a++)
		{
			if(daftar.get(a).toString().startsWith(kt))
			{
				complete = daftar.get(a).toString();
				last = complete.length();
				break;
			}
		}
		if(last>start)
		{
			txtField.setText(complete);
			txtField.setCaretPosition(last);
			txtField.moveCaretPosition(start);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void databaseNama()
	{
            Statement state;
            
            try
		{
                    KoneksiDB konek=new KoneksiDB();
                    state = konek.getKoneksi().createStatement();
                    String query = "SELECT nama, id_matkul FROM tb_matkul";
                try (ResultSet rs = state.executeQuery(query)) {
                    while(rs.next())
                    {
                        daftar.add(rs.getString(1)+"("+rs.getString(2)+")");
                    }
                }
			state.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("tes"+ex);
		}
	}
}
