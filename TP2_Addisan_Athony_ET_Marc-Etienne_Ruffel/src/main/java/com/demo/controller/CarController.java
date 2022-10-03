package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/rent/{pid}")
    public ModelAndView rentCar(@PathVariable("pid") Integer pid, Model model) {
        try {
            carService.rentCar(pid);
        } catch (IllegalStateException e) {
            return new ModelAndView("redirect:/error");
        }
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/return/{pid}")
    public ModelAndView returnCar(@PathVariable("pid") Integer pid) {
        try {
            carService.returnCar(pid);
        } catch (IllegalStateException e) {
            return new ModelAndView("redirect:/error");
        }

        return new ModelAndView("redirect:/");
    }
}
