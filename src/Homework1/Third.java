package Homework1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;

/* Create an app for calculating perimeter of figures(triangle, square, circle)
(Input could be smth like: circle 10; square 5; triangle 1 2 3)
 */

/* IMPORTANT: The numbers must be inserted on a new line:
  square
  4

  Sorry for IllegalArgumentException for wrong shapes, not familiar with Exceptions/Catch/etc yet

*/

public class Third {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputshape = reader.readLine();
        Shapes shape = Shapes.valueOf(inputshape.toUpperCase());

        switch (shape) {
            case TRIANGLE :
                int a = Integer.parseInt(reader.readLine()); // sorry, could not google easier way
                int b = Integer.parseInt(reader.readLine());
                int c = Integer.parseInt(reader.readLine());
                System.out.println("Triangle perimeter is " + perTriangle(a,b,c));
                break;
            case SQUARE:
                int side = Integer.parseInt(reader.readLine());
                System.out.println("Square perimeter is " + perSquare(side));
                break;
            case CIRCLE:
                int radius = Integer.parseInt(reader.readLine());
                System.out.println("Circle perimeter is " + perCircle(radius));
                break;
            default:
                System.out.println("Inserted shape is not supported, must be {triangle, square, circle}");
        }
    }

    public static int perTriangle (int a, int b, int c){
        return a +b +c;
    }
    public static int perSquare (int a) {
        return a*4;
    }
    public static double perCircle(int a) {
        return a*2*Math.PI;
    }

    public enum Shapes {
        TRIANGLE,
        SQUARE,
        CIRCLE
    }
}
