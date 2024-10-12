package part2;

import java.util.HashMap;
import java.util.Map;

public class Country {
    private String name;
    private Map<Integer, Emission> yearEmissions;

    public Country(String name, Map<Integer, Emission> yearEmissions){
        this.name = name;
        this.yearEmissions = yearEmissions;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Emission> getEmissions() {
        return yearEmissions;
    }

    public int getYearWithHighestEmissions(){
        Map<Integer, Emission> countryEmissions = this.getEmissions();
        double highestTotalEmission = 0;
        int highestTotalEmissionCountry = 0;

        for (Map.Entry<Integer, Emission> currentYearEmission : countryEmissions.entrySet()){
            double currentTotalEmissions = currentYearEmission.getValue().getN2O() + currentYearEmission.getValue().getCH4() + currentYearEmission.getValue().getCO2();
            if (currentTotalEmissions > highestTotalEmission) {
                highestTotalEmission = currentTotalEmissions;
                highestTotalEmissionCountry = currentYearEmission.getKey();
            }
        }
        return highestTotalEmissionCountry;
    }
}
