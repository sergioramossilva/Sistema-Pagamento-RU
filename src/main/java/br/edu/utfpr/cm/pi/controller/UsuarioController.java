package br.edu.utfpr.cm.pi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.cm.pi.beans.Usuario;
import br.edu.utfpr.cm.pi.daos.UsuarioDao;

public class UsuarioController {

    private final UsuarioDao udao;

    public UsuarioController() {
        udao = new UsuarioDao();
    }
    
    @RequestMapping("incluirUsuario")
    public String incluir(HttpServletRequest request) {
        Usuario usuario = new Usuario();
        request.setAttribute("usuario", usuario);
        return "cadastros/formUsuario.jsp";
    }

    @RequestMapping("salvarUsuario")
    public String salvar(Usuario usuario) {
        udao.save(usuario);
        return "forward:listarUsuarios";
    }

    @RequestMapping("excluirUsuario")
    public String excluir(Usuario usuario) {
        udao.delete(usuario);
        return "forward:listarUsuarios";
    }
    
    @RequestMapping("alterarUsuario")
    public String alterar(Long id, Model model) {        
        model.addAttribute("usuario", udao.findById(id));
        return "cadastros/formUsuario.jsp";
    }

    @RequestMapping("listarUsuarios")
    public String lista(Model model) {
        List<Usuario> usuarios = udao.getAll();
        model.addAttribute("usuarios", usuarios);
        return "listas/listaUsuarios.jsp";
    }
}