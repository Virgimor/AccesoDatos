package es.iesjandula.examen_ud2.rest;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.examen_ud2.repository.DepartamentoRepository;
import es.iesjandula.examen_ud2.repository.EmpleadosRepository;
import es.iesjandula.examen_ud2.repository.PaisesRepository;
import es.iesjandula.examen_ud2.repository.PuestosRepository;
import es.iesjandula.examen_ud2.repository.RegionesRepository;
import es.iesjandula.examen_ud2.repository.UbicacionesRepository;
import jakarta.annotation.PostConstruct;

@Service
public class Controller {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private EmpleadosRepository empleadosRepository;
	
//	@Autowired
//	private HistorialPuestosRepository historialPuestosRepository ;
	
	@Autowired
	private PaisesRepository paisesRepository;
	
	@Autowired
	private PuestosRepository puestosRepository;
	
	@Autowired
	private RegionesRepository regionesRepository;
	
	@Autowired
	private UbicacionesRepository ubicacionesRepository;
	
	@PostConstruct
	public void init() {
		
//		System.out.println("1. Obtener todos los empleados y sus respectivos nombres de departamento.");
//		System.out.println(this.empleadosRepository.encontrarEmpleadosConSusDepartamentos());
//		System.out.println();
//		
//		System.out.println("2. Listar los nombres de los países y su nombre de región asociado.");
//		System.out.println(this.paisesRepository.encontrarPaisesYNombreRegion());
//		System.out.println();
//		
//		System.out.println("3. Mostrar los nombres de las ubicaciones junto con las ciudades y países a las que pertenecen.");
//		System.out.println(this.ubicacionesRepository.encontrarUbicacionConCiudadYPais());
//		System.out.println();
//		
//		System.out.println("4. Obtener los nombres y apellidos de los empleados junto con sus títulos de puesto.");
//		System.out.println(this.empleadosRepository.encontrarNombreYApellidosEmpleadosConNombrePuesto());
//		System.out.println();
//		
//		System.out.println("5. Mostrar los nombres y apellidos de los empleados y sus respectivos gerentes (nombre y apellidos).");
//		System.out.println(this.empleadosRepository.encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerente());
//		System.out.println();
		
		System.out.println("6. Obtener todas las ubicaciones y el nombre del país al que pertenecen.");
		System.out.println(this.ubicacionesRepository.encontrarUbicacionConNombrePais());
		System.out.println();
		
		System.out.println("7. Mostrar las regiones y la cantidad de países que pertenecen a cada región.");
		System.out.println(this.regionesRepository.encontrarRegionesYCantidadPaisesPertenecientes());
		System.out.println();
		
		System.out.println("8. Obtener los departamentos con sus ubicaciones correspondientes.");
		System.out.println(this.departamentoRepository.encontrarDepartamentoConNombreUbicacion());
		System.out.println();
		
		System.out.println("9. Mostrar todos los empleados que pertenecen a un departamento específico.");
		System.out.println(this.empleadosRepository.encontrarEmpleadosPorDepartamentoEspecifico("Administración"));
		System.out.println();
		
		System.out.println("10. Listar los puestos con empleados asignados.");
		System.out.println(this.puestosRepository.encontrarPuestosConEmpleados());
		System.out.println();
		
//		System.out.println("11. Obtener los empleados cuyo salario es mayor a 5000 junto con el nombre del departamento.");
//		System.out.println(this.empleadosRepository.encontrarEmpleadosConSueldoMayor5000ConSusDepartamentos());
//		System.out.println();
		
		System.out.println("12. Mostrar empleados con título \"Programador\" y el nombre de su gerente.");
		System.out.println(this.empleadosRepository.encontrarEmpleadosConNombreGerentePorTitutloEspecifico("Programador"));
		System.out.println();
		
		System.out.println("13. Obtener los países de la región Europa.");
		System.out.println(this.paisesRepository.encontrarPaisesDeEuropa("Europa"));
		System.out.println();
		
		Date fecha = Date.valueOf("2000-01-01");
		System.out.println("14. Mostrar empleados contratados después del año 2000 con sus departamentos.");
		System.out.println(this.empleadosRepository.encontrarEmpleadosConSusDepartamentosConContratoEspecifico(fecha));
		System.out.println();
		
		char c = 'C';
		System.out.println("15. Obtener ubicaciones en países que empiezan con la letra C.");
		System.out.println(this.ubicacionesRepository.encontrarUbicacionConNombrePaisEmpiezanPorC(c));
		System.out.println();
		
		System.out.println("16. Mostrar los empleados cuyo apellido termina en \"son\" y su puesto.");
		System.out.println(this.empleadosRepository.encontrarNombreYApellidosTerminaEnSonConNombrePuesto("son"));
		System.out.println();
		
		System.out.println("17. Listar empleados que no tienen gerente asignado.");
		System.out.println(this.empleadosRepository.encontrarNombreYApellidosEmpleadosSinGerente());
		System.out.println();
		
		System.out.println("18. Mostrar departamentos que tienen empleados con salario mayor a 10000.");
		System.out.println(this.departamentoRepository.encontrarDepartamentoConEmpleadosYElSalarioMayor10000());
		System.out.println();
		
//		System.out.println("19. Obtener empleados con comisiones asignadas y sus departamentos.");
//		System.out.println(this.empleadosRepository.encontrarEmpleadosConComisionesYDepartamentos());
//		System.out.println();
//		
//		System.out.println("20. Mostrar empleados del departamento \"Ventas\" que ganan más de 7000.");
//		System.out.println(this.empleadosRepository.encontrarEmpleadosDeVentasQueGananMas7000());
//		System.out.println();
//		
//		System.out.println("21. Listar empleados ordenados por salario descendente y nombre del departamento.");
//		System.out.println(this.empleadosRepository.encontrarEmpleadosOrdenadosPorSalarioDescYNombreDepartamentos());
//		System.out.println();
//		
//		System.out.println("22. Mostrar países ordenados por el nombre de la región a la que pertenecen.");
//		System.out.println(this.paisesRepository.encontrarPaisesOrdenadorPorNombreRegion());
//		System.out.println();
//		
//		System.out.println("23. Listar ubicaciones ordenadas por ciudad ascendente y nombre del país.");
//		System.out.println(this.ubicacionesRepository.encontrarUbicacionOrdenadaPorCiudadAscYNombrePais());
//		System.out.println();
//		
//		System.out.println("24. Mostrar empleados ordenados por fecha de contratación y salario.");
//		System.out.println(this.empleadosRepository.encontrarEmpleadosOrdenadoPorFechaDeContratoYSalario());
//		System.out.println();
		
		System.out.println("25. Obtener puestos ordenados por salario máximo descendente.");
		System.out.println(this.puestosRepository.encontrarPuestosOrdenadosPorSalarioDesc());
		System.out.println();
		
//		System.out.println("26. Mostrar empleados y su gerente ordenados por el apellido del gerente.");
//		System.out.println(this.empleadosRepository.encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerenteOrdenadosPorApellidoAsc());
//		System.out.println();
		
		System.out.println("27. Listar los departamentos ordenados por la cantidad de empleados.");
		System.out.println(this.departamentoRepository.encontrarDepartamentoOrdenadosPorCantidadEmpleados());
		System.out.println();
		
		System.out.println("28. Mostrar empleados del país IT ordenados por salario.");
		System.out.println(this.empleadosRepository.encontrarNombreEmpleadoDelPaisITOrdenadoPorSalario());
		System.out.println();
		
		System.out.println("29. Obtener regiones ordenadas por cantidad de países asociados.");
		System.out.println(this.regionesRepository.encontrarRegionesOrdenadaCantidadPaisesPertenecientesOrdenada());
		System.out.println();
		
		System.out.println("30. Mostrar empleados sin gerente, ordenados alfabéticamente.");
		System.out.println(this.empleadosRepository.encontrarNombreYApellidosEmpleadosSinGerenteOrdenadosAlfabeticamente());
		System.out.println();
		
		System.out.println("31. Obtener la cantidad de empleados por departamento.");
		System.out.println(this.departamentoRepository.encontrarDepartamentoPorCantidadEmpleados());
		System.out.println();
		
		System.out.println("32. Mostrar el salario promedio de cada departamento.");
		System.out.println(this.departamentoRepository.encontrarSalarioPromedioDeCadaDepartamento());
		System.out.println();
		
		System.out.println("33. Listar los países y el número de ubicaciones en cada país.");
		System.out.println(this.paisesRepository.encontrarPaisesConNumeroUbicacionPorPais());
		System.out.println();
		
//		System.out.println("34. Mostrar la cantidad de empleados por título de puesto.");
//		System.out.println(this.puestosRepository.encontrarCantidadEmpleadosPorTituloPuesto());
//		System.out.println();
		
		System.out.println("35. Listar regiones con el número total de países en cada una.");
		System.out.println(this.regionesRepository.listarRegionesYCantidadPaisesPertenecientes());
		System.out.println();
		
		System.out.println("36. Obtener los nombres de departamentos con más de 5 empleados.");
		System.out.println(this.departamentoRepository.encontrarDepartamentoConMas5Empleados());
		System.out.println();
		
		System.out.println("37. Mostrar la suma de salarios por departamento.");
		System.out.println(this.departamentoRepository.mostrarSumaSalariosPorDepartamentos());
		System.out.println();
		
//		System.out.println("38. Obtener la cantidad de empleados contratados en cada año.");
//		System.out.println(this.empleadosRepository.obtenerEmpleadosContratadosEnCadaAnio());
//		System.out.println();
//		
//		System.out.println("39. Listar empleados agrupados por gerente y contar cuántos empleados tiene cada uno.");
//		System.out.println(this.empleadosRepository.listarEmpleadosAgrupadosPorGerenteYCuantosEmpleadosTiene());
//		System.out.println();
		
		System.out.println("40. Obtener departamentos con empleados cuyo salario promedio es mayor a 8000.");
		System.out.println(this.departamentoRepository.obtenerDepartamentosConSalarioPromedioEmpleadosMayorA8000());
		System.out.println();
		
		System.out.println("41. Mostrar los departamentos que tienen más de 10 empleados.");
		System.out.println(this.departamentoRepository.mostrarDepartamentosConMas10Empleados());
		System.out.println();
		
		System.out.println("42. Obtener las regiones con más de 3 países asociados.");
		System.out.println(this.regionesRepository.mostrarReionesConMas3PaisesAsociados());
		System.out.println();
		
		System.out.println("43. Listar los departamentos cuyo salario total es mayor a 50000.");
		System.out.println(this.departamentoRepository.listarDepartamentosConSalarioMayor50000());
		System.out.println();
		
		System.out.println("44. Mostrar los gerentes que tienen más de 5 empleados a su cargo.");
		System.out.println(this.empleadosRepository.mostrarGerentesConMas5EmpleadosACargo());
		System.out.println();
		
//		System.out.println("45. Obtener puestos con un salario mínimo mayor a 4000 y empleados asignados.");
//		System.out.println(this.puestosRepository.obtenerPuestosConSalarioMinimoMayor4000YEmpleadosAsignados());
//		System.out.println();
		
		System.out.println("46. Listar países con más de 2 ubicaciones.");
		System.out.println(this.paisesRepository.listarPaisesConMas2Ubicaciones());
		System.out.println();
		
//		System.out.println("47. Mostrar los empleados agrupados por puesto cuyo salario promedio supera 6000.");
//		System.out.println(this.empleadosRepository.mostrarEmpleadosAgrupadosPorPuestoConSalarioPromedioMayor6000());
//		System.out.println();
		
		System.out.println("48. Obtener departamentos con empleados cuyo salario promedio supera los 9000.");
		System.out.println(this.departamentoRepository.obtenerDepartamentosConSalarioPromedioEmpleadosMayorA9000());
		System.out.println();
		
		System.out.println("49. Mostrar los países con más de 3 empleados asignados.");
		System.out.println(this.paisesRepository.mostrarPaisesConMas3Empleados());
		System.out.println();
		
		System.out.println("50. Obtener las ciudades con más de 2 ubicaciones.");
		System.out.println(this.ubicacionesRepository.obtenerCiudadesConMas2Ubicaciones());
		System.out.println();
		
//		System.out.println("74. Mostrar los departamentos cuyo salario promedio supera el salario promedio de todos los departamentos.");
//		System.out.println(this.departamentoRepository.mostrarDepartamentosCuyoSalarioPromedioSuperaAlSalarioPromedioDeLosDemasDepartamentos());
//		System.out.println();
//		
	}

}
