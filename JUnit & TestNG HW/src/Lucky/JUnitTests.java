package Lucky;

import Lucky.LuckyTicket.Ticket;
import org.junit.*;

/*   Here is my problem.

    I'd like my program to not throw uncatched exceptions and want it to be 'clean'.

    However, I'd like to have tests like that, not only 'assertTrue':

    @Test(expected=IndexOutOfBoundsException.class)
    public void shortNumber() {
        ticket.setNumber("5869");
        LuckyTicket.isLucky(ticket);
    }

    I am not sure what would be the best practice here,
    so I chose to catch exceptions and just have some variables in program showing that exception was thrown.
*/

public class JUnitTests {

    Ticket ticket = new Ticket();

    @Test
    public void testIsLucky() {
        ticket.setNumber("846729");
        org.junit.Assert.assertTrue(LuckyTicket.isLucky(ticket));
    }

    @Test
    public void testIsNotLucky() {
        ticket.setNumber("174639");
        org.junit.Assert.assertFalse(LuckyTicket.isLucky(ticket));
    }

    @Test
    public void shortNumber() {
        ticket.setNumber("5869");
        LuckyTicket.isLucky(ticket);
        org.junit.Assert.assertTrue("ArrayIndexOutOfBoundsException was not thrown", ticket.tooShort);
}

    @Test
    public void longNumber() {
        ticket.setNumber("48596235");
        LuckyTicket.isLucky(ticket);
        org.junit.Assert.assertTrue("TooLongTicketNumberException was not thrown", ticket.tooLong);
    }

    @Test
    public void charsIncluded() {
        ticket.setNumber("57hyn6");
        LuckyTicket.isLucky(ticket);
        org.junit.Assert.assertTrue("NotDigitTicketNumberException was not thrown", ticket.notDigitsDetected);
    }

}

