import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import org.junit.Test;

import static org.junit.Assert.*;
/* Test suite for the KDTree.
   @author Christine Zhou */
public class KDTreeTest {

    Random rand = new Random(18);

    /* Creates N random points. */
    List<Point> createNRandomPoints(int N) {
        List<Point> points = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            Point p = new Point(rand.nextDouble(), rand.nextDouble());
            points.add(p);
        }
        return points;
    }

    /* Generates 6 points and inserts them into the KDTree. Then, queries
       one point for nearest.

       This test is based off of the demos done during lecture. You can
       find the demo linked in the spec. */
    @Test
    public void testDemoExample() {
        Point a = new Point(2, 3);
        Point b = new Point(4, 2);
        Point c = new Point(4, 5);
        Point d = new Point(3, 3);
        Point e = new Point(1, 5);
        Point f = new Point(4, 4);
        KDTree kd = new KDTree(List.of(a, b, c, d, e, f));
        assertEquals(new Point(1, 5), kd.nearest(0, 7));
    }

    /* Creates 1,000 random points and 200 query points. Insert the 1000
       points into a NaivePointSet and KDTree. */
    @Test
    public void test1000Points200Queries() {
        List<Point> points = createNRandomPoints(1000);
        List<Point> queryPoints = createNRandomPoints(200);

        NaivePointSet naive = new NaivePointSet(points);
        KDTree kd = new KDTree(points);

        List<Point> naiveNearest = new LinkedList<>();
        Stopwatch sw0 = new Stopwatch();
        for (Point p : queryPoints) {
            naiveNearest.add(naive.nearest(p.getX(), p.getY()));
        }
        System.out.println(String.format("The NaivePointSet took %s seconds to perform 200 queries.", sw0.elapsedTime()));

        Stopwatch sw1= new Stopwatch();
        for (int i = 0; i < 200; i++) {
            double lon = queryPoints.get(i).getX();
            double lat = queryPoints.get(i).getY();
            assertEquals(naiveNearest.get(i), kd.nearest(lon, lat));
        }
        System.out.println(String.format("The KDTree took %s seconds to perform 200 queries.", sw1.elapsedTime()));
    }

    /* Creates 10,000 random points and 2,000 query points. Insert the 10,000
       points into a NaivePointSet and KDTree. */
    @Test
    public void test10000Points2000Queries() {
        List<Point> points = createNRandomPoints(10000);
        List<Point> queryPoints = createNRandomPoints(2000);

        NaivePointSet naive = new NaivePointSet(points);
        KDTree kd = new KDTree(points);

        List<Point> naiveNearest = new LinkedList<>();
        Stopwatch sw0 = new Stopwatch();
        for (Point p : queryPoints) {
            naiveNearest.add(naive.nearest(p.getX(), p.getY()));
        }
        System.out.println(String.format("The NaivePointSet took %s seconds to perform 2,000 queries.", sw0.elapsedTime()));

        Stopwatch sw1= new Stopwatch();
        for (int i = 0; i < 2000; i++) {
            double lon = queryPoints.get(i).getX();
            double lat = queryPoints.get(i).getY();
            assertEquals(naiveNearest.get(i), kd.nearest(lon, lat));
        }
        System.out.println(String.format("The KDTree took %s seconds to perform 2,000 queries.", sw1.elapsedTime()));
    }

    // Your tests here!

}
