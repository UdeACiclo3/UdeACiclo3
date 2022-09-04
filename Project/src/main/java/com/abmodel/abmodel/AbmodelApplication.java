package com.abmodel.abmodel;

import com.abmodel.abmodel.entities.Empresa;
import com.abmodel.abmodel.entities.Empleado;
import com.abmodel.abmodel.entities.Enum_RoleName;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class AbmodelApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AbmodelApplication.class, args);
		System.out.println("~~~~~~~ Prueba de la entidad empresa ~~~~~~~");
		Empresa empresa1 = new Empresa("SIGMI", "CRA 27 14 - 61", "486595", "25252652");
		System.out.println("El nombre de la empresa es "+empresa1.getNombreempresa());

		empresa1.setNombreempresa("UTEMPO");

		System.out.println("El nuevo nombre es :"+empresa1.getNombreempresa());

		System.out.println("~~~~~~~ Prueba de la entidad Empleado ~~~~~~~");
		Empleado empleado = new Empleado(1, "Juan Lozano", "juan@gmail.com", empresa1, Enum_RoleName.ADMIN);

		System.out.println("Nombre: " + empleado.getNombre());
		empleado.setNombre("Juan Carlos Lozano");
		System.out.println("Nombre actualizado: " + empleado.getNombre());

		System.out.println("Correo: " + empleado.getEmail());
		empleado.setEmail("juanCarlos@gmail.com");
		System.out.println("Correo actualizado: " + empleado.getEmail());

		System.out.println("Empresa: " + empleado.getEmpresa().getNombreempresa() + " - " +
				empleado.getEmpresa().getDireccion() + " - " + empleado.getEmpresa().getTelefono() + " - " +
				empleado.getEmpresa().getNit() );
		empleado.setEmpresa(new Empresa("Argos", "Cll.15 #45-09", "74569856", "5844558411"));
		System.out.println("Empresa actualizado: " + empleado.getEmpresa().getNombreempresa() + " - " +
				empleado.getEmpresa().getDireccion() + " - " + empleado.getEmpresa().getTelefono() + " - " +
				empleado.getEmpresa().getNit() );

		System.out.println("Rol: " + empleado.getRol().name());
		empleado.setRol(Enum_RoleName.OPERARIO);
		System.out.println("Rol actualizado: " + empleado.getRol().name());
	}

}
