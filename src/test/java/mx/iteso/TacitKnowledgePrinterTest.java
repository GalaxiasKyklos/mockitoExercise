package mx.iteso;

import static org.junit.Assert.*;
import org.junit.*;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

public class TacitKnowledgePrinterTest {

    //Test printNumbers with a limit of 10
        //Verify calculate being called 10 times
        //Verify expected result

    //Test printNumbers with a limit of 0
        //Verify Exception

    //What else can we test?
        //What should we verify?
    private Printer printer;

    @Before
    public void setUp() {
        printer = mock(Printer.class);
        when(printer.print(anyString())).then(returnsFirstArg());
    }

    @Test
    public void testTenTimesCalled() {
        TacitKnowledgePrinter tacitPrinter = new TacitKnowledgePrinter(printer);
        tacitPrinter.printNumbers(10);
        verify(printer, times(10)).print(anyString());
    }

    @Test
    public void testTenTimesResult() {
        TacitKnowledgePrinter tacitPrinter = new TacitKnowledgePrinter(printer);
        assertEquals(tacitPrinter.printNumbers(10), "12Tacit4KnowledgeTacit78TacitKnowledge");
    }

    @Test
    public void test15TimesResult() {
        TacitKnowledgePrinter tacitPrinter = new TacitKnowledgePrinter(printer);
        assertEquals(tacitPrinter.printNumbers(15), "12Tacit4KnowledgeTacit78TacitKnowledge11Tacit1314TacitKnowledge");
    }

    @Test (expected = RuntimeException.class)
    public void testZeroException()  {
        TacitKnowledgePrinter tacitPrinter = new TacitKnowledgePrinter(printer);
        when(tacitPrinter.calculate(0)).thenThrow(new RuntimeException("limit must be >= 1"));
    }

    @Test
    public void testDiv3() {
        TacitKnowledgePrinter tacitPrinter = new TacitKnowledgePrinter(printer);
        assertEquals(tacitPrinter.calculate(3), "Tacit");
    }

    @Test
    public void testDiv5() {
        TacitKnowledgePrinter tacitPrinter = new TacitKnowledgePrinter(printer);
        assertEquals(tacitPrinter.calculate(5), "Knowledge");
    }

    @Test
    public void testDiv3and5() {
        TacitKnowledgePrinter tacitPrinter = new TacitKnowledgePrinter(printer);
        assertEquals(tacitPrinter.calculate(15), "TacitKnowledge");
    }

    @Test
    public void testNonDiv3or5() {
        TacitKnowledgePrinter tacitPrinter = new TacitKnowledgePrinter(printer);
        assertEquals(tacitPrinter.calculate(4), "4");
    }
}
