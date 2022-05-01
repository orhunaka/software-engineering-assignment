public class Personnel extends Person {
    
    private int jobCount;

    public Personnel(String name, String surname) {
    }

    public void setJobCount(int jobCount) {
        this.jobCount = jobCount;
    }

    public int getJobCount() {
        return jobCount;
    }

    public void incJobCount() {
        
    }

    @Override
	public double calculate() {
		return -(getSalary() + 200 + (jobCount * 50));
	}
}
