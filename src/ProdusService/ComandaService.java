package ProdusService;

import Customer.*;
import Produs.Comanda;
import Produs.Produs;

public interface ComandaService {
    void addProdus(Comanda comanda, Produs produs);

    double calculeazaTotal(Comanda comanda);

}
