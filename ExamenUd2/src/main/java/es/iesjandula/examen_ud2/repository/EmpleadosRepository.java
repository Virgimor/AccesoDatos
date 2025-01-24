package es.iesjandula.examen_ud2.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iesjandula.examen_ud2.dtos_clase.Consulta10;
import es.iesjandula.examen_ud2.dtos_clase.Consulta12;
import es.iesjandula.examen_ud2.dtos_clase.Consulta17Y30;
import es.iesjandula.examen_ud2.dtos_clase.Consulta19;
import es.iesjandula.examen_ud2.dtos_clase.Consulta1Y11Y14Y20;
import es.iesjandula.examen_ud2.dtos_clase.Consulta21;
import es.iesjandula.examen_ud2.dtos_clase.Consulta24;
import es.iesjandula.examen_ud2.dtos_clase.Consulta28;
import es.iesjandula.examen_ud2.dtos_clase.Consulta38;
import es.iesjandula.examen_ud2.dtos_clase.Consulta39Y44;
import es.iesjandula.examen_ud2.dtos_clase.Consulta47;
import es.iesjandula.examen_ud2.dtos_clase.Consulta4Y16;
import es.iesjandula.examen_ud2.dtos_clase.Consulta51;
import es.iesjandula.examen_ud2.dtos_clase.Consulta53;
import es.iesjandula.examen_ud2.dtos_clase.Consulta54;
import es.iesjandula.examen_ud2.dtos_clase.Consulta55;
import es.iesjandula.examen_ud2.dtos_clase.Consulta56;
import es.iesjandula.examen_ud2.dtos_clase.Consulta57;
import es.iesjandula.examen_ud2.dtos_clase.Consulta58;
import es.iesjandula.examen_ud2.dtos_clase.Consulta59;
import es.iesjandula.examen_ud2.dtos_clase.Consulta5Y26;
import es.iesjandula.examen_ud2.dtos_clase.Consulta60;
import es.iesjandula.examen_ud2.dtos_clase.Consulta61;
import es.iesjandula.examen_ud2.dtos_clase.Consulta63;
import es.iesjandula.examen_ud2.dtos_clase.Consulta67;
import es.iesjandula.examen_ud2.dtos_clase.Consulta70;
import es.iesjandula.examen_ud2.dtos_clase.Consulta71;
import es.iesjandula.examen_ud2.dtos_clase.Consulta76;
import es.iesjandula.examen_ud2.dtos_clase.Consulta77;
import es.iesjandula.examen_ud2.dtos_clase.Consulta83;
import es.iesjandula.examen_ud2.dtos_clase.Consulta88;
import es.iesjandula.examen_ud2.dtos_clase.Consulta89;
import es.iesjandula.examen_ud2.dtos_clase.Consulta9;
import es.iesjandula.examen_ud2.dtos_examen.Examen2;
import es.iesjandula.examen_ud2.dtos_examen.Examen3;
import es.iesjandula.examen_ud2.dtos_examen.Examen4;
import es.iesjandula.examen_ud2.dtos_examen.Examen6;
import es.iesjandula.examen_ud2.dtos_examen.Examen8;
import es.iesjandula.examen_ud2.dtos_examen.Examen9;
import es.iesjandula.examen_ud2.models.Empleados;

public interface EmpleadosRepository extends JpaRepository<Empleados, BigDecimal>
{
	@Query("SELECT e.nombre "
			+ "FROM Empleados e "
			+ "WHERE e.nombre LIKE '%w' OR e.nombre LIKE '%x'"
			+ "ORDER BY e.idEmpleado ASC ")
	Page<String> examen1(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_examen.Examen2(e.nombre, e.comisionPct) "
			+ "FROM Empleados e "
			+ "WHERE e.comisionPct is not null AND fechaContrato > :fechaContrato")
	Page<Examen2> examen2(Date fechaContrato, Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_examen.Examen3(d.nombreDepartamento, p.nombrePais) "
			+ "FROM Departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises p "
			+ "WHERE d.nombreDepartamento is not null AND p.nombrePais != 'Estados Unidos de América'")
	Page<Examen3> examen3(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_examen.Examen4(u.direccion, u.ciudad) "
			+ "FROM Ubicaciones u "
			+ "JOIN u.paises p "
			+ "JOIN p.regiones r "
			+ "WHERE r.nombreRegion != 'Américas' AND r.nombreRegion != 'Medio Oriente y África' AND r.nombreRegion != 'Europa' "
			+ "ORDER BY u.idUbicacion ASC")
	Page<Examen4> examen4(Pageable pageable);
	
