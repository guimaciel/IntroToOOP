package labs.lab1;

import java.sql.SQLOutput;

/**
 * Class for Model
 * @author Guilherme de Almeida
 */
public class Model {

    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;


    private String firstName;
    private String lastName;
    private int height;
    private double weight;
    private boolean canTravel;
    private boolean smokes;

    /**
     * Default constructor
     */
    public Model() {
    }

    /**
     * 2nd Constructor
     * @param firstName - First Name
     * @param lastName - Last name
     * @param height - height (in inches)
     * @param weight - weight (in pounds)
     * @param canTravel - if can travel
     * @param smokes - if smokes
     */
    public Model(String firstName, String lastName, int height, double weight, boolean canTravel, boolean smokes) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        setCanTravel(canTravel);
        setSmokes(smokes);
    }

    /**
     * 3rd Constructor
     * @param firstName - First Name
     * @param lastName - Last name
     * @param height - height (in inches)
     * @param weight - weight (in pounds)
     */
    public Model(String firstName, String lastName, int height, double weight) {
        this(firstName,lastName,height,weight,true,false);
    }

    /**
     * Get First Name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set first name
     * @param firstName - First Name of the Model
     */
    public void setFirstName(String firstName) {
        if (firstName.length() >= 3 && firstName.length() <= 20) {
            this.firstName = firstName;
        }
    }

    /**
     * Get Last Name
     * @return the Last Name of the model
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set Last Name
     * @param lastName - Last Name of the model
     */
    public void setLastName(String lastName) {
        if (lastName.length() >= 3 && lastName.length() <= 20) {
            this.lastName = lastName;
        }
    }

    /**
     * Get Height
     * @return the height of the model (in inches)
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set Height
     * height must be 24 to 84 inches or it won't be stored
     * @param inches - The height of the model (in inches)
     */
    public void setHeight(int inches) {
        if (inches >= 24 && inches <= 84) {
            this.height = inches;
        }
    }

    /**
     * Set Height (feet and inches)
     * @param feet
     * @param inches
     */
    public void setHeight(int feet, int inches) {
        int inch = (feet * Model.INCHES_PER_FOOT) + inches;
        setHeight(inch);
    }

    /**
     * Get Weight
     * @return the weight in pounds
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set weight in pounds
     * @param pounds (weight)
     */
    public void setWeight(double pounds) {
        if (pounds >= 80 && pounds <= 280) {
            this.weight = pounds;
        }
    }

    /**
     * Set weight in kilograms
     * @param kilograms (weight)
     */
    public void setWeight(long kilograms) {
        double pounds = kilograms * Model.POUNDS_PER_KG;
        setWeight(pounds);
    }

    /**
     * Return if the model can travel
     * @return boolean if can travel
     */
    public boolean isCanTravel() {
        return canTravel;
    }

    /**
     * Set if can travel
     * @param canTravel (boolean)
     */
    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    /**
     * Return if the model smokes
     * @return boolean
     */
    public boolean isSmokes() {
        return smokes;
    }

    /**
     * Set if the model smoke
     * @param smokes (boolean)
     */
    public void setSmokes(boolean smokes) {
        this.smokes = smokes;
    }

    /**
     * Get Height in Feet and Inches
     * @return string with the height
     */
    public String getHeightInFeetAndInches() {
        int feet = getHeight() / Model.INCHES_PER_FOOT;
        int inches = getHeight() % Model.INCHES_PER_FOOT;
        String result = String.valueOf(feet) + " feet";
        if (inches > 0) {
            result += " " + String.valueOf(inches) + " ";
            result += (inches > 1) ? "inches" : "inch";
        }
        return result;
    }

    /**
     * Return the weight in kilograms
     * @return wight in kilograms (long)
     */
    public long getWeightKg() {
        return Math.round(weight / Model.POUNDS_PER_KG);
    }

    /**
     * Print Name, Height, Weight, Travel and Smoke information
     */
    public void printDetails() {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeight() + " inches");
        System.out.println("Weight: " + Math.round(getWeight()) + " pounds");
        if (isCanTravel()) {
            System.out.println("Does travel");
        } else {
            System.out.println("Does not travel");
        }
        if (isSmokes()) {
            System.out.println("Does smoke");
        } else {
            System.out.println("Does not smoke");
        }
    }

    /**
     * Calculate Pay Dollars Per Hour
     * @return an int value with the value of Dollars per Hour
     */
    public int calculatePayDollarsPerHour() {
        int salary = Model.BASE_RATE_DOLLARS_PER_HOUR;
        if (getHeight() >= Model.TALL_INCHES && getWeight() < Model.THIN_POUNDS) {
            salary += Model.TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
        if (isCanTravel()) {
            salary += Model.TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }
        if (isSmokes()) {
            salary -= Model.SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }
        return salary;
    }

    /**
     * Print Model Details (Name, Height, Weight, Travel, Smokes e Hourly Rate)
     */
    public void displayModelDetails() {
//        printDetails();
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeightInFeetAndInches());
        System.out.println("Weight: " + getWeight() + " pounds");
        System.out.println("Travel: " + ((isCanTravel()) ? "yep" : "nope")) ;
        System.out.println("Smokes: " + ((isSmokes()) ? "yep" : "nope"));
        System.out.println("Hourly rate: $" + calculatePayDollarsPerHour());
    }

}
