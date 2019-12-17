package com.epam.rudy.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.naming.OperationNotSupportedException;

import com.epam.rudy.dao.VehicleDAO;
import com.epam.rudy.dao.exception.EntityNotFoundException;
import com.epam.rudy.entity.Vehicle;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VehicleDAOFileImpl implements VehicleDAO {

    /** Vehicle list cache */
    private List<Vehicle> vehicleListCache = new ArrayList<>();

    /** Static id counter */
    private static int counter;

    /** Jackson object mapper */
    private final ObjectMapper mapper = new ObjectMapper();

    /** Target file to read/write from/to */
    private File destinationFile;

    /**
     * Initializing cache right at the start of the app
     *
     * @throws IOException
     */
    public VehicleDAOFileImpl() throws IOException {
        destinationFile = new File(getClass()
            .getClassLoader()
            .getResource("vehicles.json")
            .getFile());
        this.vehicleListCache = retrieveAllVehicles();
        counter = vehicleListCache.size();
    }

    public List<Vehicle> getVehicleListCache() {
        return vehicleListCache;
    }

    public void invalidateVehicleListCache() {
        vehicleListCache.clear();
    }

    @Override
    public List<Vehicle> retrieveAll() throws IOException {
        return isNotEmptyCache() ? getVehicleListCache() : fillInCache();
    }

    @Override
    public Vehicle create(Vehicle vehicle) throws IOException {
        vehicle.setId(String.valueOf(++counter));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(destinationFile, true)));
        pw.write(mapper.writeValueAsString(vehicle) + "\n");
        pw.close();
        vehicleListCache.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle retrieve(String id) throws EntityNotFoundException, IOException {
        return vehicleListCache.stream()
                                .filter(v -> Objects.equals(id, v.getId()))
                                .findFirst()
                                .orElseThrow(() -> new EntityNotFoundException("No vehicle was found for id " + id));
    }

    @Override
    public List<Vehicle> retrieveByModel(String model) throws IOException {
        return vehicleListCache.stream()
                               .filter(v -> Objects.equals(model, v.getModel()))
                               .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> retrieveByYear(int year) throws IOException {
        return vehicleListCache.stream()
                               .filter(v -> Objects.equals(year, v.getYearOfManufacture()))
                               .collect(Collectors.toList());
    }

    @Override
    public Vehicle update(Vehicle vehicle) throws Exception {
        deleteAll();
        saveAllVehicles();
        return vehicle;
    }

    @Override
    public void delete(String id) throws IOException, EntityNotFoundException {
        // We need to clone current cache before deleting
        // as saving operation may fail. Reference cloning is enough here.
        List<Vehicle> clonedList = new ArrayList<>();
        vehicleListCache.stream().forEach(v -> clonedList.add(v));
        vehicleListCache.remove(retrieve(id));
        try {
            deleteAll();
            saveAllVehicles();
        } catch (IOException ex) {
            vehicleListCache = clonedList;
            throw new IOException(ex.getMessage());
        }
    }

    @Override
    public void deleteAll() throws IOException {
        Files.newBufferedWriter(FileSystems.getDefault().getPath(destinationFile.getPath()) ,
                             StandardOpenOption.TRUNCATE_EXISTING);
    }

    private List<Vehicle> fillInCache() throws IOException {
        vehicleListCache.addAll(retrieveAllVehicles());
        return vehicleListCache;
    }

    private List<Vehicle> retrieveAllVehicles() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(destinationFile))) {
            String currentLine;
            while (Objects.nonNull(currentLine = br.readLine())) {
                vehicleListCache.add(mapper.readValue(currentLine, Vehicle.class));
            }
        }
        return vehicleListCache;
    }

    private void saveAllVehicles() throws IOException {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(destinationFile, true)))) {
            for(Vehicle vehicle : vehicleListCache) {
                pw.write(mapper.writeValueAsString(vehicle) + "\n");
            }
        } catch (JsonProcessingException ex) {
            throw new IOException(ex);
        }
    }

    private boolean isNotEmptyCache() {
        return !vehicleListCache.isEmpty();
    }
}
