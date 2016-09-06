package mx.iteso;

import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;
import mx.iteso.Printer;
import org.junit.rules.ExpectedException;
import org.mockito.internal.matchers.Any;
import org.omg.CORBA.AnySeqHelper;

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
        when(printer.print(anyString())).thenReturn(anyString());
    }

    @Test
    public void testTenTimes() {
        TacitKnowledgePrinter tacitPrinter = new TacitKnowledgePrinter(printer);
        tacitPrinter.printNumbers(10);
        verify(printer, times(10)).print(anyString());
    }

    @Test (expected = RuntimeException.class)
    public void testZeroException() {
        TacitKnowledgePrinter tacitPrinter = new TacitKnowledgePrinter(printer);
        tacitPrinter.printNumbers(0);
    }
}
