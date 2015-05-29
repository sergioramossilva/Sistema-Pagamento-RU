package br.edu.utfpr.cm.pi.controller;


import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import br.edu.utfpr.cm.pi.beans.Funcionario;
import br.edu.utfpr.cm.pi.daos.FuncionarioDao;


/**
 *
 * @author raphael
 */
@WebServlet(name = "FuncionarioController", urlPatterns = {"/cadastros/funcionario/controlador"})
public class FuncionarioController extends SuperController{

	private static final long serialVersionUID = 1L;
	
	private FuncionarioDao dao;
	   
	   public FuncionarioController() {
		dao = new FuncionarioDao();
	}	   
	
    @Override
    public String acaoPadrao(HttpServletRequest request) {
        List<Funcionario> funcionarios = dao.getAll();
        request.setAttribute("lista", funcionarios);
        return "lista.jsp";
    }
    
    public String incluir(HttpServletRequest request) {
        Funcionario funcionario = new Funcionario();
        request.setAttribute("fun", funcionario);
        return "form.jsp";
    }
    
    public String salvar(HttpServletRequest request) {
    	Funcionario funcionario = new Funcionario();
        dao.save(funcionario);
       return acaoPadrao(request);
    }
    
    public String excluir(HttpServletRequest request){
    	Funcionario funcionario = new Funcionario();
        Long id = Long.parseLong(request.getParameter("id"));
        funcionario.setId(id);
        dao.delete(funcionario);
        return acaoPadrao(request);
    }
    
    public String alterar(HttpServletRequest request){
    	Funcionario fun = new Funcionario();
        Long id = Long.parseLong(request.getParameter("id"));
        fun = dao.findById(id);
//        Funcionario fun = (Funcionario) dao.findById(funcionario.getClass(), id);
        request.setAttribute("car", fun);
        return "form.jsp";
    }
    
}