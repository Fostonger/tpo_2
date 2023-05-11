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
        trig = Mockito.spy(new Trigonometry(new BaseCos(150000)));
        log = Mockito.spy(new Log( new BaseLog(150000)));
        sut = Mockito.spy(new FunctionsSystem(trig, log));
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }
    @Test
    void systemTrigonometryWithMinus4_71IntergationTest() {
        Mockito.doReturn(-0.0023889781122815386).when(trig).cos(-4.71);
        Mockito.doReturn( 0.999997146387718).when(trig).sin(-4.71);
        assertEquals(-1.629881903763557e+26, sut.system(-4.71), 0.001);
    }
    @Test
    void systemTrigonometryWithMinus3IntergationTest() {
        Mockito.doReturn(-0.9899924966).when(trig).cos(-3);
        Mockito.doReturn(-0.1411200080598672).when(trig).sin(-3);
        assertEquals(2.1949236026986114e-06, sut.system(-3), 0.001);
    }
    @Test
    void systemTrigonometryWithMinus1_58IntergationTest() {
        Mockito.doReturn(-0.009203543268808336).when(trig).cos(-1.58);
        Mockito.doReturn(-0.9999576464987401).when(trig).sin(-1.58);
        assertEquals(2.406611685423286e+27, sut.system(-1.58), 0.001);
    }
    @Test
    void systemTrigonometryWithMinus1_57IntergationTest() {
        Mockito.doReturn(0.0007963267107332633).when(trig).cos(-1.57);
        Mockito.doReturn(-0.9999996829318346).when(trig).sin(-1.57);
        assertEquals(-1.5418308843340829e+41, sut.system(-1.57), 0.001);
    }
    @Test
    void systemTrigonometryWithMinus7_187IntergationTest() {
        Mockito.doReturn(0.6186173011879144).when(trig).cos(-7.187);
        Mockito.doReturn(-0.7856924555263218).when(trig).sin(-7.187);
        assertEquals(2.299, sut.system(-7.187), 0.001);
    }
    @Test
    void systemLogIntergationTest() {
        Mockito.doReturn(0.693147).when(log).ln(2.0);
        Mockito.doReturn(2.302585).when(log).ln(10.0);
        assertEquals(-3.3219, sut.system(2), 0.001);
    }
    @Test
    void systemTrigonometryUnitTest() {
        double x = -7.187;
        double result = sut.system(x);
        assertEquals(2.299, result, 0.001);
    }
    @Test
    void systemLogUnitTest() {
        double x = 2;
        double result = sut.system(x);
        assertEquals(-3.3219, result, 0.001);
    }
}