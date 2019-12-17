package com.epam.rudy.facade;

import com.epam.rudy.entity.Vehicle;
import com.epam.rudy.dao.exception.EntityNotFoundException;
import com.epam.rudy.service.VehicleService;
import com.epam.rudy.util.ConsoleUtil;
import com.epam.rudy.util.SearchDisplayCriteria;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 *
 */
public class VehicleFacade {

    /**  */
    private VehicleService vehicleService;

    public VehicleFacade() throws IOException {
        vehicleService = new VehicleService();
    }

    /**
     *
     */
    public void takeControl() {
        boolean stopExecution = false;
        SearchDisplayCriteria criteria = null;
        while(!stopExecution) {
            int userInput = ConsoleUtil.processUserInitialInput();
            switch (userInput) {
                case 0:
                    criteria = ConsoleUtil.processUserInput4Display();
                    stopExecution = criteria.isCriteriaEmpty();
                    if (!stopExecution)
                        tryDisplayVehicles(criteria);
                    break;
                case 1:
                    Vehicle vehicle = ConsoleUtil.processUserInput4Creation();
                    stopExecution = Objects.isNull(vehicle);
                    if (!stopExecution)
                        tryAddVehicle(vehicle);
                    break;
                case 2:
                    criteria = ConsoleUtil.processUserInput4Search();
                    stopExecution = criteria.isCriteriaEmpty();
                    if (!stopExecution)
                        tryFindVehicles(criteria);
                    break;
                case 3:
                    criteria = ConsoleUtil.processUserInput4UpdateDelete("update");
                    stopExecution = criteria.isCriteriaEmpty();
                     if (!stopExecution)
                         tryUpdateVehicleModelById(criteria);
                    break;
                case 4:
                    criteria = ConsoleUtil.processUserInput4UpdateDelete("delete");
                    stopExecution = criteria.isCriteriaEmpty();
                    if (!stopExecution)
                        tryDeleteVehicle(criteria);
                    break;
                default:
                    throw new RuntimeException();
            }
            if(!stopExecution)
                ConsoleUtil.printChooseOptionMessage();
        }
    }

    private void tryDisplayVehicles(SearchDisplayCriteria criteria) {
        try {
            List<Vehicle> vehicles = vehicleService.displayAllAvailableVehicles(criteria);
            System.out.println("\nHere are all of your vehicles:");
            vehicles.stream().forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println("Ups... something went wrong. Please try again. " + ex.getMessage());
        }
    }

    private void tryAddVehicle(Vehicle vehicle) {
        try {
            vehicleService.addNewVehicle(vehicle);
            System.out.println("\nYour vehicle was successfully added!\n" + vehicle);
        } catch (Exception ex) {
            System.out.println("Ups... something went wrong. Please try again. " + ex.getMessage());
        }
    }

    private void tryFindVehicles(SearchDisplayCriteria criteria) {
        try {
            List<Vehicle> vehicles = vehicleService.findVehicleBySearchCriteria(criteria);
            System.out.println("\nHere are the vehicles found: ");
            vehicles.stream().forEach(System.out::println);
        } catch (EntityNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Ups... something went wrong. Please try again. " + ex.getMessage());
        }
    }

    private void tryUpdateVehicleModelById(SearchDisplayCriteria criteria) {
        try {
            Vehicle vehicle = vehicleService.updateVehicleModelById(criteria.getVehicleId(), criteria.getVehicleModel());
            System.out.println("\nHere is the updated vehicle: " + vehicle);
        } catch (Exception ex) {
            System.out.println("Ups... something went wrong. Please try again. " + ex.getMessage());
        }
    }

    private void tryDeleteVehicle(SearchDisplayCriteria criteria) {
        try {
            vehicleService.deleteVehicleById(criteria.getVehicleId());
            System.out.printf("\nVehicle with id %s was successfully deleted!", criteria.getVehicleId());
        } catch (Exception ex) {
            System.out.println("Ups... something went wrong. Please try again. " + ex.getMessage());
        }
    }
}
