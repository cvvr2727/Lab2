package application;
import javafx.geometry.Point2D;

public class Ship {
    private Point2D currentLocation;
    private OceanMap oceanMap;

    public Ship(OceanMap map) {
        this.oceanMap = map;
        currentLocation = new Point2D(0, 0); // starting point for the ship
    }

    public Point2D getCurrentLocation() {
        return currentLocation;
    }

    public void goEast() {
        if (currentLocation.getX() < oceanMap.getMap().length - 1) {
            currentLocation = new Point2D(currentLocation.getX() + 1, currentLocation.getY());
        }
    }

    public void goWest() {
        if (currentLocation.getX() > 0) {
            currentLocation = new Point2D(currentLocation.getX() - 1, currentLocation.getY());
        }
    }

    public void goNorth() {
        if (currentLocation.getY() > 0) {
            currentLocation = new Point2D(currentLocation.getX(), currentLocation.getY() - 1);
        }
    }

    public void goSouth() {
        if (currentLocation.getY() < oceanMap.getMap().length - 1) {
            currentLocation = new Point2D(currentLocation.getX(), currentLocation.getY() + 1);
        }
    }
}
