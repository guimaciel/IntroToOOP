package labs.lab2;

public class Canada {
    private Province[] provinces;

    public Canada() {
        this.provinces = new Province[10];
        this.provinces[0] = new Province("Alberta","Edmonton", 4262635);
        this.provinces[1] = new Province("British Columbia","Victoria",5000879);
        this.provinces[2] = new Province("Manitoba","Winnipeg",1342153);
        this.provinces[3] = new Province("New Brunswick","Fredericton", 775610);
        this.provinces[4] = new Province("Newfoundland and Labrador","St. John's", 510550);
        this.provinces[5] = new Province("Nova Scotia","Halifax", 969383);
        this.provinces[6] = new Province("Ontario","Toronto", 14223942);
        this.provinces[7] = new Province("Prince Edward Island","Charlottetown", 154331);
        this.provinces[8] = new Province("Quebec","Québec", 8501833);
        this.provinces[9] = new Province("Saskatchewan","Regina", 1132505);
    }

    public void displayAllProvinces() {
        for (int i = 0; i < provinces.length ; i++) {
            System.out.println(provinces[i].getDetails());
        }
    }

    public int getNumOfProvincesBetween(int min, int max) {
        long minMi = min * 1000000;
        long maxMi = max * 1000000;
        int count = 0;
        for (int i = 0 ; i < provinces.length ; i++) {
            if ( provinces[i].getPopulation() >= minMi && provinces[i].getPopulation() <= maxMi) {
                count++;
            }
        }
        return count;
    }
}
