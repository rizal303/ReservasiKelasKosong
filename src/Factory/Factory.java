/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Implement.ImplementDosen;
import Implement.ImplementDtMatkul;
import Implement.ImplementDtRuang;
import Implement.ImplementJadwal;
import Implement.ImplementMatkul;
import Implement.ImplementPermintaan;
import Implement.ImplementRuang;
import Interface.InterfaceDosen;
import Interface.InterfaceDtMatkul;
import Interface.InterfaceDtRuang;
import Interface.InterfaceJadwal;
import Interface.InterfaceMatkul;
import Interface.InterfacePermintaan;
import Interface.InterfaceRuang;

/**
 *
 * @author Herie-PC
 */
public class Factory {
    public static InterfaceDosen dosen;
    public static InterfaceMatkul matkul;
    public static InterfaceRuang ruang;
    public static InterfaceJadwal jadwal;
    public static InterfacePermintaan minta;
    private static InterfaceDtMatkul dtMatkul;
    private static InterfaceDtRuang dtRuang;

    public static InterfaceMatkul getMatkul() {
        matkul= new ImplementMatkul();
        return matkul;
    }

    public static InterfaceRuang getRuang() {
        ruang= new ImplementRuang();
        return ruang;
    }

    public static InterfaceJadwal getJadwal() {
        jadwal=new ImplementJadwal();
        return jadwal;
    }

    public static InterfacePermintaan getMinta() {
        minta=new ImplementPermintaan();
        return minta;
    }

    public static InterfaceDosen getDosen(){
        dosen=new ImplementDosen();
        return dosen;
    }
    
    public static InterfaceDtMatkul getDtMatkul(){
        dtMatkul=new ImplementDtMatkul();
        return dtMatkul;
    }
    
    public static InterfaceDtRuang getDtRuang(){
        dtRuang=new ImplementDtRuang();
        return dtRuang;
    }
}
