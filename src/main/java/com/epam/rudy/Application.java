package com.epam.rudy;

import java.io.IOException;

import com.epam.rudy.facade.VehicleFacade;
import com.epam.rudy.util.ConsoleUtil;

/**
 *
 */
public class Application
{
    public static void main(String args[]) throws IOException {

        boolean stopApplication = false;
        VehicleFacade vehicleFacade = new VehicleFacade();
        ConsoleUtil.printWelcomeMessage();
        while(!stopApplication) {
            ConsoleUtil.printChooseOptionMessage();
            try {
                vehicleFacade.takeControl();
            } catch (RuntimeException ex) {
                break;
            }
            ConsoleUtil.printChooseOptionMessage();
            if (ConsoleUtil.processUserInitialInput() == -1)
                stopApplication = true;
        }
        ConsoleUtil.SCANNER.close();
    }
}
