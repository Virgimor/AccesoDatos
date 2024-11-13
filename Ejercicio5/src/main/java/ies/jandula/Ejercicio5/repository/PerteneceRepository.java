package ies.jandula.Ejercicio5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Ejercicio5.models.Pertenece;
import ies.jandula.Ejercicio5.models.PerteneceId;

public interface PerteneceRepository extends JpaRepository<Pertenece, PerteneceId>{

}
