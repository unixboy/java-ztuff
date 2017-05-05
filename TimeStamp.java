package com.unixboy.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampExample {

    private static final SimpleDateFormat sdfa = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd.HH.mm.ss.yyyy");


    public static void main(String[] args) {

        //method 1
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
 

        //method 2 - via Date
        Date date = new Date();
        System.out.println(new Timestamp(date.getTime()));

        //return number of milliseconds since January 1, 1970, 00:00:00 GMT
        System.out.println(timestamp.getTime());

        //format timestamp
        System.out.println(sdfa.format(timestamp)); 
        System.out.println(sdf.format(timestamp));

    }

}
