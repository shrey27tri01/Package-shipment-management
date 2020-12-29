package demo;

import java.util.ArrayList;
import java.util.HashMap;

import base.*;

public class HubDemo extends Hub{

    private ArrayList<Truck> truckList = new ArrayList<Truck>();

    public HubDemo(Location loc) {
        super(loc);
    }

    @Override
    public synchronized boolean add(Truck truck) {
        if (truckList.size() < this.getCapacity()) {
            truckList.add(truck);
            return true;
        }
        return false;
    }

    @Override
    protected void remove(Truck truck) {
        if (truckList.size() > 0) {
            truckList.remove(truck);
        }
    }

    @Override
    public Highway getNextHighway(Hub from, Hub dest) {
        for(Highway highway : getHighways())
        {
            HashMap<Hub,Boolean> visited = new HashMap<>();
            visited.put(this, true);
            DFS(highway.getEnd(), visited);

            if(visited.getOrDefault(dest, false))
            {
                return highway;
            }
        }
        return null;
    }

    @Override
    protected void processQ(int deltaT) {
        for (Truck truck : truckList) {
            Highway highway;
            Hub nextDestination = Network.getNearestHub(truck.getDest());
            if (truck.getLastHub() == nextDestination) {
                truck.setLoc(truck.getDest());
            } else {
                highway = this.getNextHighway(truck.getLastHub(), nextDestination);
                if (highway.hasCapacity()) {
                    highway.add(truck);
                    truck.enter(highway);
                    remove(truck);
                }
            }
        }
    }

    public void DFS(Hub hub, HashMap<Hub,Boolean> visited)
    {
        visited.put(hub, true);

        for(Highway highway : hub.getHighways())
        {
            if(!visited.getOrDefault(highway.getEnd(), false))
            {
                DFS(highway.getEnd(), visited);
            }
        }
    }
    
}
