import Config.DatabaseConnection;
import Customer.User;
import Produs.Pantalon;
import Produs.*;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) throws SQLException {
        String user = "";
        String tipuser = "";
        while(true){
            if( user.equals("") ) {
                System.out.println("Optiuni disponibile: ");
                System.out.println("1.login");
                System.out.println("2.register");
                System.out.println("-------------------------------------");
                System.out.print("\nIntroduceti optiunea: ");
                Scanner x = new Scanner(System.in);
                String optiune = x.nextLine();
                System.out.println("-------------------------------------");
                if(optiune.equals("1")){
                    System.out.print("\nIntroduceti adresa de email: ");
                    String email = x.nextLine();
                    System.out.print("\nIntroduceti parola: ");
                    String parola = x.nextLine();
                    String [] date = ProjectRespository.login(email, parola);
                    user = date[0];
                    tipuser = date[1];
                    ProjectRespository.addOperatie(user, "login");
                    System.out.println("-------------------------------------");
                }
                if(optiune.equals("2")){
                    System.out.print("\nIntroduceti prenumele: ");
                    String prenume = x.nextLine();
                    System.out.print("\nIntroduceti numele: ");
                    String nume = x.nextLine();
                    System.out.print("\nIntroduceti email-ul: ");
                    String email = x.nextLine();
                    System.out.print("\nIntroduceti nr de telefon: ");
                    String tel = x.nextLine();
                    System.out.print("\nIntroduceti parola: ");
                    String parola = x.nextLine();
                    ProjectRespository.addUser(new User(nume, prenume, email, tel, "user", parola));
                    ProjectRespository.addOperatie(email, "autentificare");
                }
            }
            if( tipuser.equals("user") ){
                System.out.println("Optiuni disponibile: ");
                System.out.println("1.afisare produse;");
                System.out.println("2.afisare detalii produs;");
                System.out.println("3.adaugare produs in cos;");
                System.out.println("4.stergere produs din cos;");
                System.out.println("5.afisare cos;");
                System.out.println("6.finalizare comanda;");
                System.out.println("7.delogare;");
                System.out.print("Introduceti optiunea: ");
                Scanner x = new Scanner(System.in);
                String optiune = x.nextLine();
                System.out.println("-------------------------------------");
                if( optiune.equals("1") ){
                    ProjectRespository.afiseazaProduse();
                    ProjectRespository.addOperatie(user, "afisare_produse");
                    System.out.println("-------------------------------------");
                }
                if( optiune.equals("2") ){
                    System.out.print("Introduceti numele produsului: ");
                    String nume = x.nextLine();
                    ProjectRespository.afiseazaProdus(nume);
                    ProjectRespository.addOperatie(user, "afisare_detalii_produs");
                    System.out.println("-------------------------------------");
                }
                if( optiune.equals("3") ){
                    System.out.print("Introduceti numele produsului: ");
                    String nume = x.nextLine();
                    System.out.print("Introduceti cantitatea: ");
                    String cantitate = x.nextLine();
                    System.out.print("Introduceti marimea: ");
                    String marime = x.nextLine();
                    String cosId = ProjectRespository.get_cosId(user);
                    ProjectRespository.addOperatie(user, "add_produs_cos");
                    ProjectRespository.addProdusCos(nume, cosId, Integer.parseInt(cantitate), marime);
                    System.out.println("-------------------------------------");
                }
                if( optiune.equals("4") ){
                    System.out.print("Introduceti numele produsului: ");
                    String nume = x.nextLine();
                    String produsId = ProjectRespository.getProdusIdByName(nume);
                    String cosId = ProjectRespository.get_cosId(user);
                    ProjectRespository.sterge_produs_cos(cosId, produsId);
                    ProjectRespository.addOperatie(user, "sterge_produs_cos");
                    System.out.println("-------------------------------------");
                }
                if( optiune.equals("5") ){
                    String cosId = ProjectRespository.get_cosId(user);
                    ProjectRespository.afiseaza_cos(cosId);
                    ProjectRespository.addOperatie(user, "afisare_cos");
                    System.out.println("-------------------------------------");
                }
                if( optiune.equals("6") ){
                    String cosId = ProjectRespository.get_cosId(user);
                    ProjectRespository.addOperatie(user, "finalizare_comanda");
                    ProjectRespository.finalizeazaComanda(cosId);
                }
                if( optiune.equals("7") ){
                    user = "";
                    tipuser = "";
                }
            }
            if( tipuser.equals("admin") ){
                System.out.println("Optiuni disponibile: ");
                System.out.println("1.afisare produse;");
                System.out.println("2.afisare detalii produs;");
                System.out.println("3.inserare produs;");
                System.out.println("4.actualizare pret;");
                System.out.println("5.actualizare stoc;");
                System.out.println("6.delogare;");
                System.out.print("Introduceti optiunea: ");
                Scanner x = new Scanner(System.in);
                String optiune = x.nextLine();
                System.out.println("-------------------------------------");
                if( optiune.equals("1") ){
                    ProjectRespository.afiseazaProduse();
                    ProjectRespository.addOperatie(user, "afisare_produse");
                    System.out.println("-------------------------------------");
                }
                if( optiune.equals("2") ){
                    System.out.print("Introduceti numele produsului: ");
                    String nume = x.nextLine();
                    ProjectRespository.afiseazaProdus(nume);
                    ProjectRespository.addOperatie(user, "afisare_produs");
                    System.out.println("-------------------------------------");
                }
                if( optiune.equals("3") ){
                    System.out.print("Introduceti tipul produsului: ");
                    String tip = x.nextLine();
                    if( tip.equals("tricou") ){
                        System.out.print("Introduceti numele tricoului: ");
                        String nume = x.nextLine();
                        System.out.print("Introduceti pretul: ");
                        String pret = x.nextLine();
                        ProjectRespository.addTricou(new Tricou(nume, Double.parseDouble(pret)));
                    }
                    if( tip.equals("pantalon") ){
                        System.out.print("Introduceti numele tricoului: ");
                        String nume = x.nextLine();
                        System.out.print("Introduceti pretul: ");
                        String pret = x.nextLine();
                        ProjectRespository.addPantalon(new Pantalon(nume, Double.parseDouble(pret)));
                    }
                    if( tip.equals("papuci") ){
                        System.out.print("Introduceti numele tricoului: ");
                        String nume = x.nextLine();
                        System.out.print("Introduceti pretul: ");
                        String pret = x.nextLine();
                        ProjectRespository.addPapuci(new Papuci(nume, Double.parseDouble(pret)));
                    }
                    ProjectRespository.addOperatie(user, "adaugare_produs");
                    System.out.println("-------------------------------------");
                }
                if( optiune.equals("4") ){
                    System.out.print("Introduceti numele tricoului: ");
                    String nume = x.nextLine();
                    System.out.print("Introduceti pretul: ");
                    String pret = x.nextLine();
                    ProjectRespository.actualizare_pret(nume, pret);
                    ProjectRespository.addOperatie(user, "actualizare_pret");
                    System.out.println("-------------------------------------");
                }
                if( optiune.equals("5") ){
                    System.out.print("Introduceti numele tricoului: ");
                    String nume = x.nextLine();
                    System.out.print("Introduceti marimea: ");
                    String marime = x.nextLine();
                    System.out.print("Introduceti cantitatea: ");
                    String cantitate = x.nextLine();
                    ProjectRespository.actualizeazaStoc(nume,marime,cantitate);
                    ProjectRespository.addOperatie(user, "modificare_stoc");
                    System.out.println("-------------------------------------");
                }
                if( optiune.equals("6") ){
                    ProjectRespository.addOperatie(user, "delogare");
                    user = "";
                    tipuser = "";
                }
            }
        }


    }
}
