package manager;

import Regex.ValidateAccount;
import io.IOFile;
import model.Account;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAccount {
    private final String PATHNAME_ACCOUNT = "src/io/account.txt";
    public static ArrayList<Account> accounts;
    private final Scanner scanner = new Scanner(System.in);
    private final IOFile<Account> ioFile = new IOFile<>();


    public ManagerAccount() {
        if (new File(PATHNAME_ACCOUNT).length() == 0) {
            this.accounts = new ArrayList<>();
        } else {
            this.accounts = ioFile.readFileData(PATHNAME_ACCOUNT);
        }
    }

    public void displayAccount() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void addAccount() {
        String userName = ValidateAccount.validateUser();
        String passWord = ValidateAccount.validatePass();
        Account account = new Account(userName, passWord);
        accounts.add(account);
        ioFile.writerFileData(accounts, PATHNAME_ACCOUNT);
    }

    public void deleteAccountByName(String userName) {
        Account account = null;
        for (Account account1 : accounts) {
            if (account1.getUserName().equals(userName)) {
                account = account1;
            }
        }
        if (account != null) {
            accounts.remove(account);
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tìm thấy tài khoản này");
        }
    }

    public void editAccount(String user) {
        Account editAcc = null;
        for (Account acc : accounts) {
            if (acc.getUserName().equals(user)) {
                editAcc = acc;
            }
        }
        if (editAcc != null) {
            String userName = ValidateAccount.validateUser();
            editAcc.setUserName(userName);
            String passWord = ValidateAccount.validatePass();
            editAcc.setPassWord(passWord);
            ioFile.writerFileData(accounts, PATHNAME_ACCOUNT);
        } else {
            System.err.println("Tên tài khoản không tồn tại");
        }
    }

    public void searchByName() {
        System.out.println("Nhập tên tài khoản muốn tìm");
        String userName = ValidateAccount.validateUser();
        for (Account acc : accounts) {
            if(acc.getUserName().equals(userName)) {
                System.out.println(acc);
            }
        }
    }

    public boolean login(Account account) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(account.getUserName()) && acc.getPassWord().equals(account.getPassWord())) {
                return true;
            }
        }
        return false;
    }




    public boolean loginAdmin(Account account) {
        if ("kien01".equals(account.getUserName()) && "1234567".equals(account.getPassWord())) {
            return true;
        } else if ("kien02".equals(account.getUserName()) && "12345678".equals(account.getPassWord())) {
            return true;
        }
        return false;
    }

    public Account createAccount() {
        System.out.println("Nhập UserName");
        String userName = scanner.nextLine();
        System.out.println("Nhập PassWord");
        String passWord = scanner.nextLine();
        return new Account(userName, passWord);
    }



}
