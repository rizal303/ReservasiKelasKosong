/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entitas.EntitasJadwal;
import java.util.List;

/**
 *
 * @author Herie-PC
 */
public interface InterfaceJadwal {
    public boolean insertJadwal(EntitasJadwal e);
    public boolean updateJadwal(EntitasJadwal e);
    public boolean deleteJadwal(EntitasJadwal e);
    public List selectJadwal(EntitasJadwal e);
    public void autoNik(EntitasJadwal e);
}
