package Produs;

import java.util.Arrays;
import Produs.*;
public class Papuci extends Produs{

    public Papuci(String name, double pret) {
        super(name, pret);
        String[] marime = {"38", "39", "40", "41", "42"};
        this.marimi = marime.clone();
        this.cantitati = new int[]{0, 0, 0, 0, 0};
    }

    @Override
    public String toString() {
        return "Papuci{" +
                super.toString() +
                "marimi=" + Arrays.toString(marimi) +
                ", cantitati=" + Arrays.toString(cantitati) +
                '}';
    }

    public int[] getCantitati() {
        return cantitati;
    }

    public void setCantitati(int[] cantitati) {
        this.cantitati = cantitati;
    }

    public String[] getMarimi() {
        return marimi;
    }

    public void setMarimi(String[] marimi) {
        this.marimi = marimi;
    }
}
