package br.edu.utfpr.cm.pi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.cm.pi.beans.Cargo;
import br.edu.utfpr.cm.pi.daos.CargoDao;

@Controller
public class CargoController {

    private final CargoDao cdao;

    public CargoController() {
        cdao = new CargoDao();
    }

    @RequestMapping("incluirCargo")
    public String incluir() {
        return "cadastros/formCargo";
    }

    @RequestMapping("salvarCargo")
    public String salvar(Cargo cargo) {
        cdao.save(cargo);
        return "forward:listarCargos";
    }

    @RequestMapping("excluirCargo")
    public String excluir(Cargo cargo) {
        cdao.delete(cargo);
        return "forward:listarCargos";
    }

    @RequestMapping("alterarCargo")
    public String alterar(Long id, Model model) {
        model.addAttribute("cargo", cdao.findById(id));
        return "cadastros/formCargo";
    }

    @RequestMapping("listarCargos")
    public String lista(Model model) {
        List<Cargo> cargos = cdao.getAll();
        model.addAttribute("cargos", cargos);
        return "listas/listaCargos";
    }

}