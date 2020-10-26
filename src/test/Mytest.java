package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Mytest {


    public static void main(String[] args) throws ParseException {
//        ServiceLoader<Robot> robotServiceLoader = ServiceLoader.load(Robot.class);
//        robotServiceLoader.forEach(Robot::sayHello);

//        String text = "Fri Apr 24 19:00:58 CST 2015";

//        DateFormat formate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date("Fri Oct 23 14:19:08 CST 2020");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String s = dateFormat.format(date);
        System.out.println(s);

    }
}
