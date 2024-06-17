package fr.esgi.repository;

import fr.esgi.domain.RentalPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalPropertyRepository extends JpaRepository<RentalPropertyEntity, Integer> {
    @Override
    List<RentalPropertyEntity> findAll();

    @Override
    Optional<RentalPropertyEntity> findById(Integer id);

    @Override
    RentalPropertyEntity saveAndFlush(RentalPropertyEntity rentalProperty);
}
