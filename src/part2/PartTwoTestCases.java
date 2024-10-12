package part2;

import org.junit.jupiter.api.Test;
import part1.Util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * NOTE THAT THIS FILE WILL NOT COMPILE UNTIL YOU HAVE COPIED OVER YOUR
 * EMISSION, COUNTRY, AND SECTOR CLASSES TO THE part2 DIRECTORY
 */
public class PartTwoTestCases {

    /**
     * Tests the implementation of the Emission class.
     *
     * TO-DO: Examine this test case to know what you should name your public methods.
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void testEmissionImplSpecifics() throws NoSuchMethodException {
        final List<String> expectedMethodNames = Arrays.asList("getCO2", "getN2O", "getCH4");

        final List<Class> expectedMethodReturns = Arrays.asList(double.class, double.class, double.class);

        final List<Class[]> expectedMethodParameters = Arrays.asList(new Class[0], new Class[0], new Class[0]);

        verifyImplSpecifics(Emission.class, expectedMethodNames, expectedMethodReturns,
                expectedMethodParameters);
    }

    /**
     * Tests the part2 implementation of the Country class.
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void testCountryImplSpecifics() throws NoSuchMethodException {
        final List<String> expectedMethodNames = Arrays.asList("getName", "getEmissions", "getYearWithHighestEmissions");

        final List<Class> expectedMethodReturns = Arrays.asList(String.class, Map.class, int.class);

        final List<Class[]> expectedMethodParameters = Arrays.asList(new Class[0], new Class[0], new Class[0]);

        verifyImplSpecifics(Country.class, expectedMethodNames, expectedMethodReturns,
                expectedMethodParameters);
    }

    /**
     * Tests the part2 implementation of the Sector class.
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void testSectorImplSpecifics() throws NoSuchMethodException {
        final List<String> expectedMethodNames = Arrays.asList("getName", "getEmissions", "getYearWithHighestEmissions");

        final List<Class> expectedMethodReturns = Arrays.asList(String.class, Map.class, int.class);

        final List<Class[]> expectedMethodParameters = Arrays.asList(new Class[0], new Class[0], new Class[0]);

        verifyImplSpecifics(Sector.class, expectedMethodNames, expectedMethodReturns,
                expectedMethodParameters);
    }

    private static void verifyImplSpecifics(final Class<?> clazz, final List<String> expectedMethodNames,
                                            final List<Class> expectedMethodReturns, final List<Class[]> expectedMethodParameters)
            throws NoSuchMethodException {
        assertEquals(0, clazz.getFields().length, "Unexpected number of public fields");

        final List<Method> publicMethods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> Modifier.isPublic(m.getModifiers())).collect(Collectors.toList());

        assertEquals(expectedMethodNames.size(), publicMethods.size(),
                "Unexpected number of public methods");

        assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
                "Invalid test configuration");
        assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
                "Invalid test configuration");

        for (int i = 0; i < expectedMethodNames.size(); i++) {
            Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i), expectedMethodParameters.get(i));
            assertEquals(expectedMethodReturns.get(i), method.getReturnType());
        }
    }

    @Test
    public void testYearWithHighestEmissions() {
        // Create the testable Sector object
        Map<Integer, Double> emissions = new HashMap<>();
        emissions.put(1970, 2278.8);
        emissions.put(1971, 2356.43);
        emissions.put(1972, 2243.3);
        Sector sector = new Sector("Transport", emissions);

        // Check that the method works as expected
        assertEquals(1971, sector.getYearWithHighestEmissions());
    }

    @Test
    public void testCountryWithHighestEmissions() {
        // Creating country object
        Map<Integer, Emission> yearEmissions = new HashMap<>();
        yearEmissions.put(1972, new Emission(288000.0, 684000.0, 4690000.0));
        yearEmissions.put(1977, new Emission(291000.0, 744000.0, 7560000.0));
        yearEmissions.put(1981, new Emission(281000.0, 641000.0, 4870000.0));
        Country country = new Country("Ghana", yearEmissions);

        // Checking method
        assertEquals(1977, country.getYearWithHighestEmissions());
    }
}
