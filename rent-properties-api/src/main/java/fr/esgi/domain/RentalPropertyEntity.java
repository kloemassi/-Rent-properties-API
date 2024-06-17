package fr.esgi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "rental_property")
public class RentalPropertyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Description is mandatory")
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Town is mandatory")
    @Column(name = "town")
    private String town;

    @NotBlank(message = "Address is mandatory")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "Property type is mandatory")
    @Column(name = "property_type")
    private String propertyType;

    @NotNull(message = "Rent amount is mandatory")
    @Positive(message = "Rent amount must be greater than 0")
    @Column(name = "rent_amount")
    private Double rentAmount;

    @NotNull(message = "Security deposit amount is mandatory")
    @Positive(message = "Security deposit amount must be greater than 0")
    @Column(name = "security_deposit_amount")
    private Double securityDepositAmount;

    @NotNull(message = "Area is mandatory")
    @Positive(message = "Area must be greater than 0")
    @Column(name = "area")
    private Double area;

    @PositiveOrZero(message = "Number of bedrooms must be a non-negative value")
    @Column(name = "number_of_bedrooms")
    private Integer numberOfBedrooms;

    @PositiveOrZero(message = "Floor number must be a non-negative value")
    @Column(name = "floor_number")
    private Integer floorNumber;

    @Positive(message = "Number of floors must be at least 1")
    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @PositiveOrZero(message = "Construction year must be a non-negative value")
    @Column(name = "construction_year")
    private Integer constructionYear;

    @NotBlank(message = "Energy classification is mandatory")
    @Column(name = "energy_classification")
    private String energyClassification;

    @Column(name = "has_elevator")
    private Boolean hasElevator;

    @Column(name = "has_intercom")
    private Boolean hasIntercom;

    @Column(name = "has_balcony")
    private Boolean hasBalcony;

    @Column(name = "has_parking_space")
    private Boolean hasParkingSpace;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    public String getEnergyClassification() {
        return energyClassification;
    }

    public void setEnergyClassification(String energyClassification) {
        this.energyClassification = energyClassification;
    }

    public Boolean getHasElevator() {
        return hasElevator;
    }

    public void setHasElevator(Boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    public Boolean getHasIntercom() {
        return hasIntercom;
    }

    public void setHasIntercom(Boolean hasIntercom) {
        this.hasIntercom = hasIntercom;
    }

    public Boolean getHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(Boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public Boolean getHasParkingSpace() {
        return hasParkingSpace;
    }

    public void setHasParkingSpace(Boolean hasParkingSpace) {
        this.hasParkingSpace = hasParkingSpace;
    }
}
