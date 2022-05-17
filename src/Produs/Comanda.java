package Produs;
import Customer.*;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class Comanda {

    private Boolean Status;

    private final String ComandaId;

    private final String UserId;
    private HashMap<Produs, Integer> Produse = new HashMap<>();


    public Comanda(String UserId, HashMap<Produs, Integer> Produse){
        this.ComandaId = UUID.randomUUID().toString();
        this.UserId = UserId;
        this.Produse = Produse;
        this.Status = true;
    }

    public Comanda(String UserId){
        this.ComandaId = UUID.randomUUID().toString();
        this.Status = true;
        this.UserId = UserId;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public String getComandaId() {
        return ComandaId;
    }

    public String getUserId() {
        return UserId;
    }

    public HashMap<Produs, Integer> getProduse() {
        return Produse;
    }

    public void setProduse(HashMap<Produs, Integer> produse) {
        Produse = produse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comanda comanda = (Comanda) o;
        return ComandaId == comanda.ComandaId && UserId == comanda.UserId && Objects.equals(Status, comanda.Status) && Objects.equals(Produse, comanda.Produse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Status, ComandaId, UserId, Produse );
    }
}
