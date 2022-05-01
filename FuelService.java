
public class FuelService extends Service {

	private double litersBought;

	public FuelService(String carPlate, double litersBought) {
		super(carPlate);
		this.litersBought = litersBought;
	}

	@Override
	public void displayServiceInfo() {
		System.out.println("Bought " + litersBought + " liters.");
		super.displayServiceInfo();
	}

	public double getLitersBought() {
		return litersBought;
	}

	@Override
	public void makeTransaction(double value) {
		super.makeTransaction(value);
	}

}
