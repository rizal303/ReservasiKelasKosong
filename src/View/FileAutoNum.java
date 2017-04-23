/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Herie-PC
 */
public class FileAutoNum extends autoNum {
     public FileAutoNum(JTextComponent comp){ 
        super(comp); 
    } 
 
     @Override
    protected boolean updateListData(){ 
        String value = textComp.getText(); 
        int index1 = value.lastIndexOf('\\'); 
        int index2 = value.lastIndexOf('/'); 
        int index = Math.max(index1, index2); 
        if(index==-1) 
            return false; 
        String dir = value.substring(0, index+1); 
        final String prefix = index==value.length()-1 ? null : value.substring(index + 1).toLowerCase(); 
        String[] files = new File(dir).list((File dir1, String name) -> prefix!=null ? name.toLowerCase().startsWith(prefix) : true); 
        if(files == null){ 
            list.setListData(new String[0]); 
            return true; 
        } else{ 
            if(files.length==1 && files[0].equalsIgnoreCase(prefix)) 
                list.setListData(new String[0]); 
            else 
                list.setListData(files); 
            return true; 
        } 
    } 
 
     @Override
     @SuppressWarnings("CallToPrintStackTrace")
    protected void acceptedListItem(String selected){ 
        if(selected==null) 
            return; 
 
        String value = textComp.getText(); 
        int index1 = value.lastIndexOf('\\'); 
        int index2 = value.lastIndexOf('/'); 
        int index = Math.max(index1, index2); 
        if(index==-1) 
            return; 
        int prefixlen = textComp.getDocument().getLength()-index-1; 
        try{ 
            textComp.getDocument().insertString(textComp.getCaretPosition(), selected.substring(prefixlen), null); 
        } catch(BadLocationException e){ 
            e.printStackTrace(); 
        } 
    } 
}
