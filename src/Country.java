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
}
