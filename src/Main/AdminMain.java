package Main;

import Regex.ValidateAccount;
import manager.ManagerAccount;
import manager.ManagerStaffFullTime;
import manager.ManagerStaffPartTime;

import java.util.Scanner;

public class AdminMain {
    public static void mainAccount() {
        while (true) {
            ManagerAccount managerAccount = new ManagerAccount();
            ManagerStaffFullTime managerStaffFullTime = new ManagerStaffFullTime();
            ManagerStaffPartTime managerStaffPartTime = new ManagerStaffPartTime();
            Scanner scanner = new Scanner(System.in);
            System.out.println("*****************************");
            System.out.println("*   1. Quản lý nhân viên    *");
            System.out.println("*   2. Quản Lý Tài khoản    *");
            System.out.println("*   3. Đăng xuất            *");
            System.out.println("*****************************");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int choice2;
                    do {
                        System.out.println("*******************************************************");
                        System.out.println("*              QUẢN LÝ NHÂN VIÊN                      *");
                        System.out.println("*    1. Hiển thị danh sách nhân viên Full Time        *");
                        System.out.println("*    2. Hiển thị danh sách nhân viên Part Time        *");
                        System.out.println("*    3. Thêm nhân viên Full Time                      *");
                        System.out.println("*    4. Thêm nhân viên Part Time                      *");
                        System.out.println("*    5. Sửa thông tin nhân viên Full Time             *");
                        System.out.println("*    6. Sửa thông tin nhân viên Part Time             *");
                        System.out.println("*    7. Xóa nhân viên Full Time                       *");
                        System.out.println("*    8. Xóa nhân viên Part Time                       *");
                        System.out.println("*    9. Tìm kiếm nhân viên Full Time theo ID          *");
                        System.out.println("*   10. Tìm kiếm nhân viên Part Time theo ID          *");
                        System.out.println("*   11. Tìm kiếm nhân viên Full Time theo tên         *");
                        System.out.println("*   12. Tìm kiếm nhân viên Part Time theo tên         *");
                        System.out.println("*   13. Sắp xếp nhân viên                             *");
                        System.out.println("*   14. Hiển thị nhân viên Full Time đang làm việc    *");
                        System.out.println("*    0. Quay lại                                      *");
                        System.out.println("*******************************************************");
                        choice2 = scanner.nextInt();
                        switch (choice2) {
                            case 1:
                                managerStaffFullTime.displayFullTime();
                                break;
                            case 2:
                                managerStaffPartTime.displayPartTime();
                                break;
                            case 3:
                                managerStaffFullTime.addStaffFullTime();
                                break;
                            case 4:
                                managerStaffPartTime.addStaffPartTime();
                                break;
                            case 5:
                                System.out.println("Nhập id nhân viên cần sửa");
                                int id1 = scanner.nextInt();
                                managerStaffFullTime.editStaffFullTime(id1);
                                break;
                            case 6:
                                System.out.println("Nhập id nhân viên ");
                                int id2 = scanner.nextInt();
                                managerStaffPartTime.editStaffPartTime(id2);
                                break;
                            case 7:
                                System.out.println("Nhập id nhân viên cần xóa");
                                int id3 = scanner.nextInt();
                                managerStaffFullTime.deleteStaffFullTime(id3);
                                break;
                            case 8:
                                System.out.println("Nhập id nhân viên cần xóa");
                                int id4 = scanner.nextInt();
                                managerStaffPartTime.deleteStaffPartTime(id4);
                                break;
                            case 9:
                                System.out.println("Nhập id nhân viên muốn tìm");
                                int id5 = scanner.nextInt();
                                managerStaffFullTime.searchStaffFTbyId(id5);
                                break;
                            case 10:
                                System.out.println("Nhập id nhân viên muốn tìm");
                                int id6 = scanner.nextInt();
                                managerStaffPartTime.searchStaffPTbyId(id6);
                                break;
                            case 11:
                                System.out.println("Nhập tên nhân viên muốn tìm");
                                String name1 = scanner.nextLine();
                                managerStaffFullTime.searchStaffFTByName(name1);
                                break;
                            case 12:
                                System.out.println("Nhập tên nhân viên muốn tìm");
                                String name2 = scanner.nextLine();
                                managerStaffPartTime.searchStaffPTByName(name2);
                                break;
                            case 13:
                                int choice5;
                                do {
                                    System.out.println("**********************************************");
                                    System.out.println("*             SẮP XẾP NHÂN VIÊN              *");
                                    System.out.println("* 1. Sắp xếp nhân viên Full Time theo tuổi   *");
                                    System.out.println("* 2. Sắp xếp nhân viên Part Time theo tuổi   *");
                                    System.out.println("* 3. Sắp xếp nhân viên Full Time theo lương  *");
                                    System.out.println("* 4. Sắp xếp nhân viên Part Time theo lương  *");
                                    System.out.println("* 0. Quay lại                                *");
                                    System.out.println("**********************************************");
                                    choice5 = scanner.nextInt();
                                    switch (choice5) {
                                        case 1:
                                            managerStaffFullTime.sortByAge();
                                            break;
                                        case 2:
                                            managerStaffPartTime.sortByAge();
                                            break;
                                    }
                                } while (choice5 != 0);
                                break;
                            case 14:
                                managerStaffFullTime.displayByStatusON();
                                break;
                        }
                    } while (choice2 != 0);
                    break;
                case 2:
                    int choice3;
                    do {
                        System.out.println("***********************************");
                        System.out.println("*        QUẢN LÝ TÀI KHOẢN        *");
                        System.out.println("* 1. Hiển thị tất cả tài khoản    *");
                        System.out.println("* 2. Thêm tài khoản               *");
                        System.out.println("* 3. Sửa tài khoản                *");
                        System.out.println("* 4. Xóa tài khoản                *");
                        System.out.println("* 5. Tìm kiếm tài khoản           *");
                        System.out.println("***********************************");
                        choice3 = scanner.nextInt();
                        switch (choice3) {
                            case 1:
                                managerAccount.displayAccount();
                                break;
                            case 2:
                                managerAccount.addAccount();
                                break;
                            case 3:
                                String userName1 = ValidateAccount.validateUser();
                                managerAccount.editAccount(userName1);
                                break;
                            case 4:
                                String userName2 = ValidateAccount.validateUser();
                                managerAccount.deleteAccountByName(userName2);
                                break;
                            case 5:
                                managerAccount.searchByName();
                                break;
                        }
                    } while ( choice3 != 0);
                    break;
                case 3:
                    return;
            }
        }
    }
}
