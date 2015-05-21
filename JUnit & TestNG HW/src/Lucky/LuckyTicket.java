package Lucky;

import javax.xml.bind.SchemaOutputResolver;
import  java.lang.Exception;

public class LuckyTicket {

    public static class Ticket {
        String num;
        boolean tooShort = false;
        boolean tooLong = false;
        boolean notDigitsDetected = false;

        public void setNumber(String string) {
            this.num = string;
        }
    }

    public static boolean isLucky(Ticket ticket) {
        String temp = ticket.num;
        char[] charArray = temp.toCharArray();
        int[] digit = new int[6];

        try {
            if (temp.length() > 6) throw new TooLongTicketNumberException();

            for (int i = 0; i < 6; i++) {
                if (!Character.isDigit(charArray[i])) throw new NotDigitTicketNumberException();
                digit[i] = charArray[i];
            }

            int sum1, sum2;
            sum1 = digit[0] + digit[1] + digit[2];
            sum2 = digit[3] + digit[4] + digit[5];

            return (sum1 == sum2);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ticket number is less than 6 digits");
            ticket.tooShort = true;
            return false;
        } catch (TooLongTicketNumberException e) {
            System.out.println("Ticket number is more than 6 digits");
            ticket.tooLong = true;
            return false;
        } catch (NotDigitTicketNumberException e) {
            System.out.println("Ticket number contains not only digits");
            ticket.notDigitsDetected = true;
            return false;
        }
    }

    public static class TooLongTicketNumberException extends Exception {}
    public static class NotDigitTicketNumberException extends Exception {}
}


