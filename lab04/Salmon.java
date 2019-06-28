public class Salmon extends Fish {

    // Constructor C: No-args Salmon Constructor
    public Salmon() {

    }

    /*
    // Constructor D: Salmon Constructor with an int parameter
    public Salmon(int w) {
        weight = w;
    }*/

    /*
    // Constructor E: Salmon Constructor with an int parameter
    // and a call to the super int parameter Constructor
    public Salmon(int w) {
        super(w);
    }
    */

    public void fry() {
        System.out.println("Frying sssssssssalmon");
    }

    @Override
    public void swim() {
        System.out.println("splish splash");
    }

    public void swim(int speed) {
        System.out.println("swimming at " + speed + " mph");
    }
}
