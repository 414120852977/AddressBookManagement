package com.brigelabz;

import com.bridgelabz.AddressBookDBService;
import com.bridgelabz.Contact;
import org.junit.Assert;
import org.junit.Test;

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

}
