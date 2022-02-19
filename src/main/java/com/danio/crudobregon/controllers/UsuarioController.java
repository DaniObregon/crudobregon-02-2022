package com.danio.crudobregon.controllers;

import com.danio.crudobregon.interfaceservice.IUsuarioService;
import com.danio.crudobregon.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class UsuarioController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @RequestMapping(value = "prueba")
    public String prueba() {
        return "Prueba OK";
    }

    @RequestMapping(value = "prueba2")
    public List<String> segundaPrueba() {
        return List.of("Banana", "Manzana", "Pera", "Durazno");
    }

    @GetMapping(value = "/listar_usuarios")
    public String listar(Model model) {
        List<Usuario> usuarios = iUsuarioService.listar();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("usuario", new Usuario());
        return "form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Usuario> usuario = iUsuarioService.listarPorID(id);
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/guardar")
    public String save(Model model, @Valid Usuario usuario){
        iUsuarioService.guardar(usuario);
        return "redirect:/listar_usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        iUsuarioService.eliminar(id);
        return "redirect:/listar_usuarios";
    }

    /*
    IMPORTANTE:
    Cuando el usuario nos envia el id null o 0, se crea un uevo usuario,
    Cuando el usuario envia un id existente  se actualizan los datos correspondientes
    */
}
