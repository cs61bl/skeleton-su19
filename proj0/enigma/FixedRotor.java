package enigma;

import static enigma.EnigmaException.*;

/** Class that represents a rotor that has no ratchet and does not advance.
 *  @author
 */
class FixedRotor extends Rotor {

    /** A non-moving rotor named NAME whose permutation at the 0 setting
     * is given by PERM. */
    FixedRotor(String name, Permutation perm) {
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
}
