
import java.util.*;

class Orphan {
    String name;
    int age;
    String gender;
    String healthStatus;

    public Orphan(String name, int age, String gender, String healthStatus) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.healthStatus = healthStatus;
    }

    public void display() {
        System.out.println("Name         : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Gender       : " + gender);
        System.out.println("Health Status: " + healthStatus);
        System.out.println("---------------------------------");
    }
}

class Adoption {
    String orphanName;
    String adopterName;
    String contact;
    Date adoptionDate;

    public Adoption(String orphanName, String adopterName, String contact) {
        this.orphanName = orphanName;
        this.adopterName = adopterName;
        this.contact = contact;
        this.adoptionDate = new Date();
    }
}

class Donation {
    String donorName;
    double amount;
    String purpose;
    Date date;

    public Donation(String donorName, double amount, String purpose) {
        this.donorName = donorName;
        this.amount = amount;
        this.purpose = purpose;
        this.date = new Date();
    }
}

public class OrphanageManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Orphan> orphans = new ArrayList<>();
    static ArrayList<Adoption> adoptions = new ArrayList<>();
    static ArrayList<Donation> donations = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Orphanage Management System ===");
            System.out.println("1. Add Orphan");
            System.out.println("2. View All Orphans");
            System.out.println("3. Record Adoption");
            System.out.println("4. View Adoption History");
            System.out.println("5. Record Donation");
            System.out.println("6. View Donation Records");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addOrphan();
                case 2 -> viewOrphans();
                case 3 -> recordAdoption();
                case 4 -> viewAdoptions();
                case 5 -> recordDonation();
                case 6 -> viewDonations();
                case 7 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    }

    static void addOrphan() {
        System.out.print("Enter Orphan Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Health Status: ");
        String health = scanner.nextLine();

        orphans.add(new Orphan(name, age, gender, health));
        System.out.println("Orphan added successfully!");
    }

    static void viewOrphans() {
        if (orphans.isEmpty()) {
            System.out.println("No orphans found.");
            return;
        }

        System.out.println("\n--- List of Orphans ---");
        for (Orphan o : orphans) {
            o.display();
        }
    }

    static void recordAdoption() {
        System.out.print("Enter Orphan Name: ");
        String orphanName = scanner.nextLine();
        System.out.print("Enter Adopter's Name: ");
        String adopterName = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        adoptions.add(new Adoption(orphanName, adopterName, contact));
        System.out.println("Adoption recorded successfully!");
    }

    static void viewAdoptions() {
        if (adoptions.isEmpty()) {
            System.out.println("No adoption records found.");
            return;
        }

        System.out.println("\n--- Adoption History ---");
        for (Adoption a : adoptions) {
            System.out.println("Orphan Name : " + a.orphanName);
            System.out.println("Adopter Name: " + a.adopterName);
            System.out.println("Contact     : " + a.contact);
            System.out.println("Adoption Date: " + a.adoptionDate);
            System.out.println("-------------------------------");
        }
    }

    static void recordDonation() {
        System.out.print("Enter Donor Name: ");
        String donorName = scanner.nextLine();
        System.out.print("Enter Amount Donated: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Purpose (e.g. Education, Food): ");
        String purpose = scanner.nextLine();

        donations.add(new Donation(donorName, amount, purpose));
        System.out.println("Donation recorded successfully!");
    }

    static void viewDonations() {
        if (donations.isEmpty()) {
            System.out.println("No donation records found.");
            return;
        }

        System.out.println("\n--- Donation Records ---");
        for (Donation d : donations) {
            System.out.println("Donor Name : " + d.donorName);
            System.out.println("Amount     : ₹" + d.amount);
            System.out.println("Purpose    : " + d.purpose);
            System.out.println("Date       : " + d.date);
            System.out.println("-----------------------------");
        }
    }
}
