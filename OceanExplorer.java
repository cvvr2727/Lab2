package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class OceanExplorer extends Application {
    final int dimension = 10; // Corrected spelling
    final int scale = 50; // Scale for the grid
    Pane root;
    Image shipImage;
    ImageView shipImageView;
    Ship ship; // Initialize later with OceanMap
    Scene scene;

    public static void main(String[] args) {
        launch(args); // Start the JavaFX application
    }

    // Load the ship image and place it on the grid
    public void loadShipImage() {
        shipImage = new Image("file:ship.png", scale, scale, false, false);
        shipImageView = new ImageView(shipImage);
        shipImageView.setX(ship.getCurrentLocation().getX() * scale);
        shipImageView.setY(ship.getCurrentLocation().getY() * scale);
        root.getChildren().add(shipImageView);
    }

    // Draw the grid for the ocean
    public void drawMap() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                Rectangle rect = new Rectangle(i * scale, j * scale, scale, scale);
                rect.setStroke(Color.BLACK); // Grid lines
                rect.setFill(Color.PALETURQUOISE); // Ocean color
                root.getChildren().add(rect);
            }
        }
    }

    // Set up event handling for ship movement
    public void startSailing() {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT:
                    ship.goEast();
                    break;
                case LEFT:
                    ship.goWest();
                    break;
                case UP:
                    ship.goNorth();
                    break;
                case DOWN:
                    ship.goSouth();
                    break;
                default:
                    break;
            }
            // Update the ship's position on the grid
            shipImageView.setX(ship.getCurrentLocation().getX() * scale);
            shipImageView.setY(ship.getCurrentLocation().getY() * scale);
        });
    }

    @Override
    public void start(Stage oceanStage) {
        root = new AnchorPane();
        scene = new Scene(root, dimension * scale, dimension * scale); // Correct scene size based on grid

        // Initialize the map and ship
        OceanMap oceanMap = new OceanMap(dimension); // Use correct constructor with dimension
        ship = new Ship(oceanMap); // Initialize ship with oceanMap

        // Set up stage
        oceanStage.setScene(scene);
        oceanStage.setTitle("Ocean Game");
        oceanStage.show();

        // Draw the grid and ship
        drawMap();
        loadShipImage();
        startSailing(); // Start the event handler for ship movement
    }
}
