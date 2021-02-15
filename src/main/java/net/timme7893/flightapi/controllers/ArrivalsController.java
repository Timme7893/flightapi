package net.timme7893.flightapi.controllers;

import net.timme7893.flightapi.models.ArrivingPlaneModel;
import net.timme7893.flightapi.repositories.ArrivalsRepository;
import net.timme7893.flightapi.utils.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("api/v1/arrivals")
@RestController
public class ArrivalsController {

    @Autowired
    ArrivalsRepository arrivalsRepository;

    @PostMapping
    public void addPlane(@NonNull @RequestBody ArrivingPlaneModel planeModel) {
        arrivalsRepository.save(planeModel);
    }

    @GetMapping
    public List<ArrivingPlaneModel> getAllArrivingPlanes() {
        return arrivalsRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public ArrivingPlaneModel getPlaneById(@PathVariable("id") int id) {
        return arrivalsRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/department/{id}")
    public List<ArrivingPlaneModel> getAllPlanesByDepartment(@PathVariable("id") Department department) {
        return arrivalsRepository.findAll().stream().filter(arrivingPlaneModel -> arrivingPlaneModel.getDepartment().equals(department)).collect(Collectors.toList());
    }

    @DeleteMapping(path = "{id}")
    public void deletePlaneById(@PathVariable("id") int id) {
        arrivalsRepository.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePlaneStatus(@PathVariable("id") int id, @NonNull @RequestBody ArrivingPlaneModel updatedPlane) {
        if (arrivalsRepository.existsById(id)) {
            ArrivingPlaneModel planeModel = arrivalsRepository.getOne(id);
            planeModel.setPlaneId(updatedPlane.getPlaneId());
            planeModel.setDepartment(updatedPlane.getDepartment());
            planeModel.setBoardedPassagners(updatedPlane.getBoardedPassagners());
            planeModel.setBagageItems(updatedPlane.getBagageItems());
            planeModel.setArrivalTime(updatedPlane.getArrivalTime());
            arrivalsRepository.save(planeModel);
        }
    }

}
