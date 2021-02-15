package net.timme7893.flightapi.repositories;

import net.timme7893.flightapi.models.ArrivingPlaneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArrivalsRepository extends JpaRepository<ArrivingPlaneModel, Integer> {

}
