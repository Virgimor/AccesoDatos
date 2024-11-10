package ies.jandula.Ejercicio1.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Excursion {
	
	@EmbeddedId
	private ExcursionId excursionId;
	
	@ManyToOne
	@MapsId("nif")
	@JoinColumn(name = "nif_empresa")
	private Empresa empresa;
	
	
	@Column
	private Date fecha;

}
