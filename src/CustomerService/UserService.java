package CustomerService;
import Customer.*;
import Produs.*;

public interface UserService {

    void addProdusCos(User user, Produs produs);

    void removeProdusCos(User user, Produs produs);


    void finalizeazaComanda(User user);

    void changePassword(User user, String parola);
}
