package h2;

public class H2_main {
    public static void main(String[] args) {
        Bus busA = new Bus();
        Bus busB = new Bus();

        Passenger anna = new Passenger("Anna", 2, true); // wants to ride 2 stops
        Passenger ben = new Passenger("Ben", 1, false);  // will get off after 1 stop, no ticket
        Passenger clara = new Passenger("Clara", 3, true);
        Passenger dave = new Passenger("Dave", 2, true);

        // Anna and Ben enter bus A
        busA.enterBus(anna);
        busA.enterBus(ben);
        busA.enterBus(clara);

        System.out.println("Initial Bus A: " + busA);

        // next stop: increment visited, Ben should get off (planned==1)
        busA.nextStop();
        System.out.println("After 1st stop Bus A: " + busA);

        // boarding: Dave gets on at this stop
        Passenger[] boarding = new Passenger[] { dave };
        busA.nextStop(boarding);
        System.out.println("After 2nd stop Bus A (Dave boarded): " + busA);

        // find and remove passengers without tickets (Ben already left, but if any present)
        Passenger[] noTicketsDemo = new Passenger[] { new Passenger("Zoe", 1, false) };
        // Zoe boards and will be removed by findPassengersWithoutTickets
        busA.nextStop(noTicketsDemo);
        System.out.println("After Zoe boarded and stop processed: " + busA);

        System.out.println("Removed without tickets: " + busA.findPassengersWithoutTickets());
        System.out.println("Bus A after removing no-ticket passengers: " + busA);

        // Transfer Anna and Clara to bus B
        String[] transferNames = new String[] { "Anna", "Clara" };
        busA.transferPassengers(busB, transferNames);
        System.out.println("Bus A after transfer: " + busA);
        System.out.println("Bus B after transfer: " + busB);
    }
}