package part1;

import java.util.HashMap;
import java.util.Map;


public class Sector {
    private String name;
    private Map<Integer, Double> yearEmissionsMap;

    public Sector(String name, Map<Integer, Double> yearEmissionsMap) {
        this.name = name;
        this.yearEmissionsMap = yearEmissionsMap;

    }
    public String getName(){
        return name;
    }

    public Map<Integer, Double> getEmissions() {
        return yearEmissionsMap;
    }

}
