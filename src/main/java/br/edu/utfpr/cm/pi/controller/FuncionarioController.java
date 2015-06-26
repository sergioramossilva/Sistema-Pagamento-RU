
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

    private final FuncionarioDao fdao;

    public FuncionarioController() {
        fdao = new FuncionarioDao();
    }

    @RequestMapping("incluirFuncionario")
    public String incluir(HttpServletRequest request) {
        Funcionario funcionario = new Funcionario();
        request.setAttribute("funcionario", funcionario);
        return "cadastros/formFuncionario.jsp";
    }

    @RequestMapping("salvarFuncionario")
    public String salvar(Funcionario funcionario) {
        fdao.save(funcionario);
        return "forward:listarFuncionarios";
    }

    @RequestMapping("excluirFuncionario")
    public String excluir(Funcionario funcionario) {
        fdao.delete(funcionario);
        return "forward:listarFuncionarios";
    }
    
    @RequestMapping("alterarFuncionario")
    public String alterar(Long id, Model model) {        
        model.addAttribute("funcionario", fdao.findById(id));
        return "cadastros/formFuncionario.jsp";
    }

    @RequestMapping("listarFuncionarios")
    public String lista(Model model) {
        List<Funcionario> funcionarios = fdao.getAll();
        model.addAttribute("funcionarios", funcionarios);
        return "listas/listaFuncionarios.jsp";
    }

}