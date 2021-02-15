package net.timme7893.flightapi.models;

import net.timme7893.flightapi.utils.Destination;

import javax.persistence.*;

@Entity
@Table(name = "departingPlanes")
public class DepartingPlaneModel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "planeId")
    private int planeId;

    @Column(name = "destination")
    private Destination destination;

    @Column(name = "boardedPassagners")
    private int boardedPassagners;

    @Column(name = "bagageItems")
    private int bagageItems;

    @Column(name = "flightTime")
    private String flightTime;

    public DepartingPlaneModel() {
    }

    public int getId() {
        return id;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public int getBoardedPassagners() {
        return boardedPassagners;
    }

    public void setBoardedPassagners(int boardedPassagners) {
        this.boardedPassagners = boardedPassagners;
    }

    public int getBagageItems() {
        return bagageItems;
    }

    public void setBagageItems(int bagageItems) {
        this.bagageItems = bagageItems;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }
}
