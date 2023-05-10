package csvWriter;

import functions.BaseCos;
import functions.BaseLog;
import functions.Trigonometry;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvWriter {
    private interface FunctionToWrite { double execute(double x);}
    public static void main(String[] args) {
        int x = 100;

        BaseCos cos = new BaseCos(10000);
        executeModuleAndWriteCsv(x, 0.001F, cos::cos, "baseCos");

        BaseLog ln = new BaseLog(10000);
        executeModuleAndWriteCsv(x, 0.01F, ln::ln, "baseLog");
    }

    private static void executeModuleAndWriteCsv(int x, float step, FunctionToWrite f, String  name) {
        List<String[]> result = new ArrayList<>();
        for (float i = 0; i < x; i += step) {
            try {
                result.add(new String[] { Double.toString( i ), Double.toString( f.execute(i) ) });
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
        generateCsv(result, name);
    }
    private static String convertToCSV(String[] data) {
        return Stream.of(data).collect(Collectors.joining(","));
    }
    private static void generateCsv(List<String[]> data, String name) {
        File csvOutputFile = new File("csv/" + name + ".csv");
        if (!csvOutputFile.exists()) {
            try { csvOutputFile.createNewFile(); }
            catch (IOException e) { throw new RuntimeException(e); }
        }
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            data.stream().map(CsvWriter::convertToCSV).forEach(pw::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
