package baseFunctions;

import functions.BaseCos;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseCosUnitTest {
    private BaseCos sut;
    @BeforeEach
    void setUp() {
        sut = new BaseCos(1000);
    }
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("cosArgs")
    void seriesParametrizedTest(double x, double expected) {
        assertEquals(expected, sut.cos(x), 0.00001);
    }
    static Stream<Arguments> cosArgs() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(PI, -1),
                Arguments.of(PI / 2, 0),
                Arguments.of(PI / 3, 0.5),
                Arguments.of(PI / 4, sqrt(2) / 2),
                Arguments.of(PI / 6, sqrt(3) / 2),
                Arguments.of(2 * PI / 3, -0.5),
                Arguments.of(3 * PI / 4, -sqrt(2) / 2),
                Arguments.of(5 * PI / 6, -sqrt(3) / 2),
                Arguments.of(2 * PI, 1),
                Arguments.of(3 * PI, -1),
                Arguments.of(3 * PI / 2, 0),
                Arguments.of(16 * PI / 3, -0.5));
    }
}