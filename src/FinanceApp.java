import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FinanceApp {
    private Map<String, User> users;
    private User currentUser;

    public FinanceApp() {
        this.users = new HashMap<>();
        this.currentUser = null;
    }

    public void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("User already exists!");
        } else {
            users.put(username, new User(username, password));
            System.out.println("Registration successful!");
        }
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            currentUser = user;
            System.out.println("Login successful!");
            return true;
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    public void logout() {
        currentUser = null;
        System.out.println("Logged out successfully.");
    }

    private void addIncome(Scanner scanner) {
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }
        System.out.print("Enter income amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        currentUser.getWallet().addIncome(amount, category);
    }

    private void addExpense(Scanner scanner) {
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        currentUser.getWallet().addExpense(amount, category);
    }

    private void setBudget(Scanner scanner) {
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter budget amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        currentUser.getWallet().setBudget(category, amount);
    }

    private void viewStatistics() {
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }
        currentUser.getWallet().printStatistics();
    }

    public static void main(String[] args) {
        FinanceApp app = new FinanceApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Add Income\n4. Add Expense\n5. Set Budget\n6. View Statistics\n7. Logout\n8. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    app.register(username, password);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    if (app.login(username, password)) {
                        System.out.println("Welcome, " + username + "!");
                    }
                    break;
                case 3:
                    app.addIncome(scanner);
                    break;
                case 4:
                    app.addExpense(scanner);
                    break;
                case 5:
                    app.setBudget(scanner);
                    break;
                case 6:
                    app.viewStatistics();
                    break;
                case 7:
                    app.logout();
                    break;
                case 8:
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}