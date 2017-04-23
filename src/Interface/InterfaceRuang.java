/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entitas.EntitasRuang;
import java.util.List;

/**
 *
 * @author Herie-PC
 */
public interface InterfaceRuang {
    public boolean insertRuang(EntitasRuang e);
    public boolean updateRuang(EntitasRuang e);
    public boolean deleteRuang(EntitasRuang e);
    public List selectRuang();
}
