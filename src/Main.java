import functions.BaseCos;
import functions.BaseLog;

public class Main {
    public static void main(String[] args) {
        BaseLog ln = new BaseLog(10000);
        System.out.println(ln.ln(0.00005));
        System.out.println(Math.log(0.00005));
    }
}