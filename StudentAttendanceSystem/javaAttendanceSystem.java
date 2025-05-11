
import java.util.ArrayList;
import java.util.Scanner;

class StudentAttendence {
        String name;
        boolean isPresent;

        StudentAttendence(String name) {
            this.name = name;
            this.isPresent = false;
        }

        void markPresent() {
            this.isPresent = true;
        }

        void markAbsent() {
            this.isPresent = false;
        }

        @Override
        public String toString() {
            return name + " - " + (isPresent ? "Present" : "Absent");
        }
    }

    public class javaAttendanceSystem {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<StudentAttendence> students = new ArrayList<>();
            int choice;

            do {
                System.out.println("\nStudent Attendance System");
                System.out.println("1. Add Student");
                System.out.println("2. Mark Attendance");
                System.out.println("3. View Attendance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        students.add(new StudentAttendence(name));
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        if (students.isEmpty()) {
                            System.out.println("No students to mark attendance for.");
                            break;
                        }
                        for (int i = 0; i < students.size(); i++) {
                                System.out.print("Is " + students.get(i).name + " present? (y/n): ");
                                String response = scanner.nextLine();
                                if (response.equalsIgnoreCase("y")) {
                                    students.get(i).markPresent();
                                } else {
                                    students.get(i).markAbsent();
                                }
                            }
                            break;

                    case 3:
                        if (students.isEmpty()) {
                            System.out.println("No students in the list.");
                        } else {
                            System.out.println("Attendance Record:");
                            for (StudentAttendence s : students) {
                                System.out.println(s);
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 4);

            scanner.close();
        }
    }

