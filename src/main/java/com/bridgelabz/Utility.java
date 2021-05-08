package com.bridgelabz;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

    public static String ADDRESS_FILE_NAME = "contact.txt";
    public static String ADDRESS_CSV_NAME = "contact_info.csv";

    /**
     * here write data method is used to write data into the text file
     *
     * @param list
     */
    public void writeData(List<Contact> list) {
        StringBuffer empBuffer = new StringBuffer();
        list.forEach(person -> {
            String empDataString = person.toString().concat("\n");
            empBuffer.append(empDataString);
        });
        try {
            Files.write(Paths.get(ADDRESS_FILE_NAME), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Utility() {
    }

    public void printData() {
        try {
            Files.lines(new File(ADDRESS_FILE_NAME).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Contact> contactsList;

    public Utility(List<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    /**
     * read data method  shows data on console ..
     *
     * @return
     */
    public List<Contact> readData() {
        List<Contact> list = new ArrayList<>();
        try {
            Files.lines(new File("contact.txt").toPath()).map(line -> line.trim()).forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void writeCsvData(List<Contact> list) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        try(  Writer writer = Files.newBufferedWriter(Paths.get(ADDRESS_CSV_NAME));)
        {
            StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            List<Contact> list1 = new ArrayList<Contact>();
            beanToCsv.write(list);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Contact> readDataCSV() {
        List<Contact> list = new ArrayList<>();
        try {
            Files.lines(new File("contact_info.csv").toPath()).map(line -> line.trim()).forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
