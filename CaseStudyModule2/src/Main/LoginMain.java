package Main;

import manager.ManagerAccount;
import model.Account;

import java.util.Scanner;

public class LoginMain {
    public static void mainLogin() {
        while (true) {
            ManagerAccount managerAccount = new ManagerAccount();
            Scanner scanner = new Scanner(System.in);
            System.out.println("***************************");
            System.out.println("*     1. Đăng Nhập        *");
            System.out.println("*     2. Đăng Ký          *");
            System.out.println("***************************");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice !=1 && choice != 2) {
                    System.err.println("Vui lòng nhập lại");
                }
            } catch (Exception e) {
                System.err.println("Vui lòng nhập lại");
            }
                switch (choice) {
                    case 1:
                        Account account = managerAccount.createAccount();
                        if (managerAccount.login(account)) {
                            StaffMain.staffMain();
                            break;
                        }
                        if (managerAccount.loginAdmin(account)) {
                            AdminMain.mainAccount();
                            break;
                        }
                        break;
                    case 2:
                        managerAccount.addAccount();
            }
        }
    }
}
