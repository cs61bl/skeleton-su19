import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import static org.junit.Assert.*;

public class GraphTest {

    /* Returns a randomly generated graph with VERTICES number of vertices and
       EDGES number of edges with max weight WEIGHT.

       Note: This method doesn't guarantee the resulting Graph will be
       connected. */
    public static Graph randomGraph(int vertices, int edges, int weight) {
        Graph g = new Graph();
        Random rng = new Random();
        for (int i = 0; i < vertices; i += 1) {
            g.addVertex(i);
        }
        for (int i = 0; i < edges; i += 1) {
            Edge e = new Edge(rng.nextInt(vertices), rng.nextInt(vertices), rng.nextInt(weight));
            g.addEdge(e);
        }
        return g;
    }

    /* Returns a Graph object with integer edge weights as parsed from
       FILENAME. Talk about the setup of this file. */
    public static Graph loadFromText(String filename) {
        Charset cs = Charset.forName("US-ASCII");
        try (BufferedReader r = Files.newBufferedReader(Paths.get(filename), cs)) {
            Graph g = new Graph();
            String line;
            while ((line = r.readLine()) != null) {
                String[] fields = line.split(", ");
                if (fields.length == 3) {
                    int from = Integer.parseInt(fields[0]);
                    int to = Integer.parseInt(fields[1]);
                    int weight = Integer.parseInt(fields[2]);
                    g.addEdge(from, to, weight);
                } else if (fields.length == 1) {
                    g.addVertex(Integer.parseInt(fields[0]));
                } else {
                    throw new IllegalArgumentException("Bad input file!");
                }
            }
            return g;
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
            System.exit(1);
            return null;
        }
    }

    @Test
    public void testMultiEdgeGraph() {
        Graph input = loadFromText("inputs/graphTestMultiEdge.in");
        Graph output = loadFromText("outputs/graphTestMultiEdge.out");
        assertEquals("Prim's algorithm failed on graphTestMultiEdge.", output, input.prims(0));
        assertEquals("Kruskal's algorithm failed on graphTestMultiEdge.", output, input.kruskals());
    }

    @Test
    public void testNormalGraph() {
        Graph input = loadFromText("inputs/graphTestNormal.in");
        Graph output = loadFromText("outputs/graphTestNormal.out");
        assertEquals("Prim's algorithm failed on graphTestNormal.", output, input.prims(0));
        assertEquals("Kruskal's algorithm failed on graphTestNormal.", output, input.kruskals());
    }

    @Test
    public void testMediumGraph() {
        Graph input = loadFromText("inputs/graphTestMedium.in");
        Graph output = loadFromText("outputs/graphTestMedium.out");
        assertEquals("Prim's algorithm failed on graphTestMedium.", output, input.prims(0));
        assertEquals("Kruskal's algorithm failed on graphTestMedium.", output, input.kruskals());
    }

}
