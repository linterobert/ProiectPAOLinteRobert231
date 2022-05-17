import Config.DatabaseConnection;
import Customer.User;
import Produs.Produs;
import Produs.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.time.*;

public class ProjectRespository {
    public static void addOperatie(String userId, String operatie){
        String query = "insert into \"Operatii\" values(?, ?, ?, ?)";
        LocalDate data = LocalDate.now();
        String d = data.toString();
        LocalTime x = LocalTime.now();
        String o = x.toString();
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)){
            statement.setString(1, userId);
            statement.setString(2, operatie);
            statement.setString(3, d);
            statement.setString(4, o);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addUser(User user){
        String query = "insert into \"User\" values(?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)){
            statement.setString(1, user.getUserId());
            statement.setString(2, user.getTipUser());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getPassword());
            statement.setString(8, user.getCos().getComandaId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        createComanda(user);
    }
    public static String[] login(String email, String password){
        String query = "select * from \"User\" where email = ? and password = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String userId = result.getString(1);
                String tipUser = result.getString(2);
                String firstName = result.getString(3);
                String lastName = result.getString(4);
                String Email = result.getString(5);
                String phone = result.getString(6);
                String Password = result.getString(7);
                System.out.println("Conectare realizata cu succes!");
                return new String[]{userId, tipUser};
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Parola sau adresa gresite!");
        return new String[]{"", ""};
    }
    public static void addTricou(Tricou produs){
        String query = "insert into \"Produs\" values(?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)){
            statement.setString(1, produs.getProdusId());
            statement.setString(2, produs.getName());
            statement.setDouble(3, produs.getPret());
            String marimi = "";
            for( String i : produs.getMarimi() ){
                marimi = marimi.concat(i);
                marimi = marimi.concat("/");
            }
            statement.setString(4, marimi);
            String cantitati = "";
            for( int i : produs.getCantitati() ){
                cantitati = cantitati.concat(Integer.toString(i));
                cantitati = cantitati.concat("/");
            }
            statement.setString(5, cantitati);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addPantalon(Pantalon produs){
        String query = "insert into \"Produs\" values(?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)){
            statement.setString(1, produs.getProdusId());
            statement.setString(2, produs.getName());
            statement.setDouble(3, produs.getPret());
            String marimi = "";
            for( String i : produs.getMarimi() ){
                marimi = marimi.concat(i);
                marimi = marimi.concat("/");
            }
            statement.setString(4, marimi);
            String cantitati = "";
            for( int i : produs.getCantitati() ){
                cantitati = cantitati.concat(Integer.toString(i));
                cantitati = cantitati.concat("/");
            }
            statement.setString(5, cantitati);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addPapuci(Papuci produs){
        String query = "insert into \"Produs\" values(?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)){
            statement.setString(1, produs.getProdusId());
            statement.setString(2, produs.getName());
            statement.setDouble(3, produs.getPret());
            String marimi = "";
            for( String i : produs.getMarimi() ){
                marimi = marimi.concat(i);
                marimi = marimi.concat("/");
            }
            statement.setString(4, marimi);
            String cantitati = "";
            for( int i : produs.getCantitati() ){
                cantitati = cantitati.concat(Integer.toString(i));
                cantitati = cantitati.concat("/");
            }
            statement.setString(5, cantitati);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createComanda(User user){
        String query = "insert into \"Comanda\" values(?, 1, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)){
            statement.setString(1, user.getCos().getComandaId());
            statement.setString(2, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String get_cosId(String userId){
        String query = "select * from \"Comanda\" where userId = ? and status = 1";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, userId);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String cosId = result.getString(1);
                return cosId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String getProdusIdByName(String nume){
        String query = "select * from \"Produs\" where name = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, nume);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String cosId = result.getString(1);
                return cosId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String getProdusNameById(String nume){
        String query = "select * from \"Produs\" where produsId = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, nume);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String cosId = result.getString(2);
                return cosId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String getProdusPretById(String nume){
        String query = "select * from \"Produs\" where produsId = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, nume);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String cosId = result.getString(3);
                return cosId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static void addProdusCos(String nume, String comandaId, int cantitate, String marime){
        String produsId = getProdusIdByName(nume);
        String stoc = returnCantitate(nume, marime);
        int nr = Integer.parseInt(stoc);
        nr -= cantitate;
        if(nr >= 0) {
            actualizeazaStoc(nume, marime, Integer.toString(nr));
            String query = "insert into \"Comanda_Produs\" values(?, ?, ?, ?)";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
                statement.setString(2, produsId);
                statement.setString(1, comandaId);
                statement.setInt(3, cantitate);
                statement.setString(4, marime);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Produs adaugat cu succes in cos!");
        }
        else{
            System.out.println("Stoc insuficient!");
        }
    }
    public static void finalizeazaComanda(String comandaId){
        String query = "delete from \"Comanda_Produs\" where coamndaId = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, comandaId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void sterge_produs_cos(String comandaId, String produsId){
        String query = "delete from \"Comanda_Produs\" where coamndaId = ? and produsId = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, comandaId);
            statement.setString(2, produsId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void afiseazaProduse(){
        String query = "select * from \"Produs\"";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String nume = result.getString(2);
                String pret = result.getString(3);
                nume = "Denumire: ".concat(nume).concat(", pret: ").concat(pret);
                System.out.println(nume);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void actualizeazaStoc(String nume, String marime, String cantitate){
        String query = "select * from \"Produs\" where name = ?";
        String [] vmarimi;
        String [] vcantitati = {};
        int j = -1;
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, nume);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String marimi = result.getString(4);
                String cantitati = result.getString(5);
                vmarimi = marimi.split("/");
                vcantitati = cantitati.split("/");
                for( int i = 0; i < vmarimi.length; i++ ){
                    if( vmarimi[i].equals(marime) ){
                        vcantitati[i] = cantitate;
                        break;
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cantitate = "";
        for( String i : vcantitati ){
            cantitate = cantitate.concat(i).concat("/");
        }
        query = "update \"Produs\" set cantitati = ? where name = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, cantitate);
            statement.setString(2, nume);
            int result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String returnCantitate(String nume, String marime){
        String query = "select * from \"Produs\" where name = ?";
        String [] vmarimi;
        String [] vcantitati = {};
        int j = -1;
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, nume);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String marimi = result.getString(4);
                String cantitati = result.getString(5);
                vmarimi = marimi.split("/");
                vcantitati = cantitati.split("/");
                for( int i = 0; i < vmarimi.length; i++ ){
                    if( vmarimi[i].equals(marime) ){
                        return vcantitati[i];
                    }
                }
                return "0";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "0";
    }
    public static void afiseazaProdus(String name){
        String query = "select * from \"Produs\" where name = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String nume = result.getString(2);
                String pret = result.getString(3);
                String marimi = result.getString(4);
                String cantitati = result.getString(5);
                System.out.println("Nume produs: ".concat(nume).concat("\nPret: ").concat(pret).concat("\nMarimi: ").concat(marimi).concat("\nCantitati: ").concat(cantitati));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void actualizare_pret(String nume, String pret){
        String query = "update \"Produs\" set pret = ? where name = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, pret);
            statement.setString(2, nume);
            int result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void afiseaza_cos(String comandaId){
        String query = "select * from \"Comanda_Produs\" where coamndaId = ?";
        Double total = 0.00;
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareCall(query)){
            statement.setString(1, comandaId);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String produsId = result.getString(2);
                String cantitate = result.getString(3);
                String marime = result.getString(4);
                String nume = String.valueOf(getProdusNameById(produsId));
                String pret = String.valueOf(getProdusPretById(produsId));
                total += Double.parseDouble(pret)*Integer.parseInt(cantitate);
                System.out.println("Denumire: ".concat(nume).concat(", cantitate: ").concat(cantitate).concat(", pret: ").concat(pret).concat(", marime: ").concat(marime));
            }
            System.out.println("Total: ".concat(Double.toString(total)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
