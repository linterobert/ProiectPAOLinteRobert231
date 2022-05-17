package Produs;

import java.util.Arrays;
import java.util.Scanner;

public class Tricou extends Produs{

    public Tricou(String name, double pret) {
        super(name, pret);
        String[] marime = {"S", "M", "L", "XL", "XXL"};
        this.marimi = marime.clone();
        this.cantitati = new int[]{0, 0, 0, 0, 0};
    }

    @Override
    public String toString() {
        return "Tricou{" +
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
