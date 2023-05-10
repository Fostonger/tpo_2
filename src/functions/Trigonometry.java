package functions;

import interfaces.CosCalculatable;
import interfaces.TrigonometryCalculatable;

public class Trigonometry implements TrigonometryCalculatable {
    private CosCalculatable cosCalculator;
    public Trigonometry(CosCalculatable cosCalculator) { this.cosCalculator = cosCalculator; }
    public double sin(double x) {
        Double tableValue = TrigonometryFunction.tableValue(x, TrigonometryFunction.SIN);
        if (tableValue != null) { return tableValue; }
        double cos = cos(x);
        x %= Math.PI * 2;
        return (( (x > Math.PI || (x < 0 && x > -Math.PI)) ? -1 : 1) * Math.sqrt(1 - cos * cos));
    }
    public double cot(double x) {
        Double tableValue = TrigonometryFunction.tableValue(x, TrigonometryFunction.COT);
        if (tableValue != null) { return tableValue; }

        double cos = cos(x);
        double sin = sin(x);
        return cos / sin;
    }
    public double tan(double x) {
        Double tableValue = TrigonometryFunction.tableValue(x, TrigonometryFunction.TAN);
        if (tableValue != null) { return tableValue; }

        return 1 / cot(x);
    }
    public double csc(double x) {
        Double tableValue = TrigonometryFunction.tableValue(x, TrigonometryFunction.CSC);
        if (tableValue != null) { return tableValue; }

        return 1 / sin(x);
    }
    public double sec(double x) {
        Double tableValue = TrigonometryFunction.tableValue(x, TrigonometryFunction.SEC);
        if (tableValue != null) { return tableValue; }

        return 1 / cos(x);
    }
    public double cos(double x) {
        Double tableValue = TrigonometryFunction.tableValue(x, TrigonometryFunction.COS);
        if (tableValue != null) { return tableValue; }

        return cosCalculator.cos(x);
    }
}
