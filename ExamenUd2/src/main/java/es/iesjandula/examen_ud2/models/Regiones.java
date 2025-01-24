package es.iesjandula.examen_ud2.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Regiones {
	
	@Id
	@Column(precision =  10)
	private BigDecimal idRegion;
	
	@Column(length = 25)
	private String nombreRegion;
	
	@OneToMany(mappedBy = "regiones")
	private List<Paises> listaPaises;

}
