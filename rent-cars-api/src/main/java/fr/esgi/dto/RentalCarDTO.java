package fr.esgi.dto;

import fr.esgi.domain.RentalCarEntity;

public class RentalCarDTO {
    private String brand;
    private String model;
    private Double rentAmount;
    private Double securityDepositAmount;
    private Integer numberOfSeats;
    private Integer numberOfDoors;
    private Boolean hasAirConditioning;
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

    public static RentalCarDTO fromEntity(RentalCarEntity entity) {
        RentalCarDTO dto = new RentalCarDTO();

        dto.setBrand(entity.getBrand());
        dto.setModel(entity.getModel());
        dto.setRentAmount(entity.getRentAmount());
        dto.setSecurityDepositAmount(entity.getSecurityDepositAmount());
        dto.setNumberOfSeats(entity.getNumberOfSeats());
        dto.setNumberOfDoors(entity.getNumberOfDoors());
        dto.setHasAirConditioning(entity.getHasAirConditioning());

        return dto;
    }

    public RentalCarEntity toEntity() {
        RentalCarEntity entity = new RentalCarEntity();

        entity.setBrand(this.getBrand());
        entity.setModel(this.getModel());
        entity.setRentAmount(this.getRentAmount());
        entity.setSecurityDepositAmount(this.getSecurityDepositAmount());
        entity.setNumberOfSeats(this.getNumberOfSeats());
        entity.setNumberOfDoors(this.getNumberOfDoors());
        entity.setHasAirConditioning(this.getHasAirConditioning());

        return entity;
    }
}
