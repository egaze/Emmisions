import java.util.HashMap;
import java.util.Map;

public class Country {
    String name;
    int years;
    Map<Integer, Emission> yearEmissions;
    Emission emission;

    public Country(String name, int years, Emission emission){
        this.name = name;
        this.years = years;
        this.emission = emission;
    }

    Map<Integer, Emission> emissions = new HashMap<>();

    public void addEntry(int years, Emission emission){
        emissions.put(this.years, this.emission);
    }
}
