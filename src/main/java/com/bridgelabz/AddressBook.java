package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    List<Contact> list = new ArrayList<>();
    Contact person = new Contact();
    Scanner scanner = new Scanner(System.in);
    /**
     * created method to adding contacts user choice how many contacts he want to add in addressbook
     * @return
     */
    public void addContact()  {
        System.out.println("enter a number to how many contacts you have to add");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        for (int i = 1; i <= number; i++) {
            Contact person = new Contact();
            System.out.println("you can countinue");
            System.out.println("enter your first name");
            String firstName = scanner.next();
            person.setFirstName(firstName);
            System.out.println("enter your last name");
            String lastName = scanner.next();
            person.setLastName(lastName);
            System.out.println("enter your address :");
            String address = scanner.next();
            person.setAddress(address);
            System.out.println("enter your state name");
            String state = scanner.next();
            person.setState(state);
            System.out.println("enter your city :");
            String city = scanner.next();
            person.setCity(city);
            System.out.println("enter your email");
            String email = scanner.next();
            person.setEmail(email);
            System.out.println("enter your zip :");
            int zip = scanner.nextInt();
            person.setZip(zip);
            System.out.println("enter your contact no");
            int mobile = scanner.nextInt();
            person.setPhoneNo(mobile);
            list.add(person);
        }
        System.out.println(list);
    }
}
