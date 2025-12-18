package com.example.demo.Repository;

import org.springframework.data.jpa.Repository.JpaRepository;
import com.example.demo.Entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}