package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private Integer year;
    private Integer mileage;
    private Boolean isRented;
    private String model;
    private String license;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;


    public Car(Integer year, Integer mileage, Boolean isRented, String model, String license, BigDecimal price) {
        this.year = year;
        this.mileage = mileage;
        this.isRented = isRented;
        this.model = model;
        this.license = license;
        this.price = price;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer productID) {
        this.pid = productID;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Boolean getIsRented() {
        return isRented;
    }

    public void setIsRented(Boolean rented) {
        isRented = rented;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model.toUpperCase();
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license.toUpperCase();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "productID=" + pid +
                ", year=" + year +
                ", mileage=" + mileage +
                ", isRented=" + isRented +
                ", model='" + model + '\'' +
                ", license='" + license + '\'' +
                ", price=" + price +
                '}';
    }
}
