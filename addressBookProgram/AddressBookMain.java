package com.addressBookProgram;

/**
 * @author Puja
 */


public class AddressBookMain {
    public static void main(String[] args) {
        /**
         *
         * Wel come message for the user
         */
        System.out.println("~~~WEL-COME TO THE ADDRESS BOOK PROGRAM~~~");
        int choice;
        /**
         *
         * int variable for User choice
         * AddressBook  class is used for object creation and contact management
         */

        AddressBook addressBook = new AddressBook();

        /**
         *
         * Show Menu for user to Select Operation on AddressBook
         */

        do {
            System.out.println("1. Add New Contact\n2. Edit Contact\n3. Delete Contact" +
                    "\n4. Display Contact\n5. Exit");
            System.out.println("Enter Choise: ");
            choice = addressBook.sc.nextInt();

            switch (choice) {
                case 1:
                    addressBook.addNewContact();
                    break;
                case 2:
                    addressBook.editContact();
                    break;
                case 3:
                    addressBook.deleteContact();
                    break;
                case 4:
                    addressBook.displayContact();
                    break;
                case 5:
                    System.out.println("Thank You for Using Address Book.");
                    break;
                default:
                    System.out.println("Please Select between 1 to 5 only.");
                    break;
            }
        } while (choice != 5);

    }
}

