package ies.jandula.Ejercicio4.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Region {
	
	@Id
	@Column(length = 100, nullable = false)
	private String nombreRegion;
	
	@OneToMany(mappedBy = "region")
	private List<Provincia> provincia;

}
