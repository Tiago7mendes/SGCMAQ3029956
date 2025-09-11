package model;

import java.sql.SQLException;

public class __Exemplo {
    public static void main(String[] args) throws SQLException {

        TipoUsuario tp = new TipoUsuario();
        
//        tp.setId(7);
//        tp.setModuloAdministrativo("N");
//        tp.setModuloAgendamento("N");
//        tp.setModuloAtendimento("S");
//        
//        tp.save(); // insert
//        
//        tp.setModuloAdministrativo("S");
//        tp.save(); // update

          tp.setId(7);
          boolean status = tp.load(); // select (read)
          System.out.println(status);
          System.out.println(tp);
          
          tp.setNome("tipo 7");
          tp.save(); // update
          
//          tp.delete();
    }
}
