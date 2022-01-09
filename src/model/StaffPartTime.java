package model;

public class StaffPartTime extends Staff{
    private int workingHour;
    private double hourSalary;

    public StaffPartTime(int id, String name, int age, String gender, String address, String numberPhone, String email, String status, int workingHour, double hourSalary) {
        super(id, name, age, gender, address, numberPhone, email, status);
        this.workingHour = workingHour;
        this.hourSalary = hourSalary;
    }

    public int getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    public double getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(double hourSalary) {
        this.hourSalary = hourSalary;
    }

    public double salaryPartTime() {
        return workingHour * hourSalary;
    }

    @Override
    public String toString() {
        return "StaffPartTime" + super.toString();
    }
}
