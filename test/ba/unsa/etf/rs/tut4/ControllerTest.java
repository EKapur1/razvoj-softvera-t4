package ba.unsa.etf.rs.tut4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.awt.*;

import static org.junit.Assert.assertNotNull;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {
    @Start
    public void start(Stage stage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("Kasa.fxml"));
            stage.setTitle("Kasa");
            stage.setScene(new Scene(root));
            stage.show();
            stage.toFront();
        }


}