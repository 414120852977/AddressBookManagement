package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookManager {
    public static void main(String[] args) {
        /**
         * welcome message
         */
        System.out.println("**Welcome to AddressBook**");
        List<Contact> list = new ArrayList();
        Contact person = new Contact("ashok", "mane", "jalna", "maharashtra", "aurangabad", "ash@gmail.com", 4544, 454);
        list.add(person);
        System.out.println(list);
/**
 * here in main method switch case overhere beacause users choile he want to operation or exit from our addressbook system
 */
        System.out.println("1./go in addressbook to do operatoons" +
                "2./exit from addressbook");
        System.out.println("enter a number--->");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        switch (number) {
            case 1:
                AddressBook addressBook = new AddressBook();
                addressBook.addContact();
//                addressBook.editperson();
//                addressBook.deleteperson();
//                addressBook.addMultiplePersonToAddressBookAndCreateAddressBook();
//                addressBook.searchByName();
//                addressBook.searchByEmail();
//                addressBook.searchByState();
//                addressBook.getContactByCity();
//                addressBook.sortAddressBookByName();
//                addressBook.sortByState();
                addressBook.showOnConsole(Utility.IOService.FILE_IO);
                System.out.println("reading data using file io:");
                Utility utility  = new Utility();
                utility.readData();
                break;
            case 2:
                System.out.println("thanks for joining us ! have a nice day");
        }
        System.out.println("****** Created and developed by Ashok Mane *******");
    }
}
