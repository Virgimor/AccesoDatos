package ies.jandula.empleados.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Paises {
	
	@Id
	@Column(length = 2)
	private Character idPais;
	
	@Column(length = 40)
	private String nombrePais;
	
	@ManyToOne
	@JoinColumn(name = "id_region", referencedColumnName = "idRegion")
	private Regiones regiones;
	
	@OneToMany(mappedBy = "paises")
	private List<Ubicaciones> ubicaciones;

}
