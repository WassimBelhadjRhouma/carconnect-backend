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

  @Query("SELECT c FROM Car c WHERE c.id = :id")
    CarProjection findCarById(@Param("id") Long id);   

    @Query("SELECT c FROM Car c WHERE " +
           "(:make IS NULL OR c.make = :make) AND " +
           "(:fuelType IS NULL OR c.fuelType = :fuelType) AND " +
           "(:model IS NULL OR c.model = :model) AND " +
           "(:drivingMode IS NULL OR c.drivingMode = :drivingMode) AND " +
           "(:minPrice IS NULL OR c.pricePerDay >= :minPrice) AND " +
           "(:maxPrice IS NULL OR c.pricePerDay <= :maxPrice)")
    List<CarProjection> findCarsWithFilters(
            @Param("make") String make,
            @Param("fuelType") String fuelType,
            @Param("model") String model,
            @Param("drivingMode") String drivingMode,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice);

}
