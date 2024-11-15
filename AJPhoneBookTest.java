//Abby Jahns
//11.02.24
//Assignment 2: Phone Book
//AJPhoneBookTest.java -  Main method
//Resources: JpPhoneBook example code from class 
//and this stackoverflow discussion...
//https://stackoverflow.com/questions/4066729/creating-a-linkedlist-class-from-scratch
import java.util.Scanner;

public class AJPhoneBookTest {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        PhoneBookManager ajPhoneBook = new PhoneBookManager();
        //ajPhoneBook.testCodeManually(); //test code
        System.out.println("Welcome to your Phone Book Manager.");
        boolean loop = true;
        do{
            int menu = ajPhoneBook.mainMenu(input);
            switch (menu) {
                case 1: //add a contact
                    ajPhoneBook.addContactInfo(input, ajPhoneBook);
                    break;
                case 2: //view phone book
                    ajPhoneBook.print();
                    break;
                case 3: //search for a contact
                    ajPhoneBook.getSearchInfo(input, ajPhoneBook);
                    break;
                case 4: //modify a contact
                    ajPhoneBook.getModifyInfo(input, ajPhoneBook);
                    break;
                case 5: //delete a contact
                    ajPhoneBook.getDeleteInfo(input, ajPhoneBook);
                    break;
                case 0: //exit
                    loop = false;
                    break;
                default:
                    System.out.println("Error, enter a number 0 - 5");
            }
        }while (loop);

    }//end main method
}//end AJPhoneBookTest Class
