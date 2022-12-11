package tn.smart_lighting.entities;

import java.util.Date;
import java.util.Objects;

public class LightModule {
    private Integer id;
    private Address address;
    private Coordinates coordinates;
    private Boolean isOn;
    private Boolean isBroken;
    private Date creationDate;
    private Boolean isArchived;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Boolean getOn() {
        return isOn;
    }

    public void setOn(Boolean on) {
        isOn = on;
    }

    public Boolean getBroken() {
        return isBroken;
    }

    public void setBroken(Boolean broken) {
        isBroken = broken;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightModule that = (LightModule) o;
        return Objects.equals(id, that.id) && Objects.equals(address, that.address) && Objects.equals(coordinates, that.coordinates) && Objects.equals(isOn, that.isOn) && Objects.equals(isBroken, that.isBroken) && Objects.equals(creationDate, that.creationDate) && Objects.equals(isArchived, that.isArchived);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, coordinates, isOn, isBroken, creationDate, isArchived);
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id +
                ", \"address=" + address +
                ", \"coordinates\":" + coordinates +
                ", \"isOn\":" + isOn +
                ", \"isBroken\":" + isBroken +
                ", \"creationDate\":" + creationDate +
                ", \"isArchived\":" + isArchived +
                '}';
    }
}
