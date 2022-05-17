package ProdusService;
import Produs.*;

public class MagazinImpl implements MagazinService{
    @Override
    public void createProdus(Magazin magazin, Produs produs) {
        magazin.getProducts().add(produs);
    }

    @Override
    public void printProduse(Magazin magazin) {
        for(Produs produs : magazin.getProducts()) {
            System.out.println("Product name: " + produs.getName());
        }
    }

    @Override
    public void actualizeazaStoc(Magazin magazin, Produs produs, String marime, int stoc){
        if( produs instanceof Pantalon ){
            for( int i = 0; i < ((Pantalon) produs).getMarimi().length; i++ ){
                if( ((Pantalon) produs).getMarimi()[i] == marime ){
                    ((Pantalon) produs).getCantitati()[i] = stoc;
                }
            }
        }
        else if( produs instanceof Papuci ){
            for( int i = 0; i < ((Papuci) produs).getMarimi().length; i++ ){
                if( ((Papuci) produs).getMarimi()[i] == marime ){
                    ((Papuci) produs).getCantitati()[i] = stoc;
                }
            }
        }
        else if( produs instanceof Tricou ){
            for( int i = 0; i < ((Tricou) produs).getMarimi().length; i++ ){
                if( ((Tricou) produs).getMarimi()[i] == marime ){
                    ((Tricou) produs).getCantitati()[i] = stoc;
                }
            }
        }
    }
}
