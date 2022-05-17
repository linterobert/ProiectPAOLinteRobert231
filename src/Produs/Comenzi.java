package Produs;

import java.util.ArrayList;
import java.util.List;

public class Comenzi {
    private static Comenzi single_instance = null;

    public List<Comanda> lista_comenzi;

    private Comenzi(){
        lista_comenzi = new ArrayList<>();
    }

    public static Comenzi getInstance(){
        if( single_instance == null )
            single_instance = new Comenzi();
        return single_instance;
    }

    public List<Comanda> getComenzi() {
        return lista_comenzi;
    }

    public void setComenzi(List<Comanda> lista_comenzi) {
        this.lista_comenzi = lista_comenzi;
    }
}
