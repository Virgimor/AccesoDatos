package ies.jandula.empleados.models;

import java.math.BigDecimal;
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
public class Ubicaciones {
	
	@Id
	@Column(precision = 4)
	private BigDecimal idUbicacion;
	
	@Column(length = 40)
	private String direccion;
	
	@Column(length = 12)
	private String codigoPostal;
	
	@Column(length = 30, nullable = false)
	private String ciudad;
	
	@Column(length = 25)
	private String estadoProvincia;
	
	@ManyToOne
	@JoinColumn(name = "id_pais", referencedColumnName = "idPais")
	private Paises paises;
	
	@OneToMany(mappedBy = "ubicaciones")
	private List<Departamentos> listaDepartamentos;

}
