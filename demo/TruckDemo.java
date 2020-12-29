package demo;

import base.*;

public class TruckDemo extends Truck {

    // private String state;
    private Highway highway;
    private String truckName;
    // private int actualTime = 0;
    // private Hub lastHub = null, currentHub = null, nextHub = null, destHub = null; // destHub should be exlusively used in truckDemo only
	// private boolean hwyFlag = false, hasReached = false;
	// private Hub srcHub;
	// private boolean journeyStarted = false; // if true then partyy { ☆:. o(≧▽≦)o .:☆ }. Our journey has started(Yooo Hooo)

    
    TruckDemo (String name) {
        this.truckName = name;
    }

    @Override
    public synchronized Hub getLastHub() {
        return this.highway.getStart();
    }

    @Override
    public synchronized void enter(Highway hwy) {
        this.highway = hwy;
    }

    public synchronized String getTruckName() {
        return this.truckName;
    }

    @Override
    protected synchronized void update(int deltaT) {

        // int x1 = this.highway.getStart().getLoc().getX();
        // int y1 = this.highway.getStart().getLoc().getY();
        // int x2 = this.highway.getEnd().getLoc().getX();
        // int y2 = this.highway.getEnd().getLoc().getY();

        // int speed = this.highway.getMaxSpeed();
        // int distance = speed * deltaT;

        /* break */

        // Truck newTruck = new Truck19084(this.truckName);

        if (this.getLoc().getX() == this.getSource().getX() && this.getLoc().getY() == this.getSource().getY()) {
            this.setLoc(Network.getNearestHub(this.getSource()).getLoc());
            Network.getNearestHub(this.getSource());
            return;
        }

        // System.out.println(this.state);

        // if (state.equals("halt")) {
        //     return;
        // }

        int x1 = this.getLastHub().getLoc().getX();
        int y1 = this.getLastHub().getLoc().getY(); 
        int x2 = this.getDest().getX();
        int y2 = this.getDest().getY();

        double slope = (y2 - y1) / (x2 - x1);

        int speed = this.highway.getMaxSpeed();
        int distance = (speed * deltaT) / 1000;

        double deltaX = (double)distance * (double)(1 / (Math.sqrt((slope * slope) + 1)));
        double deltaY = (double)distance * (double)(slope / Math.sqrt((slope * slope) + 1));
        
        // System.out.println(deltaX + " " + deltaY);

        if (deltaX < 1) {
            deltaX = 1;
            deltaY = slope;
        }
        if (deltaY < 1) {
            deltaY = 1;
            deltaX = (double)(1 / slope);
        }

            Location l = new Location((int)(this.getLoc().getX() + deltaX), (int)(this.getLoc().getX() + deltaX));

            int newX = l.getX();
            int newY = l.getY();

            if (newX >= this.getDest().getX() || newY >= this.getDest().getY()) {
                newX = this.getDest().getX();
                newY = this.getDest().getY();

                Location l1 = new Location(newX, newY); 
                this.setLoc(l1);

                // newTruck.getDest().add();
                // newTruck.remove(this);

            }
            else {
                this.setLoc(l);
	        }
	
	/* break */

    
		}
    
    
    }


