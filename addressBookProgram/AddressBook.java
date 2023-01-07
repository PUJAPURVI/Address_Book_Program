package com.addressBookProgram;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    Scanner scanner = new Scanner(System.in);
    public Map<String, Contacts> contactList = new HashMap<String, Contacts>();
    public static HashMap<String, ArrayList<Contacts>> city = new HashMap<String, ArrayList<Contacts>>();
    public static HashMap<String, ArrayList<Contacts>> state = new HashMap<String, ArrayList<Contacts>>();
    public String addressBookName;
    public boolean isPresent = false;

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public ArrayList<Contacts> getContact() {
        return new ArrayList<Contacts>(contactList.values());
    }

    public void displayMenu() {
        boolean change = true;
        do {
            System.out.println("\n Select the operation you want to perform : ");
            System.out.println(
                    "1.Add To Address Book\n2.Edit Existing Entry\n3.Delete Contact\n4.Display Address book\n5.Exit Address book System");
            switch (scanner.nextInt()) {
                /**
                 *
                 * case 1-Adding new address book in the AddressBook System
                 * case 2- Edit address book Details
                 * case 3- Delete address book Details
                 * case 4- Display the address book details
                 */
                case 1:
                    addContact();
                    break;
                case 2:
                    editPerson();
                    break;
                case 3:
                    deletePerson();
                    break;
                case 4:
                    displayContents();
                    break;
                default:
                    change = false;
                    System.out.println("Exiting Address Book: " + this.getAddressBookName() + " !");
            }
        } while (change);
    }

    /**
     *
     *This method is used for Adding contact in address book
     */
    public void addContact() {
        Contacts person = new Contacts();

        System.out.println("Enter first name: ");
        String firstName = scanner.next();
        contactList.entrySet().stream().forEach(entry -> {
            if (entry.getKey().equals(firstName.toLowerCase())) {
                System.out.println("Contact already exist.");
                isPresent = true;
                return;
            }
        });
        if (isPresent == false) {
            System.out.println("Enter last name : ");
            String lastName = scanner.next();
            System.out.println("Enter phone number :");
            long phoneNumber = scanner.nextLong();
            System.out.println("Enter email: ");
            String email = scanner.next();
            System.out.println("Enter city :");
            String city = scanner.next();
            System.out.println("enter state: ");
            String state = scanner.next();
            System.out.println("Enter zip code: ");
            long zip = scanner.nextLong();

            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setPhoneNumber(phoneNumber);
            person.setEmail(email);
            person.setCity(city);
            person.setState(state);
            person.setZip(zip);
            addPersonToCity(person);
            addPersonToState(person);
            contactList.put(firstName.toLowerCase(), person);
        }
    }

    /**
     *
     *This method is used for Display contact in address book
     */
    public void displayContents() {
        System.out.println("----- Contents of the Address Book " + this.getAddressBookName() + " -----");
        for (String eachContact : contactList.keySet()) {
            Contacts contact = contactList.get(eachContact);
            System.out.println(contact);
        }
        System.out.println("----------------------------------------------------");
    }

    /**
     *
     *This method is used for Edit contact in address book
     */
    void editPerson() {
        Contacts person = new Contacts();
        System.out.println("Enter first name : ");
        String firstName = scanner.next();
        if (contactList.containsKey(firstName)) {
            person = contactList.get(firstName);
            System.out.println("Choose you want to change : ");
            System.out.println("1.Last Name\n2.Phone Number\n3.Email\n4.City\n5.State\n6.ZipCode");
            switch (scanner.nextInt()) {
                /**
                 *
                 * case 1- set last name
                 * case 2- set phone number
                 * case 3- set email id
                 * case 4- set city name
                 * case 5- set state name
                 * case 6- set zip code
                 */
                case 1:
                    System.out.println("Enter the correct Last Name :");
                    String lastName = scanner.next();
                    person.setLastName(lastName);
                    break;
                case 2:
                    System.out.println("Enter the correct Phone Number :");
                    long phoneNumber = scanner.nextLong();
                    person.setPhoneNumber(phoneNumber);
                    break;
                case 3:
                    System.out.println("Enter the correct Email Address :");
                    String email = scanner.next();
                    person.setEmail(email);
                    break;
                case 4:
                    System.out.println("Enter the correct City :");
                    String city = scanner.next();
                    person.setCity(city);
                    break;
                case 5:
                    System.out.println("Enter the correct State :");
                    String state = scanner.next();
                    person.setState(state);
                    break;
                case 6:
                    System.out.println("Enter the correct ZipCode :");
                    long zip = scanner.nextLong();
                    person.setZip(zip);
                    break;
            }

        } else {
            System.out.println(" Name does not exist.");
        }
    }

    /**
     *
     *This method is used for Delete contact in address book
     */
    public void deletePerson() {
        System.out.println("Enter first name of person to delete : ");
        String firstName = scanner.next();
        if (contactList.containsKey(firstName)) {
            contactList.remove(firstName);
            System.out.println("Successfully deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    /**
     *
     *This method is used for Adding person city name in address book
     */
    public void addPersonToCity(Contacts contact) {
        if (city.containsKey(contact.getCity())) {
            city.get(contact.getCity()).add(contact);
        } else {
            ArrayList<Contacts> cityList = new ArrayList<Contacts>();
            cityList.add(contact);
            city.put(contact.getCity(), cityList);
        }
    }

    /**
     *
     *This method is used for Adding person state name in address book
     */
    public void addPersonToState(Contacts contact) {
        if (state.containsKey(contact.getState())) {
            state.get(contact.getState()).add(contact);
        } else {
            ArrayList<Contacts> stateList = new ArrayList<Contacts>();
            stateList.add(contact);
            state.put(contact.getState(), stateList);
        }
    }

    /**
     *
     *This method is used for Printing the sorted list in address book
     */
    public void printSortedList(List<Contacts> sortedContactList) {
        System.out.println("------Sorted address book " + this.getAddressBookName() + "-------- ");
        Iterator iterator = sortedContactList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println();
        }
        System.out.println("=======================================");
    }
}

