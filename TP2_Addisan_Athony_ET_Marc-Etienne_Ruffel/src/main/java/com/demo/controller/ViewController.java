package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String home(Model model) {
        List<Car> carList = carService.listAll();
        model.addAttribute("carList", carList);
        return "index.html";
    }

    @GetMapping("/rented")
    public String rented(Model model) {
        List<Car> rentedList = carService.listRented();
        model.addAttribute("rentedList", rentedList);
        return "rented.html";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error.html";
    }
}
