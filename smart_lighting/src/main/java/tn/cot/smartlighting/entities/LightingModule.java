package tn.cot.smartlighting.entities;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import tn.cot.smartlighting.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.Table;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
@Table(name = "lightingModules")
public class LightingModule {
    @Id
    private String id;
    @Column
    private double longitude;
    @Column
    private double latitude;
    @Column
    private String addressId;
    @Column
    private boolean is_on;
    @Column
    private boolean is_broken;
    @Column
    private boolean archived;

    public LightingModule(){ };

    public String getId() {
        return id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getAddressId() {
        return addressId;
    }

    public boolean isIs_on() {
        return is_on;
    }

    public boolean isIs_broken() {
        return is_broken;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public static LightingModuleBuilder builder() {
        return new LightingModuleBuilder();
    }

    public static class LightingModuleBuilder {
        private String id;
        private double longitude;
        private double latitude;
        private String addressId;
        private boolean is_on;
        private boolean is_broken;
        private boolean archived;

        public LightingModuleBuilder WithId(String id) {
            this.id = id;
            return this;
        }
        public LightingModuleBuilder WithLongitude(double longitude) {
            this.longitude = longitude;
            return this;
        }
        public LightingModuleBuilder WithLatitude(double latitude) {
            this.latitude = latitude;
            return this;
        }
        public LightingModuleBuilder WithAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }
        public LightingModuleBuilder WithIsOn() {
            this.is_on = true;
            return this;
        }
        public LightingModuleBuilder WithIsBroken() {
            this.is_broken = false;
            return this;
        }
        public LightingModuleBuilder WithArchived() {
            this.archived = false;
            return this;
        }
        public LightingModule build() {
            LightingModule lightingModule = new LightingModule();
            lightingModule.id = id;
            lightingModule.addressId = addressId;
            lightingModule.longitude = longitude;
            lightingModule.latitude = latitude;
            lightingModule.is_on = true;
            lightingModule.is_broken = is_broken;
            lightingModule.archived = archived;
            return lightingModule;
        }
    }
}
