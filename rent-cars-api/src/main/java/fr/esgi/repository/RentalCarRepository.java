package fr.esgi.repository;

import fr.esgi.domain.RentalCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalCarRepository extends JpaRepository<RentalCarEntity, Integer> {
    @Override
    List<RentalCarEntity> findAll();

    @Override
    Optional<RentalCarEntity> findById(Integer id);

    @Override
    RentalCarEntity saveAndFlush(RentalCarEntity rentalCar);
}
