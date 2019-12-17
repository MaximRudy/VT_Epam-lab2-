package com.epam.rudy.util;

import java.util.Objects;
import java.util.Scanner;

import com.epam.rudy.entity.CarBodyType;
import com.epam.rudy.entity.Vehicle;
import com.epam.rudy.entity.VehicleType;
import com.epam.rudy.entity.factory.VehicleFactory;

public final class ConsoleUtil {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void printChooseOptionMessage() {
        System.out.println("\n\nPlease choose one of the following options: ");
        System.out.println("-------------------------------------");
        System.out.println("0 - To show all present vehicles");
        System.out.println("-------------------------------------");
        System.out.println("1 - To add a new vehicle");
        System.out.println("-------------------------------------");
        System.out.println("2 - To find a specific vehicle");
        System.out.println("-------------------------------------");
        System.out.println("3 - To update a specific vehicle's model");
        System.out.println("-------------------------------------");
        System.out.println("4 - To delete a specific vehicle");
        System.out.println("-------------------------------------");
        System.out.println("To quit the app please enter \':wq\'. ");
        System.out.println("##########################################################");
        System.out.print("Your choice: ");
    }

    public static void printWelcomeMessage() {
        System.out.println("##########################################################");
        System.out.println("Welcome to a small \'rent-a-car\' admin application!");
        System.out.println("##########################################################");
    }

    public static int processUserInitialInput() {
        int input = -1;
        while (SCANNER.hasNext()) {
            if ((SCANNER.hasNextInt() && checkIntNumberRange4InitialChoice(input = SCANNER.nextInt()))
                || checkExitOption(SCANNER.next()))
                return input;
            else
                System.out.println("Please enter a valid integer number from range 1-4 or enter \':wq\' to quite");
        }
        return input;
    }

    public static SearchDisplayCriteria processUserInput4Display() {
        int input;
        SearchDisplayCriteria criteria = null;
        System.out.println("Please choose the option to use during display sorting:");
        System.out.println("0 - By vehicle id (by default)");
        System.out.println("1 - By vehicle model");
        System.out.println("2 - By vehicle year of manufacture");
        System.out.print("Your choice: ");
        while(SCANNER.hasNext()) {
            if ((SCANNER.hasNextInt() && checkIntNumberRange4Display(input = SCANNER.nextInt()))) {
                criteria = defineDisplaySearchCriteria(input, "display");
                break;
            }
            else if (checkExitOption(SCANNER.next())) {
                // building an empty criteria
                criteria = new SearchDisplayCriteria.SearchCriteriaBuilder().build();
                break;
            }
            else {
                System.out.print("Please enter a valid integer number from range 1-4  or enter \':wq\' to get back: ");
            }
        }
        return criteria;
    }

    private static SearchDisplayCriteria defineDisplaySearchCriteria(int input, String action) {
        SearchDisplayCriteria.SearchCriteriaBuilder
                criteriaBuilder = new SearchDisplayCriteria.SearchCriteriaBuilder();
        switch (input) {
            case 0:
                if ("search".equals(action))
                    criteriaBuilder.withVehicleId(processUserInput4StringParameter("id"));
                else
                    criteriaBuilder.withVehicleId("");
                break;
            case 1:
                if ("search".equals(action))
                    criteriaBuilder.withVehicleModel(processUserInput4StringParameter("model"));
                else
                    criteriaBuilder.withVehicleModel("");
                break;
            case 2:
                if ("search".equals(action))
                    criteriaBuilder.withYearOfManufacture(
                            Integer.valueOf(processUserInput4StringParameter("year of manufacture")));
                else
                    criteriaBuilder.withYearOfManufacture(0);
                break;
            default:
                break;
        }
        return criteriaBuilder.build();
    }

