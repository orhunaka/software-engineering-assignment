
public class GasolineService extends FuelService {

	private boolean hasCoupon = false;

	public GasolineService(String carPlate, double litersBought, boolean hasCoupon) {
		super(carPlate, litersBought);
		this.hasCoupon = hasCoupon;
	}

	@Override
	public void displayServiceInfo() {
		System.out.println();
		System.out.println("Gasoline Service...");
		super.displayServiceInfo();
		if (hasCoupon)
			System.out.println("Has 10% discount coupon");
	}

	@Override
	public void makeTransaction(double value) {
		if (hasCoupon)
			super.makeTransaction(value * getLitersBought() * 0.9);
		else
			super.makeTransaction(value * getLitersBought());
	}

}
