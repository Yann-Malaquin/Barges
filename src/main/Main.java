package main;

import service.LectureService;
import service.Service;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //LectureService lectureService = new LectureService();


        /*List<String> testList = new ArrayList<>();
        testList.add("C");
        testList.add("1");
        testList.add("D");
        testList.add("2");
        testList.add("E");
        testList.add("3");
        testList.add("F");
        testList.add("4");
        Map<String, String> mapTest = new HashMap<>();

        for (int i = 0; i + 1 < testList.size(); i+=2){
            mapTest.put(testList.get(i), testList.get(i+1));
        }

        Set<String> setTest = mapTest.keySet();

        for (String phoneNumber : setTest) {
            String name = mapTest.get(phoneNumber);

            System.out.println("Phone Number: " + phoneNumber + " ==> Name: " + name);
        }*/
        LectureService ls = new LectureService();
        System.out.println(ls.toString());



    }
}
