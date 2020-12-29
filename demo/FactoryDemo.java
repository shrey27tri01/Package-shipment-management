package demo;

import base.*;

public class FactoryDemo extends Factory {

    @Override
    public Network createNetwork() {
        NetworkDemo network = new NetworkDemo();
        return network;
    }

    @Override
    public Highway createHighway() {
        return new HighwayDemo();
    }

    @Override
    public Hub createHub(Location loc) {
        return new HubDemo(loc);
    }

    @Override
    public Truck createTruck() {
        return new TruckDemo("Truck19084");
    }

}

