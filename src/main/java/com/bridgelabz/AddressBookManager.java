package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class AddressBookManager {
    public static void main(String[] args) {
        /**
         * welcome message
         */
        System.out.println("**Welcome to AddressBook**");
        List<Contact> list = new ArrayList();
        Contact person = new Contact("ashok","mane","jalna","maharashtra","aurangabad","ash@gmail.com",4544,454);
        list.add(person);
        System.out.println(list);
        AddressBook addressBook = new AddressBook();
        addressBook.addContact();
    }
}
