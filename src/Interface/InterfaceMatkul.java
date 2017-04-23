/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entitas.EntitasMatkul;
import java.util.List;

/**
 *
 * @author Herie-PC
 */
public interface InterfaceMatkul {
    public boolean insertMatkul(EntitasMatkul e);
    public boolean updateMatkul(EntitasMatkul e);
    public boolean deleteMatkul(EntitasMatkul e);
    public List selectMatkul(EntitasMatkul e);
}
