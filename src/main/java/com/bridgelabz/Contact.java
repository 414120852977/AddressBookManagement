package com.bridgelabz;

import java.util.Objects;

public class Contact {
     String firstName;
     String lastName;
     String address;
     String state;
     String city;
     String email;
     int zip;
     int phoneNo;

    /**
     * used constructor overhere to fetch data in other classes its a fature of object oriented programming language
     * @param firstName
     * @param lastName
     * @param address
     * @param state
     * @param city
     * @param email
     * @param zip
     * @param phoneNo
     */
    public Contact(String firstName, String lastName, String address, String state, String city, String email, int zip, int phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.email = email;
        this.zip = zip;
        this.phoneNo = phoneNo;
    }

    /**
     * its a empty consructor to get dynamic data from user
     */
    public Contact() {
    }

    /**
     * used getter and setter method to get and set data in dynamic way.
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", zip=" + zip +
                ", phoneNo=" + phoneNo +
                '}';
    }
    /**
     * override equal method to get object equals in teo fields
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return zip == contact.zip && phoneNo == contact.phoneNo && Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(address, contact.address) && Objects.equals(state, contact.state) && Objects.equals(city, contact.city) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, state, city, email, zip, phoneNo);
    }

}
