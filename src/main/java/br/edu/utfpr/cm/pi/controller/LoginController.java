package br.edu.utfpr.cm.pi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.utfpr.cm.pi.beans.Funcionario;
import br.edu.utfpr.cm.pi.daos.FuncionarioDao;

@Controller
public class LoginController {

    private final FuncionarioDao dao;

    public LoginController() {
        dao = new FuncionarioDao();
    }

    @RequestMapping("/efetuarLogin")
    public String efetuarLogin(Funcionario funcionario, HttpSession session) {

        System.out.println(funcionario.getLogin());
        System.out.println(funcionario.getSenha());

        Funcionario fun = dao.getLogin(funcionario.getLogin(), funcionario.getSenha());

        if (fun != null) {

            session.setAttribute("func", fun);
            return "bemvindo";
        } 
        return "loginInvalido";
    }

    /*@RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginForm";
    }*/
}
