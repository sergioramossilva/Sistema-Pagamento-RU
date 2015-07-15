package br.edu.utfpr.cm.pi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.cm.pi.beans.Cargo;
import br.edu.utfpr.cm.pi.beans.Funcionario;
import br.edu.utfpr.cm.pi.beans.TipoTransacao;
import br.edu.utfpr.cm.pi.beans.Transacao;
import br.edu.utfpr.cm.pi.beans.UsuarioSistema;
import br.edu.utfpr.cm.pi.daos.TipoTransacaoDao;
import br.edu.utfpr.cm.pi.daos.TransacaoDao;
import br.edu.utfpr.cm.pi.daos.UsuarioDao;
import br.edu.utfpr.cm.pi.ldap.LoginLDAP;

@Controller
public class TransacaoController {

    private final TransacaoDao tdao;
    private final LoginLDAP loginLdap;

    public TransacaoController() {
        loginLdap = new LoginLDAP();
        tdao = new TransacaoDao();
        tpdao = new TipoTransacaoDao();
        new UsuarioDao();
    }

    @RequestMapping("autorizarCompra")
    public String incluir() {
        return "cadastros/formAutorizacaoCompra";
    }

    @RequestMapping("inserirCredito")
    public String incluirCredito() {
        return "cadastros/formInserirCredito";
    }

    @RequestMapping("creditar")
    public String creditar(Transacao transacao, @PathVariable String senha) {

        UsuarioSistema user = loginLdap.logarNoLDAP(transacao.getUsuario()
                .getLogin(), senha);
        user.setSaldo(user.getSaldo() + transacao.getQuantidade());
        return "forward:salvarTransacao";
    }

    @RequestMapping("salvarTransacao")
    public String salvar(Transacao transacao) {

        tdao.save(transacao);
        return "forward:listarTransacoes";
    }

    @RequestMapping("excluirTransacao")
    public String excluir(Transacao transacao) {
        tdao.delete(transacao);
        return "forward:listarTransacaos";
    }

    @RequestMapping("alterarTransacao")
    public String alterar(Long id, Model model) {
        model.addAttribute("transacao", tdao.findById(id));
        return "cadastros/formAutorizacaoCompra";
    }


    @RequestMapping("listaExtrato")
    public String lista(Model model) {
        List<Transacao> transacoes = tdao.getAll();
        model.addAttribute("transacoes", transacoes);
        return "listas/listaExtrato";
    }

    @RequestMapping("autorizaCompra")
    public String listaAutorizacaoCompra(Model model) {
        List<Transacao> transacoes = tdao.getAll();
        model.addAttribute("transacoes", transacoes);
        return "cadastros/formAutorizacaoCompra";
    }
    
/**    @RequestMapping("inserirCredito")
    public String listaInserirCredito(Model model) {
        List<Transacao> transacoes = tdao.getAll();
        model.addAttribute("transacoes", transacoes);
        return "cadastros/formInserirCredito";
    }
 **/   
}

