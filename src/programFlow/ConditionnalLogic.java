package src.programFlow;

public class ConditionnalLogic {
    enum myEnum { JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER,
        NOVEMBER, DECEMBER };
    enum typeAge {YOUNG, ADULT};

    public static void main(String[] args){
        int myNumber = 456789865;
        Boolean isPrimeNumber = isPrime(myNumber);
        System.out.println("Is my number prime ? " + isPrimeNumber);

        for( Object stringNum : myEnum.values()){
            System.out.println(stringNum);
        }

        /**
         * in condition we can only have boolean condition that don't need second operator
         * if(isSet) ..... : isSet has to be boolean
         * we use switch when we have specific values
         */

        String theDay = dayOfWeek(5);
        System.out.println("The day of the week is : " + theDay);

    }

    public static Boolean isPrime(int myNumber){
        /**
         * Using if else statement
         */
        // verify if prime number
        if(myNumber <= 1 ) return false;
        else if (myNumber <= 3 ) return true;
        else if(myNumber % 2 == 0 || myNumber % 3 == 0 ) return false;
        else {
            int i =5;
            while (i*i <= myNumber)
                if(myNumber % i == 0  || myNumber % (i + 2) == 0) return false;
            i+=6;
        }

        return true;
    }

    /**
     *
     * When we use switch we have to be sure that we add a break to
     * avoid passing time in controlling the others control
     */
    private static String dayOfTheWeek2(int myDay){
        String dayToSendBack = null;
        switch (myDay){
            case 1: dayToSendBack = "Monday";
            break;
            case 2: dayToSendBack = "Tuesday";
            break;
            case 3: dayToSendBack = "Wednesday";
            break;
            case 4: dayToSendBack = "Thursday";
            break;
            case 5: dayToSendBack = "Friday";
            break;
            case 6: dayToSendBack = "Saturday";
            break;
            case 7: dayToSendBack = "Sunday";
            break;
            default: dayToSendBack = "Not a day";
        }
        return dayToSendBack;
    }

    private static String dayOfWeek(int day){
        switch (day){
            case 1 : return "Monday";
            case 2 : return "Tuesday";
            case 3 : return "Wednesday";
            case 4 : return "Thursday";
            case 5 : return "Friday";
            case 6 : return "Saturday";
            case 7 : return "Sunday";
            default:  return "Not a day";
        }
    }

    private static String verifyAge(int age){
        Boolean range_sup = age>18;

        typeAge rangeSupEnum = null;
        if (range_sup) rangeSupEnum = typeAge.ADULT;

        String toReturn = "";
        switch (rangeSupEnum){

            case ADULT : toReturn = "Adult";
            break;
            case YOUNG : toReturn = "Young";
            break;
            default: toReturn = "Not young not adult";
        }
        return toReturn;
    }
}
