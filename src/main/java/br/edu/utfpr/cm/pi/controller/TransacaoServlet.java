package br.edu.utfpr.cm.pi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.cm.pi.beans.Funcionario;
import br.edu.utfpr.cm.pi.beans.Transacao;
import br.edu.utfpr.cm.pi.beans.UsuarioSistema;
import br.edu.utfpr.cm.pi.daos.TipoTransacaoDao;
import br.edu.utfpr.cm.pi.daos.TransacaoDao;
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
        System.out.print("Passei por aqu");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Funcionario funcionario = (Funcionario) session.getAttribute("func");

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        int tipo = Integer.parseInt(request.getParameter("tipo"));

        LoginLDAP loginLDAP = new LoginLDAP();

        UsuarioSistema usuario = null;

        if (tipo == 0) {
            usuario = loginLDAP.geraUsuarioDoSistemaAPartirDeLoginNoLDAP(login);
        } else if (tipo == 1) {
            usuario = loginLDAP.logarNoLDAP(login, senha);
        }

        if (usuario == null) {
            response.sendRedirect("loginInvalidoUsuario.jsp");
        } else if (usuario.getSaldo() == 0) {
            request.setAttribute("mensagemSaldo", "Você não possui saldo!");
            RequestDispatcher rdn = request.getRequestDispatcher("/autorizaCompra");
            rdn.forward(request, response);

            // response.sendRedirect("loginUsuario.jsp");
        } else {
            boolean erro = true;
            Transacao transacao = new Transacao();
            transacao.setFuncionario(funcionario);
            TipoTransacaoDao tipoTransacaoDao = new TipoTransacaoDao();

            if (tipo == 0) {
                int quantidade = Integer.parseInt(request
                        .getParameter("quantidade"));
                usuario.setSaldo(usuario.getSaldo() + quantidade);
                transacao.setQuantidade(quantidade);
                transacao.setTipoTransacao(tipoTransacaoDao.findById(1L));
                erro = false;
                request.setAttribute("mensagem", "Crédito Inserido!");
                RequestDispatcher rd1 = request.getRequestDispatcher("bemvindo.jsp");
                rd1.forward(request, response);
            } else if (tipo == 1) {
                usuario.setSaldo(usuario.getSaldo() - 1);
                transacao.setTipoTransacao(tipoTransacaoDao.findById(2L));
                transacao.setQuantidade(1);

                request.setAttribute("mensagem", "Débito realizado com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("/autorizaCompra");
                rd.forward(request, response);
               
                // request.getRequestDispatcher("loginUsuario.jsp").forward(request,
                // response);
                erro = false;
            }

            if (!erro) {
                transacao.setUsuario(usuario);
                new UsuarioDao().save(usuario);
                new TransacaoDao().save(transacao);
            }

        }
    }
}
