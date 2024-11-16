package tyit;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ATM extends HttpServlet {
    private BankAccount account;

    public void init() {
        account = new BankAccount(1000); // Initial balance
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int amount = Integer.parseInt(request.getParameter("amount"));
        PrintWriter out = response.getWriter();

        switch (action) {
            case "withdraw":
                if (account.withdraw(amount)) {
                    out.println("Withdrawal successful. New balance: " + account.checkBalance());
                } else {
                    out.println("Insufficient balance.");
                }
                break;
            case "deposit":
                account.deposit(amount);
                out.println("Deposit successful. New balance: " + account.checkBalance());
                break;
            case "checkBalance":
                out.println("Current balance: " + account.checkBalance());
                break;
            default:
                out.println("Invalid action.");
        }
    }
}
