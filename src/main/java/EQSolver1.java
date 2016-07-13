import java.math.BigDecimal;
import java.util.ArrayList;

public class EQSolver1 {
    public static int scale = 10;

    public static void main(String[] args) {
        System.out.println("Solving equation 1");
        solve(2,5,3);
        System.out.println("Solving equation 2");
        solve(4,4,1);
        System.out.println("Solving equation 3");
        solve(2,5,4);
    }

    public static ArrayList solve(double param1, double param2, double param3) {
        ArrayList result = new ArrayList();
        BigDecimal a = BigDecimal.valueOf(param1);
        BigDecimal b = BigDecimal.valueOf(param2);
        BigDecimal c = BigDecimal.valueOf(param3);

        double numerator = (b.pow(2).subtract(BigDecimal.valueOf(4).multiply(a).multiply(c))).doubleValue();
        if (numerator < 0) {
            System.out.println("Equation has no roots");
        } else {
            BigDecimal x1 = b.negate().add(
                    BigDecimal.valueOf(Math.sqrt(numerator)))
                    .divide(BigDecimal.valueOf(2).multiply(a), EQSolver1.scale, BigDecimal.ROUND_HALF_UP);
            BigDecimal x2 = b.negate().subtract(
                    BigDecimal.valueOf(Math.sqrt(numerator)))
                    .divide(BigDecimal.valueOf(2).multiply(a), EQSolver1.scale, BigDecimal.ROUND_HALF_UP);

            if (x1.equals(x2)) {
                System.out.println("Equation has 1 root: " + x1.toPlainString());
                result.add(x1);
            } else {
                System.out.println("Root1: " + x1.toPlainString());
                System.out.println("Root2: " + x2.toPlainString());
                result.add(x1);
                result.add(x2);
            }
        }
        return result;
    }
}
