package br.edu.utfpr.cm.pi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.cm.pi.beans.Transacao;
import br.edu.utfpr.cm.pi.beans.UsuarioSistema;
import br.edu.utfpr.cm.pi.daos.TransacaoDao;
import br.edu.utfpr.cm.pi.daos.UsuarioDao;

@Controller
public class TransacaoController {

    private final TransacaoDao tdao;
    private final UsuarioDao udao;

    public TransacaoController() {
        tdao = new TransacaoDao();
        udao = new UsuarioDao();
    }

    @RequestMapping("autorizarCompra")
    public String incluir() {
        return "cadastros/formAutorizacaoCompra";
    }

    @RequestMapping("inserirCredito")
    public String incluirCredito() {
        return "cadastros/formInserirCredito";
    }

    @RequestMapping("salvarTransacao")
    public String salvar(Transacao transacao) {

        UsuarioSistema user = udao.findById(transacao.getUsuario().getId());
        
        //Credito
        if(transacao.getTipoTransacao()) {
            user.setSaldo(user.getSaldo()+transacao.getQuantidade());
            transacao.setUsuario(user);
            //Debito
        } else {
            user.setSaldo(user.getSaldo()-transacao.getQuantidade());
            transacao.setUsuario(user);
        }
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
        List<Transacao> transacaos = tdao.getAll();
        model.addAttribute("transacaos", transacaos);
        return "listas/listaTransacoes";
    }

}