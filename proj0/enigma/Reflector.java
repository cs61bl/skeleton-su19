package enigma;

import static enigma.EnigmaException.*;

/** Class that represents a reflector in the enigma.
 *  @author
 */
class Reflector extends FixedRotor {

    /** A non-moving rotor named NAME whose permutation at the 0 setting
     * is PERM. */
    Reflector(String name, Permutation perm) {
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
        if (posn != 0) {
            throw error("reflector has only one position");
        }
    }

}
