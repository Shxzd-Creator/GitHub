import java.util.ArrayList;
import java.util.Scanner;

// Patient class
class Patient {
    int id;
    String name;
    int age;
    String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Disease: " + disease);
    }
}

// Doctor class
class Doctor {
    int id;
    String name;
    String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Specialization: " + specialization);
    }
}

// Appointment class
class Appointment {
    Patient patient;
    Doctor doctor;
    String date;
    String day;   // New field for appointment date

    public Appointment(Patient patient, Doctor doctor, String date, String day) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.day=day;
    }

    public void displayInfo() {
        System.out.println("Appointment: " + patient.name + " with Dr. " + doctor.name + 
                           " (" + doctor.specialization + ") on "+ day + date);
    }
}

// Main System
public class HospitalManagement {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    bookAppointment();
                    break;
                case 4:
                    viewAppointments();
                    break;
                case 5:
                    System.out.println("Exiting System...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();

        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient added successfully!");
    }

    public static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        doctors.add(new Doctor(id, name, specialization));
        System.out.println("Doctor added successfully!");
    }

    public static void bookAppointment() {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("Patients or Doctors list is empty! Add them first.");
            return;
        }

        System.out.println("Select a Patient:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).name);
        }
        System.out.print("Enter choice: ");
        int patientIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("Select a Doctor:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).name + " (" + doctors.get(i).specialization + ")");
        }
        System.out.print("Enter choice: ");
        int doctorIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Enter Appointment Day : ");
        String day = scanner.nextLine();

        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        appointments.add(new Appointment(patients.get(patientIndex), doctors.get(doctorIndex), day,date));
        System.out.println("Appointment booked successfully for " + day + date + "!");
    }

    public static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments booked yet.");
            return;
        }
        System.out.println("\n--- Appointments List ---");
        for (Appointment appt : appointments) {
            appt.displayInfo();
        }
    }
}