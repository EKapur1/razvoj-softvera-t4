package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Racun {

    private ArrayList<Stavka> stavke;

    public Racun() {
        this.stavke = new ArrayList<>();
    }

    public void dodajStavku(Artikal artikal, int kolicina) {
        if (stavke.isEmpty()) {
            stavke.add(new Stavka(artikal, kolicina));
        } else {
            for (int i = 0; i < stavke.size(); i++) {
                if (stavke.get(i).getArtikal().getSifra().equals(artikal.getSifra())) {
                    stavke.set(i, new Stavka(artikal, stavke.get(i).getKolicina() + kolicina));
                } else if (i == stavke.size() - 1) {
                    //Ako se ne nalazi dodaj novi par
                    stavke.add(new Stavka(artikal, kolicina));
                    break;
                }
            }

        }
    }

    public double ukupanIznos() {
        double iznos = 0;
        for (Stavka stavka : stavke) {
            iznos += stavka.getArtikal().getCijena() * stavka.getKolicina();
        }
        return iznos;
    }

    public ArrayList<Stavka> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<Stavka> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Stavka stavka : stavke) {
            output.append(stavka.getArtikal().getSifra()).append(" ").append(stavka.getArtikal().getCijena() * stavka.getKolicina()).append("\n");
        }
        output.append("Ukupan iznos: ").append(ukupanIznos());
        return output.toString();
    }

    private static class Stavka {
        private Artikal artikal;
        private int kolicina;

        public Stavka(Artikal artikal, int kolicina) {
            this.artikal = artikal;
            this.kolicina = kolicina;
        }

        public Artikal getArtikal() {
            return artikal;
        }

        public void setArtikal(Artikal artikal) {
            this.artikal = artikal;
        }

        public int getKolicina() {
            return kolicina;
        }

        public void setKolicina(int kolicina) {
            this.kolicina = kolicina;
        }
    }

}
