package ExpenseTracker;
import java.sql.*;
import java.util.*;

public class ExpenseDAO {

    public void addExpense(Expense e) throws SQLException {
        String sql = "INSERT INTO expenses(date, category, amount, note) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getDate());
            stmt.setString(2, e.getCategory());
            stmt.setDouble(3, e.getAmount());
            stmt.setString(4, e.getNote());
            stmt.executeUpdate();
        }
    }

    public List<Expense> getAllExpenses() throws SQLException {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Expense e = new Expense(
                    rs.getInt("id"),
                    rs.getString("date"),
                    rs.getString("category"),
                    rs.getDouble("amount"),
                    rs.getString("note")
                );
                list.add(e);
            }
        }
        return list;
    }
}

