package Produs;

import java.util.Arrays;

public class Pantalon extends Produs{


    public Pantalon(String name, double pret) {
        super(name, pret);
        String[] marime = {"32", "34", "36", "38", "40"};
        this.marimi = marime.clone();
        this.cantitati = new int[] {0,0,0,0,0};
    }

    public int[] getCantitati() {
        return cantitati;
    }

    public void setCantitati(int[] cantitati) {
        this.cantitati = cantitati;
    }

    @Override
    public String toString() {
        return "Pantalon{" +
                super.toString() +
                "marimi= " + Arrays.toString(marimi) +
                "cantitati=" + Arrays.toString(cantitati) +
                '}';
    }

    public String[] getMarimi() {
        return marimi;
    }

    public void setMarimi(String[] marimi) {
        this.marimi = marimi;
    }
}
