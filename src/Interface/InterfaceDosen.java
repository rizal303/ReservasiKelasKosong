/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entitas.EntitasDosen;
import java.util.List;


/**
 *
 * @author Herie-PC
 */
public interface InterfaceDosen {
    public boolean insertDosen(EntitasDosen e);
    public boolean updateDosen(EntitasDosen e);
    public boolean deleteDosen(EntitasDosen e);
    List selectDosen();
    List cariDosen(EntitasDosen e);
}
