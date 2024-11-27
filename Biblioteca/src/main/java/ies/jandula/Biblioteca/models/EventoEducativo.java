package ies.jandula.Biblioteca.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class EventoEducativo extends Evento{
	
	@Column
	private String nivel;

}
