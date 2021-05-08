package com.bridgelabz;

import java.util.ArrayList;
import java.util.Iterator;
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
    /**
     * @edit method gives us to edit person data user can also edit his data by using his/she name
     */
    public void editperson() {
        System.out.println("enter a name whose data will you have to edit");
        Scanner scanner = new Scanner(System.in);
        String fname = scanner.nextLine();

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            Contact person = (Contact) iterator.next();

            if (fname.equals(person.getFirstName())) {
                System.out.println("you can edit");
                System.out.println("1/edit first name," +
                        "2/edit lastname," +
                        "3/edit phone no," +
                        "4/edit city," +
                        "5/edit zip," +
                        "6/edit state," +
                        "7/edit phone no");
                System.out.println("enter a number to edit details");
                int number = scanner.nextInt();

                switch (number) {

                    case 1:
                        System.out.println("please suggest firstName");
                        person.firstName = scanner.next();
                        System.out.println("implemented firstName: " + person.firstName);
                        break;
                    case 2:
                        System.out.println("please suggest your lastname");
                        person.lastName = scanner.next();
                        System.out.println("implemented lastname: " + person.lastName);
                        break;
                    case 3:
                        System.out.println("please suggest your Phone Number");
                        person.phoneNo = scanner.nextInt();
                        System.out.println("implemented PhoneNo: " + person.phoneNo);
                        break;
                    case 4:
                        System.out.println("please suggest your City");
                        person.city = scanner.next();
                        System.out.println("implemented city: " + person.city);
                        break;
                    case 5:
                        System.out.println("please suggest your Zip");
                        person.zip = scanner.nextInt();
                        System.out.println("implemented zip: " + person.zip);
                        break;
                    case 6:
                        System.out.println("please suggest your State");
                        person.state = scanner.next();
                        System.out.println("implemented state: " + person.state);
                        break;
                    case 7:
                        System.out.println("please suggest your address");
                        person.address = scanner.next();
                        System.out.println("implemented address is: " + person.address);
                        list.add(person);
                }
                System.out.println(list);
            } else {
                System.out.println("person not found");
            }
        }
    }
}
