package Regex;

import java.util.Scanner;

public class ValidateStaff {

    static Scanner scanner = new Scanner(System.in);

    public static String validatePhoneNumber() {
        String phone;
        String regex = "^(0|\\+84)(\\s|\\.)?(\\d{9,11}+)$";
        while (true) {
            System.out.println("Input PhoneNumber");
            try {
                phone = scanner.nextLine();
                if (phone.matches(regex)) {
                    break;
                } else {
                    System.err.println("☠☠ Mời nhập lại ☠☠");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return phone;
    }

    public static String validateEmail() {
        String email;
        String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        while (true) {
            System.out.println("Input Email");
            try {
                email = scanner.nextLine();
                if (email.matches(regex)) {
                    break;
                } else {
                    System.err.println("☠☠ Email sai định dạng ☠☠");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return email;
    }
}
