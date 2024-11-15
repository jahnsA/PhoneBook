//Abby Jahns
//11.02.24
//Assignment 2: Phone Book
//PhoneBookNode.java  object class

public class PhoneBookNode {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;

    PhoneBookNode next;

    public PhoneBookNode(String firstName, String lastName, String phoneNumber, 
                         String address, String city, String state, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.next = null;
    }//end constructor

    //returns all node info in nice format for printing
    public String toString() {
        return (this.firstName + " " + this.lastName + " - " + this.phoneNumber + 
            "\n\t" + this.address + ", " + this.city + ", " + this.state + 
            " " + this.zip);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public void setNumber(String number) {
        this.phoneNumber = number;
    }

    public void setAddress(String address, String city, String state, String zip) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}//end ListNode
