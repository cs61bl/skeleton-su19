package enigma;

import static enigma.EnigmaException.*;

/** Class that represents a rotating rotor in the enigma machine.
 *  @author
 */
public class MovingRotor extends Rotor {

    /** A rotor named NAME whose permutation in its default setting is
     *  PERM, and whose notches are at the positions indicated in NOTCHES.
     *  The Rotor is initially in its 0 setting (first character of its
     *  alphabet).
     */
    public MovingRotor(String name, Permutation perm, String notches) {
        super(name, perm);
        // FIXME - Assign any additional instance variables.
    }

    // FIXME - This class inherits all of the information present in the
    //			Rotor class, meaning that any method which exists in
    //			Rotor can be used from MovingRotor. This will make more sense
    //			later in the course, but for now, you should think about
    //			how a MovingRotor's behavior is different from a FixedRotor.
    //			Does a MovingRotor's behavior differ from the default Rotor
    //			behavior? Some methods that differ appear below. Do we need
    //			to update any other methods in this class in order for it to
    //			behave as a moving Rotor? Check out Rotor and FixedRotor to
    //			see what methods might be different between these two classes.

    @Override // Use this special tag when updating the behavior of a method this class inherits from Rotor
    public boolean rotates() {
        return false; // FIXME - How do we know whether this Rotor should rotate?
    }

    @Override // Use this special tag when updating the behavior of a method this class inherits from Rotor
    public boolean atNotch() {
        return false; // FIXME - How do we know whether this Rotor is at a notch?
    }

    @Override // Use this special tag when updating the behavior of a method this class inherits from Rotor
    public void advance() {
        // FIXME - What methods can we use to advance this Rotor by one position?
    }

    // FIXME - How do we keep track of my notches?

    // FIXME: ADDITIONAL FIELDS HERE, AS NEEDED

    // To run this through command line, from the proj0 directory, run the following:
    // javac enigma/Rotor.java enigma/MovingRotor.java enigma/Permutation.java enigma/Alphabet.java enigma/CharacterRange.java enigma/EnigmaException.java
    // java enigma/MovingRotor
    public static void main(String[] args) {
        Permutation perm = new Permutation("(AB) (CDEFGHIJKLMNOPQRSTUVWXYZ)", new CharacterRange('A', 'Z'));
        MovingRotor rotor = new MovingRotor("forward one", perm, "B");

        System.out.println(rotor.name().equals("forward one"));
        System.out.println(rotor.alphabet() == perm.alphabet());
        System.out.println(rotor.permutation() == perm);
        System.out.println(rotor.rotates() == true);
        System.out.println(rotor.reflecting() == false);

        System.out.println(rotor.size() == 26);
        rotor.set(1);
        System.out.println(rotor.setting() == 1);
        System.out.println(rotor.atNotch() == true);
        rotor.set('A');
        System.out.println(rotor.setting() == 0);
        System.out.println(rotor.atNotch() == false);
        System.out.println(rotor.convertForward(0) == 1);
        System.out.println(rotor.convertBackward(1) == 0);
        rotor.advance();
        System.out.println(rotor.setting() == 1);
        System.out.println(rotor.atNotch() == true);
        System.out.println(rotor.convertForward(0) == 25);
        System.out.println(rotor.convertBackward(25) == 0);
    }

}
