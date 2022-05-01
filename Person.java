public class Person implements Profitable{
    
    private String name;
    private String surname;
    private double salary = 100;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void displayInformation() {
        
    }

    @Override
    public double calculate() {
        return 0;
    }
}
