import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    private static final String PHONE_REGEX = "(\\d{3})(\\d{3})(\\d{3})";
    private static final String NUMBER_REGEX = "+48 $1 $2 $3";
    private static final String INPUT_REGEX = "\\D+";
    private static Set<String> phoneNumbers = new TreeSet<>();

    public static void main(String[] args) {

        System.out.println("\n\t Welcome to the phone book! \n");

        while (true) {
            System.out.println("\t Please enter the phone number: ");
            String input = new Scanner(System.in).nextLine();
            if (input.equalsIgnoreCase("print")) {
                print();
            } else if (input.equals("exit")) {
                System.out.println("Bye bye!");
                return;
            } else {
                String number = input.replaceAll(INPUT_REGEX, "").trim();
                if((number.length() > 10) || (number.length() < 9)) {
                    System.out.println("Please enter a valid phone number");
                    continue;
                } else if (number.length() == 9) {
                    addPhoneNumber(number);
                }
            }
        }
    }
    public static void addPhoneNumber(String phoneNumber) {
        if (phoneNumbers.contains(phoneNumber)) {
            System.out.println("The phone number " + phoneNumber + " is already in the phone book");
            return;
        }
        phoneNumbers.add(phoneNumber);
        System.out.println("The phone number " + phoneNumber + " is added to the phone book");
    }
    public static void print() {
        if(phoneNumbers.isEmpty()) {
            System.out.println("There are no phone numbers");
            return;
        }
        for (String phone : phoneNumbers) {
            String number = phone.replaceAll(PHONE_REGEX, NUMBER_REGEX);
            System.out.println(number);
        }
    }
}