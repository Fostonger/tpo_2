package functions;

import interfaces.LnCalculatable;

public final class BaseLog implements LnCalculatable {
    private int n = 100;
    public BaseLog(int n) { this.n = n; }
    public double ln(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("logarithm undefined for non-positive numbers");
        }
        if (x == 1) { return 0; }
        else if (x == Math.E) { return 1; }

        double result = 0;
        double term = 1;
        if (x < 1) {
            for (int i = 1; i <= n; i++) {
                term *= (x - 1);
                result += ((i%2==0) ? -1 : 1 ) * term / i;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                term *= (x - 1) / x;
                result += term / i;
            }
        }
        return result;
    }
}
