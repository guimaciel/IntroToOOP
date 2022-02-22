package labs.lab2;

public class Province {
    private final static long DEFAULT_POPULATION = 4648055;
    private final static String DEFAULT_PROVINCE = "British Columbia";
    private final static String DEFAULT_CAPITAL = "Victoria";

    private String name;
    private String capital;
    private long population;

    public Province() {
        this(DEFAULT_PROVINCE,DEFAULT_CAPITAL,DEFAULT_POPULATION);
    }

    public Province(String name, String capital, long population) {
        if (isValidPopulation(population) && (isValidProvince(name))
                && (isValidCapitalCity(capital))) {

            this.name = name;
            this.capital = capital;
            this.population = population;
        } else {
            // if there is any error; create the default data, shown below
            this.population = DEFAULT_POPULATION; // 4,648,055
            this.name = DEFAULT_PROVINCE; // “British Columbia”
            this.capital = DEFAULT_CAPITAL; // “Victoria”
        }
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setName(String name) {
        if (isValidProvince(name)) {
            this.name = name;
        } else {
            this.name = DEFAULT_PROVINCE;
        }
    }

    public void setCapital(String capital) {
        if (isValidCapitalCity(capital)) {
            this.capital = capital;
        } else {
            this.capital = DEFAULT_CAPITAL;
        }
    }

    public void setPopulation(long population) {
        if (isValidPopulation(population)) {
            this.population = population;
        } else {
            this.population = DEFAULT_POPULATION;
        }
    }

    private boolean isValidProvince(String province) {
        String provinces[] = {"Alberta","British Columbia","Manitoba","New Brunswick",
                        "Newfoundland and Labrador","Nova Scotia","Ontario","Prince Edward Island",
                        "Quebec","Saskatchewan"};
        for (int i = 0; i < provinces.length ; i++) {
            if (province == provinces[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidCapitalCity(String capital) {
        String capitals[] = {"Edmonton","Victoria","Winnipeg","Fredericton","St. John's",
                            "Halifax","Toronto","Charlottetown","Québec","Regina"};

        for (int i = 0; i < capitals.length ; i++) {
            if (capital == capitals[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidPopulation(long population) {
        return (population >= 30000 && population <= 15000000);
    }

    public String getDetails() {
        return "The capital of " + getName() + " (population. " + getPopulation() + ") is " + getCapital() + ".";
    }
}
