package ExpenseTracker;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseDAO dao = new ExpenseDAO();

        while (true) {
            System.out.println("\n==== Expense Tracker ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter date (YYYY-MM-DD): ");
                        String date = sc.nextLine();
                        System.out.print("Enter category: ");
                        String category = sc.nextLine();
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter note: ");
                        String note = sc.nextLine();

                        Expense e = new Expense(0, date, category, amount, note);
                        dao.addExpense(e);
                        System.out.println("Expense added successfully!");
                        break;

                    case 2:
                        List<Expense> expenses = dao.getAllExpenses();
                        for (Expense ex : expenses) {
                            System.out.println(ex.getId() + " | " + ex.getDate() + " | " + ex.getCategory() +
                                               " | " + ex.getAmount() + " | " + ex.getNote());
                        }
                        break;

                    case 3:
                        System.out.println("Exiting... Bye!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
