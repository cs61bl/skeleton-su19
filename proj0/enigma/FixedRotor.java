package enigma;

import static enigma.EnigmaException.*;

/** Class that represents a rotor that has no ratchet and does not advance.
 *  @author
 */
public class FixedRotor extends Rotor {

    /** A non-moving rotor named NAME whose permutation at the 0 setting
     * is given by PERM. */
    public FixedRotor(String name, Permutation perm) {
        super(name, perm);
    }

    // FIXME? - This class inherits all of the information present in the
    //			Rotor class, meaning that any method which exists in
    //			Rotor can be used from FixedRotor. This will make more sense
    //			later in the course, but for now, you should think about
    //			how a FixedRotor's behavior is different from a MovingRotor.
    //			Does a FixedRotor's behavior differ from the default Rotor
    //			behavior? Do we need to add anything to this class in order
    //			for it to behave as a non-moving Rotor? Check out Rotor and
    //			MovingRotor to see what methods might be different between
    //			these two classes.

    // HINT: Nothing to add here !

    // To run this through command line, from the proj0 directory, run the following:
    // javac enigma/Rotor.java enigma/FixedRotor.java enigma/Permutation.java enigma/Alphabet.java enigma/CharacterRange.java enigma/EnigmaException.java
    // java enigma/FixedRotor
    public static void main(String[] args) {
        Permutation perm = new Permutation("(ABCDEFGHIJKLMNOPQRSTUVWXYZ)", new CharacterRange('A', 'Z'));
        Rotor rotor = new FixedRotor("forward one", perm);

        System.out.println(rotor.name().equals("forward one"));
        System.out.println(rotor.alphabet() == perm.alphabet());
        System.out.println(rotor.permutation() == perm);
        System.out.println(rotor.rotates() == false);
        System.out.println(rotor.reflecting() == false);

        System.out.println(rotor.size() == 26);
        rotor.set(1);
        System.out.println(rotor.setting() == 1);
        rotor.set('A');
        System.out.println(rotor.setting() == 0);
        System.out.println(rotor.convertForward(0) == 1);
        System.out.println(rotor.convertBackward(1) == 0);
    }
}
