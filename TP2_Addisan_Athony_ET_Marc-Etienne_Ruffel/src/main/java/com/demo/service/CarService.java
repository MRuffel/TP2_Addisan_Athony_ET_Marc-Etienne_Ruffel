package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> listAll() {
        return carRepository.findAll();
    }

    public List<Car> listRented() {
        List<Car> rentedList = new ArrayList<>();
        carRepository.findAll().forEach(car -> {
            if (car.getIsRented()) {
                rentedList.add(car);
            }
        });
        return rentedList;
    }

    public void rentCar(Integer pid) {
        Car car = carRepository.findById(pid).orElseThrow(() -> new IllegalStateException("Car with pid=" + pid + "does not exist."));
        if (car.getIsRented()) {
            throw new IllegalStateException("Car with pid=" + pid + " is already rented.");
        } else {
            car.setIsRented(true);
        }
    }

    public void returnCar(Integer pid) {
        Car car = carRepository.findById(pid).orElseThrow(() -> new IllegalStateException("Car with pid=" + pid + "does not exist."));
        if (!car.getIsRented()) {
            throw new IllegalStateException("Car with pid=" + pid + " is not rented. Cannot return a car that is not rented...");
        } else {
            car.setIsRented(false);
        }
    }


}
