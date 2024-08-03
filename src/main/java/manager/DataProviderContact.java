package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();


        return list.iterator();


    }


    @DataProvider
    public Iterator<Object[]> contactSuccess(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("34343435556")
                .email("stark@gmail.com")
                .address("NY")
                .description("All Fields")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("TonyReq")
                .lastName("Stark")
                .phone("34343434442")
                .email("stark123@gmail.com")
                .address("NY")
                .build()});

        return list.iterator();


    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("john")
                .lastName("Wick")
                .phone("123")
                .email("wick@gmail.com")
                .address("NY")
                .description("John")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("johny")
                .lastName("Wicky")
                .phone("123456789123456789")
                .email("wick12@gmail.com")
                .address("NY")
                .description("Johny")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("john232")
                .lastName("Wick232")
                .phone("qwertyqwert")
                .email("wick232@gmail.com")
                .address("NY")
                .description("John")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("jojo")
                .lastName("Wickstr")
                .phone("")
                .email("wickjojo@gmail.com")
                .address("NY")
                .description("John")
                .build()});


        return list.iterator();


    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/contact.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});

            line = reader.readLine();
        }


        return list.iterator();


    }
}
