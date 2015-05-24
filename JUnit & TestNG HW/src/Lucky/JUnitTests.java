package Lucky;

import Lucky.LuckyTicket.Ticket;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;

public class JUnitTests {

    private LuckyTicket.Ticket ticket;

    @Before
    public void setUp() {
        ticket = new LuckyTicket.Ticket();
    }

    @Test
    public void testIsLucky() {
        ticket.setNumber("846729");
        assertTrue(LuckyTicket.isLucky(ticket));
    }

    @Test
    public void testIsNotLucky() {
        ticket.setNumber("174639");
        assertFalse(LuckyTicket.isLucky(ticket));
    }

    @Test
    public void shortNumber() {
        ticket.setNumber("5869");
        LuckyTicket.isLucky(ticket);
        assertTrue("ArrayIndexOutOfBoundsException was not thrown", ticket.tooShort);
}

    @Test
    public void longNumber() {
        ticket.setNumber("48596235");
        LuckyTicket.isLucky(ticket);
        assertTrue("TooLongTicketNumberException was not thrown", ticket.tooLong);
    }

    @Test
    public void charsIncluded() {
        ticket.setNumber("57hyn6");
        LuckyTicket.isLucky(ticket);
        assertTrue("NotDigitTicketNumberException was not thrown", ticket.notDigitsDetected);
    }

}

