import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.nio.file.Files.readAllBytes;

public class Contacts {


    public static void displayMenu() {

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):\n");


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


    public static void addContact() {

        // User adds a new name

        System.out.println("Enter a name ");
        Scanner sc = new Scanner(System.in);
        String addName = sc.next();

        // User adds a PhoneNumber

        System.out.println("Enter a Number");
        String newNumber = sc.next();


        try {

            Files.write(Paths.get("src/data/contacts.txt"), List.of(addName + " | " + newNumber), StandardOpenOption.APPEND);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void searchContact() {


        System.out.println("Enter the name of a Contact?");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();

        Path contactPath = Paths.get("src/data/contacts.txt");


        try {
            List<String> lines = Files.readAllLines(contactPath);
//            contactList = (ArrayList<String>) Files.readAllLines(contactPath);,

            for (String line : lines) {

//            System.out.println(contactList);

                if (line.toLowerCase().contains(userInput.toLowerCase())) {

                    System.out.println(line);

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void deleteContact() {


        System.out.println("Enter the name of a Contact that you would like to delete");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();

        Path contactPath = Paths.get("src/data/contacts.txt");


        try {
            List<String> lines = Files.readAllLines(contactPath);

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);

                if (line.toLowerCase().contains(userInput.toLowerCase())) {
                    lines.remove(line);

                }

            }

            Files.write(contactPath, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public static void userInput() {

        Scanner sc = new Scanner(System.in);
        int userInput;


        while (true) {
            displayMenu();
            userInput = sc.nextInt();


            if (userInput == 1) {

                getContacts();
                System.out.println("   ");


            } else if (userInput == 2) {

                addContact();
                System.out.println("   ");


            } else if (userInput == 3) {

                searchContact();
                System.out.println("   ");


            } else if (userInput == 4) {

                deleteContact();
                System.out.println("   ");


            } else if (userInput == 5) {
                System.out.println("Exiting Program");
                break;

            }


        }

    }

}





