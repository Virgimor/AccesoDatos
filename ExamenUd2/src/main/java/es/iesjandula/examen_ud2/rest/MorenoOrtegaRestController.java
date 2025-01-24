package es.iesjandula.examen_ud2.rest;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.examen_ud2.dtos_examen.Examen2;
import es.iesjandula.examen_ud2.dtos_examen.Examen3;
import es.iesjandula.examen_ud2.dtos_examen.Examen4;
import es.iesjandula.examen_ud2.dtos_examen.Examen6;
import es.iesjandula.examen_ud2.dtos_examen.Examen8;
import es.iesjandula.examen_ud2.dtos_examen.Examen9;
import es.iesjandula.examen_ud2.repository.EmpleadosRepository;
import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
@RequestMapping(value = "/examen")
public class MorenoOrtegaRestController {
	
	@Autowired
	private EmpleadosRepository empleadosRepository;
	
	@GetMapping("/1")
	public Page<String> examen1(@PageableDefault(size=10, page=0) Pageable pageable){
		
		return this.empleadosRepository.examen1(pageable);
		
	}
	
	Date fecha = Date.valueOf("2000-03-24");
	@GetMapping("/2")
	public Page<Examen2> examen2(@PageableDefault(size=10, page=0) Pageable pageable){
		
		return this.empleadosRepository.examen2(fecha, pageable);
		
	}
	
	@GetMapping("/3")
	public Page<Examen3> examen3(@PageableDefault(size=10, page=0) Pageable pageable){
		
		return this.empleadosRepository.examen3(pageable);
		
	}
	
	@GetMapping("/4")
	public Page<Examen4> examen4(@PageableDefault(size=10, page=0) Pageable pageable){
		
		return this.empleadosRepository.examen4(pageable);
		
	}
	
	@GetMapping("/5")
	public Page<String> examen5(@PageableDefault(size=10, page=0) Pageable pageable){
		
		return this.empleadosRepository.examen5(pageable);
		
	}

	@GetMapping("/6")
	public Page<Examen6> examen6(@PageableDefault(size=10, page=0) Pageable pageable){
		
		return this.empleadosRepository.examen6(pageable);
		
	}
	
	@GetMapping("/7")
	public Page<String> examen7(@PageableDefault(size=10, page=0) Pageable pageable){
		
		return this.empleadosRepository.examen7(pageable);
		
	}
	
	@GetMapping("/8")
	public Page<Examen8> examen8(@PageableDefault(size=10, page=0) Pageable pageable){
		
		return this.empleadosRepository.examen8(pageable);
		
	}
	
	@GetMapping("/9")
	public Page<Examen9> examen9(@PageableDefault(size=10, page=0) Pageable pageable){
		
		return this.empleadosRepository.examen9(pageable);
		
	}

}
