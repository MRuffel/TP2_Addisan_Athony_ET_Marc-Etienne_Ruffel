package com.example.demo.config;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class CarConfig {
    @Bean
    CommandLineRunner commandLineRunner(CarRepository carRepository) {
        return args -> {
            Car car1 =  new Car(2022, 6201, false, "MERCEDES E53", "A12 BCD", new BigDecimal("49000"));
            Car car2 = new Car(2019, 92038, false, "ACURA TL", "T72 DGH", new BigDecimal("24000"));
            Car car3 = new Car(2009, 290000, false, "CADILLAC CTS", "I92 DUH", new BigDecimal("8009"));
            Car car4 = new Car(2021, 178892, false, "TOYOTA CAMRY", "K38 HDJ", new BigDecimal("15000"));
            Car car5 = new Car(2014, 178892, false, "HONDA ACCORD", "B42 JHF", new BigDecimal("6000"));

            carRepository.saveAll(List.of(car1, car2, car3, car4, car5));
        };
    }
}
