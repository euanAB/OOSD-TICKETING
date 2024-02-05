import java.util.Scanner;

public class Customer {
    private String username;
    private String password;

    public void signUp() {
        Scanner input = new Scanner(System.in);

        System.out.print("Input username: ");
        username = input.nextLine();
        System.out.print("Input password: ");
        password = input.nextLine();

        System.out.println("Account created");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
