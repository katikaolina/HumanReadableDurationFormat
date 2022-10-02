package com.company;
//https://www.codewars.com/kata/human-readable-duration-format

// Two solutions: one with HashMap and one with if


import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println(makeReadableWithHashMap(11200));
        } catch (IllegalArgumentException e) {
            System.out.println("Input must not be smaller than 0");
        }


        try {
            System.out.println(makeReadableWithIf(352345786));
        } catch (IllegalArgumentException e) {
            System.out.println("Input must not be smaller than 0");
        }
    }

//    Solution with HashMap

    public static String makeReadableWithHashMap(int input) {

        if (input < 0) {
            throw new IllegalArgumentException();
        }
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("year", 31536000);
        myMap.put("day", 86400);
        myMap.put("hour", 3600);
        myMap.put("minute", 60);
        myMap.put("second", 1);

        String result = "";

        if (input == 0) return "now";

        for (String key : myMap.keySet()) {
            if (input >= myMap.get(key)) {
                int temporary = (int) Math.floor(input / myMap.get(key));
                result += (temporary > 1 ? temporary + " " + key + "s " : temporary + " " + key + " ");
                input = input % myMap.get(key);
            }
        }
        return result;
    }

//  Solution with If

    public static String makeReadableWithIf(int input) {

        if (input < 0) {
            throw new IllegalArgumentException();
        }

        int sec = 1;
        int minute = 60 * sec;
        int hour = 60 * minute;
        int day = 24 * hour;
        int year = 365 * day;

        String result = "";
        if (input == 0) {
            return "now";
        }

        if (input > year) {//
            result += (input / year > 1 ? input / year + " years " : input / year + " year ");
            input = input % year;
        }


        if (input > day) {
            result += (input / day > 1 ? input / day + " days " : input / day + " day ");
            input = input % day;
        }
        if (input > hour) {
            result += (input / hour > 1 ? input / hour + " hours " : input / hour + " hour ");
            input = input % hour;
        }
        if (input > minute) {
            result += (input / minute > 1 ? input / minute + " minutes " : input / minute + " minute ");
            input = input % minute;
        }
        result += (input > 1 ? input + " seconds" : input + " second");

        return result;
    }

}
