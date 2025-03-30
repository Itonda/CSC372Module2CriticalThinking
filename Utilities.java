import java.time.LocalDate;

public class Utilities {
    // Method to add dashes to user input for date of birth in the format YYYY-MM-DD.
    public static String formatDateOfBirth(String input) throws Exception {
        // Validate the raw input first (before cleaning/formatting)
        validateRawInput(input);

        // Remove any spaces, dashes, or slashes to clean the input
        String cleanedInput = input.replaceAll("[^\\d]", "");

        // Format the cleaned input as YYYY-MM-DD if it has 8 digits
        if (cleanedInput.length() == 8) {
            return cleanedInput.substring(0, 4) + "-" + cleanedInput.substring(4, 6) + "-" + cleanedInput.substring(6, 8);
        }
        
        return "";   
    }

    // Method to validate the raw input for unacceptable characters
    private static void validateRawInput(String input) throws Exception {
        // Allow only digits, spaces, dashes, and slashes
        if (!input.matches("[\\d\\s\\-\\/]*")) {
            throw new Exception("Invalid input. Only numbers, spaces, dashes, and slashes are allowed.");
        }
    }

    // Method to validate the date and check if it's in the future
    public static void validateDate(String dob) throws Exception {
        // Check if the input matches the expected date format (YYYY-MM-DD)
        if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new Exception("Invalid date format. Please use YYYY-MM-DD.");
        }

        // Split the input into parts
        String[] parts = dob.split("-");
        try {
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            // Create a LocalDate object for the date of birth
            LocalDate birthDate = LocalDate.of(year, month, day);

            // Check if the date is in the future
            if (birthDate.isAfter(LocalDate.now())) {
                throw new Exception("Not born yet.");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Invalid date format. Please use numeric values for year, month, and day.");
        }
    }
}
