public class Manager extends Person {
    
    public int jobYear;

    public Manager(String name, String surname) {
    }

    @Override
	public double calculate() {
		return -(getSalary() + (jobYear * 1.5));
	}
    
}
