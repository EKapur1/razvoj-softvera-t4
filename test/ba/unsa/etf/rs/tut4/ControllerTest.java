package ba.unsa.etf.rs.tut4;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.ArrayList;

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

    public TextArea unesiArtikle;
    public Button dugmeDodaj;
    public TextArea ispisiArtikle;
    public ChoiceBox<String> liste;
    public Spinner<Integer> spin;
    public Button dodaj;
    public TextArea ispisiRacun;
    Racun racun;
    public ArrayList<Artikal> artikli;

    @Test
    public void testButtonClick (FxRobot robot) {
        TextArea t2 = robot.lookup("#ispisiArtikle").queryAs(TextArea.class);
        TextArea t3 = robot.lookup("#ispisiRacun").queryAs(TextArea.class);
        robot.clickOn("#unesiArtikle");
        robot.write("HLB001,Crni hljeb,1\n" +
                "HLB002,Bijeli hljeb,1.10\n" +
                "HLB002,Bijeli hljeb,1.10\n" +
                "MLK001,Mlijeko Meggle,1.10");
        robot.clickOn("#dugmeDodaj");
        assertEquals("HLB001,Crni hljeb,1.0\n" +
                "HLB002,Bijeli hljeb,1.1\n" +
                "MLK001,Mlijeko Meggle,1.1\n", t2.getText());

    }

}