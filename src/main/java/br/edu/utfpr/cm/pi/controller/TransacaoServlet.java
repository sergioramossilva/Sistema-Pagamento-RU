package br.edu.utfpr.cm.pi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.cm.pi.beans.UsuarioSistema;
import br.edu.utfpr.cm.pi.daos.UsuarioDao;
import br.edu.utfpr.cm.pi.ldap.LoginLDAP;

/**
 * Servlet implementation class TransacaoServlet
 */
@WebServlet(description = "realiza operações da transação, como debitar e creditar refeições", urlPatterns = { "/TransacaoServlet" })
public class TransacaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransacaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        LoginLDAP loginLDAP = new LoginLDAP();
        UsuarioSistema usuario = loginLDAP.logarNoLDAP(login, senha);
        if (usuario == null) {
            response.sendRedirect("loginInvalidoUsuario.jsp");
        } else if (usuario.getSaldo() == 0) {
            response.sendRedirect("semsaldo.jsp");
        } else {
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            if (tipo == 0) {
                double quantidade = Double.parseDouble(request
                        .getParameter("quantidade"));
                usuario.setSaldo(usuario.getSaldo() + quantidade);
                new UsuarioDao().save(usuario);
            } else if (tipo == 1) {
                usuario.setSaldo(usuario.getSaldo() - 1);
                new UsuarioDao().save(usuario);
            }

        }
    }

}
