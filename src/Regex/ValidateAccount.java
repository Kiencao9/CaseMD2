package Regex;

import java.util.Scanner;

public class ValidateAccount {
    static Scanner scanner = new Scanner(System.in);
    public static String validateUser(){
        String userName;
        while (true){
            System.out.println("Nhập Tài KHoản");
            try {
                userName = scanner.nextLine();
                if (userName.matches("^[a-zA-Z0-9]+$")){
                    break;
                }else {
                    System.err.println("☠☠ Tài khoản chỉ bao gồm chữ hoa chữ thường và số ☠☠");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return userName;
    }
    public static String validatePass(){
        String passWord;
        while (true){
            System.out.println("Nhập Pass");
            try {
                passWord = scanner.nextLine();
                if (passWord.matches("^[a-zA-Z0-9]+$")){
                    break;
                } else {
                    System.err.println("☠☠ Mật khẩu chỉ bao gồm chữ hoa chữ thường và số ☠☠");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return passWord;
    }
}
