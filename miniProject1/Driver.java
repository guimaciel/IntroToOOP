package labs.miniProject1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        try {
            Questions q = new Questions();
            while (!q.askLetter());
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }









    }
}
