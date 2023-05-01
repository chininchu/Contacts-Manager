import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Contacts {


    public static String getContacts() {

        Path getContacts = Paths.get("src/data/contacts.txt");

//        List<String> contactList;

        List<String> contactList;
        String message = "Thanks for using Contact Manager";
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


}
