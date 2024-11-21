package ies.jandula.Concesionario.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Coche {
	
	public Coche(Coche coche) {
		super();
		this.matricula = coche.getMatricula();
		this.color = coche.getColor();
		this.marca = coche.getMarca();
		this.modelo = coche.getModelo();
	}

	@Id
	@Column(length = 10)
	private String matricula;
	
	@Column(length = 20)
	private String color;
	
	@Column(length = 30)
	private String marca;
	
	@Column(length = 50)
	private String modelo;
	
	@ManyToOne
	private Cliente nifCliente;

}
