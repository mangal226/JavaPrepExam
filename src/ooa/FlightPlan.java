package src.ooa;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FlightPlan {
    String id;
    String departure;
    String destination;

    LocalDateTime departureTime;
    String route;

    static int numberOfFlights = 0;

    static final int MAX_FLIGHT_HOUR = 10000;

    enum parisToOuaga {CDG, ACC, OUA};
    enum berlinToYork {BER, ORY, LAX, JFK};

    private FlightPlan(){
        this.id = UUID.randomUUID().toString();
    }

    private FlightPlan(String from, String to, LocalDateTime depTime, String checksAirports){
        this();
        if(from.isBlank() || to.isBlank() || checksAirports == null) throw new IllegalArgumentException();
        this.departure = from;
        this.destination = to;
        this.departureTime = depTime;
        this.route = checksAirports;
    }

    @Override
    public String toString() {
        return "FlightPlan { " +
                "id='" + id + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime=" + departureTime +
                ", route=" + route +
                '}';
    }

    public static void main(String[] args){
        FlightPlan flight1 = new FlightPlan("CDG", "OUA", LocalDateTime.of(2024, 05, 12, 00, 45, 00), Arrays.stream(parisToOuaga.values()).collect(Collectors.toList()).toString());
        System.out.println(flight1.toString());
        FlightPlan flight2 = new FlightPlan("BER", "JFK", LocalDateTime.of(2024, 05, 20, 11, 10, 00), Arrays.stream(berlinToYork.values()).collect(Collectors.toList()).toString());
        System.out.println(flight2.toString());
        FlightPlan flight3 = new FlightPlan("", "", LocalDateTime.of(2024, 05, 20, 11, 10, 00), Arrays.stream(berlinToYork.values()).collect(Collectors.toList()).toString());
        System.out.println(flight3.toString());
    }


    /**
     * there are four type of variables : instance variables, class variables, local variables and parameters
     * instance variables: they store individual state in non static fields, they are called instance variable cause they are unique in every instance of a class
     * for example they are the attribute of a class(id, departure, destination, route ...)
     * they permit to instanciate classes they have access modifiers
     * class variables are declared with the static keyword, we can call them global variables, they are used in the class but not to instanciate fields : numberOfFlights, MAX_FLIGHT_HOUR
     * class and instance variable are also called fields
     * local variables are instanciated in methods and have no values outside
     * parameters are variables set in the declaration of a method
     * method name should always begin with verb e.g. setCurrent, getDatan calculateDif, printUser ...
     */





}
