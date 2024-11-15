//Abby Jahns
//11.02.24
//Assignment 2: Phone Book
//PhoneBookManager.java  Manager class
//try / catch at line 165 & 240
//code until line 123 is for implementing Link Lists, after that is user interface

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBookManager {
    private PhoneBookNode front;

    public PhoneBookManager(){
        this.front = null;
    }

    //Adds new node to end of linked list
    public void add(String firstName, String lastName, String phoneNumber, 
                    String address, String city, String state, String zip) {
        if (front == null) {
            //add to empty list
            front = new PhoneBookNode(firstName, lastName, phoneNumber, 
                                      address, city, state, zip);
        } else {
            //add to the end of list
            PhoneBookNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new PhoneBookNode(firstName, lastName, phoneNumber, 
                                            address, city, state, zip);
        }
    }//end add method

    //Prints linked list
    public void print() {
        if (this.front == null) {
            System.out.println("Empty Phone Book");
            return;
        }
        PhoneBookNode current = this.front; 
        System.out.println(current.toString()); //print current node
        while(current.next != null) {
            current = current.next; //move to next node
            System.out.println(current.toString());
        }
    }//end print method

    //Search method, returns node of entered first and last name
    public PhoneBookNode search(String firstName, String lastName) {
        //check if front node is name searched
        if(this.front == null) return null;
        if (this.front.getFirstName().equals(firstName) && 
            this.front.getLastName().equals(lastName)) {
            return this.front;
        }
        PhoneBookNode current = this.front;
        boolean found = false;
        while (!found && current.next != null) {
            current = current.next;
            if (current.getFirstName().equals(firstName) && 
                current.getLastName().equals(lastName)) {
                found = true;
                return current;
            }
        }
        return null;
        // returns null if not found
    }//end search method

    public void modifyName(String firstName, String lastName, 
                            String changeFirst, String changeLast) {
        PhoneBookNode contact = this.search(firstName, lastName);
        contact.setFirstName(changeFirst);
        contact.setLastName(changeLast);
    }//end modifyName method

    public void modifyNumber(String firstName, String lastName, String number) {
        PhoneBookNode contact = this.search(firstName, lastName);
        contact.setNumber(number);
    }//end modifyNumber methhod

    public void modifyAddress(String firstName, String lastName, String address, 
                            String city, String state, String zip) {
        PhoneBookNode contact = this.search(firstName, lastName);
        contact.setAddress(address, city, state, zip);
    }

    public void delete(String firstName, String lastName) {
        //catches if entered name not found, else run code
        if (this.search(firstName, lastName) == null) {
            System.out.print("Name not found.");
        } else {
            //if first node is the one being deleted, make next node the front
            if (this.front.getFirstName().equals(firstName) && 
                this.front.getLastName().equals(lastName)) {
                this.front = this.front.next;
                return;
            }
            //find node while storing previous node
            PhoneBookNode prev = null;
            PhoneBookNode current = this.front;
            boolean found = false;
            while (!found && current.next != null) {
                prev = current;
                current = current.next;
                if (current.getFirstName().equals(firstName) && 
                    current.getLastName().equals(lastName)) {
                    found = true;
                }
            }//end while loop

            if (current.next != null) {
                prev.next = current.next;
            } else {
                //delete last in linked list
                prev.next = null;
            }
        }//end if statement
    }//end delete method

    //code above is for implementing linkedLists
    //------------------------------------------------------------------------//
    //code below is for phone book interface

    //moved test code from main to here to show my work
    //manually entered info to test each method
    public void testCodeManually() {   
        PhoneBookManager ajPhoneBook = new PhoneBookManager();
        ajPhoneBook.add("Logan", "Howlett", "1234567890", 
                        "4567 Bay Rd", "Bellingham", "WA", "98225");
        ajPhoneBook.add("Nico", "Robin", "123456789", 
                        "6789 Marine Court", "Lynden", "WA", "98264");
        ajPhoneBook.add("Luke", "Skywalker", "123456789", 
                        "2345 Tattoine Lane", "Blaine", "WA", "98230");
        ajPhoneBook.print();
        System.out.println();
        System.out.println(ajPhoneBook.search("Logan", "Howlett"));
        System.out.println(ajPhoneBook.search("Luke", "Skywalker"));
        System.out.println();
        ajPhoneBook.modifyName("Logan", "Howlett", 
                            "James", "Howlett");
        ajPhoneBook.modifyName("Luke", "Skywalker", 
                            "Luke", "Vader");
        ajPhoneBook.modifyNumber("Nico", "Robin", "1111111111");
        ajPhoneBook.modifyAddress("Luke", "Vader", 
                            "1111 Big City", "Coruscant", "Space" , "23456");
        ajPhoneBook.print();
        System.out.println();
        ajPhoneBook.delete("Luke", "Vader");
        ajPhoneBook.delete("James", "Howlett");
        ajPhoneBook.print();
    }//end testCodeManually method

    //menu interface that gets looped back too for selection 
    public int mainMenu(Scanner input) {
        int answer = 0;
        boolean success = false;
        do{
            System.out.println();
            System.out.println("Please enter one of the following:");
            System.out.println("1.) Add a contact");
            System.out.println("2.) View all contacts");
            System.out.println("3.) Search phone book");
            System.out.println("4.) Modify a contact");
            System.out.println("5.) Delete a contact");
            System.out.println("0.) Exit");
            try {
                answer = input.nextInt(); 
                input.nextLine(); //consumes newline
                success = false;
            } catch (InputMismatchException e) {
                System.out.println("This is not an integer.");
                input.nextLine(); //consumes last entry
                success = true; //loop again
            }
        } while (success);
        return answer;
    }//end mainMenu method

    //get info from user and adds new node to linkedList
    public void addContactInfo(Scanner input, PhoneBookManager book) {
        System.out.println("Entering a new contact");
        System.out.print("Enter their first and last name: ");
        String firstName = input.next();
        String lastName = null;
        if (input.hasNext()){
            lastName = input.next();
        }
        input.nextLine(); //consume blank space
        System.out.print("\nWhat is their phone number: ");
        String number = input.nextLine();
        System.out.print("\nNow enter their address\nEnter the street address: ");
        String address = input.nextLine();
        System.out.print("\nEnter their city: ");
        String city = input.nextLine();
        System.out.print("\nEnter their state: ");
        String state = input.nextLine();
        System.out.print("\nEnter their zip code: ");
        String zip = input.nextLine();
        book.add(firstName, lastName, number, address, city, state, zip);
    }//end addContactInfo method

    //user enters first and last name, get node info or return not found
    public void getSearchInfo(Scanner input, PhoneBookManager book) {
        System.out.print("Enter a first and last name to search: ");
        String first = input.next();
        String last = null;
        if (input.hasNext()){
            last = input.next();
        }
        if(book.search(first, last) != null) {
            System.out.println(book.search(first, last));
        } else {
            System.out.println("Name not found.");
        }
    }//end getSearchInfo

    //user enters name, can modify name, phone number or address
    public void getModifyInfo(Scanner input, PhoneBookManager book) {
        //loop for a correct name entered
        String first;
        String last = null;
        boolean pass = true;
        System.out.print("Who's contact do you want to modify: ");
        first = input.next();
        if (input.hasNext()){
            last = input.next();
        }
        if (book.front == null) {  //no nodes in phone book
            System.out.println("There are no contacts in this phone book. ");
            pass = false;
        } else if (book.search(first, last) == null) {
            System.out.println("Error, this name is not in the phone book.");
            pass = false;
        }//end catch if entered name will break code 
        if (pass) {
            //loop for correct enterty of which modify info
            boolean correct = true;
            do { 
                int answer = 0;
                System.out.println("Do you want to:\n1.) Change name\n" +
                    "2.) Change phone number\n3.) Change address");
                try {
                    answer = input.nextInt();
                    input.nextLine(); //consume newline
                } catch (InputMismatchException e) {
                    correct = false;
                    System.out.println("This is not an integer.");
                }
                switch (answer){
                    case 1:
                        System.out.print("Enter the new name: ");
                        String changeFirst = input.next();
                        String changeLast = null;
                        if (input.hasNext()){
                            changeLast = input.next();
                        }
                        book.modifyName(first, last, changeFirst, changeLast);
                        System.out.println(book.search(changeFirst, changeLast));
                        correct = false; //end loop
                        break;
                    case 2:
                        System.out.print("Enter the new number: ");
                        String newNumber = input.nextLine();
                        book.modifyNumber(first, last, newNumber);
                        System.out.println(book.search(first, last));
                        correct = false; //end loop
                        break;
                    case 3:
                        System.out.print("Enter the new street address: ");
                        String address = input.nextLine();
                        System.out.print("\nEnter the new city: ");
                        String city = input.nextLine();
                        System.out.print("\nEnter the new state: ");
                        String state = input.nextLine();
                        System.out.print("\nEnter the new zip code: ");
                        String zip = input.nextLine();
                        book.modifyAddress(first, last, address, city, state, zip);
                        System.out.println(book.search(first, last));
                        correct = false; //end loop
                        break;
                    default:
                        System.out.println("Error, enter a number 1 - 3");
                        correct = true; //loop again
                }//end switch case
            } while (correct); //loop until answer = 1-3 and is an integer
        } //end if statement, if else do nothing (name entered didn't match)
    }//end getModifyInfo  

    //user enteres name to be deleted from linkedList
    public void getDeleteInfo (Scanner input, PhoneBookManager book) {
        System.out.print("Enter a first and last name to delete: ");
        String first = input.next();
        String last = null;
        if (input.hasNext()){
            last = input.next();
        }
        book.delete(first, last);
    }//end getDeleteInfo method

}//end PhoneBook class