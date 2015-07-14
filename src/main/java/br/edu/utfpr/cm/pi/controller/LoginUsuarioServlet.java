package br.edu.utfpr.cm.pi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.cm.pi.beans.UsuarioSistema;
import br.edu.utfpr.cm.pi.ldap.LoginLDAP;

@WebServlet(name = "LoginUsuarioServlet", urlPatterns = { "/LoginUsuarioServlet" })
public class LoginUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginUsuarioServlet() {
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

    
        LoginLDAP ldap = new LoginLDAP();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        UsuarioSistema usuario = ldap.logarNoLDAP(login, senha);
        
        if (usuario != null) {

            HttpSession sessao = request.getSession(true);
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect("bemvindoUsuario.jsp");
        } else {

            response.sendRedirect("loginInvalidoUsuario.jsp");
        }
    }
}