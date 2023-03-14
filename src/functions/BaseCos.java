package functions;

import interfaces.CosCalculatable;

public final class BaseCos implements CosCalculatable {
    private int n = 100;
    public BaseCos(int n) { this.n = n; }
    public double cos(double x) {
        Double tableValue = TrigonometryFunction.tableValue(x, TrigonometryFunction.COS);
        if (tableValue != null) { return tableValue; }

        double sum = 1;
        double term = 1;
        x %= Math.PI*2;
        for (int i = 1; i < n; i++) {
            term *=  x*x /  (( i * 2 - 1) * ( i * 2));
            sum += (( i%2 == 0) ? 1 : -1) * term;
        }
        return sum;
    }
}
