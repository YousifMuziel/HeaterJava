// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Create a new Heater and set its name (identity) to heater1
        Heater heater1 = new Heater();

        // Add a breakpoint at the line where you created the object heater1
        // by clicking on the space on the right of the line number.

        // Debug the program by clicking on "Run -> Debug 'Main.java'"
        // The program will run and stop at the breakpoint (line 5).

        // To navigate the debug mode, click on "Step into" to enter the class's constructor.
        // The current variable and attribute values will be displayed on the right side of the Debugger console.

        // Invoke the temperature() method and print the current temperature setting
        int currentTemperature = heater1.temperature();
        System.out.println("Current temperature: " + currentTemperature);

        // Call the warmer() method to increase the temperature
        heater1.warmer();

        // Retrieve the updated temperature and print it
        currentTemperature = heater1.temperature();
        System.out.println("Updated temperature: " + currentTemperature);

        // Call the cooler() method to decrease the temperature
        heater1.cooler();

        // Retrieve the updated temperature and print it
        currentTemperature = heater1.temperature();
        System.out.println("Updated temperature after cooling: " + currentTemperature);
        // Call the setIncrement() method to set a new increment value
        heater1.setIncrement(0);

        // Invoke the temperature() method and print the current temperature setting
        currentTemperature = heater1.temperature();
        System.out.println("Updated temperature with new increment: " + currentTemperature);
    }
}