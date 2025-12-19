package h2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Bus {
    public ArrayList<Passenger> passengers;

    public Bus() {
        passengers = new ArrayList<>();
    }

    public void enterBus(Passenger p) {
        passengers.add(p);
    }

    private void exitBus() {
        Iterator<Passenger> it = passengers.iterator();
        while (it.hasNext()) {
            Passenger p = it.next();
            if (p.planned == p.visited) {
                it.remove();
            }
        }
    }

    public void nextStop(Passenger[] boarding) {
        // increment visited for all passengers currently on the bus
        for (Passenger p : passengers) {
            p.visited += 1;
        }
        // remove passengers that must get off
        exitBus();
        // add boarding passengers at the end in given order
        if (boarding != null) {
            for (Passenger p : boarding) {
                if (p != null) enterBus(p);
            }
        }
    }

    // overloaded method: no new passengers
    public void nextStop() {
        nextStop(null);
    }

    public ArrayList<Passenger> findPassengersWithoutTickets() {
        ArrayList<Passenger> removed = new ArrayList<>();
        Iterator<Passenger> it = passengers.iterator();
        while (it.hasNext()) {
            Passenger p = it.next();
            if (!p.ticket) {
                removed.add(p);
                it.remove();
            }
        }
        return removed;
    }

    public void transferPassengers(Bus otherBus, String[] passengerNames) {
        // use a hashset for quick lookup of requested names
        HashSet<String> names = new HashSet<>();
        if (passengerNames != null) {
            for (String s : passengerNames) names.add(s);
        }

        ArrayList<Passenger> toTransfer = new ArrayList<>();
        Iterator<Passenger> it = passengers.iterator();
        while (it.hasNext()) {
            Passenger p = it.next();
            if (names.contains(p.name)) {
                toTransfer.add(p);
                it.remove();
            }
        }
        // add them to otherBus in the same order they were in this bus
        for (Passenger p : toTransfer) otherBus.enterBus(p);
    }

    @Override
    public String toString() {
        return passengers.toString();
    }
}