
package com.uisrael.repository;

import com.uisrael.entity.Simulacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulacionRepository extends JpaRepository<Simulacion, Long> {

}