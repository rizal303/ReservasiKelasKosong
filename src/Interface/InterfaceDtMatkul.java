/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entitas.EntitasDtMatkul;
import java.util.List;

/**
 *
 * @author Herie-PC
 */
public interface InterfaceDtMatkul {
    public boolean insertDetail(EntitasDtMatkul e);
    public boolean updateDetail(EntitasDtMatkul e);
    public boolean deleteDetail(EntitasDtMatkul e);
    public void autoNik(EntitasDtMatkul e);
    public List selectDtMatkul(EntitasDtMatkul e);
}
