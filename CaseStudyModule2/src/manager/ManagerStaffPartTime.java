package manager;

import Regex.ValidateStaff;
import io.IOFile;
import model.StaffFullTime;
import model.StaffPartTime;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStaffPartTime {
    public static final String PATHNAME_SPT = "src/io/staffPT.txt";
    ArrayList<StaffPartTime> staffPartTimes;
    Scanner scanner = new Scanner(System.in);
    private final IOFile<StaffPartTime> ioFile = new IOFile<>();

    public ManagerStaffPartTime() {
        if (new File(PATHNAME_SPT).length() == 0) {
            this.staffPartTimes = new ArrayList<>();
        } else {
            this.staffPartTimes = ioFile.readFileData(PATHNAME_SPT);
        }
    }

    public ArrayList<StaffPartTime> getStaffFullTimes() {
        return staffPartTimes;
    }

    public void displayPartTime() {
        for (StaffPartTime staffFullTime : staffPartTimes) {
            System.out.println(staffFullTime);
        }
    }

    public String getStatus(int choice) {
        String status = "";
        switch (choice) {
            case 1:
                status = "ON";
                break;
            case 2:
                status = "OFF";
                break;
        }
        return status;
    }

    public String getGender(int choice) {
        String gender = "";
        switch (choice) {
            case 1:
                gender = "NAM";
                break;
            case 2:
                gender = "NỮ";
                break;
            case 3:
                gender = "OTHER";
                break;
        }
        return gender;
    }

    public boolean checkAge(int age) {
        return (age >= 18 && age <= 60);
    }

    public void addStaffPartTime() {
        System.out.println("Input Id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input Name");
        String name = scanner.nextLine();
        System.out.println("Input Age");
        int age = scanner.nextInt();
        System.out.println("Chọn giới tính");
        System.out.println("1. NAM");
        System.out.println("2. NỮ");
        System.out.println("3. OTHER");
        int gender = scanner.nextInt();
        System.out.println("Input Address");
        scanner.nextLine();
        String address = scanner.nextLine();
        String phoneNumber = ValidateStaff.validatePhoneNumber();
        String email = ValidateStaff.validateEmail();
        System.out.println("Chọn trạng thái làm việc");
        System.out.println("1. ON");
        System.out.println("2. OFF");
        int status = scanner.nextInt();
        System.out.println("Nhập số giờ làm việc");
        int workingHour = scanner.nextInt();
        System.out.println("Nhập số tiền lương theo giờ");
        double hourSalary = scanner.nextDouble();
        if (checkAge(age) && !getStatus(status).equals("") && !getGender(gender).equals("")) {
            StaffPartTime staffPartTime = new StaffPartTime(id, name, age, getGender(gender), address, phoneNumber, email, getStatus(status), workingHour, hourSalary);
            staffPartTimes.add(staffPartTime);
            ioFile.writerFileData(staffPartTimes, PATHNAME_SPT);
        }

    }

    public void deleteStaffPartTime(int id) {
        StaffPartTime staffPartTime = null;
        for (StaffPartTime staffPT : staffPartTimes) {
            if (staffPT.getId() == id) {
                staffPartTime = staffPT;
            }
        }
        if (staffPartTime != null) {
            staffPartTimes.remove(staffPartTime);
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tồn tại Id này");
        }
    }

    public void editStaffPartTime(int id) {
        StaffPartTime editStaffPT = null;
        for (StaffPartTime staffPartTime: staffPartTimes) {
            if (staffPartTime.getId() == id) {
                editStaffPT = staffPartTime;
            }
        }
        if (editStaffPT != null) {
            System.out.println("Nhập Id mới");
            int id1 = scanner.nextInt();
            editStaffPT.setId(id1);
            scanner.nextLine();
            System.out.println("Nhập tên mới");
            String name = scanner.nextLine();
            editStaffPT.setName(name);
            System.out.println("Nhập tuổi mới");
            int age = scanner.nextInt();
            editStaffPT.setAge(age);
            System.out.println("Chọn giới tính");
            System.out.println("1. NAM");
            System.out.println("2. NỮ");
            System.out.println("3. OTHER");
            int gender = scanner.nextInt();
            editStaffPT.setGender(getGender(gender));
            System.out.println("Nhập địa chỉ");
            scanner.nextLine();
            String address = scanner.nextLine();
            editStaffPT.setAddress(address);
            String phoneNumber = ValidateStaff.validatePhoneNumber();
            editStaffPT.setNumberPhone(phoneNumber);
            String email = ValidateStaff.validateEmail();
            editStaffPT.setEmail(email);
            System.out.println("Chọn trạng thái làm việc");
            System.out.println("1. ON");
            System.out.println("2. OFF");
            int status = scanner.nextInt();
            editStaffPT.setStatus(getStatus(status));
            System.out.println("Nhập số giờ làm việc");
            int workingHour = scanner.nextInt();
            editStaffPT.setWorkingHour(workingHour);
            System.out.println("Nhập số tiền lương theo giờ");
            double hourSalary = scanner.nextDouble();
            editStaffPT.setHourSalary(hourSalary);
            if (checkAge(age) && !getStatus(status).equals("") && !getGender(gender).equals("")) {
                System.out.println("Sửa Thành Công");
                ioFile.writerFileData(staffPartTimes, PATHNAME_SPT);
            } else {
                System.out.println("Tuổi không phù hợp");
            }
        } else {
            System.out.println("Id không tồn tại");
        }
    }

    public void searchStaffPTbyId(int id) {
        for (StaffPartTime staffPT : staffPartTimes) {
            if (staffPT.getId() == id) {
                System.out.println(staffPT);
            }
        }
    }

    public void searchStaffPTByName(String name) {
        for (StaffPartTime staffPT : staffPartTimes) {
            if (staffPT.getName().equals(name)) {
                System.out.println(staffPT);
            }
        }
    }

    public void sortByAge() {
        staffPartTimes.sort((o1, o2) -> {
            if (o1.getAge() < o2.getAge()) {
                return -1;
            } else if (o1.getAge() > o2.getAge()) {
                return 1;
            }
            return 0;
        });
        displayPartTime();
        System.out.println("Sắp xếp thành công");
    }

    public void displayByStatusON() {
        for (StaffPartTime staffPT : staffPartTimes) {
            if (staffPT.getStatus().equals("ON")) {
                System.out.println(staffPT);
            }
        }
    }

    public void displayPayPartTime() {
        for (StaffPartTime staffPT : staffPartTimes) {
            if (staffPT.getWorkingHour() >= 120) {
                System.out.println("ID " + staffPT.getId() + "| Tên " + staffPT.getName() + "| Lương " + staffPT.getHourSalary()*staffPT.getWorkingHour()*1.2+"VND");
            } else if (staffPT.getWorkingHour() >= 100) {
                System.out.println("ID " + staffPT.getId() + "| Tên " + staffPT.getName() + "| Lương " + staffPT.getHourSalary()*staffPT.getWorkingHour()*1.1+"VND");
            } else {
                System.out.println("ID " + staffPT.getId() + "| Tên " + staffPT.getName() + "| Lương " + staffPT.getHourSalary()*staffPT.getWorkingHour()+"VND");
            }
        }
    }

    public void checkStatus(int id) {
        for (StaffPartTime s: staffPartTimes) {
            if (s.getId() == id) {
                if (s.getStatus().equals("ON")) {
                    System.out.println("Đang làm việc");
                } else {
                    System.out.println("Đã nghỉ");
                }
            }
        }
    }
}
