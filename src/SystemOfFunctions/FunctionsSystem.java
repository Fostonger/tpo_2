package SystemOfFunctions;

import interfaces.LogCalculatable;
import interfaces.TrigonometryCalculatable;

public class FunctionsSystem {
    private TrigonometryCalculatable trigonometry;
    private LogCalculatable logarithms;
    public FunctionsSystem(TrigonometryCalculatable trigonometry, LogCalculatable logarithms) {
        this.trigonometry = trigonometry;
        this.logarithms = logarithms;
    }
    private double trigonometry(double x) {
        double cot = trigonometry.cot(x);
        double sin = trigonometry.sin(x);
        double sec = trigonometry.sec(x);
        double csc = trigonometry.csc(x);
        double tan = trigonometry.tan(x);
        double cos = trigonometry.cos(x);

        return (Math.pow((((((((cot - sin) * sec) / sin) + cot) / sec) + (csc - (cot / csc))) / csc) + cot, 3)
                        / ((((tan * cos) / ((cot * ((cos * cot) * (sin * tan))) + (sec * (cos + sin)))) *
                        (cos * Math.pow(Math.pow(cot, 3), 3))) * ((((sin - csc) * cos) - (csc / sec)) / tan))) / csc;
    }

    private double logarithmic(double x) {
        double log_10 = logarithms.log(10, x);
        double log_3 = logarithms.log(3, x);
        double log_2 = logarithms.log(2, x);
        double ln = logarithms.ln(x);

        return Math.pow((((log_10 / log_10) * log_3) * (Math.pow(log_2, 3) * (ln - ln))), 3) - (log_2 / log_10);
    }

    public double system(double x) {
        return (x > 0) ? logarithmic(x) : trigonometry(x);
    }
}
