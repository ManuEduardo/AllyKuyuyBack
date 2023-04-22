package com.app.AylluKuyuy.repositories;

import com.app.AylluKuyuy.modelos.Plan_Personalizado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan_Personalizado, Integer> {
}
