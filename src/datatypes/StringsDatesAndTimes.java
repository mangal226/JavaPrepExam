package src.dadatypes.stringsDatesAndTimes;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class StringsDatesAndTimes {

    public static void main(String[] args) throws StringIndexOutOfBoundsException{
        /**
         * Date
         */
        // immutable : cannot change it : the string is immutable
        Date myDate = new Date();
        LocalDateTime myLocalDate = LocalDateTime.now();
        TimeZone myDateTimeZone = TimeZone.getDefault();
        String formatOfDate = "dd MM yyyy hh:mm:ss";
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern(formatOfDate);
        String dateFormated = myLocalDate.format(formatter);

        /**
         * Strings
         * str.trim(): remove the white space, \t, \n and the escape caracters at the end
         * str.strip(), str.stripLeading(), str.stripTrailing();
         */
        String testTrim = "Teslicapota est venu me voir hier    ".trim();

        Boolean doesContains = testTrim.contains("Testi");

        int lengthOf = testTrim.length();

        int indexOfSeq = testTrim.indexOf("rieher");

        String substringOfTestTrim;

        if (indexOfSeq >= 0) substringOfTestTrim = testTrim.substring(indexOfSeq);
        else substringOfTestTrim = "";

        String str = "Hello world";

        String str2 = "Hello world";

        String str3 =  new String("Hello world");

        String testAddition = 5 + 3 + "xyz" + 3 + 5;

        System.out.println("Are the two string " + str + " and " + str2 + " equals: " + (str == str2));

        System.out.println("Printing the value of the addition value : " + testAddition);

        System.out.println("Trim de ma chaine de caractere : "  + testTrim);

        System.out.println("Are the two strings equals " + str + " and " + str3  + " equals: " + (str == str3));

        System.out.println("My timezone is : " + myDateTimeZone);

        System.out.println("Printing the date : " + myDate);

        System.out.println("Date formated : " + dateFormated);

        System.out.println("What is the length of my string " + testTrim + " : " + lengthOf);

        System.out.println("Does the string contains Testi : " + doesContains);

        System.out.println("What is the index of : " + indexOfSeq);

        System.out.println("Have I a substring of my string "+ testTrim + " at the index " + indexOfSeq + " : " + substringOfTestTrim);


    }
}
