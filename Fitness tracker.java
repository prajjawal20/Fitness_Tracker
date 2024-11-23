import java.util.Scanner;

class FitnessTracker {
    private String userName;
    private int stepsGoal;
    private int stepsTaken;
    private double caloriesGoal;
    private double caloriesBurned;
    private double waterGoal; // in liters
    private double waterConsumed; // in liters

    // Constructor
    public FitnessTracker(String userName) {
        this.userName = userName;
        this.stepsGoal = 10000; // Default step goal
        this.caloriesGoal = 2000; // Default calorie goal
        this.waterGoal = 2.0; // Default water goal in liters
        this.stepsTaken = 0;
        this.caloriesBurned = 0;
        this.waterConsumed = 0;
    }

    // Update steps taken
    public void updateSteps(int steps) {
        this.stepsTaken += steps;
        System.out.println("Steps updated. Total steps taken: " + this.stepsTaken);
    }

    // Update calories burned
    public void updateCalories(double calories) {
        this.caloriesBurned += calories;
        System.out.println("Calories updated. Total calories burned: " + this.caloriesBurned);
    }

    // Update water consumed
    public void updateWater(double liters) {
        this.waterConsumed += liters;
        System.out.println("Water intake updated. Total water consumed: " + this.waterConsumed + " liters.");
    }

    // Display progress
    public void showProgress() {
        System.out.println("\nFitness Progress for " + userName);
        System.out.println("Steps: " + stepsTaken + "/" + stepsGoal);
        System.out.println("Calories Burned: " + caloriesBurned + "/" + caloriesGoal);
        System.out.println("Water Consumed: " + waterConsumed + "/" + waterGoal + " liters\n");
    }

    // Set new fitness goals
    public void setGoals(int stepsGoal, double caloriesGoal, double waterGoal) {
        this.stepsGoal = stepsGoal;
        this.caloriesGoal = caloriesGoal;
        this.waterGoal = waterGoal;
        System.out.println("Goals updated successfully!");
    }
}

public class FitnessTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Fitness Tracker!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        FitnessTracker tracker = new FitnessTracker(name);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Update Steps");
            System.out.println("2. Update Calories Burned");
            System.out.println("3. Update Water Intake");
            System.out.println("4. View Progress");
            System.out.println("5. Set Goals");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter steps taken: ");
                    int steps = scanner.nextInt();
                    tracker.updateSteps(steps);
                    break;
                case 2:
                    System.out.print("Enter calories burned: ");
                    double calories = scanner.nextDouble();
                    tracker.updateCalories(calories);
                    break;
                case 3:
                    System.out.print("Enter water consumed (in liters): ");
                    double water = scanner.nextDouble();
                    tracker.updateWater(water);
                    break;
                case 4:
                    tracker.showProgress();
                    break;
                case 5:
                    System.out.print("Enter new steps goal: ");
                    int stepsGoal = scanner.nextInt();
                    System.out.print("Enter new calories goal: ");
                    double caloriesGoal = scanner.nextDouble();
                    System.out.print("Enter new water goal (in liters): ");
                    double waterGoal = scanner.nextDouble();
                    tracker.setGoals(stepsGoal, caloriesGoal, waterGoal);
                    break;
                case 6:
                    System.out.println("Exiting Fitness Tracker. Stay healthy!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
