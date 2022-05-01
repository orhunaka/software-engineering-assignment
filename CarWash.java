public class CarWash extends Service {
    
    public static final double basePrice = 10;

    public CarWash(String carPlate) {
        super(carPlate);
    }

    public void displayServiceInfo() {
		System.out.println();
		System.out.println("Car Wash Service...");
        super.displayServiceInfo();
	}

    @Override
	public double calculate() {
		return getRevenue();
	}
}
