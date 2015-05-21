package Lucky;

import org.testng.annotations.Test;

/* The tests here are the same as in JUnitTests class.
Please let me know if those 5 test were supposed to be different and I will be happy to write new ones.
 */

public class TestNGtests {

        LuckyTicket.Ticket ticket = new LuckyTicket.Ticket();

        @Test
        public void testIsLucky() {
            ticket.setNumber("346229");
            org.junit.Assert.assertTrue(LuckyTicket.isLucky(ticket));
        }

        @Test
        public void testIsNotLucky() {
            ticket.setNumber("275538");
            org.junit.Assert.assertFalse(LuckyTicket.isLucky(ticket));
        }

        @Test
        public void shortNumber() {
            ticket.setNumber("74158");
            LuckyTicket.isLucky(ticket);
            org.junit.Assert.assertTrue("ArrayIndexOutOfBoundsException was not thrown", ticket.tooShort);
        }

        @Test
        public void longNumber() {
            ticket.setNumber("7894562");
            LuckyTicket.isLucky(ticket);
            org.junit.Assert.assertTrue("TooLongTicketNumberException was not thrown", ticket.tooLong);
        }

        @Test
        public void charsIncluded() {
            ticket.setNumber("jyhyn6");
            LuckyTicket.isLucky(ticket);
            org.junit.Assert.assertTrue("NotDigitTicketNumberException was not thrown", ticket.notDigitsDetected);
        }

    }
