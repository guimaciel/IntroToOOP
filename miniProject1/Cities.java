package labs.miniProject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cities {
    private String name;
    private String guess;

    Cities() throws FileNotFoundException {
        pickCityFromFile();
    }

    public String getGuess() {
        return this.guess;
    }
    public String getName() { return this.name; }

    /**
     * Read the file cities.txt than pick a city (randomly)
     * @throws FileNotFoundException (if could not read the file)
     */
    public void pickCityFromFile() throws FileNotFoundException {
        File file = new File("src/labs/miniProject1/cities.txt");
        Scanner scn = new Scanner(file);
        ArrayList<String> arrCity = new ArrayList<String>();
        while (scn.hasNextLine()) {
            arrCity.add(scn.nextLine());
        }

        // randomly pick a city
        int size = arrCity.size();
        int pos = (int)(Math.random() * 100);
        this.name = arrCity.get(pos);
        this.guess = "";
        for ( int i = 0; i < this.name.length() ; i++) {
            if (name.charAt(i) == ' ') {
                this.guess = this.guess + " ";
            } else {
                this.guess = this.guess + "_";
            }
        }
    }

    /**
     * Checks if the letter is indeed in the city name
     * @param letter (the letter to be checked)
     * @return (true if the letter is indeed in the city or false if not)
     */
    public boolean guessLetter(String letter) {
        int startIndex = 0;
        int index = 0, count = 0;
        letter = letter.toLowerCase();
        String nameLCase = this.name.toLowerCase();
        while (index >= 0) {
            index = nameLCase.indexOf(letter, index);
            if (index >= 0) {
                this.guess = this.guess.substring(0, index) + this.name.substring(index,index + 1)
                               + this.guess.substring(index + 1);
                index++;
                count++;
            }
        }
        return (count > 0) ? true : false;
    }

    /**
     * Compare if the user guessed the city name (comparing the 2 fields: name and guess)
     * @return true if the user guessed the name or false if not
     */
    public boolean checkWord() {
        return this.guess.equals(this.name);
    }


}
