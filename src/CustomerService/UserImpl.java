package CustomerService;

import Customer.User;
import Produs.Produs;
import Produs.Comanda;

public class UserImpl implements UserService{

    @Override
    public void addProdusCos(User user, Produs produs){
        if(user.getCos().getProduse().containsKey(produs))
            user.getCos().getProduse().put(produs, user.getCos().getProduse().get(produs) + 1);
        else
            user.getCos().getProduse().put(produs, 1);
    }

    @Override
    public void removeProdusCos(User user, Produs produs){
        if(user.getCos().getProduse().containsKey(produs))
            user.getCos().getProduse().remove(produs);
    }

    @Override
    public void finalizeazaComanda(User user){
        user.getCos().setStatus(false);
        user.getComenzi().add(user.getCos());
        user.setCos(new Comanda(user.getUserId()));
    }

    @Override
    public void changePassword(User user, String parola){
        user.setPassword(parola);
    }
}
