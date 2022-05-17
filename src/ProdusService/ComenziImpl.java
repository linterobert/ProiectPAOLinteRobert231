package ProdusService;

import Customer.User;
import Produs.Comanda;
import Produs.Comenzi;

import java.util.*;

public class ComenziImpl implements ComenziService{

    @Override
    public List<Comanda> getComenziByUserId(Comenzi comenzi, User user){
        List<Comanda> com = new ArrayList<Comanda>();
        for( int i = 0; i < comenzi.getComenzi().size(); i++ ){
            if ( comenzi.getComenzi().get(i).getUserId() == user.getUserId() ){
                com.add(comenzi.getComenzi().get(i));
            }
        }
        return com;
    }


}
