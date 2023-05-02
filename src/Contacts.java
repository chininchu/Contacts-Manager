import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Contacts {

    // Contact and Phone Number properties

    public String name;

    public int phoneNumber;


    // Constructor

    public Contacts(String name, int phoneNumber) {

        this.name = name;
        this.phoneNumber = phoneNumber;


    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static String getContacts() {


        Path getContacts = Paths.get("src/data/contacts.txt");


        List<String> contactList;
        try {
            contactList = Files.readAllLines(getContacts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactList.get(i));


        }

        return "";


    }

    public Path writeContacts() {


        List<String> contactList = Arrays.asList(this.name, Integer.toString(this.phoneNumber));

        try {
//            Files.write(getContacts,contactList);

            return Files.write(Paths.get("src/data/contacts.txt"), List.of(this.name + " " + "|" + " " + this.phoneNumber), StandardOpenOption.APPEND);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void displayMenu() {

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):\n");


    }

    public static void addContact() {

        // User adds a new name

        System.out.println("Enter a name ");
        Scanner sc = new Scanner(System.in);
        String addName = sc.next();

        // User adds a PhoneNumber

        System.out.println("Enter a Number");
        String newNumber = sc.next();


    }


    public static void userInput() {

        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();


        for (int i = 1; userInput <= 5; i++) {

            if (userInput == 1) {

                System.out.println(getContacts());
                break;


            }


        }


    }

}



