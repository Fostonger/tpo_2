package functions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class TrigonometryIntegrationTest {
    private Trigonometry sut;
    @BeforeEach
    void setUp() {
        sut = Mockito.spy(new Trigonometry(new BaseCos(150000)));
    }
    @AfterEach
    void tearDown() {
        sut = null;
    }
    @ParameterizedTest
    @MethodSource("sinArgs")
    void sinSeriesParametrizedTest(double x, double expected) {
        assertEquals(expected, sut.sin(x), 0.00001);
    }
    static Stream<Arguments> sinArgs() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0.84147098),
                Arguments.of(PI, 0),
                Arguments.of(PI / 2, 1),
                Arguments.of(PI / 3, sqrt(3) / 2),
                Arguments.of(PI / 4, sqrt(2) / 2),
                Arguments.of(PI / 6, 0.5),
                Arguments.of(5 * PI / 6, 0.5),
                Arguments.of(3 * PI / 4, sqrt(2) / 2),
                Arguments.of(2 * PI / 3, sqrt(3) / 2),
                Arguments.of(2 * PI, 0),
                Arguments.of(3 * PI, 0),
                Arguments.of(3 * PI / 2, -1),
                Arguments.of(16 * PI / 3, -sqrt(3) / 2),
                Arguments.of(10, -0.54402));
    }
    @Test
    void tanTest() {
        double x = -4.91;
        Mockito.doReturn(0.196327).when(sut).cos(x);
        assertEquals(4.9944, sut.tan(x), 0.001);
    }

    @Test
    void cotTest() {
        double x = 10.0;
        Mockito.doReturn(-0.839072).when(sut).cos(x);
        assertEquals(1.54235, sut.cot(x), 0.001);
    }

    @Test
    void secTest() {
        double x = -5.0;
        Mockito.doReturn(0.283662).when(sut).cos(x);
        assertEquals(3.52535, sut.sec(x), 0.001);
    }

    @Test
    void cscTest() {
        double x = 45.0;
        Mockito.doReturn(0.52532).when(sut).cos(x);
        assertEquals(1.90359, sut.sec(x), 0.001);
    }
}