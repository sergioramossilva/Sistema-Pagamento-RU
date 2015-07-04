package br.edu.utfpr.cm.pi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.cm.pi.beans.Transacao;
import br.edu.utfpr.cm.pi.daos.TransacaoDao;

@Controller
public class TransacaoController {

    private final TransacaoDao tdao;

    public TransacaoController() {
        tdao = new TransacaoDao();
    }

    @RequestMapping("autorizarCompra")
    public String incluir() {
        return "cadastros/formAutorizacaoCompra";
    }

    @RequestMapping("salvarTransacao")
    public String salvar(Transacao transacao) {
        tdao.save(transacao);
        return "forward:listarTransacaos";
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

    @RequestMapping("listarTransacaos")
    public String lista(Model model) {
        List<Transacao> transacaos = tdao.getAll();
        model.addAttribute("transacaos", transacaos);
        return "listas/listaTransacaos";
    }

}