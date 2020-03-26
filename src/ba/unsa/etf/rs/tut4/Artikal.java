package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Artikal {
    private String sifra, naziv;
    private double cijena;


    public Artikal(String s) {
       String[] str = s.split(",");
       sifra = str[0];
       naziv = str[1];
       cijena = Double.parseDouble(str[2]);
    }

    public Artikal(String sifra, String naziv, double cijena) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.cijena = cijena;
    }

    public static void izbaciDuplikate(ArrayList<Artikal> lista) {
        for(int i = 0; i < lista.size(); i++){
            for(int j = i + 1; j < lista.size(); j++){
                if(lista.get(i).getSifra().equals(lista.get(j).getSifra()) && lista.get(i).getNaziv().equals(lista.get(j).getNaziv()) && lista.get(i).getCijena() == lista.get(j).getCijena()){
                    lista.remove(j);
                    j--;
                }
            }
        }
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        return sifra + "," + naziv + "," + cijena;
    }


}
