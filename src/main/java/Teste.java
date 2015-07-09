import br.edu.utfpr.cm.pi.beans.Cargo;
import br.edu.utfpr.cm.pi.beans.Funcionario;
import br.edu.utfpr.cm.pi.daos.CargoDao;
import br.edu.utfpr.cm.pi.daos.FuncionarioDao;

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
        
        funcionario.setCpf("12345678911");
        funcionario.setLogin("admin");
        funcionario.setSenha("admin");
        funcionario.setNome("Gerente do Negocio");

        FuncionarioDao dao = new FuncionarioDao();
        dao.save(funcionario);

    }
}
