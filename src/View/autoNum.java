/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
 

/**
 *
 * @author Herie-PC
 */
public abstract class autoNum {
    JList list = new JList(); 
    JPopupMenu popup = new JPopupMenu(); 
    JTextComponent textComp; 
    private static final String AUTOCOMPLETER = "AUTOCOMPLETER"; //NOI18N 
 
    @SuppressWarnings("LeakingThisInConstructor")
    public autoNum(JTextComponent comp){ 
        textComp = comp; 
        textComp.putClientProperty(AUTOCOMPLETER, this); 
        JScrollPane scroll = new JScrollPane(list); 
        scroll.setBorder(null); 
 
        list.setFocusable( false ); 
        scroll.getVerticalScrollBar().setFocusable( false ); 
        scroll.getHorizontalScrollBar().setFocusable( false ); 
 
        popup.setBorder(BorderFactory.createLineBorder(Color.black)); 
        popup.add(scroll); 
 
        if(textComp instanceof JTextField){ 
            textComp.registerKeyboardAction(showAction, KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), JComponent.WHEN_FOCUSED); 
            textComp.getDocument().addDocumentListener(documentListener); 
        }else 
            textComp.registerKeyboardAction(showAction, KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, KeyEvent.CTRL_MASK), JComponent.WHEN_FOCUSED); 
 
        textComp.registerKeyboardAction(upAction, KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), JComponent.WHEN_FOCUSED); 
        textComp.registerKeyboardAction(hidePopupAction, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_FOCUSED); 
 
        popup.addPopupMenuListener(new PopupMenuListener(){  

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                textComp.unregisterKeyboardAction(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0)); 
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                }
        }); 
        list.setRequestFocusEnabled(false); 
    } 
 
    static Action acceptAction = new AbstractAction(){ 
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JComponent tf = (JComponent)e.getSource(); 
            autoNum completer = (autoNum)tf.getClientProperty(AUTOCOMPLETER); 
            completer.popup.setVisible(false); 
            completer.acceptedListItem((String)completer.list.getSelectedValue()); 
        }
    }; 
 
    DocumentListener documentListener = new DocumentListener(){ 

        @Override
        public void insertUpdate(DocumentEvent e) {
            showPopup();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            showPopup();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            }
    }; 
 
    @SuppressWarnings("CallToPrintStackTrace")
    private void showPopup(){ 
        popup.setVisible(false); 
        if(textComp.isEnabled() && updateListData() && list.getModel().getSize()!=0){ 
            if(!(textComp instanceof JTextField)) 
                textComp.getDocument().addDocumentListener(documentListener); 
            textComp.registerKeyboardAction(acceptAction, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED); 
            int size = list.getModel().getSize(); 
            list.setVisibleRowCount(size<10 ? size : 10); 
 
            int x = 0; 
            try{ 
                int pos = Math.min(textComp.getCaret().getDot(), textComp.getCaret().getMark()); 
                x = textComp.getUI().modelToView(textComp, pos).x; 
            } catch(BadLocationException e){ 
                // this should never happen!!! 
                e.printStackTrace(); 
            } 
            popup.show(textComp, x, textComp.getHeight()); 
        }else 
            popup.setVisible(false); 
        textComp.requestFocus(); 
    } 
 
    static Action showAction = new AbstractAction(){ 
        @Override
        public void actionPerformed(ActionEvent e){ 
            JComponent tf = (JComponent)e.getSource(); 
            autoNum completer = (autoNum)tf.getClientProperty(AUTOCOMPLETER); 
            if(tf.isEnabled()){ 
                if(completer.popup.isVisible()) 
                    completer.selectNextPossibleValue(); 
                else 
                    completer.showPopup(); 
            } 
        } 
    }; 
 
    static Action upAction = new AbstractAction(){ 
        @Override
        public void actionPerformed(ActionEvent e){ 
            JComponent tf = (JComponent)e.getSource(); 
            autoNum completer = (autoNum)tf.getClientProperty(AUTOCOMPLETER); 
            if(tf.isEnabled()){ 
                if(completer.popup.isVisible()) 
                    completer.selectPreviousPossibleValue(); 
            } 
        } 
    }; 
 
    static Action hidePopupAction = new AbstractAction(){ 
        @Override
        public void actionPerformed(ActionEvent e){ 
            JComponent tf = (JComponent)e.getSource(); 
            autoNum completer = (autoNum)tf.getClientProperty(AUTOCOMPLETER); 
            if(tf.isEnabled()) 
                completer.popup.setVisible(false); 
        } 
    }; 
 
    /** 
     * Selects the next item in the list.  It won't change the selection if the 
     * currently selected item is already the last item. 
     */ 
    protected void selectNextPossibleValue(){ 
        int si = list.getSelectedIndex(); 
 
        if(si < list.getModel().getSize() - 1){ 
            list.setSelectedIndex(si + 1); 
            list.ensureIndexIsVisible(si + 1); 
        } 
    } 
 
    /** 
     * Selects the previous item in the list.  It won't change the selection if the 
     * currently selected item is already the first item. 
     */ 
    protected void selectPreviousPossibleValue(){ 
        int si = list.getSelectedIndex(); 
 
        if(si > 0){ 
            list.setSelectedIndex(si - 1); 
            list.ensureIndexIsVisible(si - 1); 
        } 
    } 
 
    // update list model depending on the data in textfield 
    protected abstract boolean updateListData(); 
 
    // user has selected some item in the list. update textfield accordingly... 
    protected abstract void acceptedListItem(String selected); 
}
