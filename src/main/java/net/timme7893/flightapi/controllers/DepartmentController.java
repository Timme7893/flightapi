package net.timme7893.flightapi.controllers;

import net.timme7893.flightapi.models.DepartingPlaneModel;
import net.timme7893.flightapi.repositories.DepartingRepository;
import net.timme7893.flightapi.utils.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("api/v1/departments")
@RestController
public class DepartmentController {

    @Autowired
    DepartingRepository departingRepository;

    @PostMapping
    public void addPlane(@NonNull @RequestBody DepartingPlaneModel planeModel) {
        departingRepository.save(planeModel);
    }

    @GetMapping
    public List<DepartingPlaneModel> getAllDepartingPlanes() {
        return departingRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public DepartingPlaneModel getPlaneById(@PathVariable("id") int id) {
        return departingRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/destination/{id}")
    public List<DepartingPlaneModel> getAllPlanesByDestination(@PathVariable("id") Destination destination) {
        return departingRepository.findAll().stream().filter(departingPlaneModel -> departingPlaneModel.getDestination().equals(destination)).collect(Collectors.toList());
    }

    @DeleteMapping(path = "{id}")
    public void deletePlaneById(@PathVariable("id") int id) {
        departingRepository.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePlaneStatus(@PathVariable("id") int id, @NonNull @RequestBody DepartingPlaneModel updatedPlane) {
        if (departingRepository.existsById(id)) {
            DepartingPlaneModel planeModel = departingRepository.getOne(id);
            planeModel.setPlaneId(updatedPlane.getPlaneId());
            planeModel.setDestination(updatedPlane.getDestination());
            planeModel.setBoardedPassagners(updatedPlane.getBoardedPassagners());
            planeModel.setBagageItems(updatedPlane.getBagageItems());
            planeModel.setFlightTime(updatedPlane.getFlightTime());
            departingRepository.save(planeModel);
        }
    }

}
