package ies.jandula.Ejercicio4.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Provincia {
	
	@Id
	@Column(nullable = false)
	private Integer codigoProvincia;
	
	@Column(length = 100, nullable = false)
	private String nombreProvinica;
	
	@OneToMany(mappedBy = "provincia")
	private List<Localidad> localidad;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Region region;

}
