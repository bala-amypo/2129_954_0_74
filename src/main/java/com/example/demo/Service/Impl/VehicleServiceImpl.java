package com.example.demo.Service;

import org.springframework.stereotype.Service;
import com.example.demo.Entity.User;
import com.example.demo.Entity.Vehicle;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.Vehiclerepo;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final Vehiclerepo vehicleRepo;
    private final Userrepo userRepo;

    public VehicleServiceImpl(Vehiclerepo vehicleRepo, Userrepo userRepo) {
        this.vehicleRepo = vehicleRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Vehicle addVehicle(Long userId, Vehicle vehicle) {

        if (vehicle.getCapacityKg() <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        vehicle.setUser(user);
        return vehicleRepo.save(vehicle);
    }
}