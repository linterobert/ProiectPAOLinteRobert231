package Customer;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import Produs.Comanda;
public class User{
    private final String userId;
    private String tipUser;
    private String firstName, lastName;
    private String email, phone;
    private String password;
    private Comanda cos;

    public String getTipUser() {
        return tipUser;
    }

    public void setTipUser(String tipUser) {
        this.tipUser = tipUser;
    }

    public List<Comanda> getComenzi() {
        return comenzi;
    }

    public void setComenzi(List<Comanda> comenzi) {
        this.comenzi = comenzi;
    }

    private List<Comanda> comenzi = new ArrayList<>();
    public Comanda getCos() {
        return cos;
    }

    public void setCos(Comanda cos) {
        this.cos = cos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String phone,  String tipUser, String password) {
        this.userId = UUID.randomUUID().toString();
        this.tipUser = tipUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.cos = new Comanda(this.userId);
    }

    public User(String customerId, Scanner in) throws ParseException {
        this.userId = customerId;
        this.read(in);
    }

    public User(String customerId, ResultSet in) throws SQLException {
        this.userId = customerId;
        this.read(in);
    }

    public void read(ResultSet in) throws SQLException {
        this.firstName = in.getString("firstName");
        this.lastName = in.getString("lastName");
        this.email = in.getString("email");
        this.phone = in.getString("phone");
    }

    public void read(Scanner in) throws ParseException {
        System.out.println("First name: ");
        this.firstName = in.nextLine();
        System.out.println("Last name: ");
        this.lastName = in.nextLine();
        System.out.println("Email: ");
        this.email = in.nextLine();
        System.out.println("Phone: ");
        this.phone = in.nextLine();
    }

    @Override
    public String toString() {
        return "{" +
                "customerId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String toCSV(){
        return userId +
                "," + firstName +
                "," + lastName +
                "," + email +
                "," + phone;
    }


    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(tipUser, user.tipUser) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(password, user.password) && Objects.equals(cos, user.cos) && Objects.equals(comenzi, user.comenzi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, tipUser, firstName, lastName, email, phone, password, cos, comenzi);
    }
}
