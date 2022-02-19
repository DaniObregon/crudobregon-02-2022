package com.danio.crudobregon.interfaceservice;

import com.danio.crudobregon.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface  IUsuarioService{

    public List<Usuario> listar();

    public Optional<Usuario> listarPorID(int id);

    public int guardar(Usuario usuario);

    public void eliminar(int id);
}
