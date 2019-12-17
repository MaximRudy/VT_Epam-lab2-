package com.epam.rudy.util;

import java.util.Objects;

public class SearchDisplayCriteria
{
    private String vehicleId;

    private String vehicleModel;

    private int yearOfManufacture;

    private SearchDisplayCriteria(SearchCriteriaBuilder builder) {
        this.vehicleId = builder.vehicleId;
        this.vehicleModel = builder.vehicleModel;
        this.yearOfManufacture = builder.yearOfManufacture;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public boolean isCriteriaEmpty() {
        return (Objects.isNull(vehicleId)
                && Objects.isNull(vehicleModel)
                && Objects.isNull(yearOfManufacture)) ? true : false;
    }

    public static class SearchCriteriaBuilder {
        private String vehicleId;
        private String vehicleModel;
        private int yearOfManufacture;

        public SearchCriteriaBuilder() {}

        public SearchCriteriaBuilder withVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public SearchCriteriaBuilder withVehicleModel(String vehicleModel) {
            this.vehicleModel = vehicleModel;
            return this;
        }

        public SearchCriteriaBuilder withYearOfManufacture(int yearOfManufacture) {
            this.yearOfManufacture = yearOfManufacture;
            return this;
        }

        public SearchDisplayCriteria build() {
            SearchDisplayCriteria sc = new SearchDisplayCriteria(this);
            return sc;
        }
    }
}
