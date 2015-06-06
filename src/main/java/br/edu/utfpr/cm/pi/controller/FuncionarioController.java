package br.edu.utfpr.cm.pi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.JasperException;
import org.apache.jasper.runtime.JspRuntimeLibrary;

import br.edu.utfpr.cm.pi.beans.Cargo;
import br.edu.utfpr.cm.pi.beans.Funcionario;
import br.edu.utfpr.cm.pi.daos.CargoDao;
import br.edu.utfpr.cm.pi.daos.FuncionarioDao;

/**
 *
 * @author raphael
 */
public class FuncionarioController extends SuperController {

    private static final long serialVersionUID = 1L;

    private FuncionarioDao fdao;
    private CargoDao cdao;

    public FuncionarioController() {
        fdao = new FuncionarioDao();
        cdao = new CargoDao();
    }

    @Override
    public String acaoPadrao(HttpServletRequest request) {
        List<Funcionario> funcionarios = fdao.getAll();
        request.setAttribute("lista", funcionarios);
        return "listas/listaFuncionarios.jsp";
    }

    public String incluir(HttpServletRequest request) {
        
        Funcionario funcionario = new Funcionario();
        request.setAttribute("funcionario", funcionario);
        
        List<Cargo> cargos = cdao.getAll();
        request.setAttribute("crgos", cargos);
        
        return "cadastros/formFuncionario.jsp";
    }

    public String salvar(HttpServletRequest request) throws JasperException {
        
        Funcionario funcionario = new Funcionario();
        JspRuntimeLibrary.introspect(funcionario, request);
        
        Long idCargo = Long.parseLong(request.getParameter("idCargo"));
        Cargo cargo = cdao.findById(idCargo);
        funcionario.setCargo(cargo);
        
        if (funcionario.getId() == null) {
        
            fdao.save(funcionario);
        } else {
            
            fdao.update(funcionario);
        }
        return acaoPadrao(request);
    }

    public String excluir(HttpServletRequest request) {
        Funcionario funcionario = new Funcionario();
        Long id = Long.parseLong(request.getParameter("id"));
        funcionario.setId(id);
        fdao.delete(funcionario);
        return acaoPadrao(request);
    }

    public String alterar(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));
        Funcionario funcionario = fdao.findById(id);
        request.setAttribute("funcionario", funcionario);

        List<Cargo> cargos = cdao.getAll();
        request.setAttribute("crgos", cargos);
        return "cadastros/formFuncionario.jsp";
    }

}