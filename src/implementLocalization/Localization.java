package src.implementLocalization;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Localization {

    public static void main(String [] args){

        /**
         * What is internalization: it is the concept of building a java app without having to put changes
         * dependent of the regions of the world we are.
         * No engineering changes to support different languages and regions i.e. i18n
         * i18n means there is 18 caractors between i and n
         * Adopting software for a specific language or region : i10n
         *
         * What is ADF: Oracle Application Development Framework
         * Bi-directional text: This is use when translating text from one
         * language to another. For example from english to arabic
         * Most of the time there are issues while trying to translate some
         * words are omitted
         * --> LTR : Left To Right
         * --> RTL : Right To Left
         */


        Locale [] franceLocale = {
                new Locale("fr"),
                new Locale("fr", "FR"),
                new Locale("fr", "FR", "WIN")
        };

        Locale locale = Locale.getDefault();
        System.out.println(locale.toString());

        /**
         * Using resourceBundle class and associated properties files
         */
        //resourceBundle();
        //getCurrency();
        //getLocalDateTime();
        chooseTimeZone();

    }

    public static void resourceBundle(){
        Locale usLocale = new Locale("en", "US");
        ResourceBundle textBundleUS = ResourceBundle.getBundle("TextBundle", usLocale);
        System.out.println(textBundleUS.getString("msg1"));
        System.out.println(textBundleUS.getString("msg2"));

        Locale inLocale = new Locale("hi", "IND");
        try {
            ResourceBundle textBundleIn = ResourceBundle.getBundle("TextBundle_in", inLocale);
            System.out.println(textBundleIn.getString("msg1"));
            System.out.println(textBundleIn.getString("msg2"));
        }catch (MissingResourceException e){
            System.out.println(textBundleUS.getString("msg1"));
            System.out.println(textBundleUS.getString("msg2"));
        }
    }

    public static void getCurrency(){
        Locale curLocale = Locale.getDefault();
        Double money = 117897.98;
        Currency curCurrency = Currency.getInstance(curLocale);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(curLocale);
        String moneyFormatted = currencyFormat.format(money);
        System.out.println(curCurrency.getDisplayName());
        System.out.println(curCurrency.getSymbol());
        System.out.println(moneyFormatted);
    }

    public static void chooseTimeZone(){
        Locale.setDefault(Locale.FRANCE);
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone.getDisplayName(Locale.getDefault()));
        //System.out.println("TimeZone : " + timeZone.getDisplayName(Locale.getDefault()));
    }

    public static void getLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime = localDateTime.toLocalTime();
        LocalDate localDate = localDateTime.toLocalDate();

        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getYear());

        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());

    }


}
