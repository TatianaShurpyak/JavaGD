package Lucky;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestNGtests {

    private LuckyTicket.Ticket ticket;

    @BeforeTest
    public void setUp() {
        ticket = new LuckyTicket.Ticket();
    }

        @Test
        public void testIsLucky() {
            ticket.setNumber("346229");
            Assert.assertTrue(LuckyTicket.isLucky(ticket));
        }

        @Test
        public void testIsNotLucky() {
            ticket.setNumber("275538");
            Assert.assertFalse(LuckyTicket.isLucky(ticket));
        }

        @Test
        public void shortNumber() {
            ticket.setNumber("74158");
            LuckyTicket.isLucky(ticket);
            Assert.assertTrue(ticket.tooShort,"ArrayIndexOutOfBoundsException was not thrown");
        }

        @Test
        public void longNumber() {
            ticket.setNumber("7894562");
            LuckyTicket.isLucky(ticket);
            Assert.assertTrue(ticket.tooLong, "TooLongTicketNumberException was not thrown");
        }

        @Test
        public void charsIncluded() {
            ticket.setNumber("jyhyn6");
            LuckyTicket.isLucky(ticket);
            Assert.assertTrue(ticket.notDigitsDetected, "NotDigitTicketNumberException was not thrown");
        }

    }
