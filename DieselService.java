
public class DieselService extends FuelService {

	private final static double ANTIFREEZEPRICE = 25;

	private boolean discountedAntiFreeze = false;
	private int discountedAntiFreezeCount = 0;

	public DieselService(String carPlate, double litersBought, boolean discountedAntiFreeze,
			int discountedAntiFreezeCount) {
		super(carPlate, litersBought);
		this.discountedAntiFreeze = discountedAntiFreeze;
		this.discountedAntiFreezeCount = discountedAntiFreezeCount;
	}

	@Override
	public void displayServiceInfo() {
		System.out.println();
		System.out.println("Diesel Service...");
		super.displayServiceInfo();
		if (discountedAntiFreeze)
			System.out.println("Bought " + discountedAntiFreezeCount + " discounted anti-freeze.");
	}

	@Override
	public void makeTransaction(double value) {
		if (discountedAntiFreeze)
			super.makeTransaction(value * getLitersBought() + ANTIFREEZEPRICE * discountedAntiFreezeCount);
		else
			super.makeTransaction(value * getLitersBought());
	}

}
