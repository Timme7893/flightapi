package net.timme7893.flightapi.controllers;

import net.timme7893.flightapi.models.PlaneModel;
import net.timme7893.flightapi.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/plane")
@RestController
public class PlaneController {

    @Autowired
    PlaneRepository planeRepository;

    @PostMapping
    public void addPlane(@NonNull @RequestBody PlaneModel planeModel) {
        if (!planeExists(planeModel)) {
            planeRepository.save(planeModel);
        }
    }

    @GetMapping
    public List<PlaneModel> getAllPlanes() {
        return planeRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public PlaneModel getPlaneById(@PathVariable("id") int id) {
        return planeRepository.findById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePlaneById(@PathVariable("id") int id) {
        planeRepository.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePlaneStatus(@PathVariable("id") int id, @NonNull @RequestBody PlaneModel updatedPlane) {
        if (planeRepository.existsById(id)) {
            PlaneModel planeModel = planeRepository.getOne(id);
            planeModel.setTotalPassagnes(updatedPlane.getTotalPassagnes());
            planeModel.setInMaintaince(updatedPlane.isInMaintaince());
            planeModel.setWeightCapacity(updatedPlane.getWeightCapacity());
            planeModel.setBagageCapacity(updatedPlane.getBagageCapacity());
            planeRepository.save(planeModel);
        }
    }

    // utils

    public boolean planeExists(PlaneModel plane) {
        return planeRepository.existsById(plane.getPlaneId());
    }
}
