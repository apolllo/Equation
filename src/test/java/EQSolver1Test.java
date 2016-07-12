import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(value= Parameterized.class)
public class EQSolver1Test {
    private int a;
    private int b;
    private int c;
    private ArrayList<BigDecimal> roots;

    @Parameterized.Parameters(name = "Test with {index} root(s)")
    public static Collection data() {
        return Arrays.asList(new double[][][] {
                {{2,5,4},{}},
                {{4,4,1},{-0.5}},
                {{2,5,3},{-1,-1.5}}
        });
    }

    public EQSolver1Test(double[] params, double[] roots) {
        this.a = (int) params[0];
        this.b = (int) params[1];
        this.c = (int) params[2];
        this.roots = new ArrayList<>();
        if (roots.length >= 1) {
            this.roots.add(new BigDecimal(roots[0]).setScale(EQSolver1.scale));
        }
        if (roots.length >= 2) {
            this.roots.add(new BigDecimal(roots[1]).setScale(EQSolver1.scale));
        }
    }

    @Test
    public void solveTest() {
        assertEquals(roots, EQSolver1.solve(a,b,c));
    }
}
