package h1;

public class H1_main {
    public static void main(String[] args) {
        PrioListe pl = new PrioListe();

        Patient A = new Patient("A", 1);
        Patient B = new Patient("B", 10);
        Patient C = new Patient("C", 5);

        pl.addPatient(A);
        pl.addPatient(B);
        pl.addPatient(C);

        System.out.println("After adding A, B, C: " + pl.myList);

        Patient D = new Patient("D", 7);
        pl.addPatient(D);

        System.out.println("After adding D: " + pl.myList);

        Patient next = pl.getNextPatient();
        System.out.println("getNextPatient() returned: " + next);
        System.out.println("List after getNextPatient: " + pl.myList);

        System.out.println("getPosition(D) = " + pl.getPosition(D));
        System.out.println("getPosition(B) = " + pl.getPosition(B));
    }
}