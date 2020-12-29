package demo;

import java.util.ArrayList;
import base.*;

class NetworkDemo extends Network {

	ArrayList<Hub> hubs = new ArrayList<Hub>();
	ArrayList<Highway> highways = new ArrayList<Highway>();
	ArrayList<Truck> trucks = new ArrayList<Truck>();

	public NetworkDemo() {
		super();
	}
	
	@Override
	public void add(Hub hub) {
		hubs.add(hub);
	}

	@Override
	public void add(Highway hwy) {
		highways.add(hwy);
	}

	@Override
	public void add(Truck truck) {
		trucks.add(truck);
	}

	@Override
	public void start() {
		for(Hub h:hubs) {
			h.start();
		}
		for(Truck t:trucks) {
			t.start();
		}
	}
	
	@Override
	public void redisplay(Display disp) {
		for(Hub h:hubs) {
			h.draw(disp);
		}
		for(Highway hwy:highways) {
			hwy.draw(disp);
		}
		for(Truck t:trucks) {
			t.draw(disp);
		}
	}

	@Override
	public Hub findNearestHubForLoc(Location loc) {
		int minDistance = 100000;
		Hub nearestHub = new HubDemo(loc);
		for(Hub h : hubs) {
			Location hloc = h.getLoc();
			if(hloc.distSqrd(loc) < minDistance) {
				minDistance = hloc.distSqrd(loc);
				nearestHub = h;
			}
		}
		return nearestHub;
		
	}	
	
	
}
