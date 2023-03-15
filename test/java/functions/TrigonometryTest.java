package functions;

import interfaces.CosCalculatable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class TrigonometryTest {
    Trigonometry sut;
    @BeforeEach
    void setUp() {
        CosCalculatable baseCos = new BaseCos(1000);
        sut = new Trigonometry(baseCos);
    }
    @AfterEach
    void tearDown() {
        sut = null;
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/base-cos-tests.csv", numLinesToSkip = 1)
    void cosParameterizedTest(double x, double expected, double delta) {
        Double result = sut.cos(x);
        assertEquals(expected, result, delta);
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/sin-tests.csv", numLinesToSkip = 1)
    void sinParameterizedTest(double x, double expected, double delta) {
        Double result = sut.sin(x);
        assertEquals(expected, result, delta);
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/tan-tests.csv", numLinesToSkip = 1)
    void tanParameterizedTest(double x, double expected, double delta) {
        Double result = sut.tan(x);
        assertEquals(expected, result, delta);
    }
    @Test
    void tanOf90ShouldThrow() {
        assertThrows(IllegalArgumentException.class, ()->{
            sut.tan(Math.PI/2);
        });
    }
    @Test
    void tanOf270ShouldThrow() {
        assertThrows(IllegalArgumentException.class, ()->{
            sut.tan(3 * Math.PI / 2);
        });
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/cot-tests.csv", numLinesToSkip = 1)
    void cotParameterizedTest(double x, double expected, double delta) {
        Double result = sut.cot(x);
        assertEquals(expected, result, delta);
    }
    @Test
    void cotOf360ShouldThrow() {
        assertThrows(IllegalArgumentException.class, ()->{
            sut.cot(Math.PI * 2);
        });
    }
    @Test
    void cotOf180ShouldThrow() {
        assertThrows(IllegalArgumentException.class, ()->{
            sut.cot(Math.PI);
        });
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/csc-tests.csv", numLinesToSkip = 1)
    void cscParameterizedTest(double x, double expected, double delta) {
        Double result = sut.csc(x);
        assertEquals(expected, result, delta);
    }
    @Test
    void cscWith0ShouldThrow() {
        assertThrows(IllegalArgumentException.class, ()->{
            sut.csc(0);
        });
    }
    @Test
    void cscWith180ShouldThrow() {
        assertThrows(IllegalArgumentException.class, ()->{
            sut.csc(Math.PI);
        });
    }
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/sec-tests.csv", numLinesToSkip = 1)
    void secParameterizedTest(double x, double expected, double delta) {
        Double result = sut.sec(x);
        assertEquals(expected, result, delta);
    }
    @Test
    void secWith90ShouldThrow() {
        assertThrows(IllegalArgumentException.class, ()->{
            sut.sec(Math.PI/2);
        });
    }
    @Test
    void secWith270ShouldThrow() {
        assertThrows(IllegalArgumentException.class, ()->{
            sut.sec(3 * Math.PI/2);
        });
    }
}