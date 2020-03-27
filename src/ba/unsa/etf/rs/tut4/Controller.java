package ba.unsa.etf.rs.tut4;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

import static ba.unsa.etf.rs.tut4.Artikal.izbaciDuplikate;

public class Controller {
    public TextArea unesiArtikle;
    public Button dugmeDodaj;
    public TextArea ispisiArtikle;
    public ChoiceBox liste;

    public void izbaci() {
        ArrayList<Artikal> lista = new ArrayList<>();
            String[] s = unesiArtikle.getText().split("\n");
            for(int i = 0; i < s.length; i++){
                lista.add(new Artikal(s[i]));
            }
            izbaciDuplikate(lista);
            StringBuilder novi = new StringBuilder();
            for(int i = 0; i < lista.size(); i++) {
                    novi.append(lista.get(i)).append("\n");
                }
                ispisiArtikle.setText(novi.toString());


            String nazivi = s[0] + ",";
            for(int i = 1; i < s.length; i++){
                nazivi += s[i] + ",";
        }
            String [] izbor = nazivi.split(",");
            for(int i = 0; i < izbor.length; i+=3){
                liste.getItems().add(izbor[i]);
                System.out.println(izbor[i]);
        }


    }
}
