package ProdusService;
import Customer.User;
import Produs.*;
import java.util.*;

public interface ComenziService {

    List<Comanda> getComenziByUserId(Comenzi comenzi, User user);

}
