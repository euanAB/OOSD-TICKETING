import java.util.Scanner;

public class TicketPrinter {
    private static boolean[][] seatingChart = new boolean[5][10];

    public void displayTicketMenu(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            ticketChoice(choice, customer);
        } while (choice != 2);

        scanner.close();
    }

    public void displayMenu() {
        System.out.println("1. Buy Ticket");
        System.out.println("2. Exit");
        System.out.print("Please pick an option: ");
    }

    public void ticketChoice(int choice, Customer customer) {
        switch (choice) {
            case 1:
                buyTicket(customer);
                break;
            case 2:
                System.out.println("Exiting ticket menu");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    public void buyTicket(Customer customer) {
        Scanner input = new Scanner(System.in);

        Event.displayAllEvents();

        System.out.print("Enter the number of the event you want to attend: ");
        int eventNumber = input.nextInt();
        input.nextLine();
        Event chosenEvent = Event.getEventByNumber(eventNumber);

        if (chosenEvent != null) {
            chosenEvent.displayEventDetails();

            displaySeatingChart();

            System.out.print("Enter the row number (1-5) of the seat you want: ");
            int row = input.nextInt();
            System.out.print("Enter the seat number (1-10) of the seat you want: ");
            int seat = input.nextInt();
            input.nextLine();

            if (isValidSeat(row, seat)) {
                markSeatAsTaken(row, seat);

                System.out.println("Choose a ticket type:");
                System.out.println("1. Standard");
                System.out.println("2. Student");
                System.out.println("3. OAP (Elderly)");
                System.out.println("4. Child");
                System.out.print("Please pick a ticket type: ");
                int ticketTypeChoice = input.nextInt();
                input.nextLine();

                String ticketType = getTicketType(ticketTypeChoice);

                if (ticketType != null) {
                    int cost = getTicketCost(ticketType);

                    System.out.println("You have chosen " + ticketType + " ticket for the event '" + chosenEvent.getEventName() +
                            "' in row " + row + ", seat " + seat + ". The cost is " + cost + " pounds. Are you happy with this choice?");
                    System.out.println("Press 1 to confirm your choice or 0 to go back.");
                    int userChoice = input.nextInt();
                    input.nextLine();

                    if (userChoice == 1) {
                        System.out.print("Enter the name on the ticket: ");
                        String ticketHolderName = input.nextLine();

                        System.out.println("Processing payment for " + ticketHolderName + "...");
                        System.out.println("Payment successful!");
                    } else if (userChoice == 0) {
                        System.out.println("Returning to the ticket screen");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                } else {
                    System.out.println("Invalid ticket type choice.");
                }
            } else {
                System.out.println("Invalid seat selection. Please choose a valid seat.");
            }

            displayMenu();
        } else {
            System.out.println("Event not found. Please enter a valid event number.");
        }

        System.out.println();
    }

    private void displaySeatingChart() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < seatingChart.length; i++) {
            for (int j = 0; j < seatingChart[i].length; j++) {
                System.out.print(seatingChart[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }

    private boolean isValidSeat(int row, int seat) {
        return row >= 1 && row <= seatingChart.length && seat >= 1 && seat <= seatingChart[0].length && !seatingChart[row - 1][seat - 1];
    }

    private void markSeatAsTaken(int row, int seat) {
        seatingChart[row - 1][seat - 1] = true;
    }

    private String getTicketType(int choice) {
        switch (choice) {
            case 1:
                return "Standard";
            case 2:
                return "Student";
            case 3:
                return "OAP (Elderly)";
            case 4:
                return "Child";
            default:
                return null;
        }
    }

    private int getTicketCost(String ticketType) {
        switch (ticketType) {
            case "Standard":
                return 10;
            case "Student":
            case "OAP (Elderly)":
                return 8;
            case "Child":
                return 5;
            default:
                return 0;
        }
    }
}