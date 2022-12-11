package tn.smart_lighting.entities;

import java.util.Objects;

public class Coordinates {
    private Long longitude;
    private Long latitude;
    private String projectionType;

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public String getCoordSystem() {
        return projectionType;
    }

    public void setCoordSystem(String coordSystem) {
        this.projectionType = coordSystem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(longitude, that.longitude) && Objects.equals(latitude, that.latitude) && Objects.equals(projectionType, that.projectionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude, projectionType);
    }

    @Override
    public String toString() {
        return "{" +
                "\"longitude\":" + longitude +
                ", \"latitude\":" + latitude +
                ", \"coordSystem\":\"" + projectionType + '\"' +
                '}';
    }
}
