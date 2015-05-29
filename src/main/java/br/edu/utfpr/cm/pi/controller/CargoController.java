package br.edu.utfpr.cm.pi.controller;



import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import br.edu.utfpr.cm.pi.beans.Cargo;
import br.edu.utfpr.cm.pi.daos.CargoDao;


/**
 *
 * @author raphael
 */
@WebServlet(name = "CargoController", urlPatterns = {"/cadastros/cargo/controlador"})
public class CargoController extends SuperController{

	   /**
     * 
     */
    private static final long serialVersionUID = -2370921254016052104L;
    private CargoDao dao;
	   
	   public CargoController() {
		dao = new CargoDao();
	}	   
	
    @Override
    public String acaoPadrao(HttpServletRequest request) {
        List cargos = dao.getAll();
        request.setAttribute("lista", cargos);
        return "lista.jsp";
    }
    
    public String incluir(HttpServletRequest request) {
        Cargo cargo = new Cargo();
        request.setAttribute("car", cargo);
        return "form.jsp";
    }
    
    public String salvar(HttpServletRequest request) {
        Cargo cargo = new Cargo();
        dao.save(cargo);
       return acaoPadrao(request);
    }
    
    public String excluir(HttpServletRequest request){
        Cargo cargo = new Cargo();
        Long id = Long.parseLong(request.getParameter("id"));
        dao.delete(id);
        return acaoPadrao(request);
    }
    
    public String alterar(HttpServletRequest request){
        
        Long id = Long.parseLong(request.getParameter("id"));
        Cargo e = (Cargo) dao.findById(id);
        request.setAttribute("car", e);
        return "form.jsp";
    }
    
}

