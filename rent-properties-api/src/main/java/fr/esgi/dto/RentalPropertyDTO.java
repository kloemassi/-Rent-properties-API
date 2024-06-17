package fr.esgi.dto;

import fr.esgi.domain.RentalPropertyEntity;

public class RentalPropertyDTO {
    private String address;
    private Double area;
    private String description;
    private String propertyType;
    private Double rentAmount;
    private Double securityDepositAmount;
    private String town;

    // Getters and Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    // Static method to convert from entity to DTO
    public static RentalPropertyDTO fromEntity(RentalPropertyEntity entity) {
        RentalPropertyDTO dto = new RentalPropertyDTO();

        dto.setAddress(entity.getAddress());
        dto.setArea(entity.getArea());
        dto.setDescription(entity.getDescription());
        dto.setPropertyType(entity.getPropertyType());
        dto.setRentAmount(entity.getRentAmount());
        dto.setSecurityDepositAmount(entity.getSecurityDepositAmount());
        dto.setTown(entity.getTown());

        return dto;
    }

    // Method to convert from DTO to entity
    public RentalPropertyEntity toEntity() {
        RentalPropertyEntity entity = new RentalPropertyEntity();

        entity.setAddress(this.getAddress());
        entity.setArea(this.getArea());
        entity.setDescription(this.getDescription());
        entity.setPropertyType(this.getPropertyType());
        entity.setRentAmount(this.getRentAmount());
        entity.setSecurityDepositAmount(this.getSecurityDepositAmount());
        entity.setTown(this.getTown());

        return entity;
    }
}
