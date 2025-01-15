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
import ies.jandula.empleados.dtos.Consulta51;
import ies.jandula.empleados.dtos.Consulta52;
import ies.jandula.empleados.dtos.Consulta53;
import ies.jandula.empleados.dtos.Consulta54;
import ies.jandula.empleados.dtos.Consulta55;
import ies.jandula.empleados.dtos.Consulta56;
import ies.jandula.empleados.dtos.Consulta57;
import ies.jandula.empleados.dtos.Consulta58;
import ies.jandula.empleados.dtos.Consulta59;
import ies.jandula.empleados.dtos.Consulta5Y26;
import ies.jandula.empleados.dtos.Consulta60;
import ies.jandula.empleados.dtos.Consulta61;
import ies.jandula.empleados.dtos.Consulta63;
import ies.jandula.empleados.dtos.Consulta64;
import ies.jandula.empleados.dtos.Consulta65;
import ies.jandula.empleados.dtos.Consulta66;
import ies.jandula.empleados.dtos.Consulta67;
import ies.jandula.empleados.dtos.Consulta70;
import ies.jandula.empleados.dtos.Consulta71;
import ies.jandula.empleados.dtos.Consulta74;
import ies.jandula.empleados.dtos.Consulta76;
import ies.jandula.empleados.models.Empleados;
import ies.jandula.empleados.repository.DepartamentoRepository;
import ies.jandula.empleados.repository.EmpleadosRepository;
import ies.jandula.empleados.repository.HistorialPuestosRepository;
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
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private EmpleadosRepository empleadosRepository;
	
	@Autowired
	private HistorialPuestosRepository historialPuestosRepository ;
	
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
	@GetMapping("/consulta38")
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
	public Page<Consulta45> obtenerPuestosConSalarioMinimoMayor4000YEmpleadosAsignados(@PageableDefault(size=2) Pageable pageable){
		
		return this.puestosRepository.obtenerPuestosConSalarioMinimoMayor4000YEmpleadosAsignados(pageable);
		
	}
	
//	47. Mostrar los empleados agrupados por puesto cuyo salario promedio supera 6000.
	@GetMapping("/mostrarEmpleadosAgrupadosPorPuestoConSalarioPromedioMayor6000")
	public Page<Consulta47> mostrarEmpleadosAgrupadosPorPuestoConSalarioPromedioMayor6000(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.mostrarEmpleadosAgrupadosPorPuestoConSalarioPromedioMayor6000(pageable);
		
	}
	
//	51. Listar empleados, sus puestos y el nombre de los departamentos a los que pertenecen.
	@GetMapping("/mostrarEmpleadosPuestosYNombreDepartamentoQuePertenecen")
	public Page<Consulta51> mostrarEmpleadosPuestosYNombreDepartamentoQuePertenecen(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.mostrarEmpleadosPuestosYNombreDepartamentoQuePertenecen(pageable);
		
	}
	
//	52. Mostrar ubicaciones con el nombre de país y la región.
	@GetMapping("/consulta52")
	public Page<Consulta52> mostrarDireccionNombreDePaisYRegion(@PageableDefault(size=10) Pageable pageable){
		
		return this.ubicacionesRepository.mostrarDireccionNombreDePaisYRegion(pageable);
		
	}
	
//	53. Obtener empleados con sus gerentes y el nombre del departamento.
	@GetMapping("/mostrarEmpleadosGerenteYNombreDepartamentoQuePertenecen")
	public Page<Consulta53> mostrarEmpleadosGerenteYNombreDepartamentoQuePertenecen(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.mostrarEmpleadosGerenteYNombreDepartamentoQuePertenecen(pageable);
		
	}
	
//	54. Mostrar empleados con sus puestos, departamentos y ubicaciones.
	@GetMapping("/mostrarEmpleadosPuestosYNombreDepartamentoYUbicaciones")
	public Page<Consulta54> mostrarEmpleadosPuestosYNombreDepartamentoYUbicaciones(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.mostrarEmpleadosPuestosYNombreDepartamentoYUbicaciones(pageable);
		
	}
	
//	55. Listar empleados, sus países y las regiones donde trabajan.
	@GetMapping("/listarEmpleadosPaisesYRegiones")
	public Page<Consulta55> listarEmpleadosPaisesYRegiones(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.listarEmpleadosPaisesYRegiones(pageable);
		
	}
	
