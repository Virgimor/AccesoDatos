package ies.jandula.empleados.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Ubicación {
	
	@Id
	private Float idUbicacion;
	
	@Column(length = 40)
	private String direccion;
	
	@Column(length = 12)
	private String codigoPostal;
	
	@Column(length = 30)
	private String ciudad;
	
	@Column(length = 20)
	private String estadoProvincia;

}
