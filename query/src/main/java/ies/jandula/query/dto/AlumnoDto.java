package ies.jandula.query.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlumnoDto {
	
	private Long id;
	
	private String nif;
	
	private Integer edad;
	
	private String direccion;
	
	private Boolean aprobado;
	
	private TutorDto tutor;
	
	private NacionalidadDto nacionalidad;
	
	private MentorDto mentor;
	
	public AlumnoDto(Long id, String nif, Integer edad, String direccion, Boolean aprobado,
			int tutorId, String tutorNombre, String nombreNacionalidad, String paisNacionalidad, Long idMentor, 
			String nifMentor, Integer edadMentor, String direccionMentor, Boolean aprobadoMentor) {
		super();
		this.id = id;
		this.nif = nif;
		this.edad = edad;
		this.direccion = direccion;
		this.aprobado = aprobado;
		
		this.tutor =  new TutorDto(tutorId, tutorNombre);
		
		this.nacionalidad = new NacionalidadDto(nombreNacionalidad, paisNacionalidad);
		
		this.mentor = new MentorDto(idMentor, nifMentor, edadMentor, direccionMentor, aprobadoMentor);
	}
	
	
	

}
