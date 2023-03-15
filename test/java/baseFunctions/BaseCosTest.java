package baseFunctions;

import functions.BaseCos;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseCosTest {
    BaseCos sut;
    @BeforeEach
    void setUp() {
        sut = new BaseCos(1000);
    }
    @AfterEach
    void tearDown() {
        sut = null;
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/base-cos-tests.csv", numLinesToSkip = 1)
    void seriesParametrizedTest(double x, double expected, double delta) {
        Double result = sut.cos(x);
        assertEquals(expected, result, delta);
    }
}