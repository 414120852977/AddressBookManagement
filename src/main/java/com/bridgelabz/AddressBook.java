package com.bridgelabz;

import com.google.gson.Gson;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import javax.naming.InvalidNameException;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    List<Contact> list = new ArrayList<>();
    Map<String, List<Contact>> addressBookMap = new HashMap<>();
    Contact person = new Contact();
    Scanner scanner = new Scanner(System.in);

    /**
     * created method to adding contacts user choice how many contacts he want to add in addressbook
     *
     * @return
     */
    public void addContact() {
        System.out.println("enter a number to how many contacts you have to add");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        for (int i = 1; i <= number; i++) {
            Contact person = new Contact();
            System.out.println("you can countinue");
            System.out.println("enter your first name");
            String firstName = scanner.next();
            if (firstName.equals(person.getFirstName())) {
                try {
                    throw new InvalidNameException("duplicate name");
                } catch (InvalidNameException e) {
                    e.printStackTrace();
                }
            } else {
                person.setFirstName(firstName);
            }
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

    /**
     * @delete method is used to deleting present person from addressbook. user can do deleting his data on his own restriction
     */
    public void deleteperson() {
        System.out.println("enter your name to delete data of name:");
        String fName = scanner.next();
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Contact person = (Contact) itr.next();
            if (fName.equals(person.getFirstName())) {
                list.remove(person);
            }
            System.out.println("after deleting " + list);
        }
    }

    /**
     * @addMultiplePerson method used to create addressbook into addressbook and admin created following addressbook then user also pressered
     * use of  admin addresbooks
     */
    public void addMultiplePersonToAddressBookAndCreateAddressBook() {
        /**
         * this is for creating addressbook choice is there for user create his own or inbuils option is there..
         */
        System.out.println("Here some address book you can create it in your data:--");
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Aurangabad");
        map.put(2, "Mumbai");
        map.put(3, "Pune");
        System.out.println("this addressbooks are inbuild in addressbook you can use this it or create your own" + map);

        System.out.println("select your choice :1./n:add contact in inbuild addressbook,2./n add your own addressbook");
        int numbers = scanner.nextInt();

        switch (numbers) {
            case 1:
                System.out.println("1./t,For Aurangabad,2./t For Mumbai,3./t For Pune");
                System.out.println("enter a number:--");
                int number1 = scanner.nextInt();
                switch (number1) {
                    case 1:
                        System.out.println("you will be added your detalis for Aurangabad:--");

                        System.out.println("enter a number to how many contacts you have to add");
                        int number = scanner.nextInt();

                        for (int i = 1; i <= number; i++) {
                            //   Contact person = new Contact("ash", "njjd", "njebd", "ehfe", "eddej", "sduh", 5454, 5454);

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
                            if (city.equalsIgnoreCase("aurangabad")) {
                                person.setCity(city);
                            } else {
                                try {
                                    throw new InvalidCityException("invalid city");
                                } catch (InvalidCityException e) {
                                    System.out.println(e.message);
                                    addMultiplePersonToAddressBookAndCreateAddressBook();
                                }
                            }
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
                        break;
                    case 2:
                        System.out.println("you will be added your detalis for Mumbai:--");

                        System.out.println("enter a number to how many contacts you have to add");
                        Scanner scanner1 = new Scanner(System.in);
                        int number2 = scanner1.nextInt();

                        for (int i = 1; i <= number2; i++) {
                            //   Contact person = new Contact("ash", "njjd", "njebd", "ehfe", "eddej", "sduh", 5454, 5454);

                            Contact person = new Contact();
                            System.out.println("you can countinue");
                            System.out.println("enter your first name");
                            String firstName = scanner1.next();
                            person.setFirstName(firstName);
                            System.out.println("enter your last name");
                            String lastName = scanner1.next();
                            person.setLastName(lastName);
                            System.out.println("enter your address :");
                            String address = scanner1.next();
                            person.setAddress(address);
                            System.out.println("enter your state name");
                            String state = scanner1.next();
                            person.setState(state);
                            System.out.println("enter your city :");
                            String city = scanner1.next();
                            if (city.equalsIgnoreCase("Mumbai")) {
                                person.setCity(city);
                            } else {
                                try {
                                    throw new InvalidCityException("invalid city");
                                } catch (InvalidCityException e) {
                                    System.out.println(e.message);
                                    addMultiplePersonToAddressBookAndCreateAddressBook();
                                }
                            }
                            System.out.println("enter your email");
                            String email = scanner1.next();
                            person.setEmail(email);
                            System.out.println("enter your zip :");
                            int zip = scanner1.nextInt();
                            person.setZip(zip);
                            System.out.println("enter your contact no");
                            int mobile = scanner1.nextInt();
                            person.setPhoneNo(mobile);
                            list.add(person);
                        }
                        break;
                    case 3:

                        System.out.println("you will be added your detalis for Pune:--");

                        System.out.println("enter a number to how many contacts you have to add");
                        Scanner scanner2 = new Scanner(System.in);
                        int number3 = scanner2.nextInt();

                        for (int i = 1; i <= number3; i++) {
                            Contact person = new Contact();
                            System.out.println("you can countinue");
                            System.out.println("enter your first name");
                            String firstName = scanner2.next();
                            person.setFirstName(firstName);
                            System.out.println("enter your last name");
                            String lastName = scanner2.next();
                            person.setLastName(lastName);
                            System.out.println("enter your address :");
                            String address = scanner2.next();
                            person.setAddress(address);
                            System.out.println("enter your state name");
                            String state = scanner2.next();
                            person.setState(state);
                            System.out.println("enter your city :");
                            String city = scanner2.next();
                            if (city.equalsIgnoreCase("pune")) {
                                person.setCity(city);
                            } else {
                                try {
                                    throw new InvalidCityException("invalid city");
                                } catch (InvalidCityException e) {
                                    System.out.println(e.message);
                                    addMultiplePersonToAddressBookAndCreateAddressBook();
                                }
                            }
                            System.out.println("enter your email");
                            String email = scanner2.next();
                            person.setEmail(email);
                            System.out.println("enter your zip :");
                            int zip = scanner2.nextInt();
                            person.setZip(zip);
                            System.out.println("enter your contact no");
                            int mobile = scanner2.nextInt();
                            person.setPhoneNo(mobile);
                            list.add(person);
                        }
                }
                System.out.println(list);
                break;
            case 2:
                addAddressBook();
        }
    }

    /**
     * user can also creating his own addressbook with gives his specific name to addressbook
     */
    public void addMultipleBook() {
        Set set = new TreeSet();
        System.out.println(" yours choice how many addressbook you want to create it:--");
        int number = scanner.nextInt();

        for (int index = 1; index <= number; index++) {
            System.out.println("give name to your dictionary:--");
            String name = scanner.next();
            set.add(name);
        }
        System.out.println(set);
    }

    public void addAddressBook() {
        System.out.println("**welcome to add addressbook**");
        System.out.println(" yours choice how many addressbook you want to create it:--");
        int bookValue = scanner.nextInt();
        for (int index = 1; index <= bookValue; index++) {
            System.out.println("enter a name of a addressbook");
            String addressBookName = scanner.next();
            addressBookMap.put(addressBookName, list);
            System.out.println("enter a addressbook name to add details in perticular addressbook----");
            String name = scanner.next();
            if (addressBookName.equals(name)) {
                System.out.println("enter a number to how many contacts you have to add");
                Scanner scanner = new Scanner(System.in);
                int number = scanner.nextInt();

                for (int i = 1; i <= number; i++) {
                    Contact person = new Contact();
                    System.out.println("you can countinue");
                    System.out.println("enter your first name");
                    String firstName = scanner.next();
                    if (firstName.equals(person.getFirstName())) {
                        try {
                            throw new InvalidNameException("duplicate name");
                        } catch (InvalidNameException e) {
                            e.printStackTrace();
                        }
                    } else {
                        person.setFirstName(firstName);
                    }
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
            } else {
                System.out.println("entered wrong key enter correct key!!!");
                System.out.println("1.stay here\t\t2.exit");
                int enter = scanner.nextInt();
                if (enter == 1) {
                    addAddressBook();
                } else if (enter == 2) {

                }
            }
        }
    }

    /**
     * display addressbook to user......
     */
    public void showAddressBook() {
        System.out.println("addressbook are created :" + addressBookMap);
    }

    /**
     * user can do serch data by using name of a person
     */
    public void searchByName() {
        System.out.println("enter a name to search");
        Scanner sc = new Scanner(System.in);
        String fName = sc.nextLine();
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Contact person = (Contact) itr.next();
            if (fName.equals(person.getFirstName())) {
                List streamlist = list.stream().
                        filter(n -> n.getFirstName().
                                contains(fName)).
                        collect(Collectors.toList());
                System.out.println(streamlist);
            }
        }
    }

    /**
     * if user know person email id then he will also check by email id whos there with this email id
     */
    public void searchByEmail() {
        System.out.println("enter email to get that person details:");
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Contact person = (Contact) itr.next();
            if (email.equals(person.getEmail())) {
                List streamList = list.stream().filter(n -> n.getEmail().contains(email)).collect(Collectors.toList());
                System.out.println(streamList);
            }
        }
    }

    /**
     * user can also check who is from my state in addressbook
     */
    public void searchByState() {
        System.out.println("enter a name of state to fetch person data fro state :--");
        String state = scanner.next();

        Iterator it = list.iterator();
        while (it.hasNext()) {
            Contact person = (Contact) it.next();
            if (state.equals(person.getState())) {
                List stream = list.stream().filter(n -> n.getCity().contains(state)).collect(Collectors.toList());
                System.out.println(stream);
            }
        }
    }

    /**
     * if user will hve been any help fro his city then he will check in addressbook who is from my city then he will find his
     * phone no.
     */
    public void getContactByCity() {
        System.out.println("enter a name of city to fetch contact details:--");
        String city = scanner.next();

        Iterator itrs = list.iterator();
        while (itrs.hasNext()) {
            Contact person = (Contact) itrs.next();

            if (city.equals(person.getCity())) {
                List streamList = list.stream().map(n -> n.getPhoneNo()).collect(Collectors.toList());
                System.out.println(streamList);
            }
        }
    }

    /**
     * sorting by name
     */
    public void sortAddressBookByName() {
        System.out.println(" write name to sort entry by name :");
        String name = scanner.next();
        if (name.equalsIgnoreCase(person.getFirstName())) {
            Collections.sort(list, (n1, n2) -> n1.getFirstName().compareTo(n1.getFirstName()));
        }
        System.out.println(list);
    }

    /**
     * sort by state
     */
    public void sortByState() {
        System.out.println("enter a state  to seach :");
        String state = scanner.next();
        Iterator itr = list.listIterator();
        while (itr.hasNext()) {
            Contact contact = (Contact) itr.next();
            if (state.equalsIgnoreCase(person.getState())) {
                Collections.sort(list, (l1, l2) -> l1.getFirstName().compareTo(l1.getFirstName()));
                System.out.println(list);
            }
        }
    }

    /**
     * printing text file...
     *
     * @param ioService
     */
    public void showOnConsole(Utility.IOService ioService) {
        if (ioService.equals(Utility.IOService.CONSOLE_IO)) {
            System.out.println(list);
        } else if (ioService.equals(Utility.IOService.FILE_IO)) {
            new Utility().writeData(list);
        }
    }

    /**
     * printing csv file....
     *
     * @param ioService1
     * @throws CsvRequiredFieldEmptyException
     * @throws CsvDataTypeMismatchException
     */
    public void consoleCsv(Utility.IOService ioService1) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        if (ioService1.equals(Utility.IOService.CONSOLE_IO)) {
            System.out.println(list);
        } else if (ioService1.equals(Utility.IOService.FILE_IO)) {
            new Utility().writeCsvData(list);
        }
    }

    /**
     * writing json string ......
     */
    public void gsonData() {
        Gson gson = new Gson();
        gson.toJson(list);
        System.out.println("gson string is :----->" + list);
    }

    /**
     * added json file
     *
     * @param ioService
     */
    public void consoleOnJson(Utility.IOService ioService) {
        if (ioService.equals(Utility.IOService.CONSOLE_IO)) {
            System.out.println(list);
        } else if (ioService.equals(Utility.IOService.FILE_IO)) {
            new Utility().writeJson(list);
        }
    }


    public List<Contact> readAddressBookDataDB(IOService ioService) {
        if (ioService.equals(Utility.IOService.DB_IO))
            this.list = new AddressBookDBService().readData();
        return this.list;
    }

    public List<Contact> readContactDataForGivenDateRange(LocalDate startDate, LocalDate endDate) {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        this.list = addressBookDBService.getContactForGivenDateRange(startDate, endDate);
        return list;
    }

    public Map<String, Integer> readContactByCityOrState() {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        return addressBookDBService.getContactsByCityOrState();

    }

    public void addContactToDB(String firstName, String lastName, String address, String city, Date start, String state, int zip, int phoneNumber, String email, String name, String TYPE) {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        list.add(addressBookDBService.addContact(firstName, lastName, address, city, LocalDate.now(), state, zip, phoneNumber, email, name, TYPE));
    }

    public boolean checkAddressBookInSyncWithDB(String firstName) {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        List<Contact> list = addressBookDBService.getAddressBookDatas(firstName);
        return list.get(0).equals(getAddressBookData(firstName));
    }

    private Contact getAddressBookData(String firstName) {
        return this.list.stream()
                .filter(addressBookDataListItem -> addressBookDataListItem.firstName.equals(firstName))
                .findFirst()
                .orElse(null);
    }


    public enum IOService {FILE_IO, CONSOLE_IO, DB_IO, REST_IO}


    public void addDetails(List<Contact> list) {
        list.forEach(addressBookData -> {
            System.out.println("Employee being added : " + addressBookData.firstName);
            this.addContactToDB(addressBookData.firstName, addressBookData.lastName, addressBookData.address,
                    addressBookData.state, addressBookData.city, addressBookData.start,
                    addressBookData.zip, addressBookData.phoneNo, addressBookData.email, addressBookData.name,
                    (String) addressBookData.type);
            System.out.println("Employee added : " + addressBookData.firstName);
        });
        System.out.println("" + this.list);
    }

    private void addContactToDB(String firstName, String lastName, String address, String state, String city, LocalDate start, int zip, int phoneNo, String email, String name, String type) {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        list.add(addressBookDBService.addContact(firstName, lastName, address, city,start, state, zip, phoneNo, email, name, type));
    }
    public void addDetailsWithThreads(List<Contact> list) {
        Map<Integer, Boolean> contactAdditionStatus = new HashMap<>();
        list.forEach(addressBookData -> {
            Runnable task = () -> {
                contactAdditionStatus.put(addressBookData.hashCode(), false);
                System.out.println("Employee being added : " + Thread.currentThread().getName());
                this.addContactToDB(addressBookData.firstName, addressBookData.lastName, addressBookData.address,
                        addressBookData.state, addressBookData.city, addressBookData.start,
                        addressBookData.zip, addressBookData.phoneNo, addressBookData.email, addressBookData.name,
                        (String) addressBookData.type);
                contactAdditionStatus.put(addressBookData.hashCode(), true);
                System.out.println("Employee added : " + Thread.currentThread().getName());
            };
            Thread thread = new Thread(task, addressBookData.firstName);
            thread.start();
        });
        while (contactAdditionStatus.containsValue(false)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("" + this.list);
    }


    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new Utility().countEntries();
        return 0;
    }
}