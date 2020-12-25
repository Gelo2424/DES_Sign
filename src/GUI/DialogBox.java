package GUI;

import javafx.scene.control.Alert;

public class DialogBox {

    public static void dialogAboutError(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Oh no! Something goes wrong.");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void dialogAboutInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Verification");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
