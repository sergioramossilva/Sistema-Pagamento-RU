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

    @RequestMapping("efetuarLogin")
    public String efetuarLogin(@RequestParam("login") String login,
            @RequestParam("senha") String senha, HttpSession session) {

        System.out.println(login);
        System.out.println(senha);

        Funcionario fun = dao.getLogin(login, senha);

        if (fun != null) {

            session.setAttribute("func", fun);
            return "bemvindo";
        } else {
            return "loginInvalido";
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginForm";
    }
}
