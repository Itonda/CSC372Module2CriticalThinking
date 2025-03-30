import java.time.LocalDate;
// This class handles utility functions for the application.
// Includes methods for formatting and validating user input.
public class Utilities {
    // Method to add dashes to user input for date of birth in the format YYYY-MM-DD.
    public static String formatDateOfBirth(String input) throws Exception {
        // Allow only digits, spaces, dashes, and slashes
        if (!input.matches("[\\d\\s\\-\\/]*")) {
            throw new Exception("Invalid input. Check input for characters.");
        }
    
        // Remove any spaces, dashes, or slashes to clean the input
        String cleanedInput = input.replaceAll("[^\\d]", "");
    
        // Check if the cleaned input has the correct length for a date (8 digits)
        if (cleanedInput.length() == 8) {
            // Format the input as YYYY-MM-DD
            return cleanedInput.substring(0, 4) + "-" + cleanedInput.substring(4, 6) + "-" + cleanedInput.substring(6, 8);
        }
    
        // Return the cleaned input if it doesn't match the expected length
        throw new Exception("Invalid date. Please ensure you enter a valid date in YYYY-MM-DD format.");
    }
    

    // Method to validate the date and check if it's in the future
    public static void validateDate(String dob) throws Exception {
        String[] parts = dob.split("-");
        if (parts.length != 3) {
            throw new Exception("Invalid date format");
        }

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // Create a LocalDate object for the date of birth
        LocalDate birthDate = LocalDate.of(year, month, day);

        // Check if the date is in the future
        if (birthDate.isAfter(LocalDate.now())) {
            throw new Exception("Not born yet.");
        }
    }
}
