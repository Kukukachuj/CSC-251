import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class GradeCalculator {
    private static ArrayList<Double> grades = new ArrayList<>();
    private static DecimalFormat df = new DecimalFormat("#.##");
    
    public static void main(String[] args) {
        showWelcomeMessage();
        
        int choice;
        do {
            choice = showMenu();
            processChoice(choice);
        } while (choice != 4);
        
        showGoodbyeMessage();
    }
    
    /**
     * Shows welcome message to user
     */
    private static void showWelcomeMessage() {
        JOptionPane.showMessageDialog(null,
            "Welcome to the Grade Calculator System!\n\n" +
            "This program will help you track your grades\n" +
            "and calculate your current average.",
            "Grade Calculator",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Displays main menu and gets user choice
     * @return user's menu choice
     */
    private static int showMenu() {
        String[] options = {
            "1. Add a Grade",
            "2. View Current Average", 
            "3. View Letter Grade",
            "4. Exit"
        };
        
        String menu = "Grade Calculator Menu\n" +
                     "=====================\n\n";
        for (String option : options) {
            menu += option + "\n";
        }
        menu += "\nPlease enter your choice (1-4):";
        
        int choice = 0;
        boolean validChoice = false;
        
        while (!validChoice) {
            try {
                String input = JOptionPane.showInputDialog(null, menu,
                    "Grade Calculator Menu", JOptionPane.QUESTION_MESSAGE);
                
                if (input == null) {
                    choice = 4; // Treat cancel as exit
                    validChoice = true;
                } else {
                    choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= 4) {
                        validChoice = true;
                    } else {
                        JOptionPane.showMessageDialog(null,
                            "Please enter a number between 1 and 4.",
                            "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                    "Please enter a valid number.",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
        return choice;
    }
    
    /**
     * Processes user's menu choice
     * @param choice the selected menu option
     */
    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                addGrade();
                break;
            case 2:
                viewAverage();
                break;
            case 3:
                viewLetterGrade();
                break;
            case 4:
                // Exit - handled in main loop
                break;
            default:
                JOptionPane.showMessageDialog(null,
                    "Invalid choice. Please try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Adds a new grade to the collection
     */
    private static void addGrade() {
       String input = JOptionPane.showInputDialog(null,
            "Enter the grade to add (0-100):",
            "Add Grade", JOptionPane.QUESTION_MESSAGE);
        if (input == null){
            return;
        }
        double grade = Double.parseDouble(input);
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
            JOptionPane.showMessageDialog(null, "Your grade was successfully added!");
        }
    }
    
    /**
     * Calculates and displays current average
     */
    private static void viewAverage() {
        // TODO: Calculate average of all grades
        // Handle case when no grades exist
        // Display formatted average
    }
    
    /**
     * Determines and displays letter grade based on average
     */
    private static void viewLetterGrade() {
        // TODO: Calculate average, then determine letter grade
        // Use standard grading scale (A: 90-100, B: 80-89, etc.)
        // Display both average and letter grade
    }
    
    /**
     * Shows goodbye message
     */
    private static void showGoodbyeMessage() {
        String message = "Thank you for using Grade Calculator!\n\n";
        if (!grades.isEmpty()) {
            double average = calculateAverage();
            message += "Final Statistics:\n" +
                      "Total Grades: " + grades.size() + "\n" +
                      "Final Average: " + df.format(average) + "%\n" +
                      "Letter Grade: " + getLetterGrade(average);
        }
        
        JOptionPane.showMessageDialog(null, message,
            "Goodbye", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // TODO: Add helper methods for calculations
    private static double calculateAverage() {
        if (grades.isEmpty()) return 0.0;
        double total = 0.0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.size();
        return 0.0;
    }
    
    private static String getLetterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
        return "A";
    }
}