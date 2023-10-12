package com.bolsadeideas.springboot.app.springbootweb.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "/home" })
    public String index(ModelMap model){
        model.addAttribute("titulo", "hola Spring Framework!");
        return "index";
    }

}
