package br.edu.utfpr.cm.pi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.cm.pi.beans.Funcionario;
import br.edu.utfpr.cm.pi.daos.FuncionarioDao;

@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }

    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        FuncionarioDao dao = new FuncionarioDao();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        Funcionario funcionario = dao.getLogin(login, senha);

        if (funcionario != null) {

            HttpSession sessao = request.getSession(true);
            sessao.setAttribute("func", funcionario);
            response.sendRedirect("views/bemvindo.jsp");
        } else {

            response.sendRedirect("loginInvalido.jsp");
        }
    }
}