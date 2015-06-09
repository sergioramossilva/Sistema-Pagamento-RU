import java.util.Calendar;

import br.edu.utfpr.cm.pi.beans.Cargo;
import br.edu.utfpr.cm.pi.beans.Funcionario;
import br.edu.utfpr.cm.pi.daos.CargoDao;

public class Teste {

    public static void main(String[] args) {
        
        Cargo cargo = new Cargo();
        cargo.setAdmin(true);
        cargo.setNome("Gerente");
        
        CargoDao cdao = new CargoDao();
        cdao.save(cargo);
        
        Funcionario funcionario = new Funcionario();
        funcionario.setAtivo(true);
        Cargo c = cdao.findById(1L);
        funcionario.setCargo(c);
        funcionario.setCpf("12345678901");
        funcionario.setDataCadastro(Calendar.getInstance());
        funcionario.setLogin("admin");
        funcionario.setSenha("admin");
        funcionario.setNome("jhhjgjhjkghjg");
        
        
    }
}
