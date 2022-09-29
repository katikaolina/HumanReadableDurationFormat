

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println(dateCount(-33));
        } catch (IllegalArgumentException e) {
            System.out.println("Input must not be smaller than 0");
        }


        try {
            System.out.println(makeReadable(786));
        } catch (IllegalArgumentException e) {
            System.out.println("Input must not be smaller than 0");
        }
    }

    public static String dateCount(int input) {

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
                result += temporary + " " + key + " ";
                input = input % myMap.get(key);
            }
        }

        return result;
    }


    public static String makeReadable(int input) {

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

        if (input > year) {
            result += input / year + " year ";
            input = input % year;
        }
        if (input > day) {
            result += input / day + " day";
            input = input % day;
        }
        if (input > hour) {
            result += input / hour + " hour ";
            input = input % hour;
        }
        if (input > minute) {
            result += input / minute + " minute ";
            input = input % minute;
        }
        result += input + " sec";

        return result;
    }

}
