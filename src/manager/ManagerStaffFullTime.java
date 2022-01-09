package manager;

import Regex.ValidateStaff;
import io.IOFile;
import model.StaffFullTime;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStaffFullTime {
    public static final String PATHNAME_SFT = "src/io/staffFT.txt";
    ArrayList<StaffFullTime> staffFullTimes;
    private final Scanner scanner = new Scanner(System.in);
    private final IOFile<StaffFullTime> ioFile = new IOFile<>();

    public ManagerStaffFullTime() {
        if (new File(PATHNAME_SFT).length() == 0) {
            this.staffFullTimes = new ArrayList<>();
        } else {
            this.staffFullTimes = ioFile.readFileData(PATHNAME_SFT);
        }
    }

    public ArrayList<StaffFullTime> getStaffFullTimes() {
        return staffFullTimes;
    }

    public void displayFullTime() {
        for (StaffFullTime staffFullTime : staffFullTimes) {
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


    public void addStaffFullTime() {
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
        System.out.println("Nhập số ngày làm việc");
        int workingDay = scanner.nextInt();
        System.out.println("Nhập số tiền lương theo ngày");
        double dailySalary = scanner.nextDouble();
        if (checkAge(age) && !getGender(gender).equals("") && !getStatus(status).equals("")) {
            StaffFullTime staffFullTime = new StaffFullTime(id, name, age, getGender(gender), address, phoneNumber, email, getStatus(status), workingDay, dailySalary);
            staffFullTimes.add(staffFullTime);
            ioFile.writerFileData(staffFullTimes, PATHNAME_SFT);
        }else {
            System.out.println("Tuổi không phù hợp");
        }

    }


    public void deleteStaffFullTime(int id) {
        StaffFullTime staffFullTime = null;
        for (StaffFullTime staffFT : staffFullTimes) {
            if (staffFT.getId() == id) {
                staffFullTime = staffFT;
            }
        }
        if (staffFullTime != null) {
            staffFullTimes.remove(staffFullTime);
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tồn tại Id này");
        }
    }

    public void editStaffFullTime(int id) {
        StaffFullTime editStaffFT = null;
        for (StaffFullTime staffFullTime: staffFullTimes) {
            if (staffFullTime.getId() == id) {
                editStaffFT = staffFullTime;
            }
        }
        if (editStaffFT != null) {
            System.out.println("Nhập Id mới");
            int id1 = scanner.nextInt();
            editStaffFT.setId(id1);
            scanner.nextLine();
            System.out.println("Nhập tên mới");
            String name = scanner.nextLine();
            editStaffFT.setName(name);
            System.out.println("Nhập tuổi mới");
            int age = scanner.nextInt();
            editStaffFT.setAge(age);
            System.out.println("Chọn giới tính");
            System.out.println("1. NAM");
            System.out.println("2. NỮ");
            System.out.println("3. OTHER");
            int gender = scanner.nextInt();
            editStaffFT.setGender(getGender(gender));
            System.out.println("Nhập địa chỉ");
            scanner.nextLine();
            String address = scanner.nextLine();
            editStaffFT.setAddress(address);
            String phoneNumber = ValidateStaff.validatePhoneNumber();
            editStaffFT.setNumberPhone(phoneNumber);
            String email = ValidateStaff.validateEmail();
            editStaffFT.setEmail(email);
            System.out.println("Chọn trạng thái làm việc");
            System.out.println("1. ON");
            System.out.println("2. OFF");
            int status = scanner.nextInt();
            editStaffFT.setStatus(getStatus(status));
            System.out.println("Nhập số ngày làm việc");
            int workingDay = scanner.nextInt();
            editStaffFT.setWorkingDay(workingDay);
            System.out.println("Nhập số tiền lương theo ngày");
            double dailySalary = scanner.nextDouble();
            editStaffFT.setDailySalary(dailySalary);
            if (checkAge(age) && !getGender(gender).equals("") && !getStatus(status).equals("")) {
                System.out.println("Sửa thành công");
                ioFile.writerFileData(staffFullTimes, PATHNAME_SFT);
            } else {
                System.err.println("Tuổi không phù hợp!");
            }
        } else {
            System.out.println("Id không tồn tại");
        }
    }

    public void searchStaffFTbyId(int id) {
        for (StaffFullTime staffFT : staffFullTimes) {
            if (staffFT.getId() == id) {
                System.out.println(staffFT);
            }
        }
    }



    public void searchStaffFTByName(String name) {
        for (StaffFullTime staffFT : staffFullTimes) {
            if (staffFT.getName().equals(name)) {
                System.out.println(staffFT);
            }
        }
    }

    public void sortByAge() {
        staffFullTimes.sort((o1, o2) -> {
            if (o1.getAge() < o2.getAge()) {
                return -1;
            } else if (o1.getAge() > o2.getAge()) {
                return 1;
            }
            return 0;
        });
        displayFullTime();
        System.out.println("Sắp xếp thành công");
    }


    public void displayByStatusON() {
        for (StaffFullTime staffFT : staffFullTimes) {
            if (staffFT.getStatus().equals(1));
            System.out.println(staffFT);
        }
    }
}
