import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeaterTest {

    private static Heater heater;
    private static int totalTests = 0;

    public HeaterTest() {
        // Default constructor, kept empty
    }

    @BeforeAll
    private static void setUp() {
        heater = null;
    }

    @Test
    public void test_DefaultConstructor() {
        heater = new Heater(); // Create an object of Heater using the default constructor

        int expectedTemperature = 15;
        int actualTemperature = heater.temperature();

        assertEquals(expectedTemperature, actualTemperature, "Default temperature should be 15");

        totalTests++;
    }

    @Test
    public void test_OverloadedConstructor() {
        heater = new Heater(0, 30); // Create an object of Heater using the overloaded constructor

        int expectedTemperature = 0;
        int expectedMin = 0;
        int expectedMax = 30;
        int expectedIncrement = 5;

        int actualTemperature = heater.temperature();
        int actualMin = heater.getMin();
        int actualMax = heater.getMax();
        int actualIncrement = heater.getIncrement();

        assertEquals(expectedTemperature, actualTemperature, "Temperature should be 0");
        assertEquals(expectedMin, actualMin, "Min temperature should be 0");
        assertEquals(expectedMax, actualMax, "Max temperature should be 30");
        assertEquals(expectedIncrement, actualIncrement, "Increment should be 5");

        totalTests++;
    }

    @Test
    public void test_OverloadedConstructor_MinIsLargerThanMax() {
        heater = new Heater(30, 0); // Create an object of Heater using the overloaded constructor

        int expectedTemperature = 0;
        int expectedMin = 0;
        int expectedMax = 30;
        int expectedIncrement = 5;

        int actualTemperature = heater.temperature();
        int actualMin = heater.getMin();
        int actualMax = heater.getMax();
        int actualIncrement = heater.getIncrement();

        assertEquals(expectedTemperature, actualTemperature, "Temperature should be 0");
        assertEquals(expectedMin, actualMin, "Min temperature should be 0");
        assertEquals(expectedMax, actualMax, "Max temperature should be 30");
        assertEquals(expectedIncrement, actualIncrement, "Increment should be 5");

        totalTests++;
    }

    @Test
    public void test_Warmer() {
        heater = new Heater(); // Create an object of Heater using the default constructor

        int expectedTemperature = heater.temperature() + 5;
        heater.warmer();
        int actualTemperature = heater.temperature();

        assertEquals(expectedTemperature, actualTemperature, "Temperature should increase by 5");

        totalTests++;
    }

    @Test
    public void test_setIncrement_CallWarmerThenCooler() {
        heater = new Heater(); // Create an object of Heater using the default constructor

        int expectedTemperatureAfterWarmer = heater.temperature() + 4;
        heater.setIncrement(4);
        heater.warmer();

        int actualTemperatureAfterWarmer = heater.temperature();

        assertEquals(expectedTemperatureAfterWarmer, actualTemperatureAfterWarmer, "Temperature should increase after warmer() with increment set to 4");

        heater.cooler();
        int actualTemperatureAfterCooler = heater.temperature();

        assertEquals(expectedTemperatureAfterWarmer, actualTemperatureAfterCooler, "Temperature should remain the same after cooler()");

        totalTests++;
    }

    @Test
    public void test_setIncrement_ZeroAndNegativeIncrement() {
        heater = new Heater(); // Create an object of Heater using the default constructor

        int expectedTemperature = heater.temperature();
        heater.setIncrement(0);
        heater.warmer();
        heater.cooler();

        int actualTemperature = heater.temperature();

        assertEquals(expectedTemperature, actualTemperature, "Temperature should remain the same with increment set to 0");

        heater.setIncrement(-5);
        heater.warmer();
        heater.cooler();

        actualTemperature = heater.temperature();

        assertEquals(expectedTemperature, actualTemperature, "Temperature should remain the same with negative increment");

        totalTests++;
    }

    @Test
    public void test_Max_WarmerAndCoolerToLimits() {
        heater = new Heater(0, 30); // Create an object of Heater using the overloaded constructor

        int maxTemperature = heater.getMax();
        heater.setIncrement(5);

        // Warmer should not go beyond max
        for (int i = 0; i < 10; i++) {
            heater.warmer();
        }
        int actualTemperature = heater.temperature();

        assertEquals(maxTemperature, actualTemperature, "Temperature should be equal to max");

        // Cooler should not go below min
        for (int i = 0; i < 10; i++) {
            heater.cooler();
        }
        actualTemperature = heater.temperature();

        int minTemperature = heater.getMin();
        assertEquals(minTemperature, actualTemperature, "Temperature should be equal to min");

        totalTests++;
    }

    @Test
    public void test_Min_WarmerAndCoolerToLimits() {
        heater = new Heater(0, 30); // Create an object of Heater using the overloaded constructor

        int minTemperature = heater.getMin();
        heater.setIncrement(5);

        // Cooler should not go below min
        for (int i = 0; i < 10; i++) {
            heater.cooler();
        }
        int actualTemperature = heater.temperature();

        assertEquals(minTemperature, actualTemperature, "Temperature should be equal to min");

        // Warmer should not go beyond max
        for (int i = 0; i < 10; i++) {
            heater.warmer();
        }
        actualTemperature = heater.temperature();

        int maxTemperature = heater.getMax();
        assertEquals(maxTemperature, actualTemperature, "Temperature should be equal to max");

        totalTests++;
    }

    @AfterEach
    private void summary() {
        System.out.println("Number of tests that ran: " + totalTests);
    }

    @AfterAll
    private static void tearDown() {
        System.out.println("All tests are done");
    }
}
