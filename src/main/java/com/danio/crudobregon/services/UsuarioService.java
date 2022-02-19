package com.danio.crudobregon.services;

import com.danio.crudobregon.interfaces.IUsuario;
import com.danio.crudobregon.interfaceservice.IUsuarioService;
import com.danio.crudobregon.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuario iUsuario;

    @Override
    public List<Usuario> listar() {

        return (List<Usuario>) iUsuario.findAll();
    }

    @Override
    public Optional<Usuario> listarPorID(int id) {
        return iUsuario.findById(id);
    }

    @Override
    public int guardar(Usuario usuario) {
        int resultado = 0;
        Usuario usuario1 = iUsuario.save(usuario);
        if (!usuario1.equals(null)) {
            resultado = 1;
        }
        return 0;
    }

    @Override
    public void eliminar(int id) {
        iUsuario.deleteById(id);
    }
}
