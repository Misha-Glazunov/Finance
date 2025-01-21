import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Wallet {
    private double balance;
    private List<Transaction> transactions;
    private Map<String, Double> budgets;

    public Wallet() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        this.budgets = new HashMap<>();
    }

    public void addIncome(double amount, String category) {
        balance += amount;
        transactions.add(new Transaction("Income", amount, category));
        System.out.println("Income added: " + amount + " to category " + category);
    }

    public void addExpense(double amount, String category) {
        double remainingBudget = getRemainingBudget(category);
        if (remainingBudget < amount) {
            System.out.println("Warning: Expense exceeds the budget for category " + category);
        }
        balance -= amount;
        transactions.add(new Transaction("Expense", amount, category));
        System.out.println("Expense added: " + amount + " to category " + category);
    }

    public void setBudget(String category, double amount) {
        budgets.put(category, amount);
        System.out.println("Budget set: " + amount + " for category " + category);
    }

    public double getRemainingBudget(String category) {
        double spent = transactions.stream()
                .filter(t -> t.getCategory().equals(category) && t.getType().equals("Expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();
        return budgets.getOrDefault(category, 0.0) - spent;
    }

    public double getTotalIncome() {
        return transactions.stream()
                .filter(t -> t.getType().equals("Income"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getTotalExpenses() {
        return transactions.stream()
                .filter(t -> t.getType().equals("Expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getBalance() {
        return balance;
    }

    public void printStatistics() {
        System.out.println("\n--- Wallet Statistics ---");
        System.out.println("Total Balance: " + balance);
        System.out.println("Total Income: " + getTotalIncome());
        System.out.println("Total Expenses: " + getTotalExpenses());
        System.out.println("Budgets:");
        budgets.forEach((category, budget) -> {
            double remaining = getRemainingBudget(category);
            System.out.println("Category: " + category + ", Budget: " + budget + ", Remaining: " + remaining);
        });
        System.out.println("--------------------------\n");
    }
}