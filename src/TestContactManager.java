public class TestContactManager {

    public static void main(String[] args) {


//        Contacts.displayMenu();
//        Contacts.userInput();
        Contacts contact = new Contacts();
        System.out.println(contact.writeContacts("Andrew", 123 - 4569090));
        System.out.println(Contacts.getContacts());


    }
}
