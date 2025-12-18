package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}