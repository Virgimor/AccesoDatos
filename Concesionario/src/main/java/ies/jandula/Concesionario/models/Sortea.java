package ies.jandula.Concesionario.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Sortea {
	
	@Id
	private Integer anioSorteo;
	
	@Column
	private Double importeDescuento;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nif_cliente", referencedColumnName = "nif")
	@MapsId("nif")
	private Cliente nifCliente;
	

}
