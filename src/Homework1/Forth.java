package Homework1;

/**
 Create phonebook where each object is a contact with some parameters
 (phone, address, e-mail, name, surname)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Forth {
    public static void main(String[] args) throws IOException {

        Set<Contact> phonebook = new HashSet<Contact>();
        Contact contact1 = new Contact("+7-922-589-65-89", "SPB, Nevskiy, 5/1", "peter@smith.com", "Peter", "Smith");
        phonebook.add(contact1);
    }
    public static class Contact {
        String phone;
        String address;
        String email;
        String name;
        String surname;

        public Contact(String phone, String address, String email, String name, String surname) {
            this.phone = phone;
            this.address = address;
            this.email = email;
            this.name = name;
            this.surname = surname;
        }
    }

}