//	56. Mostrar todos los puestos, empleados y departamentos ordenados por salario.
	@GetMapping("/consulta56")
	public Page<Consulta56> mostrarPuestosEmpleadosYDepartamentosOrdenadosPorSalario(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.mostrarPuestosEmpleadosYDepartamentosOrdenadosPorSalario(pageable);
		
	}
	
//	57. Obtener empleados, nombre de departamento y país en una sola consulta.
	@GetMapping("/consulta57")
	public Page<Consulta57> obtenerEmpleadosNombreDepartamentoYPais(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.obtenerEmpleadosNombreDepartamentoYPais(pageable);
		
	}
	
//	58. Mostrar la cantidad de empleados por puesto y el departamento correspondiente.
	@GetMapping("/consulta58")
	public Page<Consulta58> mostrarCantidadEmpleadosPorPuestoYNombreDepartamento(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.mostrarCantidadEmpleadosPorPuestoYNombreDepartamento(pageable);
		
	}
	
//	59. Obtener los salarios más altos en cada departamento y el nombre del gerente.
	@GetMapping("/consulta59")
	public Page<Consulta59> sarioMasAltoPorDepartamentoYNombreGerente(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.sarioMasAltoPorDepartamentoYNombreGerente(pageable);
		
	}
	
//	60. Listar empleados agrupados por región y contar la cantidad en cada región.
	@GetMapping("/consulta60")
	public Page<Consulta60> listarEmpleadosPorRegionYSuCantidad(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.listarEmpleadosPorRegionYSuCantidad(pageable);
		
	}
	
//	61. Obtener empleados que trabajan en departamentos ubicados en países de la región "Asia".
	@GetMapping("/consulta61")
	public Page<Consulta61> obtenerEmpleadosCuandoDepartamentoUbicadoRegionAsia(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.obtenerEmpleadosCuandoDepartamentoUbicadoRegionAsia("Américas", pageable);
		
	}
	
//	62. Listar empleados cuyo salario supera el salario promedio de todos los empleados.
	@GetMapping("/consulta62")
	public Page<String> listarEmpleadosSalarioMayorALaMediaDeTodos(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.listarEmpleadosSalarioMayorALaMediaDeTodos(pageable);
		
	}
	
//	63. Mostrar empleados y los detalles históricos de los puestos que han tenido.
	@GetMapping("/consulta63")
	public Page<Consulta63> mostrarEmpleadosYElHistoricoDeSusPuestos(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.mostrarEmpleadosYElHistoricoDeSusPuestos(pageable);
		
	}
	
//	64. Obtener el historial de empleados y mostrar los nombres actuales de los puestos.
	@GetMapping("/consulta64")
	public Page<Consulta64> mostrarHistoricoConNombrePuestos(@PageableDefault(size=10) Pageable pageable){
		
		return this.historialPuestosRepository.mostrarHistoricoConNombrePuestos(pageable);
		
	}
	
//	65. Listar empleados que hayan cambiado de puesto más de una vez.
	@GetMapping("/consulta65")
	public Page<String> listarEmpleadosQueHanCambiadoPuestoMasDeUnaVez(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.listarEmpleadosQueHanCambiadoPuestoMasDeUnaVez(pageable);
		
	}
	
//	66. Obtener empleados cuyo salario es menor que el salario máximo de su puesto.
	@GetMapping("/consulta66")
	public Page<String> obtenerEmpleadosConSalarioMenorSalarioMaximoDelPuesto(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.obtenerEmpleadosConSalarioMenorSalarioMaximoDelPuesto(pageable);
		
	}
	
//	67. Mostrar empleados que tengan asignado un gerente cuyo salario sea menor que el suyo.
	@GetMapping("/consulta67")
	public Page<Consulta67> mostrarEmpleadosCuyoGerenteTengaSalarioMenor(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.mostrarEmpleadosCuyoGerenteTengaSalarioMenor(pageable);
		
	}
	
//	68. Listar los departamentos sin empleados asignados.
	@GetMapping("/consulta68")
	public Page<String> listarDepartamentosSinEmpleados(@PageableDefault(size=17) Pageable pageable){
		
		return this.departamentoRepository.listarDepartamentosSinEmpleados(pageable); //??
		
	}
	
