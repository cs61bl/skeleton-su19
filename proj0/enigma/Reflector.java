package enigma;

import static enigma.EnigmaException.*;

/** Class that represents a reflector in the enigma.
 *  @author
 */
public class Reflector extends FixedRotor {

    /** A non-moving rotor named NAME whose permutation at the 0 setting
     * is PERM. */
    public Reflector(String name, Permutation perm) {
        super(name, perm);
        // FIXME? - Assign any additional instance variables.
    }

    // FIXME - Just as FixedRotor inherits from Rotor, Reflector inherits
    //			from FixedRotor, meaning that it can use any methods which
    //			exist in FixedRotor. Since FixedRotor inherits from Rotor,
    //			Reflector can use any methods from Rotor, as well. Given
    //			this, are there any methods that we should override and
    //			update in order to express that this is a Reflector?

    @Override // Use this special tag when updating the behavior of a method this class inherits from FixedRotor
    public boolean reflecting() {
        return false; // FIXME? - How do we know whether this Rotor should reflect?
    }

    @Override // Use this special tag when updating the behavior of a method this class inherits from FixedRotor
    public void set(int posn) {
        super.set(0);
    }

    // To run this through command line, from the proj0 directory, run the following:
    // javac enigma/Rotor.java enigma/FixedRotor.java enigma/Reflector.java enigma/Permutation.java enigma/Alphabet.java enigma/CharacterRange.java enigma/EnigmaException.java
    // java enigma/Reflector
    public static void main(String[] args) {
        Permutation perm = new Permutation(
                "(AB) (CD) (EF) (GH) (IJ) (KL) (MN) (OP) (QR) (ST) (UV) (WX) (YZ)"
                , new CharacterRange('A', 'Z'));
        Reflector rotor = new Reflector("reflect pairs", perm);

        System.out.println(rotor.name().equals("reflect pairs"));
        System.out.println(rotor.alphabet() == perm.alphabet());
        System.out.println(rotor.permutation() == perm);
        System.out.println(rotor.rotates() == false);
        System.out.println(rotor.reflecting() == true);

        System.out.println(rotor.size() == 26);
        rotor.set(1);
        System.out.println(rotor.setting() == 0);
        rotor.set('A');
        System.out.println(rotor.setting() == 0);
        System.out.println(rotor.convertForward(0) == 1);
        System.out.println(rotor.convertBackward(1) == 0);
    }

}
