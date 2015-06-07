package br.edu.utfpr.cm.pi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.JasperException;
import org.apache.jasper.runtime.JspRuntimeLibrary;

import br.edu.utfpr.cm.pi.beans.Cargo;
import br.edu.utfpr.cm.pi.daos.CargoDao;

public class CargoController extends SuperController {

    private static final long serialVersionUID = 1L;

    private final CargoDao cdao;

    public CargoController() {
        cdao = new CargoDao();
    }

    @Override
    public String acaoPadrao(HttpServletRequest request) {
        List<Cargo> cargos = cdao.getAll();
        request.setAttribute("lista", cargos);
        return "listas/listaCargos.jsp";
    }

    @Override
    public String incluir(HttpServletRequest request) {
        Cargo cargo = new Cargo();
        request.setAttribute("cargo", cargo);
        return "cadastros/formCargo.jsp";
    }

    @Override
    public String salvar(HttpServletRequest request) throws JasperException {
        Cargo cargo = new Cargo();
        JspRuntimeLibrary.introspect(cargo, request);
        cdao.save(cargo);
        return acaoPadrao(request);
    }

    @Override
    public String alterar(HttpServletRequest request) {
        Cargo cargo = new Cargo();
        Long id = Long.parseLong(request.getParameter("id"));
        cargo = cdao.findById(id);
        request.setAttribute("cargo", cargo);
        return "cadastros/formCargo.jsp";
    }

    @Override
    public String excluir(HttpServletRequest request) {
        Cargo cargo = new Cargo();
        Long id = Long.parseLong(request.getParameter("id"));
        cargo = cdao.findById(id);
        cdao.delete(cargo);
        return acaoPadrao(request);
    }

}