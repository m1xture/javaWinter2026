package main.java.com.app.hw26;

public class Main {
    public static void main(String[] args) {
        User user = new User("Julie");
        Address adr = new Address("Deribasivska str. 7");
        System.out.println(user.toString());
        System.out.println(user.getAddress());
        user.setAddress(adr);
        System.out.println(user.getAddress().toString());
        System.out.println(user.toString());
    }
}
