package demo;

import java.util.ArrayList;

import base.*;

public class HighwayDemo extends Highway{

    private ArrayList<Truck> truckList = new ArrayList<Truck>();

    public HighwayDemo() {
        super();
    }

    @Override
    public synchronized boolean hasCapacity() {
        if (truckList.size() < this.getCapacity()) {
            return true;
        }
        return false;
    }

    @Override
    public synchronized boolean add(Truck truck) {
        if (this.hasCapacity()) {
            truckList.add(truck);
            return true;
        }
        return false;
    }

    @Override
    public synchronized void remove(Truck truck) {
        if (truckList.size() > 0) {
            truckList.remove(truck);
        }
    }
    
}
