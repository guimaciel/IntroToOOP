package labs.miniProject1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Questions  {
    private String lettersWrong;
    private int tries;
    private Cities city;

    Questions() throws FileNotFoundException {
        this.lettersWrong = "";
        this.tries = 0;

        city = new Cities();
        System.out.println("Here's the question.");
        System.out.println(city.getGuess());

    }

    /**
     * As the user to input a letter then checks if the city has that letter (cities object)
     * After that checks if the user guessed the word or loses (by the number of tries) and prints it
     * @return true if the game finished (win or lose) or false if not
     */
    public boolean askLetter() {
        System.out.print("Guess a letter: ");
        Scanner sc = new Scanner(System.in);
        String letter = sc.nextLine();
        if (!city.guessLetter(letter) && this.lettersWrong.toLowerCase().indexOf(letter.toLowerCase()) == -1) {
            this.tries++;
            this.lettersWrong += letter + " ";
        }
        if (city.checkWord()) {
            System.out.println("You win!");
            System.out.println("You have guessed '" + city.getName() + "' correctly.");
            return true;
        } else if (this.tries == 10) {
            System.out.println("You have guessed (" + this.tries + ") wrong letters: " + this.lettersWrong );
            System.out.println("You lose!");
            System.out.println("The correct word was '" + city.getName() + "'");
            return true;
        } else {
            System.out.println("You are guessing: " + city.getGuess());
            System.out.println("You have guessed (" + this.tries + ") wrong letters: " + this.lettersWrong);
            return false;
        }
    }
}
