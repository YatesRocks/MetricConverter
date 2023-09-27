import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.function.Function;
import java.io.BufferedReader;

public class Main {
    private static <T> T get_valid_input(String prompt, Function<String, T> parser) {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print(prompt);
            try {
                String input = scan.readLine();
                return parser.apply(input);
            } catch (NumberFormatException e) {
                System.err.println(e); // TODO: Use logger instead of sys err
                System.out.println("Error parsing input. Please try again.");
            } catch (Exception e) {
                System.err.println("Error occurred: " + e.getMessage());
            }
        }
    }

    private static double round(double input) {
        DecimalFormat format = new DecimalFormat("#.###");
        return Double.parseDouble(format.format(input));
    }

    public static void main(String[] args) {
        System.out.println("METRIC TO IMPERIAL CONVERTER");
        double meter_distance = get_valid_input("Enter your distance in meters: ", Double::parseDouble);
        double dist_in_miles  = meter_distance / 1609.34;
        double dist_in_feet   = meter_distance * 3.28084;
        double dist_in_inches = meter_distance * 39.3701;
        System.out.println("Distance in miles: " + round(dist_in_miles));
        System.out.println("Distance in feet: " + round(dist_in_feet));
        System.out.println("Distance in inches: " + round(dist_in_inches));
    }
}