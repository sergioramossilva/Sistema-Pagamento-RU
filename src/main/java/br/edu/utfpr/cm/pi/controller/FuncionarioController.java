package br.edu.utfpr.cm.pi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.cm.pi.beans.Funcionario;
import br.edu.utfpr.cm.pi.daos.FuncionarioDao;

@Controller
public class FuncionarioController {

    private final FuncionarioDao cdao;

    public FuncionarioController() {
        cdao = new FuncionarioDao();
    }

    @RequestMapping("incluirFuncionario")
    public String incluir(HttpServletRequest request) {
        Funcionario funcionario = new Funcionario();
        request.setAttribute("funcionario", funcionario);
        return "cadastros/formFuncionario.jsp";
    }

    @RequestMapping("salvarFuncionario")
    public String salvar(Funcionario funcionario) {
        cdao.save(funcionario);
        return "forward:listarFuncionarios";
    }

    @RequestMapping("excluirFuncionario")
    public String excluir(Funcionario funcionario) {
        cdao.delete(funcionario);
        return "forward:listarFuncionarios";
    }
    
    @RequestMapping("alterarFuncionario")
    public String alterar(Long id, Model model) {        
        model.addAttribute("funcionario", cdao.findById(id));
        return "cadastros/formFuncionario.jsp";
    }

    @RequestMapping("listarFuncionarios")
    public String lista(Model model) {
        List<Funcionario> funcionarios = cdao.getAll();
        model.addAttribute("funcionarios", funcionarios);
        return "listas/listaFuncionarios.jsp";
    }
}