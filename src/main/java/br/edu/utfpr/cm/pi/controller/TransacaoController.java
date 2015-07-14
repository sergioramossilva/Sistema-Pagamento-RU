package br.edu.utfpr.cm.pi.controller;

import org.springframework.stereotype.Controller;

@Controller
public class TransacaoController {
/*
    private final TransacaoDao tdao;
    private final LoginLDAP loginLdap;

    public TransacaoController() {
        loginLdap = new LoginLDAP();
        tdao = new TransacaoDao();
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

    @RequestMapping("debitar")
    public String debitar(Transacao transacao, @PathVariable String senha) {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        UsuarioSistema usuario = ldap.logarNoLDAP(login, senha);

        if (usuario != null) {
            
        usuario.setSaldo(usuario.getSaldo()-1);
        }
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

    @RequestMapping("listarTransacoes")
    public String lista(Model model) {
        List<Transacao> transacoes = tdao.getAll();
        model.addAttribute("transacoes", transacoes);
        return "listas/listaTransacoes";
    }

*/}