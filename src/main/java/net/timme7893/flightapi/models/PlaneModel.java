package net.timme7893.flightapi.models;

import javax.persistence.*;

@Entity
@Table(name = "planes")
public class PlaneModel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int planeId;

    @Column(name = "totalPassagners")
    private int totalPassagnes;

    @Column(name = "inMaintaince")
    private boolean inMaintaince;

    @Column(name = "weightCapacity")
    private int weightCapacity;

    @Column(name = "bagageCapacity")
    private int bagageCapacity;

    public PlaneModel() {
    }

    public int getPlaneId() {
        return planeId;
    }

    public int getTotalPassagnes() {
        return totalPassagnes;
    }

    public void setTotalPassagnes(int totalPassagnes) {
        this.totalPassagnes = totalPassagnes;
    }

    public boolean isInMaintaince() {
        return inMaintaince;
    }

    public void setInMaintaince(boolean inMaintaince) {
        this.inMaintaince = inMaintaince;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public int getBagageCapacity() {
        return bagageCapacity;
    }

    public void setBagageCapacity(int bagageCapacity) {
        this.bagageCapacity = bagageCapacity;
    }
}
