package fr.esgi.api;

import fr.esgi.domain.RentalPropertyEntity;
import fr.esgi.dto.RentalPropertyDTO;
import fr.esgi.repository.RentalPropertyRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/rent-properties-api/rental-properties")
public class RentalPropertyResource {
    private final RentalPropertyRepository repository;

    private final Validator validator;

    public RentalPropertyResource(@Autowired RentalPropertyRepository repository, @Autowired Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @GetMapping()
    public List<RentalPropertyDTO> getRentalCars() {
        return repository.findAll().stream().map(entity -> RentalPropertyDTO.fromEntity(entity)).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalPropertyDTO> getRentalCarById(@PathVariable Integer id) {
        Optional<RentalPropertyEntity> rentalCar = repository.findById(id);

        return rentalCar
                .map(rentalCarEntity -> ResponseEntity.ok(RentalPropertyDTO.fromEntity(rentalCarEntity)))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<RentalPropertyDTO> createRentalCar(@Valid @RequestBody RentalPropertyEntity rentalProperty) throws URISyntaxException {
        RentalPropertyEntity savedRentalCar = repository.saveAndFlush(rentalProperty);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedRentalCar.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalPropertyDTO> updateOrCreateRentalCar(@PathVariable Integer id, @Valid @RequestBody RentalPropertyEntity rentalProperty) {
        Optional<RentalPropertyEntity> rentalCar = repository.findById(id);

        if (rentalCar.isPresent()) {
            rentalProperty.setId(rentalCar.get().getId());
            repository.saveAndFlush(rentalProperty);
        } else {
            repository.saveAndFlush(rentalProperty);
        }

        return ResponseEntity.ok(null);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateRentalCar(@PathVariable Integer id, @Valid @RequestBody RentalPropertyEntity rentalPropertyData) {
        Optional<RentalPropertyEntity> rentalCar = repository.findById(id);

        Set<ConstraintViolation<RentalPropertyEntity>> violations = validator.validate(rentalPropertyData);
        if (!violations.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    violations
                            .stream()
                            .toList()
                            .stream()
                            .map(violation -> violation.getMessage())
            );
        }

        if (rentalCar.isPresent()) {
            rentalPropertyData.setId(rentalCar.get().getId());
            repository.saveAndFlush(rentalPropertyData);
        } else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RentalPropertyDTO> deleteRentalCar(@PathVariable Integer id) {
        Optional<RentalPropertyEntity> rentalCar = repository.findById(id);

        if (rentalCar.isPresent()) {
            repository.delete(rentalCar.get());
        } else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
