public class Manager extends Person {
    
    public int jobYear;

    public Manager(String name, String surname, int jobYear) {
        this.setName(name);
        this.setSurname(surname);
        this.jobYear = jobYear;
    }

    @Override
	public double calculate() {
		return -(getSalary() + 200 + jobYear * 50);
	}
    
}
