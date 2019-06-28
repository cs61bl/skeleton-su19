public class Main {

    public static void makeDinner(Fish f) {
        f.fry();
    }

    public static void makeSecondDinner(Salmon f) {
        f.fry();
    }

    public static void main(String[] args) {
        Fish f = new Fish(10);
        Salmon s = new Salmon();
        System.out.println(f.weight);

        /** Worksheet: Fish and Salmon 1.2 Code below */
    }
}
