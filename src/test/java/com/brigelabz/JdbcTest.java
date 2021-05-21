package com.brigelabz;

import com.bridgelabz.AddressBook;
import com.bridgelabz.AddressBookDBService;
import com.bridgelabz.AddressBookManager;
import com.bridgelabz.Contact;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

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

}
