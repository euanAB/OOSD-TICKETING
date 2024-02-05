import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Event {
    private String eventName;
    private String eventDate;
    private String eventLocation;

    private static List<Event> allEvents;

    static {
        allEvents = new ArrayList<>();
        allEvents.add(new Event("Dance", "15-05-2024", "Doncaster Main"));
        allEvents.add(new Event("Theatre", "01-08-2024", "Sheffield Town Hall"));
        allEvents.add(new Event("Cheer", "03-01-2025", "HW Town Hall"));
    }

    public Event(String name, String date, String location) {
        this.eventName = name;
        this.eventDate = date;
        this.eventLocation = location;
    }

    public Event() {
        this.eventName = "Default Event";
        this.eventDate = "01-01-2023";
        this.eventLocation = "Default Location";
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void displayEventDetails() {
        System.out.println("Event Name: " + this.eventName);
        System.out.println("Event Date: " + this.eventDate);
        System.out.println("Event Location: " + this.eventLocation);
        System.out.println();
    }

    public static void displayAllEvents() {
        System.out.println("All Events:");
        for (Event event : allEvents) {
            System.out.println("Name: " + event.getEventName() +
                    "\tDate: " + event.getEventDate() +
                    "\tLocation: " + event.getEventLocation());
        }
    }

    public static Event getEventByNumber(int number) {
        if (number >= 1 && number <= allEvents.size()) {
            return allEvents.get(number - 1);
        }
        return null;
    }

    public static void addEvent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the new event: ");
        String name = scanner.nextLine();
        System.out.print("Enter the date of the new event (DD-MM-YYYY): ");
        String date = scanner.nextLine();
        System.out.print("Enter the location of the new event: ");
        String location = scanner.nextLine();

        Event newEvent = new Event(name, date, location);
        allEvents.add(newEvent);

        System.out.println("New event added successfully!");
    }
}

