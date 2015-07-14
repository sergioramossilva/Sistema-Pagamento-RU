package br.edu.utfpr.cm.pi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/SessionFilter")
public class SessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;

	        // Verifica se existe uma sessão para comparar e se a session ID
	        // retornada pelo cliente é a mesma
	        boolean sessionInvalidated = isSessionInvalidated(httpRequest);
	        if (sessionInvalidated) {
	            httpResponse.addCookie(createCookie(httpRequest));
	            httpResponse.sendError(HttpServletResponse.SC_REQUEST_TIMEOUT);
	        } else {
	            chain.doFilter(request, response);
	        }
	}
	

	    /**
	     * Verifica se a sessão foi invalidada
	     *
	     * @param httpRequest
	     * @return
	     */
	    public boolean isSessionInvalidated(HttpServletRequest httpRequest) {
	        String requestedSessionId = httpRequest.getRequestedSessionId();
	        HttpSession session = httpRequest.getSession(false);
	        if (session == null) {
	            return (requestedSessionId != null);
	        } else {
	            return (requestedSessionId != null && !session.getId().equals(requestedSessionId));
	        }
	    }

	    /**
	     * Mata o cookie de sessão do browser
	     *
	     * @param request
	     * @return cookie
	     */
	    private Cookie createCookie(HttpServletRequest request) {
	        Cookie cookie = new Cookie("JSESSIONID", request.getRequestedSessionId());
	        cookie.setMaxAge(0); // Matar o cookie
	        String contextPath = request.getContextPath();
	        if (!"".equals(contextPath)) {
	            cookie.setPath(contextPath);
	        } else {
	            cookie.setPath("/");
	        }
	        return cookie;
	    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
