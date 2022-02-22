package labs.lab1;

/**
 * Model Class - Lab1
 * @author Guilherme Almeida
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
     * @param lastName - Last Name
     * @param height - Height in inches
     * @param weight - Weith in pounds
     * @param canTravel - Can travel (boolean)
     * @param smokes - Does Smokes (boolean)
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
     * 3rd Constructor (Can travel is true and Smokes is false)
     * @param firstName - First Name
     * @param lastName - Last Name
     * @param height - Height in inches
     * @param weight - Weith in pounds
     */
    public Model(String firstName, String lastName, int height, double weight) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        setCanTravel(true);
        setSmokes(false);
    }

    /**
     * Get First Name
     * @return the 1st name (String)
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get Last Name
     * @return last name (String)
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get Height
     * @return the height in inches
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get Weight
     * @return the weight in pounds (double)
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Get Weight Kg
     * @return the weight in kilograms (long)
     */
    public long getWeightKg() {
        return Math.round(getWeight() / Model.POUNDS_PER_KG);
    }

    /**
     * Is Can Travel?
     * @return if the model can travel (boolean)
     */
    public boolean isCanTravel() {
        return canTravel;
    }

    /**
     * Is Smokes?
     * @return if the model smokes (boolean)
     */
    public boolean isSmokes() {
        return smokes;
    }

    /**
     * Set First Name
     * @param firstName - First Name (String)
     */
    public void setFirstName(String firstName) {
        if (firstName.length() >= 3 && firstName.length() <= 20) {
            this.firstName = firstName;
        }
    }

    /**
     * Set Last Name
     * @param lastName - Last Name (String)
     */
    public void setLastName(String lastName) {
        if (lastName.length() >= 3 && lastName.length() <= 20) {
            this.lastName = lastName;
        }
    }

    /**
     * Set Height
     * @param inches - Height in inches (int)
     */
    public void setHeight(int inches) {
        if (inches >= 24 && inches <= 84) {
            this.height = inches;
        }
    }

    /**
     * Set Height - Inches and Feet
     * @param feet - Feet (int)
     * @param inches - Inches (int)
     */
    public void setHeight(int feet, int inches) {
        setHeight((feet * Model.INCHES_PER_FOOT) + inches);
    }

    /**
     * Set Weight in pounds
     * @param pounds - Weight in pounds (double)
     */
    public void setWeight(double pounds) {
        if (pounds >= 80 && pounds <= 280) {
            this.weight = pounds;
        }
    }

    /**
     * Set Weight in kilograms
     * @param kilograms - Weight in kilograms (long)
     */
    public void setWeight(long kilograms) {
        setWeight(kilograms * Model.POUNDS_PER_KG);
    }

    /**
     * Set Can Travel
     * @param canTravel - if model can travel (boolean)
     */
    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    /**
     * Set Smokes
     * @param smokes - if model smokes (boolean)
     */
    public void setSmokes(boolean smokes) {
        this.smokes = smokes;
    }

    /**
     * Get Height in Feet and Inches
     * @return the height in Feet and Inches (String)
     */
    public String getHeightInFeetAndInches() {
        int feet = getHeight() / Model.INCHES_PER_FOOT;
        int inch = getHeight() % Model.INCHES_PER_FOOT;
        String result = String.valueOf(feet) + " feet";
        if (inch > 0) {
            result = result + " " + String.valueOf(inch) + ((inch > 1) ? " inches" : " inch");
        }
        return result;
    }

    /**
     * Prints Details of the Model (Name, Height, Weight, If travel and If Smokes)
     */
    public void printDetails() {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeight() + " inches");
        System.out.println("Weight: " + getWeight() + " pounds");
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
     * @return model's per-hour pay rate (int)
     */
    public int calculatePayDollarsPerHour() {
        int rate = Model.BASE_RATE_DOLLARS_PER_HOUR;
        if (getHeight() >= Model.TALL_INCHES && getWeight() < Model.THIN_POUNDS) {
            rate += Model.TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
        if (isCanTravel()) {
            rate += Model.TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }
        if (isSmokes()) {
            rate -= Model.SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }
        return rate;
    }

    /**
     * Display Model Details (Name, Height, Weight, Travel, Smoke, Hourly rate)
     */
    public void displayModelDetails() {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeightInFeetAndInches());
        System.out.println("Weight: " + getWeight() + " pounds");
        System.out.println("Travels: " + ((isCanTravel()) ? "yep" : "nope"));
        System.out.println("Smokes: " + ((isSmokes()) ? "yep" : "nope"));
        System.out.println("Hourly rate: $" + calculatePayDollarsPerHour());

    }
}
