package br.edu.utfpr.cm.pi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.cm.pi.beans.Transacao;
import br.edu.utfpr.cm.pi.daos.TransacaoDao;

public class TransacaoController {

    private final TransacaoDao tdao;

    public TransacaoController() {
        tdao = new TransacaoDao();
    }

    @RequestMapping("incluirTransacao")
    public String incluir(HttpServletRequest request) {
        Transacao transacao = new Transacao();
        request.setAttribute("transacao", transacao);
        return "cadastros/formTransacao.jsp";
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
        return "cadastros/formTransacao.jsp";
    }

    @RequestMapping("listarTransacaos")
    public String lista(Model model) {
        List<Transacao> transacaos = tdao.getAll();
        model.addAttribute("transacaos", transacaos);
        return "listas/listaTransacaos.jsp";
    }
}