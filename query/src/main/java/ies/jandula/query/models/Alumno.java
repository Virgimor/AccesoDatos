package ies.jandula.query.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Alumno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nif;
	
	@Column
	private Integer edad;
	
	@Column
	private String direccion;
	
	@Column
	private Boolean aprobado;
	
	@ManyToOne
	private Tutor tutor;
	
	@ManyToOne
	private Nacionalidad nacionalidad;
	
	@ManyToOne
	private Alumno mentor;

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nif=" + nif + ", edad=" + edad + ", direccion=" + direccion + ", aprobado="
				+ aprobado + ", tutor=" + tutor + ", nacionalidad=" + nacionalidad + ", mentor=" + (mentor!= null ? mentor.getId() : "null") + "]";
	}

}
