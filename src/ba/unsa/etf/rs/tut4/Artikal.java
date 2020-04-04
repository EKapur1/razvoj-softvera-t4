package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Artikal {
    private String sifra, naziv;
    private double cijena;


    public Artikal(String s) {
       String[] str = s.split(",");
       setSifra(str[0]);
       setNaziv(str[1]);
       setCijena(Double.parseDouble(str[2]));
    }

    public Artikal(String sifra, String naziv, double cijena) {
        if(cijena < 0) throw new IllegalArgumentException("Cijena je negativna");
        if(sifra.equals("")) throw new IllegalArgumentException("Sifra je prazna");
        if(naziv.equals("")) throw new IllegalArgumentException ("Naziv je prazan");
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
        if(sifra.equals("")) throw new IllegalArgumentException("Sifra je prazna");
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv.equals("")) throw new IllegalArgumentException ("Naziv je prazan");
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if(cijena < 0) throw new IllegalArgumentException("Cijena je negativna");
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        String s = sifra + "," + naziv + "," + cijena;
        return s;
    }

    @Override
    public boolean equals(Object o) {
        Artikal a = (Artikal) o;
        return sifra.equals(a.sifra) && naziv.equals(a.naziv) &&
                cijena == a.cijena;
    }



    }
