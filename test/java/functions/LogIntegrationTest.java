package functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LogIntegrationTest {
    private Log sut;
    @BeforeEach
    void setUp() {
        sut = Mockito.spy(new Log(new BaseLog(1)));
    }
    @Test
    void testLogarithm() {
        int base = 2;
        double value = 16;
        Mockito.doReturn(0.693147).when(sut).ln(base);
        Mockito.doReturn(2.772588).when(sut).ln(value);

        assertEquals(4, sut.log(base, value), 0.001);
    }
    @Test
    void testLogarithmZeroBaseThrows() {
        int base = 0;
        double value = 2;
        Mockito.doThrow(new IllegalArgumentException()).when(sut).ln(base);
        Mockito.doReturn(0.693147).when(sut).ln(value);
        assertThrows(IllegalArgumentException.class, ()-> {
            sut.log(base, value);
        });
    }
    @Test
    void testLogarithmZeroValueThrows() {
        int base = 2;
        double value = 0;
        Mockito.doThrow(new IllegalArgumentException()).when(sut).ln(value);
        Mockito.doReturn(0.693147).when(sut).ln(base);
        assertThrows(IllegalArgumentException.class, ()-> {
            sut.log(base, value);
        });
    }
}