package main.java.com.app.hw25;

public class CarFactory extends TransportFactory {

    @Override
    public Car createTransport() {
        return new Car();
    }
}
