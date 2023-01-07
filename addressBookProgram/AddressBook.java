package com.addressBookProgram;
import java.util.Scanner;
/**
 *
 * @author Puja
 *
 */


public class AddressBook {
    /**
     *
     *Scanner - class is use for user input
     *Contacts - class is use for to create a object of
     *          contacts class for Getter and Setter method
     */
    Scanner sc = new Scanner(System.in);

    //Created Contacts Object for Getter and Setter Methods
    Contacts contacts = new Contacts();
    /**
     *
     * This method is used to add the contact details
     */
    public void addNewContact() {
        System.out.println("Enter the Contact Details -");
        System.out.println("Enter the First Name :");
        contacts.setFirstName(sc.next());
        System.out.println("Enter the Last Name :");
        contacts.setLastname(sc.next());
        System.out.println("Enter the Address :");
        contacts.setAddress(sc.next());
        System.out.println("Enter the City :");
        contacts.setCity(sc.next());
        System.out.println("Enter the State :");
        contacts.setState(sc.next());
        System.out.println("Enter the Zip Code :");
        contacts.setZip(sc.next());
        System.out.println("Enter the Phone Number :");
        contacts.setEmailID(sc.next());
        System.out.println("Enter the EMail ID :");
        contacts.setEmailID(sc.next());
    }
    /**
     *
     * This method is used to display the user input contact details
     */
    public void displayContact() {
        System.out.println("Contact Details -");
        System.out.println("First Name : "+contacts.getFirstName());
        System.out.println("Last Name : "+contacts.getLastname());
        System.out.println("Address : "+contacts.getAddress());
        System.out.println("City : "+contacts.getCity());
        System.out.println("State : "+contacts.getState());
        System.out.println("Zip Code : "+contacts.getZip());
        System.out.println("Phone Number : "+contacts.getPhoneNo());
        System.out.println("EMail ID : "+contacts.getEmailID());
    }
    /**
     *
     * This method is used to Edit the Existing contact details
     */

    public void editContact() {
        //Get First Name to Edit the Contact
        System.out.println("Enter the First Name : ");
        String firstName = sc.next();

        //check if the Given User with First Name
        if(!firstName.equalsIgnoreCase(contacts.getFirstName())) {
            System.out.println("The Entered Contact Name is Not Available in Address Book");
        } else {
            System.out.println("Enter the Last Name :");
            contacts.setLastname(sc.next());
            System.out.println("Enter the Address :");
            contacts.setAddress(sc.next());
            System.out.println("Enter the City :");
            contacts.setCity(sc.next());
            System.out.println("Enter the State :");
            contacts.setState(sc.next());
            System.out.println("Enter the Zip Code :");
            contacts.setZip(sc.next());
            System.out.println("Enter the Phone Number :");
            contacts.setPhoneNo(sc.next());
            System.out.println("Enter the EMail ID :");
            contacts.setEmailID(sc.next());
        }
    }
}

