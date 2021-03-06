package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static ba.unsa.etf.rs.tut4.Artikal.izbaciDuplikate;



public class Controller implements Initializable {
    public TextArea unesiArtikle;
    public Button dugmeDodaj;
    public TextArea ispisiArtikle;
    public ChoiceBox<String> liste;
    public Spinner<Integer> spin;
    public Button dodaj;
    public TextArea ispisiRacun;
    Racun racun;
    public ArrayList<Artikal> artikli;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        artikli = new ArrayList<>();
        racun = new Racun();
    }


    public void racun(ActionEvent actionEvent) {

        for (Artikal a : artikli) {
            if (liste.getSelectionModel().getSelectedItem().equals(a.getSifra())) {
                racun.dodajStavku(a, spin.getValue());
                break;
            }
        }
        ispisiRacun.setText(racun.toString());
    }


    public void izbaci() {
        ArrayList<Artikal> lista = new ArrayList<>();
        String[] s = unesiArtikle.getText().split("\n");
        for (int i = 0; i < s.length; i++) {
            lista.add(new Artikal(s[i]));
        }
        izbaciDuplikate(lista);


        artikli.addAll(lista);

        StringBuilder novi = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            novi.append(lista.get(i)).append("\n");
        }
        ispisiArtikle.setText(novi.toString());

        String nazivi = s[0] + ",";
        for (int i = 1; i < s.length; i++) {
            nazivi += s[i] + ",";
        }
        String[] izbor = nazivi.split(",");
        for (int i = 0; i < izbor.length; i += 3) {
            liste.getItems().add(izbor[i]);
        }
    }

}