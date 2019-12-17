package com.epam.rudy.service;

import java.io.IOException;
import java.util.*;

import com.epam.rudy.dao.VehicleDAO;
import com.epam.rudy.dao.impl.VehicleDAOFileImpl;
import com.epam.rudy.entity.Vehicle;
import com.epam.rudy.exception.VehicleCreationException;
import com.epam.rudy.exception.VehicleDeleteException;
import com.epam.rudy.exception.VehicleDisplayException;
import com.epam.rudy.dao.exception.EntityNotFoundException;
import com.epam.rudy.exception.VehicleUpdateException;
import com.epam.rudy.util.SearchDisplayCriteria;
import com.epam.rudy.util.comparator.VehicleModelComparator;
import com.epam.rudy.util.comparator.VehicleYearOfManufactureComparator;

public class VehicleService {

    /**  */
    private VehicleDAO vehicleDAO;

    public VehicleService() throws IOException {
        vehicleDAO = new VehicleDAOFileImpl();
    }

    public List<Vehicle> displayAllAvailableVehicles(SearchDisplayCriteria criteria) throws VehicleDisplayException {
        List<Vehicle> vehicleList;
        try {
            vehicleList = vehicleDAO.retrieveAll();
            if (criteria.isCriteriaEmpty() || Objects.nonNull(criteria.getVehicleId())) {
                Collections.sort(vehicleList);
            } else if (Objects.nonNull(criteria.getVehicleModel())) {
                Collections.sort(vehicleList, new VehicleModelComparator());
            } else {
                Collections.sort(vehicleList, new VehicleYearOfManufactureComparator());
            }
        } catch (Exception ex) {
            throw new VehicleDisplayException(ex.getMessage());
        }
        return vehicleList;
    }

    public Vehicle addNewVehicle(Vehicle vehicle) throws VehicleCreationException {
        try {
            return vehicleDAO.create(vehicle);
        } catch(Exception ex) {
            throw new VehicleCreationException(ex.getMessage());
        }
    }

    public List<Vehicle> findVehicleBySearchCriteria(SearchDisplayCriteria criteria) throws EntityNotFoundException {
        List<Vehicle> vehicleList;
        try {
            vehicleList = new ArrayList<>();
            if (Objects.nonNull(criteria.getVehicleId())) {
                vehicleList.add(vehicleDAO.retrieve(criteria.getVehicleId()));
            } else if (Objects.nonNull(criteria.getVehicleModel())) {
                vehicleList.addAll(vehicleDAO.retrieveByModel(criteria.getVehicleModel()));
            } else if (Objects.nonNull(criteria.getYearOfManufacture())) {
                vehicleList.addAll(vehicleDAO.retrieveByYear(criteria.getYearOfManufacture()));
            }
        } catch (Exception ex) {
            throw new EntityNotFoundException(ex.getMessage());
        }
        return vehicleList;
    }

    public Vehicle updateVehicleModelById(String vehicleId, String vehicleModel) throws VehicleUpdateException {
        try {
            Vehicle originalVehicle = vehicleDAO.retrieve(vehicleId);
            originalVehicle.setModel(vehicleModel);
            return vehicleDAO.update(originalVehicle);
        } catch (Exception ex) {
            throw new VehicleUpdateException(ex.getMessage());
        }
    }

    public void deleteVehicleById(String vehicleId) throws VehicleDeleteException {
        try {
            vehicleDAO.delete(vehicleId);
        } catch (Exception ex) {
            throw new VehicleDeleteException("Vehicle delete exception.", ex);
        }
    }
}
