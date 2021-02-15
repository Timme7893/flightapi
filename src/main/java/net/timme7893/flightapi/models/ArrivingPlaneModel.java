package net.timme7893.flightapi.models;

import net.timme7893.flightapi.utils.Department;

import javax.persistence.*;

@Entity
@Table(name = "arrivingPlanes")
public class ArrivingPlaneModel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "planeId")
    private int planeId;

    @Column(name = "department")
    private Department department;

    @Column(name = "boardedPassagners")
    private int boardedPassagners;

    @Column(name = "bagageItems")
    private int bagageItems;

    @Column(name = "arrivalTime")
    private String arrivalTime;

    public ArrivingPlaneModel() {}

    public int getId() {
        return id;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
