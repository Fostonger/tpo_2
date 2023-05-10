package baseFunctions;

import functions.BaseLog;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Math.exp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseLogUnitTest {
    BaseLog sut;

    @BeforeEach
    void setUp() {
        sut = new BaseLog(150000);
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }
    @ParameterizedTest
    @MethodSource("lnArgs")
    void testLogarithm(double value, double expected) {
        assertEquals(expected, sut.ln(value), 0.001);
    }
    @ParameterizedTest
    @MethodSource("logarithmThrowingArgs")
    void testLogarithmThrows(double value) {
        assertThrows(IllegalArgumentException.class, ()-> {
            sut.ln(value);
        });
    }
    static Stream<Arguments> lnArgs() {
        return Stream.of(
                Arguments.of(exp(3), 3),
                Arguments.of(exp(5), 5),
                Arguments.of(exp(8), 8),
                Arguments.of(1, 0),
                Arguments.of(exp(10), 10),
                Arguments.of(exp(0.1), 0.1)
        );
    }
    static Stream<Arguments> logarithmThrowingArgs() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(-5),
                Arguments.of(-1),
                Arguments.of(-0.5)
        );
    }
}