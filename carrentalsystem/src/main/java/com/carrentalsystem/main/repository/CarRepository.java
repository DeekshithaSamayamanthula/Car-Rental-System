package com.carrentalsystem.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrentalsystem.main.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
