package SystemOfFunctions;

import functions.BaseCos;
import functions.BaseLog;
import functions.Log;
import functions.Trigonometry;
import interfaces.CosCalculatable;
import interfaces.LnCalculatable;
import interfaces.LogCalculatable;
import interfaces.TrigonometryCalculatable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsSystemTest {
    FunctionsSystem sut;
    @BeforeEach
    void setUp() {
        CosCalculatable baseCos = new BaseCos(1000);
        TrigonometryCalculatable trigonom = new Trigonometry(baseCos);
        LnCalculatable baseLn = new BaseLog(1000);
        LogCalculatable logarithms = new Log(baseLn);
        sut = new FunctionsSystem(trigonom, logarithms);
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/system-tests.csv", numLinesToSkip = 1)
    void systemParameterizedTest(double x, double expected, double delta) {
        Double result = sut.system(x);
        assertEquals(expected, result, delta);
    }
}