package Controller;

import enums.MainLocation;

public class MainLocationController {
    private static MainLocation currentLocation = MainLocation.Farm;

    public static MainLocation getCurrentLocation() {
        return currentLocation;
    }

    public static void setCurrentLocation(MainLocation newLocation) {
        currentLocation = newLocation;
    }

    public static boolean isIn(MainLocation location) {
        return currentLocation == location;
    }
}
