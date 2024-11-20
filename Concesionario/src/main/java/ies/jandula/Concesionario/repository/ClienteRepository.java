package ies.jandula.Concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Concesionario.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
