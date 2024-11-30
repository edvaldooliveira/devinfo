package com.edsure.devinfo.controllers;

import com.edsure.devinfo.model.Usuario;
import com.edsure.devinfo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @RequestMapping(value = "/mostranome/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Curso Spring Boot API: " + name + "!";
    }

    @RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String retornaOlaMundo(@PathVariable String nome) {

        Usuario usuario = new Usuario();
        usuario.setNome(nome);

        usuarioRepository.save(usuario);//gravar no banco de dados
        return "Ola mundo " + nome;
    }
}