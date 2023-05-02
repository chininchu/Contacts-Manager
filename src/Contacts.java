import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Contacts {

    // Contact and Phone Number properties

    public String name;

    public int phoneNumber;


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

        return " ";


    }

    public Path writeContacts(String Name, int phoneNumber) {

//        Scanner sctest = new Scanner(System.in);
//
//        String userinput = sctest.next().toString();


        Path getContacts = Paths.get("src/data/contacts.txt");

        Path newContact;

        try {
            newContact = Files.writeString(getContacts, this.name + this.phoneNumber);
            System.out.println(newContact);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return newContact;


    }

    public static void displayMenu() {

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):\n");


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
