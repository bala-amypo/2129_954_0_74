package com.example.demo.Service;

import com.example.demo.Entity.Vehicle;

public interface VehicleService {
    Vehicle addVehicle(Long userId, Vehicle vehicle);
}