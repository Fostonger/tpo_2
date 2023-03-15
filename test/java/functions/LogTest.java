package functions;

import interfaces.LnCalculatable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {
    Log sut;
    @BeforeEach
    void setUp() {
        LnCalculatable baseLn = new BaseLog(1000);
        sut = new Log(baseLn);
    }
    @AfterEach
    void tearDown() {
        sut = null;
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/base-ln-tests.csv", numLinesToSkip = 1)
    void lnParameterizedTest(double x, double expected, double delta) {
        Double result = sut.ln(x);
        assertEquals(expected, result, delta);
    }
    @Test
    void lnOf0ShouldThrow() {
        assertThrows(IllegalArgumentException.class, ()->{
            sut.ln(0);
        });
    }
    @Test
    void lnOfNegativeShouldThrow() {
        assertThrows(IllegalArgumentException.class, ()->{
            sut.ln(-1);
        });
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/log10-tests.csv", numLinesToSkip = 1)
    void log10ParameterizedTest(double x, double expected, double delta) {
        Double result = sut.log10(x);
        assertEquals(expected, result, delta);
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/log2-tests.csv", numLinesToSkip = 1)
    void log2ParameterizedTest(double x, double expected, double delta) {
        Double result = sut.log2(x);
        assertEquals(expected, result, delta);
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/log3-tests.csv", numLinesToSkip = 1)
    void log3ParameterizedTest(double x, double expected, double delta) {
        Double result = sut.log3(x);
        assertEquals(expected, result, delta);
    }
}