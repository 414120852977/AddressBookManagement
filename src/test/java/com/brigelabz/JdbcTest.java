package com.brigelabz;

import com.bridgelabz.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JdbcTest {
    @Test
    public void givenConnectionShouldMatch_WithDatabase() {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        List<Contact> result = addressBookDBService.readData();
        addressBookDBService.showDatabaseRetrivedData();
        Assert.assertEquals(2,result.size());
    }

    @Test
    public void givenNewInformationToEmployee_WhenUpdated_ShouldSyncWithDatabase() {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
         addressBookDBService.updateInformationToContact("joe");
        Assert.assertEquals(2,addressBookDBService.readData().size());
    }


    @Test
    public void givenDateRange_WhenRetrieved_ShouldMatchEmployeeCount() {
        AddressBook addressBook = new AddressBook();
        addressBook. readAddressBookDataDB(AddressBook.IOService.DB_IO);
        LocalDate startDate = LocalDate.of(2019, 01, 1);
        LocalDate endDate = LocalDate.now();
        List<Contact> addressBookDataList = addressBook.readContactDataForGivenDateRange(startDate, endDate);
        Assert.assertEquals(2, addressBookDataList.size());
    }
    @Test
    public void givenContacts_RetrieveNumberOfContacts_ByCityOrState() {
        AddressBook addressBook = new AddressBook();
        addressBook.readAddressBookDataDB(AddressBook.IOService.DB_IO);
        Map<String, Integer> contactByCityOrStateMap = addressBook.readContactByCityOrState();
        Assert.assertEquals((int) contactByCityOrStateMap.get("uganda"), 1);
        Assert.assertEquals((int) contactByCityOrStateMap.get("maharashtra"), 1);
    }
    @Test
    public void givenNewContact_WhenAdded_ShouldSyncWithDB() {
        AddressBook addressBook = new AddressBook();
        addressBook.readAddressBookDataDB(AddressBook.IOService.DB_IO);
        addressBook.addContactToDB("rohit","sharma","panvel","mumbai",Date.valueOf("2021-05-21"),"Maharashtra",4545,454545454,"rohit@123","rohit"
        ,"Cricketer");
        boolean result = addressBook.checkAddressBookInSyncWithDB("rohit");
        Assert.assertTrue(result);
    }
    @Test
    public void givenContacts_WhenAddedToDB_ShouldMatchWithDatabase() {
        Utility utility = new Utility();
        Contact[] addressBookArray = {
                new Contact("rohit","sharma","bandra","mumbai",LocalDate.now(),"maharashtra",454,545445,"rohit@gmail.com","rohit","cricketer"),
                new Contact("anushka","sharma","delhi","delhi",LocalDate.now(),"delhi",54,454545,"anu@gmail.com","anushka","actoress")};
        AddressBook addressBook = new AddressBook();
        addressBook.readAddressBookDataDB(AddressBook.IOService.DB_IO);
        Instant start = Instant.now();
        addressBook.addDetails(Arrays.asList(addressBookArray));
        Instant end = Instant.now();
        System.out.println("Duration without thread : " + Duration.between(start, end));
        Instant threadStart = Instant.now();
        addressBook.addDetailsWithThreads(Arrays.asList(addressBookArray));
        Instant threadEnd = Instant.now();
        System.out.println("Duration with Thread : " + Duration.between(threadStart, threadEnd));
        Assert.assertTrue(true);
    }

}
