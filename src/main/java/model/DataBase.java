package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    ObjectMapper mapper = new ObjectMapper();
    Event event;
    //private FileWriter file = new FileWriter("C:\\Users\\Тарасов Дмитрий\\IdeaProjects\\calendar_events\\database.txt", true);

    public DataBase() throws IOException {
    }

    public void printJson(Event event) throws JsonProcessingException {
        String json = mapper.writeValueAsString(event);
        System.out.println("json = " + json);
        System.out.println();
        System.out.println(event);
        Event event1 = new ObjectMapper().readValue(json, Event.class);
        System.out.println("event1 = " + event1);
    }

    public void writeEvent(Event event) throws IOException {
        try (FileWriter file = new FileWriter("C:\\Users\\Тарасов Дмитрий\\IdeaProjects\\calendar_events\\database.txt", true)) {
            String json = mapper.writeValueAsString(event) + "\n";
            file.write(json);
            System.out.println("json = " + json);
            file.flush();
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String> readEvent() {
        ArrayList list = new ArrayList<String>();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Тарасов Дмитрий\\IdeaProjects\\calendar_events\\database.txt"));
////            reader.lines().forEach(System.out::println);
//            String s = reader.lines().toString();
//            System.out.println(s);
//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Тарасов Дмитрий\\IdeaProjects\\calendar_events\\database.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
//                System.out.println("line = " + line);
            }
//            System.out.println("list = " + list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}



