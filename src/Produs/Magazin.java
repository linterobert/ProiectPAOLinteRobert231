package Produs;

import java.util.ArrayList;
import java.util.List;

public class Magazin {
    private static Magazin single_instance = null;

    public List<Produs> lista_produse;

    private Magazin(){
        lista_produse = new ArrayList<>();
    }

    public static Magazin getInstance(){
        if( single_instance == null )
            single_instance = new Magazin();
        return single_instance;
    }

    public List<Produs> getProducts() {
        return lista_produse;
    }

    public void setProducts(List<Produs> lista_produse) {
        this.lista_produse = lista_produse;
    }
}
