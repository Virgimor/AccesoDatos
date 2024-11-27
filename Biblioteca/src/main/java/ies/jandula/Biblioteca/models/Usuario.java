package ies.jandula.Biblioteca.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
	
	@Id
	@Column
	private String email;
	
	@Column
	private String nombre;
	
	@Column
	private Date fecha;

}
