package enigma;

import static enigma.EnigmaException.*;

/** Class that represents a rotating rotor in the enigma machine.
 *  @author
 */
class MovingRotor extends Rotor {

    /** A rotor named NAME whose permutation in its default setting is
     *  PERM, and whose notches are at the positions indicated in NOTCHES.
     *  The Rotor is initially in its 0 setting (first character of its
     *  alphabet).
     */
    MovingRotor(String name, Permutation perm, String notches) {
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

}
