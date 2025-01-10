package ies.jandula.empleados.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ies.jandula.empleados.dtos.Consulta19;
import ies.jandula.empleados.dtos.Consulta1Y11Y14Y20;
import ies.jandula.empleados.dtos.Consulta21;
import ies.jandula.empleados.dtos.Consulta24;
import ies.jandula.empleados.dtos.Consulta2Y22;
import ies.jandula.empleados.dtos.Consulta34;
import ies.jandula.empleados.dtos.Consulta38;
import ies.jandula.empleados.dtos.Consulta39Y44;
import ies.jandula.empleados.dtos.Consulta3y23;
import ies.jandula.empleados.dtos.Consulta45;
import ies.jandula.empleados.dtos.Consulta47;
import ies.jandula.empleados.dtos.Consulta4Y16;
import ies.jandula.empleados.dtos.Consulta5Y26;
import ies.jandula.empleados.repository.EmpleadosRepository;
import ies.jandula.empleados.repository.PaisesRepository;
import ies.jandula.empleados.repository.PuestosRepository;
import ies.jandula.empleados.repository.UbicacionesRepository;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@NoArgsConstructor
@RequestMapping(value = "/empleados")
public class EmpeladosController {
	
//	@Autowired
//	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private EmpleadosRepository empleadosRepository;
	
//	@Autowired
//	private HistorialPuestosRepository historialPuestosRepository ;
	
	@Autowired
	private PaisesRepository paisesRepository;
	
	@Autowired
	private PuestosRepository puestosRepository;
	
//	@Autowired
//	private RegionesRepository regionesRepository;
	
