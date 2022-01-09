package Main;


import manager.ManagerStaffFullTime;
import manager.ManagerStaffPartTime;

import java.util.Scanner;

public class StaffMain {


    public static void staffMain() {
        while (true) {
            ManagerStaffFullTime managerStaffFullTime = new ManagerStaffFullTime();
            ManagerStaffPartTime managerStaffPartTime = new ManagerStaffPartTime();
            Scanner scanner = new Scanner(System.in);
            System.out.println("**************************************************");
            System.out.println("*                MENU STAFF                      *");
            System.out.println("*   1. Hiển thị danh sách nhân viên              *");
            System.out.println("*   2. Tìm Kiếm nhân viên Full Time theo ID      *");
            System.out.println("*   3. Tìm Kiếm nhân viên Part Time theo ID      *");
            System.out.println("*   4. Sắp xếp nhân viên Full time theo tuổi     *");
            System.out.println("*   5. Sắp xếp nhân viên Part Time theo tuổi     *");
            System.out.println("*   0. Đăng xuất                                 *");
            System.out.println("**************************************************");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int choice1;
                    do {
                        System.out.println("1.Hiển thị danh sách nhân viên Full Time");
                        System.out.println("2.Hiển thị danh sách nhân viên Part Time");
                        choice1 = scanner.nextInt();
                        switch (choice1) {
                            case 1:
                                managerStaffFullTime.displayFullTime();
                                break;
                            case 2:
                                managerStaffPartTime.displayPartTime();
                                break;
                        }
                    } while (choice1 != 0);
                case 2:
                    System.out.println("Nhập id nhân viên muốn tìm kiếm");
                    int id1 = scanner.nextInt();
                    managerStaffFullTime.searchStaffFTbyId(id1);
                    break;
                case 3:
                    System.out.println("Nhập id nhân viên muốn tìm kiếm");
                    int id2 = scanner.nextInt();
                    managerStaffPartTime.searchStaffPTbyId(id2);
                    break;
                case 4:
                    managerStaffFullTime.sortByAge();
                    break;
                case 5:
                    managerStaffPartTime.sortByAge();
                    break;
                case 0:
                    return;
            }
        }

    }
}
