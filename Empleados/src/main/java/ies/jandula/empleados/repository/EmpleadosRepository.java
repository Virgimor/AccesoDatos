package ies.jandula.empleados.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ies.jandula.empleados.dtos.Consulta12;
import ies.jandula.empleados.dtos.Consulta17Y30;
import ies.jandula.empleados.dtos.Consulta19;
import ies.jandula.empleados.dtos.Consulta1Y11Y14Y20;
import ies.jandula.empleados.dtos.Consulta21;
import ies.jandula.empleados.dtos.Consulta24;
import ies.jandula.empleados.dtos.Consulta28;
import ies.jandula.empleados.dtos.Consulta38;
import ies.jandula.empleados.dtos.Consulta39Y44;
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
import ies.jandula.empleados.dtos.Consulta67;
import ies.jandula.empleados.dtos.Consulta70;
import ies.jandula.empleados.dtos.Consulta71;
import ies.jandula.empleados.dtos.Consulta76;
import ies.jandula.empleados.dtos.Consulta9;
import ies.jandula.empleados.models.Empleados;

public interface EmpleadosRepository extends JpaRepository<Empleados, BigDecimal>{
	
	//1
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta1Y11Y14Y20(e.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d")
	Page<Consulta1Y11Y14Y20> encontrarEmpleadosConSusDepartamentos(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta4Y16(e.nombre, e.apellido, p.tituloPuesto) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p")
	Page<Consulta4Y16> encontrarNombreYApellidosEmpleadosConNombrePuesto(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta5Y26(e.nombre, e.apellido, g.nombre, g.apellido) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g")
	Page<Consulta5Y26> encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerente(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta9(e.nombre, e.apellido, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE d.nombreDepartamento = :nombreDepartamento")
	List<Consulta9> encontrarEmpleadosPorDepartamentoEspecifico(@Param("nombreDepartamento") String nombreDepartamento);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta1Y11Y14Y20(e.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE e.salario>=5000")
	Page<Consulta1Y11Y14Y20> encontrarEmpleadosConSueldoMayor5000ConSusDepartamentos(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta12(e.nombre, p.tituloPuesto, g.nombre) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "JOIN e.puestos p "
			+ "WHERE p.tituloPuesto = :tituloPuesto")
	List<Consulta12> encontrarEmpleadosConNombreGerentePorTitutloEspecifico(@Param("tituloPuesto") String tituloPuesto);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta1Y11Y14Y20(e.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE YEAR(e.fechaContrato) >= 2000")
	List<Consulta1Y11Y14Y20> encontrarEmpleadosConSusDepartamentosConContratoEspecifico(@Param("fechaContrato") Date fechaContrato);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta4Y16(e.nombre, e.apellido, p.tituloPuesto) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "WHERE e.apellido LIKE %:palabra")
	List<Consulta4Y16> encontrarNombreYApellidosTerminaEnSonConNombrePuesto(@Param("palabra") String palabra);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta17Y30(e.nombre, e.apellido) "
			+ "FROM Empleados e "
			+ "WHERE e.gerente is null")
	List<Consulta17Y30> encontrarNombreYApellidosEmpleadosSinGerente();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta19(e.nombre, e.comisionPct, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE e.comisionPct is not null")
	Page<Consulta19> encontrarEmpleadosConComisionesYDepartamentos(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta1Y11Y14Y20(e.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE d.nombreDepartamento = 'Ventas' AND e.salario >= 7000")
	Page<Consulta1Y11Y14Y20> encontrarEmpleadosDeVentasQueGananMas7000(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta21(e.nombre, e.salario, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "ORDER BY e.salario DESC, d.nombreDepartamento DESC")
	Page<Consulta21> encontrarEmpleadosOrdenadosPorSalarioDescYNombreDepartamentos(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta24(e.nombre, e.fechaContrato, e.salario) "
			+ "FROM Empleados e "
			+ "ORDER BY e.fechaContrato ASC, e.salario DESC")
	Page<Consulta24> encontrarEmpleadosOrdenadoPorFechaDeContratoYSalario(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta5Y26(e.nombre, e.apellido, g.nombre, g.apellido) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "ORDER BY g.apellido ASC")
	Page<Consulta5Y26> encontrarNombreYApellidosEmpleadosConNombreYApellidosDelGerenteOrdenadosPorApellidoAsc(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta28(e.nombre, p.idPais, e.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises p "
			+ "WHERE p.idPais = 'IT' "
			+ "ORDER BY e.salario ASC")
	List<Consulta28> encontrarNombreEmpleadoDelPaisITOrdenadoPorSalario();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta17Y30(e.nombre, e.apellido) "
			+ "FROM Empleados e "
			+ "WHERE e.gerente is null "
			+ "ORDER BY e.apellido ASC")
	List<Consulta17Y30> encontrarNombreYApellidosEmpleadosSinGerenteOrdenadosAlfabeticamente();
	
	@Query("SELECT DISTINCT new ies.jandula.empleados.dtos.Consulta38(COUNT(e.idEmpleado), YEAR(e.fechaContrato)) "
			+ "FROM Empleados e "
			+ "GROUP BY e.fechaContrato")
	Page<Consulta38> obtenerEmpleadosContratadosEnCadaAnio(Pageable pageable);
	
	@Query("SELECT DISTINCT new ies.jandula.empleados.dtos.Consulta39Y44(g.nombre, COUNT(e.idEmpleado)) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "GROUP BY g.nombre")
	Page<Consulta39Y44> listarEmpleadosAgrupadosPorGerenteYCuantosEmpleadosTiene(Pageable pageable);
	
	@Query("SELECT DISTINCT new ies.jandula.empleados.dtos.Consulta39Y44(g.nombre, COUNT(e.idEmpleado)) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "GROUP BY g.nombre "
			+ "HAVING COUNT(e.idEmpleado) >= 5")
	List<Consulta39Y44> mostrarGerentesConMas5EmpleadosACargo();
	
	@Query("SELECT DISTINCT new ies.jandula.empleados.dtos.Consulta47(e.nombre, p.tituloPuesto, AVG(e.salario)) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "GROUP BY p.tituloPuesto "
			+ "HAVING AVG(e.salario) >= 6000")
	Page<Consulta47> mostrarEmpleadosAgrupadosPorPuestoConSalarioPromedioMayor6000(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta51(e.nombre, p.tituloPuesto, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "JOIN e.departamentos d ")
	Page<Consulta51> mostrarEmpleadosPuestosYNombreDepartamentoQuePertenecen(Pageable pageable);

	@Query("SELECT new ies.jandula.empleados.dtos.Consulta53(e.nombre, g.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "JOIN e.departamentos d ")
	Page<Consulta53> mostrarEmpleadosGerenteYNombreDepartamentoQuePertenecen(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta54(e.nombre, p.tituloPuesto, d.nombreDepartamento, u.direccion) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u ")
	Page<Consulta54> mostrarEmpleadosPuestosYNombreDepartamentoYUbicaciones(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta55(e.nombre, pa.nombrePais, r.nombreRegion) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises pa "
			+ "JOIN pa.regiones r")
	Page<Consulta55> listarEmpleadosPaisesYRegiones(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta56(p.tituloPuesto, e.nombre, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "JOIN e.departamentos d "
			+ "ORDER BY e.salario") 
	Page<Consulta56> mostrarPuestosEmpleadosYDepartamentosOrdenadosPorSalario(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta57(e.nombre, d.nombreDepartamento, p.nombrePais) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises p ") 
	Page<Consulta57> obtenerEmpleadosNombreDepartamentoYPais(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta58(COUNT(e.idEmpleado), p.tituloPuesto, d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN e.puestos p "
			+ "GROUP BY p.idPuesto") 
	Page<Consulta58> mostrarCantidadEmpleadosPorPuestoYNombreDepartamento(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta59(e.salario, d.nombreDepartamento, g.nombre) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN e.gerente g "
			+ "ORDER BY e.salario DESC") 
	Page<Consulta59> sarioMasAltoPorDepartamentoYNombreGerente(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta60(r.nombreRegion, COUNT(e.idEmpleado)) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises p "
			+ "JOIN p.regiones r "
			+ "GROUP BY r.idRegion ") 
	Page<Consulta60> listarEmpleadosPorRegionYSuCantidad(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta61(e.nombre, r.nombreRegion) "
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
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta63(e.nombre, h.historialPuestosId.fechaInicio, h.fechaFin, h.puestos.idPuesto, h.departamentos.idDepartamento) "
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

	@Query("SELECT new ies.jandula.empleados.dtos.Consulta67(e.nombre, e.salario, g.nombre, g.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "WHERE e.salario > g.salario")
	Page<Consulta67> mostrarEmpleadosCuyoGerenteTengaSalarioMenor(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta70(g.nombre, e.nombre, e.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "WHERE e.salario > 10000")
	Page<Consulta70> obtenerGerentesConEmpleadosCuyoSalarioMayor10000(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta71(d.nombreDepartamento, e.nombre, e.salario) "
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
	
	@Query("SELECT DISTINCT new ies.jandula.empleados.dtos.Consulta76(e.nombre, p.nombrePais, e.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises p "
			+ "WHERE e.salario < "
				+ "(SELECT MAX(e2.salario) "
				+ "FROM Empleados e2) "
			+ "GROUP BY p.nombrePais ")
	Page<Consulta76> listarEmpleadosConSalarioMasAltoDeSuPais(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta70(g.nombre, e.nombre, e.salario) "
			+ "FROM Empleados e "
			+ "JOIN e.gerente g "
			+ "WHERE e.salario > 10000")
	Page<Consulta70> mostrarEmpleadosContratadosDespuesDeSuGerente(Pageable pageable);
	
}
