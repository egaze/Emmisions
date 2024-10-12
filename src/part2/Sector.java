package part2;

import part1.Country;
import part1.Emission;

import java.util.HashMap;
import java.util.Map;


public class Sector {
    private String name;
    // private int years;
    // private double totalEmissions;
    // private Emission Emission;
    private Map<Integer, Double> yearEmissionsMap;

    public Sector(String name, Map<Integer, Double> yearEmissionsMap) {
        this.name = name;
        // this.years = years;
        this.yearEmissionsMap = yearEmissionsMap;
        // this.yearEmissionsMap = new HashMap<>();
    }
    public String getName(){
        return name;
    }

//    public int getYears() {
//        return years;
//    }

//    public double getTotalEmissions() {
//        return totalEmissions;
//    }

    public Map<Integer, Double> getEmissions() {
        return yearEmissionsMap;
    }

    public int getYearWithHighestEmissions(){
        Map<Integer,Double> sectorMap = this.getEmissions();
        double highestValue = 0;
        int highestYear = 0;

        for (Map.Entry<Integer, Double> currentEmissionEntry : sectorMap.entrySet()) {
            if (currentEmissionEntry.getValue() > highestValue){
                highestValue = currentEmissionEntry.getValue();
                highestYear = currentEmissionEntry.getKey();
            }
        }
        return highestYear;
    }

//    public void addMapEntry(int years, double totalEmissions) {
//        yearEmissionsMap.put(years, totalEmissions);
//    }

}
