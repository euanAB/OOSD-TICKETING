import java.util.Scanner;

public class Login {
    private String enteredUsername;
    private String enteredPassword;

    public boolean loginAndInfo(Customer customer) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        enteredUsername = input.nextLine();
        System.out.print("Enter password: ");
        enteredPassword = input.nextLine();

        if (enteredUsername.equals(customer.getUsername()) && enteredPassword.equals(customer.getPassword())) {
            System.out.println("Login successful");
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again");
            return false;
        }
    }
}
