package h2;

public class Passenger {
    public String name;
    public int planned; // number of stations the passenger wants to travel
    public int visited; // number of stations already visited
    public boolean ticket;

    public Passenger(String name, int planned, boolean ticket) {
        this.name = name;
        this.planned = planned;
        this.ticket = ticket;
        this.visited = 0;
    }

    @Override
    public String toString() {
        return name + "(planned=" + planned + ", visited=" + visited + ", ticket=" + ticket + ")";
    }
}