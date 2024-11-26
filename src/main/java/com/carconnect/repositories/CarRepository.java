package com.carconnect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carconnect.dto.projection.CarProjection;
import com.carconnect.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
@Query("SELECT c FROM Car c")
    List<CarProjection> findAllProjectedBy();
    
  @Query("SELECT c FROM Car c WHERE c.id = :id")
    CarProjection findCarById(@Param("id") Long id);   
}
