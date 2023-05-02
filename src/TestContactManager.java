public class TestContactManager {


    public static void main(String[] args) {


        Contacts.displayMenu();
        Contacts.userInput();

        System.out.println(Contacts.getContacts());

        Contacts.addContact();



    }
}
