package manager;

import io.IOFile;
import model.Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStaff {
    private static final String PATH_NAME = "";
    private final ArrayList<Staff> staffList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final IOFile<Staff> readAndWrite = new IOFile<>();



    public void displayStaff() {
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }

//    public Staff addStaff(int choice) {
//        System.out.println("Input ID");
//        int id = scanner.nextInt();
//        System.out.println("Input Name");
//        String name = scanner.nextLine();
//        System.out.println("Input Age");
//        int age = scanner.nextInt();
//        System.out.println("Input Gender");
//        String gender = scanner.nextLine();
//        System.out.println("Input Address");
//        String address = scanner.nextLine();
//        String phoneNumber = ValidateStaff.validatePhoneNumber();
//        String email = ValidateStaff.validateEmail();
//        System.out.println("Input status");
//        boolean status = scanner.nextBoolean();
//        if (choice == 1) {
//            System.out.println("Nhập số ngày làm việc");
//            int workingDay = scanner.nextInt();
//            System.out.println("Nhập mức lương theo giờ");
//            double dailySalary = scanner.nextInt();
//            StaffFullTime staffFullTime = new StaffFullTime(id, name, age, gender, address, phoneNumber, email, status, workingDay, dailySalary);
//            staffList.add(staffFullTime);
//        } else if (choice == 2) {
//            System.out.println("Nhập số giờ làm việc");
//            int workingHour = scanner.nextInt();
//            System.out.println("Nhập mức lương theo giờ");
//            double hourSalary = scanner.nextInt();
//            StaffPartTime staffPartTime = new StaffPartTime(id, name, age, gender, address, phoneNumber, email, status, workingHour, hourSalary);
//            staffList.add(staffPartTime);
//        }
//        return null;
//    }


}
