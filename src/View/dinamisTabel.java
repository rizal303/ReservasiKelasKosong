/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Herie-PC
 */
public class dinamisTabel {
     public dinamisTabel(JTable table) {
        buatKolomSesuai(table);
    }
    private void buatKolomSesuai(JTable t){
        TableColumnModel columnModel=t.getColumnModel();
        for(int kol = 0;kol<columnModel.getColumnCount();kol++){
            int lebarKolomMax=0;
            for(int baris=0;baris<t.getRowCount();baris++){
                TableCellRenderer rend=t.getCellRenderer(baris, kol);
                Object nilaiTabel=t.getValueAt(baris, kol);
                Component comp=rend.getTableCellRendererComponent(t, nilaiTabel, false, false, baris, kol);
                lebarKolomMax=Math.max(comp.getPreferredSize().width, lebarKolomMax);
            }
            TableColumn kolom=columnModel.getColumn(kol);
            kolom.setPreferredWidth(lebarKolomMax);
        }
    }    
}
