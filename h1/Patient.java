package h1;

public class Patient {
    public String name;
    public int prio;

    public Patient(String name, int prio) {
        this.name = name;
        this.prio = prio;
    }

    @Override
    public String toString() {
        return name + "(" + prio + ")";
    }
}