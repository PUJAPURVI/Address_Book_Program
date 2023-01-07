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
    /**
     *
     * This method is used to delete the Existing contact details
     */

    public void deleteContact() {
        //Get First Name to Edit the Contact
        System.out.println("Enter First Name : ");
        String firstName = sc.next();

        //check if the Given User with First Name
        if (!firstName.equalsIgnoreCase(contacts.getFirstName())) {
            System.out.println("----The Entered Contact Name is Not Available in Address Book---");
        } else {
            contacts.setFirstName(null);
            contacts.setLastname(null);
            contacts.setAddress(null);
            contacts.setZip(null);
            contacts.setState(null);
            contacts.setCity(null);
            contacts.setEmailID(null);
            contacts.setPhoneNo(null);
            System.out.println("-------Contact Deleted Successfully-------");
        }
    }
    public void contactOptions(AddressBook addressBook) {
        //Show Menu for user to Select Operation on AddressBook
        int choice;
        do {
            System.out.println("***** ADDRESS BOOK MANAGEMENT *****");
            System.out.println("1. ADD NEW CONTACT\n2. EDIT CONTACT\n3. DELETE CONTACT" +
                    "\n4. DISPLAY CONTACT\n5. EXIT");
            System.out.println("Please Select the Operation Number : ");
            choice = addressBook.sc.nextInt();

            switch (choice) {
                case 1:
                    addressBook.addNewContact();    //Adding New Contact Details
                    break;
                case 2:
                    addressBook.editContact();  //Edit Contact Details
                    break;
                case 3:
                    addressBook.deleteContact();    //Delete the Contact Details
                    break;
                case 4:
                    addressBook.displayContact();   //Show Contact Details
                    break;
                case 5:
                    System.out.println("Thank You for Using Address Book.");
                    break;
                default:
                    System.out.println("Please Select the Operation between 1 to 5 only.");
                    break;
            }
        } while (choice != 5);
    }

}

