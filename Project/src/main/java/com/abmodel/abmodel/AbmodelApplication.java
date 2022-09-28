package com.abmodel.abmodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbmodelApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbmodelApplication.class, args);

		/* System.out.println("~~~~~~~ Prueba de la entidad Empresa ~~~~~~~");
		Empresa empresa = new Empresa("Google", "Cll 15 #45.-34", "16541651", "545456");
		System.out.println("Empresa: " + empresa.getNombre() + " - " + empresa.getDireccion()
				+ " - " + empresa.getTelefono() + " - "+ empresa.getNit());

		empresa.setNombre("Facebook");
		System.out.println("Nombre actualizado: " + empresa.getNombre() + " - " + empresa.getDireccion()
				+ " - " + empresa.getTelefono() + " - "+ empresa.getNit());

		empresa.setDireccion("Cra. 12 #06-34");
		System.out.println("Direccion actualizada: " + empresa.getNombre() + " - " + empresa.getDireccion()
				+ " - " + empresa.getTelefono() + " - "+ empresa.getNit());

		empresa.setTelefono("3154846515");
		System.out.println("Telefono actualizado: " + empresa.getNombre() + " - " + empresa.getDireccion()
				+ " - " + empresa.getTelefono() + " - "+ empresa.getNit());

		empresa.setNit("8588");
		System.out.println("Nit actualizado: " + empresa.getNombre() + " - " + empresa.getDireccion()
				+ " - " + empresa.getTelefono() + " - "+ empresa.getNit());

		System.out.println("~~~~~~~ Prueba de la entidad Empleado ~~~~~~~");
		Empleado empleado = new Empleado(1, "Juan Lozano", "juan@gmail.com", empresa, Enum_RoleName.ADMIN);

		System.out.println("Empleado: " + empleado.getNombre() + " - " + empleado.getEmail() + " - "
				+ empleado.getEmpresa().getNombre() + " - " + empleado.getRol());

		empleado.setNombre("Juan Carlos Lozano");
		System.out.println("Nombre actualizado: "+ empleado.getNombre() + " - " + empleado.getEmail() + " - "
				+ empleado.getEmpresa().getNombre() + " - " + empleado.getRol());

		empleado.setEmail("juanCarlos@gmail.com");
		System.out.println("Correo actualizado: " + empleado.getNombre() + " - " + empleado.getEmail() + " - "
				+ empleado.getEmpresa().getNombre() + " - " + empleado.getRol());

		Empresa nuevaEmpresa = new Empresa("Amazon", "Transversal 2 #6A-4", "245365", "54467");
		empleado.setEmpresa(nuevaEmpresa);
		System.out.println("Nueva empresa: "  + empleado.getNombre() + " - " + empleado.getEmail() + " - "
				+ empleado.getEmpresa().getNombre() + " - " + empleado.getRol());

		empleado.setRol(Enum_RoleName.OPERARIO);
		System.out.println("Rol actualizado: " + empleado.getNombre() + " - " + empleado.getEmail() + " - "
				+ empleado.getEmpresa().getNombre() + " - " + empleado.getRol());


		System.out.println("~~~~~~~ Prueba de la entidad MovimientoDinero ~~~~~~~");
		MovimientoDinero transaccion = new MovimientoDinero(5, "Pago de deuda", 2000000, empleado);
		System.out.println("Transaccion: " + transaccion.getConcepto() + " - " + transaccion.getMonto() + " - " +
				transaccion.getEmpleado().getNombre());

		transaccion.setMonto(2500000);
		System.out.println("Monto actualizado: " + transaccion.getConcepto() + " - " + transaccion.getMonto() + " - "
							+ " - " + transaccion.getEmpleado().getNombre());

		transaccion.setMonto(-1000000);
		System.out.println("Monto negativo: " + transaccion.getConcepto() + " - " + transaccion.getMonto() + " - "
				+ " - " + transaccion.getEmpleado().getNombre());

		transaccion.setConcepto("Prestamo");
		System.out.println("Monto negativo: " + transaccion.getConcepto() + " - " + transaccion.getMonto() + " - "
				+ " - " + transaccion.getEmpleado().getNombre());

		transaccion.setEmpleado(new Empleado(23, "Camilo", "camilo@gmail.com", empresa, Enum_RoleName.OPERARIO));
		System.out.println("Actualizacion de empleado: " + transaccion.getConcepto() + " - " + transaccion.getMonto() + " - "
				+ " - " + transaccion.getEmpleado().getNombre());*/
	}

}
