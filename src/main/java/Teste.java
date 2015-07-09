import br.edu.utfpr.cm.pi.beans.Cargo;
import br.edu.utfpr.cm.pi.beans.Funcionario;
import br.edu.utfpr.cm.pi.daos.CargoDao;
import br.edu.utfpr.cm.pi.daos.FuncionarioDao;
import br.edu.utfpr.cm.pi.utils.Validator;

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
        
        String cpf = "33312498740";
                
        if(Validator.validarCPF(cpf)) {
            funcionario.setCpf(cpf);
        } else {
            System.out.println("Aviso: cpf inválido!");
        }
        
        funcionario.setLogin("admin");
        funcionario.setSenha("admin");
        funcionario.setNome("Gerente do Negocio");

        FuncionarioDao dao = new FuncionarioDao();
        dao.save(funcionario);

    }
}
