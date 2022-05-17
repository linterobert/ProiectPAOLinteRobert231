package ProdusService;
import Produs.*;

public interface MagazinService {
    void createProdus(Magazin magazin, Produs produs);

    void printProduse(Magazin magazin);

    void actualizeazaStoc(Magazin magazin, Produs produs, String marime, int stoc);


    default int getNumberOfProducts(Magazin magazin) {
        return  magazin.getProducts().size();
    }
}
