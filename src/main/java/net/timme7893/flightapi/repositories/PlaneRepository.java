package net.timme7893.flightapi.repositories;

import net.timme7893.flightapi.models.PlaneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<PlaneModel, Integer> {
}