    public static Vehicle processUserInput4Creation() {
        VehicleType vehicleType = null;
        String vehicleModel = null;
        int yearOfManufacture = 0;
        boolean isIndependentVehicle = false;
        int enginePower = 0;
        CarBodyType carBodyType = null;
        int engineCapacity = 0;
        int timeToCharge = 0;
        int numberOfAxles = 0;
        boolean isKitchenPresent = false;

        System.out.print("Please enter one of the following vehicle types " +
                "[FUEL_CAR, ELECTRO_CAR, BUS, MINIBUS, HOUSE_ON_WHEELS, TRAILER, BICYCLE] or enter \':wq\' to get back: ");
        while(SCANNER.hasNext()) {
            String nextString = SCANNER.next();
            vehicleType = processUserInput4VehicleType(nextString);
            if (Objects.nonNull(vehicleType) || checkExitOption(nextString))
                break;
            else {
                System.out.print("Please enter one of the following vehicle types " +
                "[FUEL_CAR, ELECTRO_CAR, BUS, MINIBUS, HOUSE_ON_WHEELS, TRAILER, BICYCLE] or enter \':wq\' to get back: ");
            }
        }

        System.out.print("Please enter vehicle model: ");
        if(SCANNER.hasNext())
            vehicleModel = SCANNER.next();

        System.out.print("Please enter vehicle year of manufacture: ");
        if(SCANNER.hasNext())
            yearOfManufacture = Integer.valueOf(SCANNER.next());

        if (vehicleType.equals(VehicleType.FUEL_CAR) || vehicleType.equals(VehicleType.ELECTRO_CAR)
                || vehicleType.equals(VehicleType.MINIBUS) || vehicleType.equals(VehicleType.BUS)
                || vehicleType.equals(VehicleType.HOUSE_ON_WHEELS)) {

            System.out.print("Please enter vehicle engine power: ");
            if (SCANNER.hasNext())
                enginePower = Integer.valueOf(SCANNER.next());

            if (vehicleType.equals(VehicleType.FUEL_CAR) || vehicleType.equals(VehicleType.ELECTRO_CAR)) {
                System.out.print("Please enter one of the following car body types [SEDAN, HATCHBACK, STATION_WAGON]: ");
                while (SCANNER.hasNext()) {
                    String nextString = SCANNER.next();
                    carBodyType = processUserInput4CarBodyType(nextString);
                    if (Objects.nonNull(carBodyType) || checkExitOption(nextString))
                        break;
                    else {
                        System.out.print("Please enter vehicle one of the following car body types: " +
                                "[SEDAN, HATCHBACK, STATION_WAGON]: ");
                    }
                }
            }

            if (vehicleType.equals(VehicleType.FUEL_CAR) || vehicleType.equals(VehicleType.BUS)
                    || vehicleType.equals(VehicleType.MINIBUS) || vehicleType.equals(VehicleType.HOUSE_ON_WHEELS)) {
                System.out.print("Please enter vehicle engine capacity: ");
                if(SCANNER.hasNext())
                    engineCapacity = Integer.valueOf(SCANNER.next());
            }

            if (vehicleType.equals(VehicleType.ELECTRO_CAR)) {
                System.out.print("Please enter vehicle time to charge: ");
                if(SCANNER.hasNext())
                    timeToCharge = Integer.valueOf(SCANNER.next());
            }

            if (vehicleType.equals(VehicleType.BUS)) {
                System.out.print("Please enter vehicle number of axles: ");
                if(SCANNER.hasNext())
                    numberOfAxles = Integer.valueOf(SCANNER.next());
            }

            if (vehicleType.equals(VehicleType.HOUSE_ON_WHEELS)) {
                System.out.print("Please enter if kitchen is present [true, false]: ");
                if(SCANNER.hasNext())
                    isKitchenPresent = Boolean.valueOf(SCANNER.next());
            }
        }

        if (vehicleType.equals(VehicleType.BICYCLE) || vehicleType.equals(VehicleType.TRAILER)) {
            System.out.print("Please enter if vehicle is an independent vehicle [true, false]: ");
            if(SCANNER.hasNext())
                isIndependentVehicle = Boolean.valueOf(SCANNER.next());
        }
        return VehicleFactory.createVehicle(vehicleType, vehicleModel, yearOfManufacture,
                                            isIndependentVehicle, enginePower, carBodyType,
                                            engineCapacity, timeToCharge, numberOfAxles,
                                            isKitchenPresent);
    }

    public static SearchDisplayCriteria processUserInput4Search() {
        int input;
        SearchDisplayCriteria criteria = null;
        System.out.println("Please choose the option to search vehicle(s) or enter \':wq\' to get back: ");
        System.out.println("0 - By vehicle id");
        System.out.println("1 - By vehicle model");
        System.out.println("2 - By vehicle year of manufacture");
        System.out.print("Your choice: ");
        while(SCANNER.hasNext()) {
            if ((SCANNER.hasNextInt() && checkIntNumberRange4Display(input = SCANNER.nextInt()))) {
                criteria = defineDisplaySearchCriteria(input, "search");
                break;
            }
            else if (checkExitOption(SCANNER.next())) {
                // building an empty criteria
                criteria = new SearchDisplayCriteria.SearchCriteriaBuilder().build();
                break;
            }
            else {
                System.out.print("Please choose the option to search vehicle(s) or enter \':wq\' to get back: ");
            }
        }
        return criteria;
    }

    public static SearchDisplayCriteria processUserInput4UpdateDelete(String action) {
        String vehicleId = null;
        String vehicleModel = null;
        SearchDisplayCriteria criteria = null;
        System.out.printf("Please choose vehicle id to %s: ", action);
        if(SCANNER.hasNext())
            vehicleId = SCANNER.next();
        if ("update".equals(action)) {
            System.out.print("Please enter new vehicle model: ");
            if(SCANNER.hasNext()) {
                vehicleModel = SCANNER.next();
            }
        }
        return new SearchDisplayCriteria.SearchCriteriaBuilder()
                .withVehicleId(vehicleId)
                .withVehicleModel(vehicleModel)
                .build();
    }

    private static String processUserInput4StringParameter(String parameterName) {
        System.out.printf("Please enter vehicle %s: ", parameterName);
        if(SCANNER.hasNext()) {
            return SCANNER.next();
        }
        return "";
    }

    private static VehicleType processUserInput4VehicleType(String vehicleType) {
        VehicleType type = null;
        try {
            type = VehicleType.valueOf(vehicleType.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return type;
        }
        return type;
    }

    private static CarBodyType processUserInput4CarBodyType(String carBodyType) {
        CarBodyType type = null;
        try {
            type = CarBodyType.valueOf(carBodyType.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return type;
        }
        return type;
    }

    private static boolean checkIntNumberRange4InitialChoice(int input) {
        return (input >= 0 && input <= 4) ? true : false;
    }

    private static boolean checkIntNumberRange4Display(int input) {
        return (input >= 0 && input <= 2) ? true : false;
    }

    private static boolean checkExitOption(String input) {
        return Objects.equals(":wq", input);
    }
}
