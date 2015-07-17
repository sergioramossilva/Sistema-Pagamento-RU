package br.edu.utfpr.cm.pi.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ControleSessao extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object controller) throws Exception {

        String uri = request.getRequestURI();
        boolean sempreAutorizados = uri.endsWith("efetuarLogin")
                || uri.endsWith("LoginUsuarioServlet")
                || uri.contains("LoginUsuario");

        HttpSession httpSession = request.getSession();
        boolean usuarioLogado = httpSession.getAttribute("func") != null;

        if (sempreAutorizados || usuarioLogado) {
            return true;
        } else {
            response.sendRedirect("index.jsp");
            return false;
        }

    }
}
