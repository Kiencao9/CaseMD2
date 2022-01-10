package model;


public class StaffFullTime extends Staff {
    private int workingDay;
    private double dailySalary;



    public StaffFullTime(int id, String name, int age, String gender, String address, String numberPhone, String email, String status, int workingDay, double dailySalary) {
        super(id, name, age, gender, address, numberPhone, email, status);
        this.workingDay = workingDay;
        this.dailySalary = dailySalary;
    }



    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    public double getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(double dailySalary) {
        this.dailySalary = dailySalary;
    }

    public double getPayFullTime() {
        return getPayFullTime();
    }

    @Override
    public String toString() {
        return "StaffFullTime| " + super.toString();
    }
}
