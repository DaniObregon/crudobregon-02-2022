package com.danio.crudobregon.interfaces;

import com.danio.crudobregon.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer> {
}
