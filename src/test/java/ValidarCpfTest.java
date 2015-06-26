import org.junit.Assert;
import org.junit.Test;

import br.edu.utfpr.cm.pi.utils.Validator;

public class ValidarCpfTest {

    @Test
    public void cpfInvalidoTest() {

        String cpf = "65797369106";
        boolean retorno = Validator.validarCPF(cpf);
        Assert.assertFalse(retorno);
    }

    @Test
    public void cpfValidoTest() {

        String cpf = "33312498740";
        boolean retorno = Validator.validarCPF(cpf);
        Assert.assertTrue(retorno);
    }

}