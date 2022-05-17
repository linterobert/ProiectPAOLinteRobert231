package ProdusService;

import Produs.Comanda;
import Produs.Produs;

import java.util.HashMap;
import java.util.Map;

public class ComandaImpl implements ComandaService{

    @Override
    public void addProdus(Comanda comanda, Produs produs){
        if(comanda.getProduse().containsKey(produs))
            comanda.getProduse().put(produs, comanda.getProduse().get(produs) + 1);
        else
            comanda.getProduse().put(produs, 1);
    }



    @Override
    public double calculeazaTotal( Comanda comanda ){
        double total = 0;
        for(Map.Entry<Produs, Integer > x : comanda.getProduse().entrySet() ){
            if( x.getKey() != null ){
                total = x.getKey().getPret()*x.getValue();
            }
        }
        return total;
    }

}
