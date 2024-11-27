package ies.jandula.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Biblioteca.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
