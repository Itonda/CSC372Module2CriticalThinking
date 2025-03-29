import java.time.LocalDate;

public class Operations {
    // Method to calculate age based on date of birth in the format YYYY-MM-DD
    public static int calculateAge(String dob) throws Exception {
        // Parse the input date string
        String[] parts = dob.split("-");
        if (parts.length != 3) {
            throw new Exception("Invalid date format");
        }
        
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        // Create a LocalDate object for the date of birth
        LocalDate birthDate = LocalDate.of(year, month, day);
        
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        
        // Calculate age
        int age = currentDate.getYear() - birthDate.getYear();
        
        // Adjust age if the birthday hasn't occurred yet this year
        if (currentDate.getMonthValue() < birthDate.getMonthValue() ||
            (currentDate.getMonthValue() == birthDate.getMonthValue() && currentDate.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }
        if (age < 0) {
            // If the calculated age is negative, it means the date of birth is in the future
            throw new Exception("Not born yet");
        }
        
        return age;
    }
}
