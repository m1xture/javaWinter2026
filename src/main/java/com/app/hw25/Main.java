package main.java.com.app.hw25;

public class Main {
    public static void main(String[] args) {
        CarFactory cf = new CarFactory();
        PlaneFactory pf = new PlaneFactory();

        Car car = cf.createTransport();
        Plane plane = pf.createTransport();

        car.move();
        plane.move();
    }
}
