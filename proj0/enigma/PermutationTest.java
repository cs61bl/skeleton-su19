package enigma;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

import static enigma.TestUtils.*;

/** The suite of all JUnit tests for the Permutation class.
 *  @author
 */
public class PermutationTest {

    /** Testing time limit. */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    /* ***** TESTING UTILITIES ***** */

    private Permutation perm;
    private String alpha = UPPER_STRING;

    /** Check that perm has an alphabet whose size is that of
     *  FROMALPHA and TOALPHA and that maps each character of
     *  FROMALPHA to the corresponding character of FROMALPHA, and
     *  vice-versa. TESTID is used in error messages. */
    private void checkPerm(String testId,
                           String fromAlpha, String toAlpha) {
        int N = fromAlpha.length();
        assertEquals(testId + " (wrong length)", N, perm.size());
        for (int i = 0; i < N; i += 1) {
            char c = fromAlpha.charAt(i), e = toAlpha.charAt(i);
            assertEquals(msg(testId, "wrong translation of '%c'", c),
                         e, perm.permute(c));
            assertEquals(msg(testId, "wrong inverse of '%c'", e),
                         c, perm.invert(e));
            int ci = alpha.indexOf(c), ei = alpha.indexOf(e);
            assertEquals(msg(testId, "wrong translation of %d", ci),
                         ei, perm.permute(ci));
            assertEquals(msg(testId, "wrong inverse of %d", ei),
                         ci, perm.invert(ei));
        }
    }

    /* ***** TESTS ***** */

    @Test
    public void checkIdTransform() {
        perm = new Permutation("", UPPER);
        checkPerm("identity", UPPER_STRING, UPPER_STRING);
    }

    @Test
    public void checkForwardTransform() {
    	// permutation which maps each character forward by one (e.g. A->B, Z->A)
        perm = new Permutation("(FIXME)", UPPER); // FIXME - what string represents the Permutation for the above description?
        checkPerm("forward", UPPER_STRING, "FIXME"); // FIXME - what string represents the result of permuting each letter?
    }

    @Test
    public void checkBackwardTransform() {
    	// permutation which maps each character backward by one (e.g. B->A, A->Z)
        perm = new Permutation("(FIXME)", UPPER); // FIXME - what string represents the Permutation for the above description?
        checkPerm("backward", UPPER_STRING, "FIXME"); // FIXME - what string represents the result of permuting each letter?
    }

    @Test
    public void checkNavalPermutation() {
    	perm = new Permutation(NAVALA.get("I"), UPPER); // Consider trying Rotors besides Rotor I
    	checkPerm("naval A: I", UPPER_STRING, NAVALA_MAP.get("I"));
    }

    // FIXME Additional Tests

}
