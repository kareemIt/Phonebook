import java.io.File;
import  java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) throws Exception {

        final int MAX_SIZE = 100;

        String[] first = new String[MAX_SIZE];

        String[] last = new String[MAX_SIZE];

        String[] phoneNumber = new String[MAX_SIZE];

        Scanner file = new Scanner(new File("numbers.txt"));

        int counterL = 0;
        int counterR = 0;
        int counter = 0;

        Scanner in = new Scanner(System.in);

        int numberOfEntries = howMany(MAX_SIZE, file);

        while (file.hasNext()) {

            last[counter] = file.next();
            //System.out.println(last[counter]);

            first[counter] = file.next();
           // System.out.println(first[counter]);

            phoneNumber[counter] = file.next();
            //System.out.println(phoneNumber[counter]);

            counter++;

        }


        while (true) {

            System.out.println("lookup, reverse-lookup, quit (l/r/q)?");
            String choice = in.nextLine();

            if (choice.equals("l")) {
                System.out.println("last name?");
                String lastN = in.nextLine();
                System.out.println("first name?");
                String firstN = in.nextLine();
                Boolean N = lookUpf(lastN, firstN, first, last, numberOfEntries);
                if (phoneNumber[lookUpN(firstN, lastN, first, last, numberOfEntries)]!=null) {
                    System.out.println(firstN + " " + lastN + "'s phone number is " + phoneNumber[lookUpN(firstN, lastN, first, last, numberOfEntries)]);
                    counterL++;
                } else {
                    System.out.println("-- Name not found");
                    counterL++;
                }
            }

            if (choice.equals("r")) {
                System.out.println("phone number (nnn-nnn-nnnn)?");
                String pNumber = in.nextLine();
                reverse(numberOfEntries,pNumber,phoneNumber,last,first);
                counterR++;
            }
            if (choice.equals("q")) {
                System.out.println(counterL + " lookups performed");
                System.out.println(counterR + " reverse lookups performed");
                break;
            }

        }

    }


        public static int howMany ( int max, Scanner in) throws Exception {
            int counter = 0;
            while (in.hasNext() && counter < max) {
                counter++;
            }
            return counter;
        }

        public static Boolean lookUpf (String firstNameU, String lastNameU, String[]first, String[]last,int numEntries){
            for (int i = 0; i < numEntries; i++) {
                if (firstNameU.equals(first[i]))
                    for (int j = 0; j < numEntries; j++) {
                        if (lastNameU.equals(last[j]))
                            return true;
                    }
            }
            return false;
        }

        public static int lookUpN (String firstNameU, String lastNameU, String[]first, String[]last,int numEntries){
            int counter = 0;
            for (counter = 0; counter < numEntries / 3; counter++) {
                if (lastNameU.equals(last[counter]) && firstNameU.equals(first[counter])) {
                    return counter;
                }
            }
            return counter;
        }
        public static void reverse ( int numEntries, String number, String[]phonenumber, String[]last, String[]first){
            int counter = 0;
            for (counter = 0; counter < numEntries / 3; counter++) {
                if (number.equals(phonenumber[counter])) {
                    System.out.println(number + " belongs to " + last[counter] + " " + first[counter]);
                    return;
                }

            }
            System.out.println("-- Phone number not found");
        }


    }

