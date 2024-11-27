package ies.jandula.Biblioteca.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class EventoCultural extends Evento{
	
	@Column
	private String tematica;

}
