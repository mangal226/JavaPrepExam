package src.ooa;

import java.util.List;

public class UsingInterfacesAndPolymorphism {

    public class Aircraft{
        private String callSign;
        private Coordinate coordinate;
        private int altFlight;

        public Aircraft(String callSign, Coordinate coordinate, int altFlight){
            this.altFlight = altFlight;
            this.coordinate = coordinate;
            this.callSign = callSign;
        }

        public String getCallSign() {
            return callSign;
        }

        public Coordinate getCoordinate() {
            return coordinate;
        }

        public int getAltFlight() {
            return altFlight;
        }
    }

    public class Coordinate{

    }

    public class Circle{
        private Coordinate coordinate;
        private int radiusNm;

        public Circle(Coordinate coordinate, int radiusNm){
            this.coordinate = coordinate;
            this.radiusNm = radiusNm;
        }

        public Coordinate getCoordinate() {
            return coordinate;
        }

        public int getRadiusNm() {
            return radiusNm;
        }
    }

    public class Rectangle{
        private List<Coordinate> coordinates;

        public Rectangle(Coordinate c1, Coordinate c2, Coordinate c3, Coordinate c4){
            if(c1 == null || c2 == null || c3 == null || c4 == null ) throw new IllegalArgumentException("Can not build rectangle");
            this.coordinates = List.of(c1,c2,c3,c4);
        }
    }
}
