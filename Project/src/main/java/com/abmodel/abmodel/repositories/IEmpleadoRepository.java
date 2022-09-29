package com.abmodel.abmodel.repositories;

import com.abmodel.abmodel.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {
    @Query("SELECT e FROM Empleado e WHERE e.email = ?1 and e.password = ?2")
    List<Empleado> validaCredenciales(String usuario, String password);
}
