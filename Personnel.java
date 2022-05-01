public class Personnel extends Person {
    
    private int jobCount = 0;

    public Personnel(String name, String surname) {
        this.setName(name);
        this.setSurname(surname);
    }

    public void setJobCount(int jobCount) {
        this.jobCount = jobCount;
    }

    public int getJobCount() {
        return jobCount;
    }

    public void incJobCount() {
        jobCount = jobCount + 1;
    }

    @Override
	public double calculate() {
		return -(getSalary() + jobCount * 1.5);
	}
}
