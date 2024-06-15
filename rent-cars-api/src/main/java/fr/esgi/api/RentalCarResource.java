package fr.esgi.api;

import fr.esgi.domain.RentalCarEntity;
import fr.esgi.dto.RentalCarDTO;
import fr.esgi.repository.RentalCarRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/rent-cars-api/rental-cars")
public class RentalCarResource {
    private final RentalCarRepository repository;

    private final Validator validator;

    public RentalCarResource(@Autowired RentalCarRepository repository, @Autowired Validator validator)
    {
        this.repository = repository;
        this.validator = validator;
    }

    @GetMapping()
    public List<RentalCarDTO> getRentalCars() { return repository.findAll().stream().map(entity -> RentalCarDTO.fromEntity(entity)).toList(); }

    @GetMapping("/{id}")
    public ResponseEntity<RentalCarDTO> getRentalCarById(@PathVariable Integer id) {
        Optional<RentalCarEntity> rentalCar = repository.findById(id);

        return rentalCar
                .map(rentalCarEntity -> ResponseEntity.ok(RentalCarDTO.fromEntity(rentalCarEntity)))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<RentalCarDTO> createRentalCar(@RequestBody RentalCarDTO rentalCarData) throws URISyntaxException {
        RentalCarEntity savedRentalCar = repository.saveAndFlush(rentalCarData.toEntity());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedRentalCar.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalCarDTO> updateOrCreateRentalCar(@PathVariable Integer id, @RequestBody RentalCarDTO rentalCarData) {
        Optional<RentalCarEntity> rentalCar = repository.findById(id);

        RentalCarEntity updatedRentalCar = rentalCarData.toEntity();
        if (rentalCar.isPresent()) {
            updatedRentalCar.setId(rentalCar.get().getId());
            repository.saveAndFlush(updatedRentalCar);
        } else {
            repository.saveAndFlush(updatedRentalCar);
        }

        return ResponseEntity.ok(null);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateRentalCar(@PathVariable Integer id, @Valid @RequestBody RentalCarDTO rentalCarData) {
        Optional<RentalCarEntity> rentalCar = repository.findById(id);

        RentalCarEntity updatedRentalCar = rentalCarData.toEntity();

        Set<ConstraintViolation<RentalCarEntity>> violations = validator.validate(updatedRentalCar);
        if (! violations.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    violations
                            .stream()
                            .toList()
                            .stream()
                            .map(violation -> violation.getMessage())
            );
        }

        if (rentalCar.isPresent()) {
            updatedRentalCar.setId(rentalCar.get().getId());
            repository.saveAndFlush(updatedRentalCar);
        } else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RentalCarDTO> deleteRentalCar(@PathVariable Integer id) {
        Optional<RentalCarEntity> rentalCar = repository.findById(id);

        if (rentalCar.isPresent()) {
            repository.delete(rentalCar.get());
        } else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
