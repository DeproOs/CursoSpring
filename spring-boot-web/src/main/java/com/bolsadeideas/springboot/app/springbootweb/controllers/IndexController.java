package com.bolsadeideas.springboot.app.springbootweb.controllers;


import com.bolsadeideas.springboot.app.springbootweb.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "/home" })
    public String index(ModelMap model){
        model.addAttribute("titulo", "hola Spring Framework!");
        return "index";
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Claudio");
        usuario.setApellido("Alvarez");
        usuario.setEmail("claudio@gmail.com");

        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model){

        model.addAttribute("titulo", "Listado de usuarios: ");

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios= new ArrayList<>();

        usuarios.add(new Usuario("Claudio", "Alvarez", "claudio@gmail.com"));
        usuarios.add(new Usuario("Jose", "Vidal", "jose@gmail.com"));
        usuarios.add(new Usuario("Matias", "Lopez", "mati@gmail.com"));
        usuarios.add(new Usuario("Tornado", "Roe", "tornado@gmail.com"));

        return usuarios;
    }
}