	@Autowired
	private UbicacionesRepository ubicacionesRepository;
	
//	1. Obtener todos los empleados y sus respectivos nombres de departamento.
	@GetMapping("/encontrarEmpleadosConSusDepartamentos")
	public Page<Consulta1Y11Y14Y20> encontrarEmpleadosConSusDepartamentos(@PageableDefault(size=10, page=0) Pageable pageable){
		
		return this.empleadosRepository.encontrarEmpleadosConSusDepartamentos(pageable);
		
	}
	
//	2. Listar los nombres de los países y su nombre de región asociado.
	@GetMapping("/encontrarPaisesYNombreRegion")
	public Page<Consulta2Y22> encontrarPaisesYNombreRegion(@PageableDefault(size=10) Pageable pageable){
		
		return this.paisesRepository.encontrarPaisesYNombreRegion(pageable);
		
	}
	
//	3. Mostrar los nombres de las ubicaciones junto con las ciudades y países a las que pertenecen.
	@GetMapping("/encontrarUbicacionConCiudadYPais")
	public Page<Consulta3y23> encontrarUbicacionConCiudadYPais(@PageableDefault(size=10) Pageable pageable){
		
		return this.ubicacionesRepository.encontrarUbicacionConCiudadYPais(pageable);
		
	}
	
//	4. Obtener los nombres y apellidos de los empleados junto con sus títulos de puesto.
	@GetMapping("/encontrarNombreYApellidosEmpleadosConNombrePuesto")
	public Page<Consulta4Y16> encontrarNombreYApellidosEmpleadosConNombrePuesto(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.encontrarNombreYApellidosEmpleadosConNombrePuesto(pageable);
		
	}
	
//	5. Mostrar los nombres y apellidos de los empleados y sus respectivos gerentes (nombre y apellidos).
	@GetMapping("/encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerente")
	public Page<Consulta5Y26> encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerente(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerente(pageable);
		
	}
	
//	11. Obtener los empleados cuyo salario es mayor a 5000 junto con el nombre del departamento.
	@GetMapping("/encontrarEmpleadosConSueldoMayor5000ConSusDepartamentos")
	public Page<Consulta1Y11Y14Y20> encontrarEmpleadosConSueldoMayor5000ConSusDepartamentos(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.encontrarEmpleadosConSueldoMayor5000ConSusDepartamentos(pageable);
		
	}
	
//	19. Obtener empleados con comisiones asignadas y sus departamentos.;
	@GetMapping("/encontrarEmpleadosConComisionesYDepartamentos")
	public Page<Consulta19> encontrarEmpleadosConComisionesYDepartamentos(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.encontrarEmpleadosConComisionesYDepartamentos(pageable);
		
	}
	
//	20. Mostrar empleados del departamento \"Ventas\" que ganan más de 7000.
	@GetMapping("/encontrarEmpleadosDeVentasQueGananMas7000")
	public Page<Consulta1Y11Y14Y20> encontrarEmpleadosDeVentasQueGananMas7000(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.encontrarEmpleadosDeVentasQueGananMas7000(pageable);
		
	}
	
//	21. Listar empleados ordenados por salario descendente y nombre del departamento.
	@GetMapping("/encontrarEmpleadosOrdenadosPorSalarioDescYNombreDepartamentos")
	public Page<Consulta21> encontrarEmpleadosOrdenadosPorSalarioDescYNombreDepartamentos(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.encontrarEmpleadosOrdenadosPorSalarioDescYNombreDepartamentos(pageable);
		
	}
	
//	22. Mostrar países ordenados por el nombre de la región a la que pertenecen.
	@GetMapping("/encontrarPaisesOrdenadorPorNombreRegion")
	public Page<Consulta2Y22> encontrarPaisesOrdenadorPorNombreRegion(@PageableDefault(size=10) Pageable pageable){
		
		return this.paisesRepository.encontrarPaisesOrdenadorPorNombreRegion(pageable);
		
	}
	
//	23. Listar ubicaciones ordenadas por ciudad ascendente y nombre del país.
	@GetMapping("/encontrarUbicacionOrdenadaPorCiudadAscYNombrePais")
	public Page<Consulta3y23> encontrarUbicacionOrdenadaPorCiudadAscYNombrePais(@PageableDefault(size=10) Pageable pageable){
		
		return this.ubicacionesRepository.encontrarUbicacionOrdenadaPorCiudadAscYNombrePais(pageable);
		
	}
	
//	24. Mostrar empleados ordenados por fecha de contratación y salario	
	@GetMapping("/encontrarEmpleadosOrdenadoPorFechaDeContratoYSalario")
	public Page<Consulta24> encontrarEmpleadosOrdenadoPorFechaDeContratoYSalario(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.encontrarEmpleadosOrdenadoPorFechaDeContratoYSalario(pageable);
		
	}
	
//	26. Mostrar empleados y su gerente ordenados por el apellido del gerente.
	@GetMapping("/encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerenteOrdenadosPorApellidoAsc")
	public Page<Consulta5Y26> encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerenteOrdenadosPorApellidoAsc(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerenteOrdenadosPorApellidoAsc(pageable);
		
	}
	
//	34. Mostrar la cantidad de empleados por título de puesto.
	@GetMapping("/encontrarCantidadEmpleadosPorTituloPuesto")
	public Page<Consulta34> encontrarCantidadEmpleadosPorTituloPuesto(@PageableDefault(size=10) Pageable pageable){
		
		return this.puestosRepository.encontrarCantidadEmpleadosPorTituloPuesto(pageable);
		
	}
	
//	38. Obtener la cantidad de empleados contratados en cada año.
	@GetMapping("/obtenerEmpleadosContratadosEnCadaAnio")
	public Page<Consulta38> obtenerEmpleadosContratadosEnCadaAnio(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.obtenerEmpleadosContratadosEnCadaAnio(pageable);
		
	}
	
//	39. Listar empleados agrupados por gerente y contar cuántos empleados tiene cada uno.
	@GetMapping("/listarEmpleadosAgrupadosPorGerenteYCuantosEmpleadosTiene")
	public Page<Consulta39Y44> listarEmpleadosAgrupadosPorGerenteYCuantosEmpleadosTiene(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.listarEmpleadosAgrupadosPorGerenteYCuantosEmpleadosTiene(pageable);
		
	}
	
//	45. Obtener puestos con un salario mínimo mayor a 4000 y empleados asignados.
	@GetMapping("/obtenerPuestosConSalarioMinimoMayor4000YEmpleadosAsignados")
	public Page<Consulta45> obtenerPuestosConSalarioMinimoMayor4000YEmpleadosAsignados(@PageableDefault(size=10) Pageable pageable){
		
		return this.puestosRepository.obtenerPuestosConSalarioMinimoMayor4000YEmpleadosAsignados(pageable);
		
	}
	
//	47. Mostrar los empleados agrupados por puesto cuyo salario promedio supera 6000.
	@GetMapping("/mostrarEmpleadosAgrupadosPorPuestoConSalarioPromedioMayor6000")
	public Page<Consulta47> mostrarEmpleadosAgrupadosPorPuestoConSalarioPromedioMayor6000(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.mostrarEmpleadosAgrupadosPorPuestoConSalarioPromedioMayor6000(pageable);
		
	}
	
}