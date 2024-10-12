package part1;
import java.util.Map;

public class Util {
 /*   Country country;
    Sector sector;
    Emission emission;
*/
    public static int getYearWithHighestEmissions(Country country){
        Map<Integer, Emission> countryEmissions = country.getEmissions();
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

    public static int getYearWithHighestEmissions(Sector sector){
        Map<Integer,Double> sectorMap = sector.getEmissions();
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
}
