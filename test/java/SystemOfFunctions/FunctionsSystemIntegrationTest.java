package SystemOfFunctions;

import functions.BaseCos;
import functions.BaseLog;
import functions.Log;
import functions.Trigonometry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsSystemIntegrationTest {
    private Trigonometry trig;
    private Log log;
    private FunctionsSystem sut;
    @BeforeEach
    void setUp() {
        trig = Mockito.spy(new Trigonometry(new BaseCos(1)));
        log = Mockito.spy(new Log( new BaseLog(1)));
        sut = Mockito.spy(new FunctionsSystem(trig, log));
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }
    @Test
    void systemTrigonometryParameterizedTest() {
        Mockito.doReturn(-0.91113026188).when(trig).cos(-9);
        assertEquals(0.055186, sut.system(-9), 0.001);
    }
    @Test
    void systemLogParameterizedTest() {
        Mockito.doReturn(0.693147).when(log).ln(2.0);
        Mockito.doReturn(2.302585).when(log).ln(10.0);
        assertEquals(-3.3219, sut.system(2), 0.001);
    }
}