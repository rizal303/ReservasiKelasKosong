/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entitas.EntitasDtRuang;
import java.util.List;

/**
 *
 * @author Herie-PC
 */
public interface InterfaceDtRuang {
    public boolean insertDtRuang(EntitasDtRuang e);
    public boolean updateDtRuang(EntitasDtRuang e);
    public boolean deleteDtRuang(EntitasDtRuang e);
    public List selectDtRuang(EntitasDtRuang e);
}
