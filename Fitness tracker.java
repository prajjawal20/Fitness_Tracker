import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Model Class
class FitnessTrackerModel {
    private String userName;
    private int stepsGoal;
    private int stepsTaken;
    private double caloriesGoal;
    private double caloriesBurned;
    private double waterGoal;
    private double waterConsumed;

    // Constructor
    public FitnessTrackerModel(String userName, int stepsGoal, double caloriesGoal, double waterGoal) {
        this.userName = userName;
        this.stepsGoal = stepsGoal;
        this.caloriesGoal = caloriesGoal;
        this.waterGoal = waterGoal;
        this.stepsTaken = 0;
        this.caloriesBurned = 0;
        this.waterConsumed = 0;
    }

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public int getStepsGoal() {
        return stepsGoal;
    }

    public void setStepsGoal(int stepsGoal) {
        this.stepsGoal = stepsGoal;
    }

    public int getStepsTaken() {
        return stepsTaken;
    }

    public void setStepsTaken(int stepsTaken) {
        this.stepsTaken = stepsTaken;
    }

    public double getCaloriesGoal() {
        return caloriesGoal;
    }

    public void setCaloriesGoal(double caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public double getWaterGoal() {
        return waterGoal;
    }

    public void setWaterGoal(double waterGoal) {
        this.waterGoal = waterGoal;
    }

    public double getWaterConsumed() {
        return waterConsumed;
    }

    public void setWaterConsumed(double waterConsumed) {
        this.waterConsumed = waterConsumed;
    }
}

// DAO Class
class FitnessTrackerDAO {
    private Map<String, FitnessTrackerModel> users = new HashMap<>();

    // Save a user's data
    public void saveUser(FitnessTrackerModel user) {
        users.put(user.getUserName(), user);
        System.out.println("User data saved for: " + user.getUserName());
    }

    // Retrieve a user's data
    public FitnessTrackerModel getUser(String userName) {
        return users.get(userName);
    }

    // Update a user's data
    public void updateUser(FitnessTrackerModel user) {
        if (users.containsKey(user.getUserName())) {
            users.put(user.getUserName(), user);
            System.out.println("User data updated for: " + user.getUserName());
        } else {
            System.out.println("User not found: " + user.getUserName());
        }
    }
}

// Main Application
public class FitnessTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FitnessTrackerDAO dao = new FitnessTrackerDAO();

        System.out.println("Welcome to the Fitness Tracker!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Check if user exists or create a new one
        FitnessTrackerModel user = dao.getUser(name);
        if (user == null) {
            user = new FitnessTrackerModel(name, 10000, 2000, 2.0);
            dao.saveUser(user);
        }

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
                    user.setStepsTaken(user.getStepsTaken() + steps);
                    System.out.println("Steps updated. Total steps: " + user.getStepsTaken());
                    dao.updateUser(user);
                    break;

                case 2:
                    System.out.print("Enter calories burned: ");
                    double calories = scanner.nextDouble();
                    user.setCaloriesBurned(user.getCaloriesBurned() + calories);
                    System.out.println("Calories updated. Total calories burned: " + user.getCaloriesBurned());
                    dao.updateUser(user);
                    break;

                case 3:
                    System.out.print("Enter water consumed (in liters): ");
                    double water = scanner.nextDouble();
                    user.setWaterConsumed(user.getWaterConsumed() + water);
                    System.out.println("Water intake updated. Total water consumed: " + user.getWaterConsumed());
                    dao.updateUser(user);
                    break;

                case 4:
                    System.out.println("\nFitness Progress for " + user.getUserName());
                    System.out.println("Steps: " + user.getStepsTaken() + "/" + user.getStepsGoal());
                    System.out.println("Calories Burned: " + user.getCaloriesBurned() + "/" + user.getCaloriesGoal());
                    System.out.println("Water Consumed: " + user.getWaterConsumed() + "/" + user.getWaterGoal() + " liters\n");
                    break;

                case 5:
                    System.out.print("Enter new steps goal: ");
                    int stepsGoal = scanner.nextInt();
                    System.out.print("Enter new calories goal: ");
                    double caloriesGoal = scanner.nextDouble();
                    System.out.print("Enter new water goal (in liters): ");
                    double waterGoal = scanner.nextDouble();
                    user.setStepsGoal(stepsGoal);
                    user.setCaloriesGoal(caloriesGoal);
                    user.setWaterGoal(waterGoal);
                    System.out.println("Goals updated successfully!");
                    dao.updateUser(user);
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
