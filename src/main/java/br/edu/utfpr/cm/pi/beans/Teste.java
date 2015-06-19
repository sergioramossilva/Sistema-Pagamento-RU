package br.edu.utfpr.cm.pi.beans;

import java.util.List;

import br.edu.utfpr.cm.pi.daos.CargoDao;

public class Teste {

    public static void main(String[] args) {
       
        CargoDao dao = new CargoDao();
        
        List<Cargo> cargos = dao.getAll();
        
        if(cargos==null) {
            
            System.out.println("nulo");
        } else {
            
            for (Cargo cargo : cargos) {
                System.out.println(cargo.toString());
            }
        }
        
 

    }

}