	@Query("SELECT p.tituloPuesto "
			+ "FROM Puestos p "
			+ "WHERE (p.salarioMax - p.salarioMin) = "
				+ "(SELECT MIN(p2.salarioMax - p2.salarioMin) "
				+ "FROM Puestos p2) "
			+ "ORDER BY p.idPuesto ASC ")
	Page<String> examen5(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_examen.Examen6(g.nombre, g.apellido, COUNT(g.idEmpleado)) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "GROUP BY g.nombre,  g.apellido")
	Page<Examen6> examen6(Pageable pageable);
	
	@Query("SELECT p.tituloPuesto "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "WHERE e.puestos is null")
	Page<String> examen7(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_examen.Examen8(e.nombre, e.apellido, p.tituloPuesto, e.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "WHERE e.salario = "
				+ "(SELECT MAX(e2.salario) "
				+ "FROM Empleados e2 "
				+ "WHERE e.puestos = e2.puestos) "
			+ "ORDER BY e.salario,  p.tituloPuesto DESC")
	Page<Examen8> examen8(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_examen.Examen9(e.nombre, e.apellido) "
			+ "FROM Empleados e "
			+ "JOIN e.listaHistorialPuestos hp "
			+ "WHERE e.apellido LIKE '%z%' ")
	Page<Examen9> examen9(Pageable pageable);
	
//	====== CONSULTAS ANTIGUAS =======
	//1
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta1Y11Y14Y20(e.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d")
	Page<Consulta1Y11Y14Y20> encontrarEmpleadosConSusDepartamentos(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta4Y16(e.nombre, e.apellido, p.tituloPuesto) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p")
	Page<Consulta4Y16> encontrarNombreYApellidosEmpleadosConNombrePuesto(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta5Y26(e.nombre, e.apellido, g.nombre, g.apellido) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g")
	Page<Consulta5Y26> encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerente(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta9(e.nombre, e.apellido, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE d.nombreDepartamento = :nombreDepartamento")
	List<Consulta9> encontrarEmpleadosPorDepartamentoEspecifico(@Param("nombreDepartamento") String nombreDepartamento);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta1Y11Y14Y20(e.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE e.salario>=5000")
	Page<Consulta1Y11Y14Y20> encontrarEmpleadosConSueldoMayor5000ConSusDepartamentos(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta12(e.nombre, p.tituloPuesto, g.nombre) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "JOIN e.puestos p "
			+ "WHERE p.tituloPuesto = :tituloPuesto")
	List<Consulta12> encontrarEmpleadosConNombreGerentePorTitutloEspecifico(@Param("tituloPuesto") String tituloPuesto);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta1Y11Y14Y20(e.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE YEAR(e.fechaContrato) >= 2000")
	List<Consulta1Y11Y14Y20> encontrarEmpleadosConSusDepartamentosConContratoEspecifico(@Param("fechaContrato") Date fechaContrato);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta4Y16(e.nombre, e.apellido, p.tituloPuesto) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "WHERE e.apellido LIKE %:palabra")
	List<Consulta4Y16> encontrarNombreYApellidosTerminaEnSonConNombrePuesto(@Param("palabra") String palabra);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta17Y30(e.nombre, e.apellido) "
			+ "FROM Empleados e "
			+ "WHERE e.gerente is null")
	List<Consulta17Y30> encontrarNombreYApellidosEmpleadosSinGerente();
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta19(e.nombre, e.comisionPct, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE e.comisionPct is not null")
	Page<Consulta19> encontrarEmpleadosConComisionesYDepartamentos(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta1Y11Y14Y20(e.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE d.nombreDepartamento = 'Ventas' AND e.salario >= 7000")
	Page<Consulta1Y11Y14Y20> encontrarEmpleadosDeVentasQueGananMas7000(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta21(e.nombre, e.salario, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "ORDER BY e.salario DESC, d.nombreDepartamento DESC")
	Page<Consulta21> encontrarEmpleadosOrdenadosPorSalarioDescYNombreDepartamentos(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta24(e.nombre, e.fechaContrato, e.salario) "
			+ "FROM Empleados e "
			+ "ORDER BY e.fechaContrato ASC, e.salario DESC")
	Page<Consulta24> encontrarEmpleadosOrdenadoPorFechaDeContratoYSalario(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta5Y26(e.nombre, e.apellido, g.nombre, g.apellido) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "ORDER BY g.apellido ASC")
	Page<Consulta5Y26> encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerenteOrdenadosPorApellidoAsc(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta28(e.nombre, p.idPais, e.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises p "
			+ "WHERE p.idPais = 'IT' "
			+ "ORDER BY e.salario ASC")
	List<Consulta28> encontrarNombreEmpleadoDelPaisITOrdenadoPorSalario();
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta17Y30(e.nombre, e.apellido) "
			+ "FROM Empleados e "
			+ "WHERE e.gerente is null "
			+ "ORDER BY e.apellido ASC")
	List<Consulta17Y30> encontrarNombreYApellidosEmpleadosSinGerenteOrdenadosAlfabeticamente();
	
	@Query("SELECT DISTINCT new es.iesjandula.examen_ud2.dtos_clase.Consulta38(COUNT(e.idEmpleado), YEAR(e.fechaContrato)) "
			+ "FROM Empleados e "
			+ "GROUP BY e.fechaContrato")
	Page<Consulta38> obtenerEmpleadosContratadosEnCadaAnio(Pageable pageable);
	
	@Query("SELECT DISTINCT new es.iesjandula.examen_ud2.dtos_clase.Consulta39Y44(g.nombre, COUNT(e.idEmpleado)) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "GROUP BY g.nombre")
	Page<Consulta39Y44> listarEmpleadosAgrupadosPorGerenteYCuantosEmpleadosTiene(Pageable pageable);
	
	@Query("SELECT DISTINCT new es.iesjandula.examen_ud2.dtos_clase.Consulta39Y44(g.nombre, COUNT(e.idEmpleado)) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "GROUP BY g.nombre "
			+ "HAVING COUNT(e.idEmpleado) >= 5")
	List<Consulta39Y44> mostrarGerentesConMas5EmpleadosACargo();
	
	@Query("SELECT DISTINCT new es.iesjandula.examen_ud2.dtos_clase.Consulta47(e.nombre, p.tituloPuesto, AVG(e.salario)) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "GROUP BY p.tituloPuesto "
			+ "HAVING AVG(e.salario) >= 6000")
	Page<Consulta47> mostrarEmpleadosAgrupadosPorPuestoConSalarioPromedioMayor6000(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta51(e.nombre, p.tituloPuesto, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "JOIN e.departamentos d ")
	Page<Consulta51> mostrarEmpleadosPuestosYNombreDepartamentoQuePertenecen(Pageable pageable);

	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta53(e.nombre, g.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "JOIN e.departamentos d ")
	Page<Consulta53> mostrarEmpleadosGerenteYNombreDepartamentoQuePertenecen(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta54(e.nombre, p.tituloPuesto, d.nombreDepartamento, u.direccion) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u ")
	Page<Consulta54> mostrarEmpleadosPuestosYNombreDepartamentoYUbicaciones(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta55(e.nombre, pa.nombrePais, r.nombreRegion) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises pa "
			+ "JOIN pa.regiones r")
	Page<Consulta55> listarEmpleadosPaisesYRegiones(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta56(p.tituloPuesto, e.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "JOIN e.departamentos d "
			+ "ORDER BY e.salario") 
	Page<Consulta56> mostrarPuestosEmpleadosYDepartamentosOrdenadosPorSalario(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta57(e.nombre, d.nombreDepartamento, p.nombrePais) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises p ") 
	Page<Consulta57> obtenerEmpleadosNombreDepartamentoYPais(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta58(COUNT(e.idEmpleado), p.tituloPuesto, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN e.puestos p "
			+ "GROUP BY p.idPuesto") 
	Page<Consulta58> mostrarCantidadEmpleadosPorPuestoYNombreDepartamento(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta59(e.salario, d.nombreDepartamento, g.nombre) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN e.gerente g "
			+ "ORDER BY e.salario DESC") 
	Page<Consulta59> sarioMasAltoPorDepartamentoYNombreGerente(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta60(r.nombreRegion, COUNT(e.idEmpleado)) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises p "
			+ "JOIN p.regiones r "
			+ "GROUP BY r.idRegion ") 
	Page<Consulta60> listarEmpleadosPorRegionYSuCantidad(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta61(e.nombre, r.nombreRegion) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises p "
			+ "JOIN p.regiones r "
			+ "WHERE r.nombreRegion = :nombreRegion") 
	Page<Consulta61> obtenerEmpleadosCuandoDepartamentoUbicadoRegionAsia( String nombreRegion, Pageable pageable);
	
	@Query("SELECT e.nombre "
			+ "FROM Empleados e "
			+ "WHERE e.salario > ( "
				+ "SELECT AVG(e2.salario) "
				+ "FROM Empleados e2)") 
	Page<String> listarEmpleadosSalarioMayorALaMediaDeTodos(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta63(e.nombre, h.historialPuestosId.fechaInicio, h.fechaFin, h.puestos.idPuesto, h.departamentos.idDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.listaHistorialPuestos h") 
	Page<Consulta63> mostrarEmpleadosYElHistoricoDeSusPuestos(Pageable pageable);
	
	@Query("SELECT e.nombre "
			+ "FROM Empleados e "
			+ "JOIN e.listaHistorialPuestos h "
			+ "GROUP BY e.idEmpleado "
			+ "HAVING COUNT(h.empleados.idEmpleado) = 2 ")
	Page<String> listarEmpleadosQueHanCambiadoPuestoMasDeUnaVez(Pageable pageable);
	
//	@Query("SELECT e.nombre "
//			+ "FROM Empleados e "
//			+ "JOIN e.puestos p "
//			+ "WHERE e.salario < "
//				+ "(SELECT p2.salarioMax "
//				+ "FROM Puestos p2 "
//				+ "WHERE p.idPuesto = p2.idPuesto)")
	@Query("SELECT e.nombre "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "WHERE e.salario < e.puestos.salarioMax")
	Page<String> obtenerEmpleadosConSalarioMenorSalarioMaximoDelPuesto(Pageable pageable);

	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta67(e.nombre, e.salario, g.nombre, g.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "WHERE e.salario > g.salario")
	Page<Consulta67> mostrarEmpleadosCuyoGerenteTengaSalarioMenor(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta70(g.nombre, e.nombre, e.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "WHERE e.salario > 10000")
	Page<Consulta70> obtenerGerentesConEmpleadosCuyoSalarioMayor10000(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta71(d.nombreDepartamento, e.nombre, e.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE e.salario = "
				+ "(SELECT MAX(e2.salario) "
				+ "FROM Empleados e2 "
				+ "WHERE e2.departamentos = d)")
	Page<Consulta71> listarEmpleadosCuyoSarlarioMaximoDelDepartamento(Pageable pageable);
	
	@Query("SELECT e.nombre "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "WHERE e.salario = "
				+ "(SELECT MIN(e2.salario) "
				+ "FROM Empleados e2 "
				+ "JOIN e2.puestos p2 "
				+ "WHERE p.idPuesto = p2.idPuesto)")
	Page<String> obtenerEmpleadosConElSalarioMásBajoDeSuPuesto(Pageable pageable);
	
//	@Query("SELECT p.nombrePais "
//			+ "FROM Empleados e "
//			+ "right JOIN e.departamentos d "
//			+ "JOIN d.ubicaciones u "
//			+ "right JOIN u.paises p "
//			+ "WHERE u.paises is null ")
//	Page<String> obatenerEmpleadosTrabajanEnDepartamentosEnPaisesSinEmpleados(Pageable pageable);

	@Query("SELECT u.paises.nombrePais "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "WHERE u.paises.idPais in "
				+ "(SELECT p.idPais "
				+ "FROM Paises p "
				+ "WHERE p.idPais NOT IN "
					+ "(SELECT u.paises.idPais "
					+ "FROM Ubicaciones u))")
	Page<String> obatenerEmpleadosTrabajanEnDepartamentosEnPaisesSinEmpleados(Pageable pageable);
	
	@Query("SELECT DISTINCT new es.iesjandula.examen_ud2.dtos_clase.Consulta76(e.nombre, p.nombrePais, e.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises p "
			+ "WHERE e.salario < "
				+ "(SELECT MAX(e2.salario) "
				+ "FROM Empleados e2) "
			+ "GROUP BY p.nombrePais ")
	Page<Consulta76> listarEmpleadosConSalarioMasAltoDeSuPais(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta77(g.nombre, e.nombre, e.fechaContrato, g.fechaContrato) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "WHERE e.fechaContrato<g.fechaContrato")
	Page<Consulta77> mostrarEmpleadosContratadosDespuesDeSuGerente(Pageable pageable);

	@Query("SELECT e.nombre "
			+ "FROM Empleados e "
			+ "WHERE e.puestos.salarioMax > 20000")
	Page<String> listarEmpleadosConPuestosCuyoSalarioMaximoEsMayor20000(Pageable pageable);
	
	@Query("SELECT e.nombre "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "WHERE e.puestos.idPuesto IN "
				+ "(SELECT p.idPuesto "
				+ "FROM Empleados e2 "
				+ "GROUP BY e2.puestos.idPuesto)")
	Page<String> mostrarEmpleadosEnPuestosDondeNingunOtroEmpleadoHaTrabajado(Pageable pageable);
	
	@Query("SELECT e.nombre "
			+ "FROM Empleados e "
			+ "JOIN e.listaHistorialPuestos h "
			+ "GROUP BY e.idEmpleado "
			+ "HAVING COUNT(h.empleados.idEmpleado) > 1 ")
	Page<String> mostrarEmpleadosQueHanTenidoMasDe3CambiosDePusto(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta83(e.nombre, hp.puestos.tituloPuesto, hp.departamentos.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.listaHistorialPuestos hp "
			+ "WHERE hp.historialPuestosId.fechaInicio = "
				+ "(SELECT MIN(hp2.historialPuestosId.fechaInicio) "
				+ "FROM HistorialPuestos hp2 "
				+ "WHERE hp2.empleados.idEmpleado = e.idEmpleado)")
	Page<Consulta83> listarEmpleadosActualesJuntoConElPrimerPuestosYDepartamentoQueOcuparon(Pageable pageable);
	
	@Query("SELECT e.nombre "
			+ "FROM Empleados e "
			+ "WHERE e.salario > "
				+ "(SELECT e2.salario * 2 "
				+ "From Empleados e2 "
				+ "WHERE e.idEmpleado = e2.idEmpleado)")
	Page<String> obtenerEmpleadosCuyoSalarioSuperaElDobleDelSalarioDeOtroEmpleado(Pageable pageable);
	
	@Query("SELECT  g.nombre "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "WHERE g.idEmpleado is not null AND e.salario = "
				+ "(SELECT MAX(e2.salario) "
				+ "From Empleados e2)")
	Page<String> mostrarGerentesCuyosEmpleadosTienenElSalarioMaximoDeLaEmpresa(Pageable pageable);
	
	@Query("SELECT e.nombre "
			+ "FROM Empleados e "
			+ "JOIN e.listaHistorialPuestos hp "
			+ "GROUP BY e.idEmpleado, e.departamentos.nombreDepartamento "
			+ "HAVING COUNT(hp.empleados.idEmpleado) > 1 ")
	Page<String> listarEmpleadoConMasConMasDeUnHistorialDePuestosEnElMismoDepartamento(Pageable pageable);
	
	@Query("SELECT DISTINCT new es.iesjandula.examen_ud2.dtos_clase.Consulta88(e.nombre, hp.puestos.idPuesto) "
			+ "FROM Empleados e "
			+ "JOIN e.listaHistorialPuestos hp "
			+ "WHERE hp.puestos.idPuesto != e.puestos.idPuesto ")
	Page<Consulta88> obtenerEmpleadosConTitulosHistoricosDiferentesAlTituloActual(Pageable pageable);
	
	@Query("SELECT DISTINCT new es.iesjandula.examen_ud2.dtos_clase.Consulta89(e.nombre, hp.puestos.tituloPuesto, e.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.listaHistorialPuestos hp "
			+ "WHERE hp.puestos.idPuesto != e.puestos.idPuesto AND e.salario < (hp.puestos.salarioMin + hp.puestos.salarioMax)/2")
	Page<Consulta89> mostrarEmpleadosCuyoSalarioActualEsMenorQueElSalarioDeAlgunPuestoAnterior(Pageable pageable);
}
