package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Plan_Personalizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface PlanRepository extends JpaRepository<Plan_Personalizado, Integer> {
    @Query("select p from Plan_Personalizado p inner join Familias f on f.idfamilia = p.idfamilia where f.codigo_familiar = :codigo_familiar")
    ArrayList<Plan_Personalizado> getPlanes(@Param("codigo_familiar") int codigo_familiar);

}
