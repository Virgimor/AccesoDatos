package ies.jandula.empleados.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ies.jandula.empleados.dtos.Consulta27Y31Y36;
import ies.jandula.empleados.dtos.Consulta32;
import ies.jandula.empleados.dtos.Consulta37Y43;
import ies.jandula.empleados.dtos.Consulta40;
import ies.jandula.empleados.dtos.Consulta41;
import ies.jandula.empleados.dtos.Consulta74;
import ies.jandula.empleados.dtos.Consulta8;
import ies.jandula.empleados.models.Departamentos;

public interface DepartamentoRepository extends JpaRepository<Departamentos, BigDecimal>{
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta8(d.nombreDepartamento, u.ciudad) "
			+ "FROM Departamentos d "
			+ "JOIN d.ubicaciones u")
	List<Consulta8> encontrarDepartamentoConNombreUbicacion();
	
	@Query("SELECT DISTINCT d.nombreDepartamento "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "WHERE e.salario >=10000")
	List<String> encontrarDepartamentoConEmpleadosYElSalarioMayor10000();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta27Y31Y36(d.nombreDepartamento, COUNT(e.idEmpleado) AS cantidadEmpleados) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "GROUP BY d.nombreDepartamento "
			+ "ORDER BY cantidadEmpleados DESC")
	List<Consulta27Y31Y36> encontrarDepartamentoOrdenadosPorCantidadEmpleados();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta27Y31Y36(d.nombreDepartamento, COUNT(e.idEmpleado) AS cantidadEmpleados) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "GROUP BY d.nombreDepartamento ")
	List<Consulta27Y31Y36> encontrarDepartamentoPorCantidadEmpleados();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta32(AVG(e.salario), d.nombreDepartamento) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "GROUP BY d.nombreDepartamento ")
	List<Consulta32> encontrarSalarioPromedioDeCadaDepartamento();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta27Y31Y36(d.nombreDepartamento, COUNT(e.idEmpleado) AS cantidadEmpleados) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "GROUP BY d.nombreDepartamento "
			+ "HAVING COUNT(e.idEmpleado)>=5")
	List<Consulta27Y31Y36> encontrarDepartamentoConMas5Empleados();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta37Y43(d.nombreDepartamento, SUM(e.salario)) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "GROUP BY d.nombreDepartamento ")
	List<Consulta37Y43> mostrarSumaSalariosPorDepartamentos();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta40(d.nombreDepartamento, AVG(e.salario)) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "GROUP BY d.nombreDepartamento "
			+ "HAVING AVG(e.salario)>=8000")
	List<Consulta40> obtenerDepartamentosConSalarioPromedioEmpleadosMayorA8000();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta41(d.nombreDepartamento, COUNT(e.idEmpleado)) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "GROUP BY d.nombreDepartamento "
			+ "HAVING COUNT(e.idEmpleado)>=10")
	List<Consulta41> mostrarDepartamentosConMas10Empleados();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta37Y43(d.nombreDepartamento, SUM(e.salario)) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "GROUP BY d.nombreDepartamento "
			+ "HAVING SUM(e.salario) >= 50000")
	List<Consulta37Y43> listarDepartamentosConSalarioMayor50000();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta40(d.nombreDepartamento, AVG(e.salario)) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "GROUP BY d.nombreDepartamento "
			+ "HAVING AVG(e.salario)> 9000")
	List<Consulta40> obtenerDepartamentosConSalarioPromedioEmpleadosMayorA9000();
	
	@Query("SELECT d.nombreDepartamento "
			+ "FROM Departamentos d "
			+ "LEFT JOIN d.listaEmpleados e "
			+ "WHERE e.idEmpleado is null")
	Page<String> listarDepartamentosSinEmpleados(Pageable pageable);
	
	@Query("SELECT DISTINCT d.nombreDepartamento "
			+ "FROM Departamentos d "
			+ "WHERE NOT EXISTS "
				+ "(SELECT e "
				+ "FROM Empleados e "
				+ "WHERE e.departamentos = d AND e.salario <= 5000)")
	Page<String> mostrarDepartamentosDondeTodosEmpleadosGanan5000(Pageable pageable);
//	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta74(d.nombreDepartamento, AVG(e.salario)) "
			+ "FROM Departamentos d "
			+ "JOIN d.listaEmpleados e "
			+ "GROUP BY d.nombreDepartamento "
			+ "HAVING AVG(e.salario) > "
				+ "(SELECT AVG(e2.salario) "
				+ "FROM Empleados e2 "
				+ "GROUP BY d.nombreDepartamento)")
	Page<Consulta74> mostrarDepartamentosCuyoSalarioPromedioSuperaAlSalarioPromedioDeLosDemasDepartamentos(Pageable pageable);
	
	@Query("SELECT d.nombreDepartamento "
			+ "FROM Departamentos d "
			+ "JOIN d.listaEmpleados e "
			+ "GROUP BY d.nombreDepartamento "
			+ "HAVING COUNT(e.idEmpleado) > "
				+ "(SELECT COUNT(e2.idEmpleado ) "
				+ "FROM Departamentos d2 "
				+ "JOIN d2.listaEmpleados e2 "
				+ "WHERE d2.nombreDepartamento = 'Ventas' "
				+ "GROUP BY d2.nombreDepartamento) ")
	Page<String> obtenerDepartamentosConMasEmpleadosQueElDepartamentoVentas(Pageable pageable);
	
	@Query("SELECT d.nombreDepartamento "
			+ "FROM Departamentos d "
			+ "JOIN d.listaHistorialPuestos hp "
			+ "GROUP BY hp.empleados.idEmpleado, d.nombreDepartamento "
			+ "HAVING COUNT(hp.empleados.idEmpleado) < 2 ")
	Page<String> mostrarDepartamentosDondeNoSeHaRegistradoNingunCambioDePuesto(Pageable pageable);

}
