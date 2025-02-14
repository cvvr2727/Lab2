package application;
public class OceanMap {
    private boolean[][] oceanGrid;
    private int dimensions;

    public OceanMap(int dimensions) {
        this.dimensions = dimensions;
        oceanGrid = new boolean[dimensions][dimensions]; // false means empty, true can mean occupied (like islands later)
    }

    public boolean[][] getMap() {
        return oceanGrid;
    }
}
