// This class handles utility functions for the application.
// Includes methods for formatting user input.
public class Utilities {
    // Method to add dashes to user input for date of birth in the format YYYY-MM-DD.
    public static String formatDateOfBirth(String input) {
        // Remove any existing dashes or non-digit characters from the input
        String cleanedInput = input.replaceAll("[^\\d]", "");
        
        // Check if the cleaned input has the correct length for a date (8 digits)
        if (cleanedInput.length() == 8) {
            // Format the input as YYYY-MM-DD
            return cleanedInput.substring(0, 4) + "-" + cleanedInput.substring(4, 6) + "-" + cleanedInput.substring(6, 8);
        }
        // Return the cleaned input if it doesn't match the expected length
        return cleanedInput;
    }
}
