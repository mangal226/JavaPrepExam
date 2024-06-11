package src.ooa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LamdaExpression {
    List<FlightPlan> flightPlanList = null;

    public LamdaExpression(List<FlightPlan> list){
        this.flightPlanList = list;
    }



    public static void main(String[] args){
        FlightPlan flight1 = new FlightPlan("CDG", "OUA", LocalDateTime.of(2024, 05, 12, 00, 45, 00), Arrays.stream(FlightPlan.parisToOuaga.values()).collect(Collectors.toList()).toString());

        FlightPlan flight2 = new FlightPlan("BER", "JFK", LocalDateTime.of(2024, 05, 20, 11, 10, 00), Arrays.stream(FlightPlan.berlinToYork.values()).collect(Collectors.toList()).toString());

        FlightPlan flight3 = new FlightPlan("BRU", "OUA", LocalDateTime.of(2024, 07, 12, 00, 15, 20), Arrays.stream(FlightPlan.brusselToOuaga.values()).collect(Collectors.toList()).toString());

        FlightPlan flight4 = new FlightPlan("MAD", "JFK", LocalDateTime.of(2024, 06, 11, 11, 10, 00), Arrays.stream(FlightPlan.madridToYork.values()).collect(Collectors.toList()).toString());

        FlightPlan flight5 = new FlightPlan("MAD", "JFK", LocalDateTime.of(2024, 06, 11, 11, 10, 00), Arrays.stream(FlightPlan.madridToYork.values()).collect(Collectors.toList()).toString());

        List<FlightPlan> flightPlans = Arrays.asList(flight1, flight2, flight3, flight4, flight5);

        flightPlans.stream().map(flightPlan -> flightPlan.check("MAD")).collect(Collectors.toList());
    }
}
