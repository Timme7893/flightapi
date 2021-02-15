package net.timme7893.flightapi.repositories;

import net.timme7893.flightapi.models.DepartingPlaneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartingRepository extends JpaRepository<DepartingPlaneModel, Integer> {
}
