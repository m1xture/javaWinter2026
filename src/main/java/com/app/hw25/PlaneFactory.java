package main.java.com.app.hw25;

public class PlaneFactory extends TransportFactory {

    @Override
    public Plane createTransport() {
        return new Plane();
    }
}
