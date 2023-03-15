package baseFunctions;

import functions.BaseCos;
import functions.BaseLog;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseLogTest {
    BaseLog sut;

    @BeforeEach
    void setUp() {
        sut = new BaseLog(1000);
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/base-ln-tests.csv", numLinesToSkip = 1)
    void seriesParametrizedTest(double x, double expected, double delta) {
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
}