//	69. Mostrar países sin ubicaciones registradas.
	@GetMapping("/consulta69")
	public Page<String> mostrarPaisesSinUbicaciones(@PageableDefault(size=10) Pageable pageable){
		
		return this.paisesRepository.mostrarPaisesSinUbicaciones(pageable);//preguntar
		
	}
	
//	70. Obtener gerentes que tengan empleados cuyo salario supera 10000.
	@GetMapping("/consulta70")
	public Page<Consulta70> obtenerGerentesConEmpleadosCuyoSalarioMayor10000(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.obtenerGerentesConEmpleadosCuyoSalarioMayor10000(pageable);
		
	}
	
//	71. Listar empleados cuyo salario es el máximo en su departamento.
	@GetMapping("/consulta71")
	public Page<Consulta71> listarEmpleadosCuyoSarlarioMaximoDelDepartamento(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.listarEmpleadosCuyoSarlarioMaximoDelDepartamento(pageable);
		
	}
	
//	72. Mostrar departamentos donde todos los empleados ganan más de 5000.
	@GetMapping("/consulta72")
	public Page<String> mostrarDepartamentosDondeTodosEmpleadosGanan5000(@PageableDefault(size=28) Pageable pageable){
		
		return this.departamentoRepository.mostrarDepartamentosDondeTodosEmpleadosGanan5000(pageable);
		
	}
	
//	73. Obtener empleados con el salario más bajo de su puesto.
	@GetMapping("/consulta73")
	public Page<String> obtenerEmpleadosConElSalarioMásBajoDeSuPuesto(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.obtenerEmpleadosConElSalarioMásBajoDeSuPuesto(pageable);
		
	}
	
//	74. Mostrar los departamentos cuyo salario promedio supera el salario promedio de todos los departamentos.
//	@GetMapping("/consulta74")
//	public Page<Consulta74> mostrarDepartamentosCuyoSalarioPromedioSuperaAlSalarioPromedioDeLosDemasDepartamentos(@PageableDefault(size=10) Pageable pageable){
//		
//		return this.departamentoRepository.mostrarDepartamentosCuyoSalarioPromedioSuperaAlSalarioPromedioDeLosDemasDepartamentos(pageable);
//		
//	}
	
//	75. Obtener empleados que trabajan en departamentos ubicados en países sin empleados asignados.
	@GetMapping("/consulta75")
	public Page<Consulta47> obatenerEmpleadosTrabajanEnDepartamentosEnPaises(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.mostrarEmpleadosAgrupadosPorPuestoConSalarioPromedioMayor6000(pageable);
		
	}
	
//	76. Listar empleados con el salario más alto en su país.
	@GetMapping("/consulta76")
	public Page<Consulta76> listarEmpleadosConSalarioMasAltoDeSuPais(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.listarEmpleadosConSalarioMasAltoDeSuPais(pageable);
		
	}
	
//	77. Mostrar empleados contratados después de la fecha de contratación de su gerente.
	@GetMapping("/consulta77")
	public Page<Consulta76> mostrarEmpleadosContratadosDespuesDeSuGerente(@PageableDefault(size=10) Pageable pageable){
		
		return this.empleadosRepository.mostrarEmpleadosContratadosDespuesDeSuGerente(pageable);
		
	}
	
//	78. Obtener departamentos con más empleados que el departamento "Ventas".
//	@GetMapping("/consulta78")
//	public Page<Consulta76> listarEmpleadosConSalarioMasAltoDeSuPais(@PageableDefault(size=10) Pageable pageable){
//		
//		return this.empleadosRepository.listarEmpleadosConSalarioMasAltoDeSuPais(pageable);
//		
//	}
//	
//	79. Listar empleados con puestos cuyo salario máximo es mayor que 20000.
//	@GetMapping("/consulta79")
//	public Page<Consulta76> listarEmpleadosConSalarioMasAltoDeSuPais(@PageableDefault(size=10) Pageable pageable){
//		
//		return this.empleadosRepository.listarEmpleadosConSalarioMasAltoDeSuPais(pageable);
//		
//	}
//	
//	80. Mostrar empleados en puestos donde ningún otro empleado ha trabajado.
//	@GetMapping("/consulta80")
//	public Page<Consulta76> listarEmpleadosConSalarioMasAltoDeSuPais(@PageableDefault(size=10) Pageable pageable){
//		
//		return this.empleadosRepository.listarEmpleadosConSalarioMasAltoDeSuPais(pageable);
//		
//	}
	
	
}