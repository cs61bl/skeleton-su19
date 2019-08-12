import org.junit.Test;
import static org.junit.Assert.*;

public class UnionFindTest {

    @Test
    public void testSmallExample() {
        UnionFind uf = new UnionFind(6);
        uf.union(0, 1);
        uf.union(4, 0);
        uf.union(3, 5);
        assertEquals(0, uf.find(4));
        assertTrue(uf.connected(3, 5));
        uf.union(4, 3);
        assertEquals(5, uf.sizeOf(0));
        assertEquals(5, uf.sizeOf(4));
        assertEquals(5, uf.sizeOf(5));
        assertEquals(1, uf.sizeOf(2));
        assertFalse(uf.connected(2, 5));
    }
}
