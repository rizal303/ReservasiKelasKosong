/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entitas.EntitasPermintaan;
import java.util.List;

/**
 *
 * @author Herie-PC
 */
public interface InterfacePermintaan {
    public boolean insertPermintaan(EntitasPermintaan e);
    public boolean updatePermintaan(EntitasPermintaan e);
    public boolean deletePermintaan(EntitasPermintaan e);
    public List selectPermintaan(EntitasPermintaan e);
    public void autoNik(EntitasPermintaan e);
}
