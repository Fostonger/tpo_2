package functions;
public enum TrigonometryFunction {
    SIN, COS, TAN, COT, CSC, SEC;
    private static double precision = 0.0000001;
    public static void setPrecision(double precision) {
        TrigonometryFunction.precision = precision;
    }

    public static Double tableValue(Double x, TrigonometryFunction f) {
        if (x == null) { return null; }
        x %= Math.PI*2;
        switch (f) {
            case SIN -> { return sinVal(x); }
            case COS -> { return cosVal(x); }
            case TAN -> { return tanVal(x); }
            case COT -> { return cotVal(x); }
            case CSC -> { return cosVal(1/x); }
            case SEC -> { return sinVal(1/x); }
            default  -> { return null; }
        }
    }
    private static Double sinVal(double x) {
        if      ( compare(x, degToRad(0))  || compare(x, degToRad(180)) ) { return 0d; }
        else if ( compare(x, degToRad(30)) || compare(x, degToRad(150)) ) { return 0.5; }
        else if ( compare(x, degToRad(45)) || compare(x, degToRad(135)) ) { return Math.sqrt(2)/2; }
        else if ( compare(x, degToRad(60)) || compare(x, degToRad(120)) ) { return Math.sqrt(3)/2; }
        else if ( compare(x, degToRad(90)) ) { return 1d; }
        else if ( compare(x, degToRad(270)) ) { return -1d; }
        else return null;
    }
    private static Double cosVal(double x) {
        if      ( compare(x, degToRad(0)) ) { return 1d; }
        else if ( compare(x, degToRad(30)) ) { return Math.sqrt(3)/2; }
        else if ( compare(x, degToRad(45)) ) { return Math.sqrt(2)/2; }
        else if ( compare(x, degToRad(60)) ) { return 0.5; }
        else if ( compare(x, degToRad(90)) || compare(x, degToRad(270))) { return 0d; }
        else if ( compare(x, degToRad(120)) ) { return -0.5; }
        else if ( compare(x, degToRad(135)) ) { return -Math.sqrt(2)/2; }
        else if ( compare(x, degToRad(150)) ) { return -Math.sqrt(3)/2; }
        else if ( compare(x, degToRad(180)) ) { return -1d; }
        else return null;
    }
    private static Double tanVal(double x) {
        if      ( compare(x, degToRad(0)) ) { return 0d; }
        else if ( compare(x, degToRad(30)) ) { return Math.sqrt(3)/3; }
        else if ( compare(x, degToRad(45)) ) { return 1d; }
        else if ( compare(x, degToRad(60)) ) { return Math.sqrt(3); }
        else if ( compare(x, degToRad(90)) || compare(x, degToRad(270))) {
            throw new IllegalArgumentException("tan is not defined on 90 and 270 degrees");
        }
        else if ( compare(x, degToRad(120)) ) { return -Math.sqrt(3); }
        else if ( compare(x, degToRad(135)) ) { return -1d; }
        else if ( compare(x, degToRad(150)) ) { return -Math.sqrt(3)/3; }
        else if ( compare(x, degToRad(180)) ) { return 0d; }
        else return null;
    }
    private static Double cotVal(double x) {
        if      ( compare(x, degToRad(0)) || compare(x, degToRad(180)) ) {
            throw new IllegalArgumentException("cot is not defined on 90 and 270 degrees");
        }
        else if ( compare(x, degToRad(30)) ) { return Math.sqrt(3); }
        else if ( compare(x, degToRad(45)) ) { return 1d; }
        else if ( compare(x, degToRad(60)) ) { return Math.sqrt(3)/3; }
        else if ( compare(x, degToRad(90)) || compare(x, degToRad(270))) { return 0d; }
        else if ( compare(x, degToRad(120)) ) { return -Math.sqrt(3)/3; }
        else if ( compare(x, degToRad(135)) ) { return -1d; }
        else if ( compare(x, degToRad(150)) ) { return -Math.sqrt(3); }
        else return null;
    }
    private static double degToRad(double d) { return d * Math.PI / 180; }
    private static boolean compare(double a, double b) { return Math.abs(a-b) <= precision; }
}
