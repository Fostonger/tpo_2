package functions;

import interfaces.LnCalculatable;
import interfaces.LogCalculatable;

public class Log implements LogCalculatable {
    private LnCalculatable lnCalculator;
    public Log(LnCalculatable lnCalculator) { this.lnCalculator = lnCalculator; }
    public double log(int base, double x) {
        double table = tableValues(x, 10);
        if (table != -1) { return table; }
        return ln(x) / ln(base);
    }
    public double ln(double x) {
        return lnCalculator.ln(x);
    }
    private double tableValues(double x, int base) {
        if (x == 1) {
            return 0;
        } else if (x == base) {
            return 1;
        } else {
            return -1;
        }
    }
}