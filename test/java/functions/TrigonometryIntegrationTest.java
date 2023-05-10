package functions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TrigonometryIntegrationTest {
    private Trigonometry sut;
    @BeforeEach
    void setUp() {
        sut = Mockito.spy(new Trigonometry(new BaseCos(1)));
    }
    @AfterEach
    void tearDown() {
        sut = null;
    }
    @Test
    void sinTest() {
        double x = 12;
        Mockito.doReturn(0.84385).when(sut).cos(x);
        assertEquals(-0.53657, sut.sin(x), 0.001);
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