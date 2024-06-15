package fr.esgi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "rental_car")
public class RentalCarEntity
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id") private Integer id;
    @NotNull(message = "brand is mandatory")
    @Column(name = "brand") private String brand;
    @NotNull(message = "model is mandatory")
    @Column(name = "model") private String model;
    @NotNull(message = "rent_amount is mandatory and must be greater than 0")
    @Positive(message = "rent_amount must be greater than 0")
    @Column(name = "rent_amount") private Double rentAmount;
    @NotNull(message = "security_deposit_amount is mandatory and must be greater than 0")
    @Positive(message = "security_deposit_amount must be greater than 0")
    @Column(name = "security_deposit_amount") private Double securityDepositAmount;
    @Positive(message = "number_of_seats must be greater than 0")
    @Column(name = "number_of_seats") private Integer numberOfSeats;
    @Positive(message = "number_of_doors should be positive")
    @Column(name = "number_of_doors") private Integer numberOfDoors;
    @Column(name = "has_air_conditioning")
    private Boolean hasAirConditioning;

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(Double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public Double getSecurityDepositAmount() {
        return securityDepositAmount;
    }

    public void setSecurityDepositAmount(Double securityDepositAmount) {
        this.securityDepositAmount = securityDepositAmount;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Boolean getHasAirConditioning() {
        return hasAirConditioning;
    }

    public void setHasAirConditioning(Boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }
}
