package com.abmodel.abmodel.repositories;

import com.abmodel.abmodel.entities.Empresa;
import com.abmodel.abmodel.entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {
    @Query("SELECT t FROM Transaccion t WHERE t.empresa =? 1")
    List<Transaccion> buscarPorEmpresa(Empresa empresa);
}
