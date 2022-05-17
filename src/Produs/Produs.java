package Produs;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public abstract class Produs {
    private final String produsId;
    private String name;

    private double pret;
    String[] marimi = {"S", "M", "L", "XL", "XXL"};
    int[] cantitati;

    public Produs(String name, double pret) {
        this.produsId = UUID.randomUUID().toString();
        this.name = String.copyValueOf(name.toCharArray());
        this.pret = pret;
    }


    public void read(Scanner in){
        System.out.println("Denumire produs: ");
        this.name = in.nextLine();
        System.out.println("Pret: ");
        this.pret = Double.parseDouble(in.nextLine());
    }

    public void print(){
        System.out.println("Denumire produs: ");
        System.out.println(this.name);
        System.out.println("\nPret: ");
        System.out.println(this.pret);
    }

    public String getProdusId() {
        return produsId;
    }

    public double getPret() {
        return pret;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "produsId=" + produsId +
                ", tipProdusId=" +
                ", name='" + name + '\'' +
                ", pret=" + pret +
                '}';
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
