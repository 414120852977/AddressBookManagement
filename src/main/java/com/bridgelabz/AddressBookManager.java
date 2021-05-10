package com.bridgelabz;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookManager {

    public static void main(String[] args) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        Scanner sc = new Scanner(System.in);
        /**
         * welcome message
         */
        System.out.println("**Welcome to AddressBook**");
        Contact person = new Contact("ashok", "mane", "jalna", "maharashtra", "aurangabad", "ash@gmail.com", 4544, 454);
        /**
         * here in main method switch case overhere beacause users choile he want to operation or exit from our addressbook system
         */
        AddressBook addressBook = new AddressBook();
        Utility utility = new Utility();
        System.out.println("Enter Valid Option (1-->ENTER,2-->EXIT):");
        int option = sc.nextInt();
        while (option != 2) {
            System.out.println("\n *****Enter Your Choice*****\n1.Add Contact\t\t\t\t2.Edit Contact\n3.delete contact\t\t\t4.adding multiple person to addressbook\n" +
                    "5.search person details by name\t\t6.finding serching details by email\n7.Search Person By state\t\t8.get contact no by city" +
                    "\n9.sort addressbook by name\t\t\t\t10.sort addressbook by state\n11.reading text file " +
                    "\t\t12.reading and writing csv file\n13.reading and writing json file\t\t\t14.exit");
            System.out.println("enter a number--->");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.editperson();
                    break;
                case 3:
                    addressBook.deleteperson();
                    break;
                case 4:
                    addressBook.addMultiplePersonToAddressBookAndCreateAddressBook();
                    break;
                case 5:
                    addressBook.searchByName();
                    break;
                case 6:
                    addressBook.searchByEmail();
                    break;
                case 7:
                    addressBook.searchByState();
                    break;
                case 8:
                    addressBook.getContactByCity();
                    break;
                case 9:
                    addressBook.sortAddressBookByName();
                    break;
                case 10:
                    addressBook.sortByState();
                    break;
                case 11:
                    addressBook.showOnConsole(Utility.IOService.FILE_IO);
                    System.out.println("reading data using file io:.........");
                    utility.readData();
                    break;
                case 12:
                    addressBook.consoleCsv(Utility.IOService.FILE_IO);
                    System.out.println("reading csv file...........");
                    utility.readDataCSV();
                    break;
                case 13:
                    addressBook.consoleOnJson(Utility.IOService.FILE_IO);
                    System.out.println("reading json file...........");
                    utility.readJson();
                    break;
                default:
                    System.out.println("select valid operation[1/2]");

            }
            System.out.println("Enter choice(1-Enter \t 2-Exit):");
            int option1=sc.nextInt();
            if (option1==2)
            {
                System.out.println("OOPS!! you are choosing an Exit mode");
                break;
            }
        }
        System.out.println("****** Created and developed by Ashok Mane *******");
    }
}
