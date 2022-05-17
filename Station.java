import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Station {

	private String stationName;
	private int ID;
	private Gasoline[] gasolineArray;
	private Diesel[] dieselArray;
	private ArrayList<Service> serviceArray;
	private ArrayList<Personnel> personnelList;
	private ArrayList<Manager> managerList;

	private int gCounter = 0;
	private int dCounter = 0;
	private int sCounter = 0;

	private double averageGasolinePrice = 0;
	private double totalGasolineInStation = 0;

	private double averageDieselPrice = 0;
	private double totalDieselInStation = 0;

	public Station(String stationName, int ID) {
		this.stationName = stationName;
		this.ID = ID;
		gasolineArray = new Gasoline[10];
		dieselArray = new Diesel[10];
		serviceArray = new ArrayList<Service>();
		personnelList = new ArrayList<Personnel>();
		managerList = new ArrayList<Manager>();
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getAverageGasolinePrice() {
		return averageGasolinePrice;
	}

	public double getTotalGasolineInStation() {
		return totalGasolineInStation;
	}

	public void setTotalGasolineInStation(double totalGasolineInStation) {
		this.totalGasolineInStation = totalGasolineInStation;
	}

	public double getAverageDieselPrice() {
		return averageDieselPrice;
	}

	public double getTotalDieselInStation() {
		return totalDieselInStation;
	}

	public void setTotalDieselInStation(double totalDieselInStation) {
		this.totalDieselInStation = totalDieselInStation;
	}

	public void addToGasolineInventory(Gasoline gasoline) {
		gasolineArray[gCounter++] = gasoline;
	}

	public void addToDieselInventory(Diesel diesel) {
		dieselArray[dCounter++] = diesel;
	}

	public void addToServiceList(Service service) {
		serviceArray.add(service);
	}

	public void calculateAverageGasolinePrice() {
		double val = 0;
		for (Gasoline gasoline : gasolineArray) {
			if (gasoline != null)
				val += gasoline.getPricePerLiter() * gasoline.getTotalLiters();
		}
		this.averageGasolinePrice = val / getTotalGasolineInStation();
	}

	public void calculateTotalGasolineInStation() {
		double val = 0;
		for (Gasoline gasoline : gasolineArray) {
			if (gasoline != null)
				val += gasoline.getTotalLiters();
		}
		this.totalGasolineInStation = val;
	}

	public void calculateAverageDieselPrice() {
		double val = 0;
		for (Diesel diesel : dieselArray) {
			if (diesel != null)
				val += diesel.getPricePerLiter() * diesel.getTotalLiters();
		}
		this.averageDieselPrice = val / getTotalDieselInStation();
	}

	public void calculateTotalDieselInStation() {
		double val = 0;
		for (Diesel diesel : dieselArray) {
			if (diesel != null)
				val += diesel.getTotalLiters();
		}
		this.totalDieselInStation = val;
	}

	public static Station createStation() {
		Scanner sc = new Scanner(System.in);

		while (true) {

			try {
				System.out.print("Please enter the name of the Station: ");
				String name = sc.nextLine();
			} catch (InputMismatchException exception){
	
				System.err.print("Name must be a string.");
			}
				System.out.print("Please enter the Station ID: ");
				int ID = sc.nextInt();
				return new Station(name, ID);
	
			
		}

		
		
	}

	public static void findStationAndAddGasoline(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to search: ");
		int ID = sc.nextInt();
		System.out.println();
		boolean flag = false;
		for (Station station : stationArray) {
			if (station != null && station.getID() == ID) {
				Gasoline tmp = Gasoline.createGasoline();
				station.addToGasolineInventory(tmp);
				station.calculateTotalGasolineInStation();
				station.calculateAverageGasolinePrice();
				System.out.println();
				System.out.println("The total gasoline liters in Station #" + station.getID() + " is "
						+ station.getTotalGasolineInStation());
				System.out.println("The average gasoline price in Station #" + station.getID() + " is "
						+ station.getAverageGasolinePrice());
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("No station found with the given ID!");
		}
	}

	public static void findStationAndAddDiesel(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to search: ");
		int ID = sc.nextInt();
		System.out.println();
		boolean flag = false;
		for (Station station : stationArray) {
			if (station != null && station.getID() == ID) {
				Diesel tmp = Diesel.createDiesel();
				station.addToDieselInventory(tmp);
				station.calculateTotalDieselInStation();
				station.calculateAverageDieselPrice();
				System.out.println();
				System.out.println("The total diesel liters in Station #" + station.getID() + " is "
						+ station.getTotalDieselInStation());
				System.out.println("The average diesel price in Station #" + station.getID() + " is "
						+ station.getAverageDieselPrice());
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("No station found with the given ID!");
		}
	}

	public static void displayStationInventory(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to display: ");
		int ID = sc.nextInt();
		System.out.println();
		boolean flag = false;
		for (Station station : stationArray) {
			if (station != null && station.getID() == ID) {
				System.out.println("Displaying the inventory of Station #" + station.getID());
				for (Gasoline g : station.gasolineArray) {
					if (g != null)
						g.displayInfo();
				}
				System.out.println();
				System.out.println("The total gasoline liters in Station #" + station.getID() + " is "
						+ station.getTotalGasolineInStation());
				System.out.println("The average gasoline price in Station #" + station.getID() + " is "
						+ station.getAverageGasolinePrice());
				for (Diesel d : station.dieselArray) {
					if (d != null)
						d.displayInfo();
				}
				System.out.println();
				System.out.println("The total diesel liters in Station #" + station.getID() + " is "
						+ station.getTotalDieselInStation());
				System.out.println("The average diesel price in Station #" + station.getID() + " is "
						+ station.getAverageDieselPrice());
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("No station found with the given ID!");
		}
	}

	public static void sellGasoline(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to sell Gasoline: ");
		int ID = sc.nextInt();
		sc.nextLine();
		System.out.println();
		boolean flag = false;
		for (Station station : stationArray) {
			if (station != null && station.getID() == ID) {
				System.out.print("Please enter the car plate: ");
				String plate = sc.nextLine();
				System.out.print("Please enter the gasoline liter: ");
				double liter = sc.nextDouble();
				sc.nextLine();
				if (station.getTotalGasolineInStation() - liter >= 0) {
					System.out.print("Please enter if you have a coupon (y/n): ");
					boolean coupon = ("y".equalsIgnoreCase(sc.nextLine()) ? true : false);
					GasolineService gS = new GasolineService(plate, liter, coupon);
					gS.makeTransaction(station.averageGasolinePrice);
					station.setTotalGasolineInStation(station.getTotalGasolineInStation() - liter);
					station.addToServiceList(gS);
					Collections.shuffle(station.personnelList);
					station.personnelList.get(0).setJobCount(station.personnelList.get(0).getJobCount() + 1);
					System.out.println("Personnel helped during this service: ");
					System.out.print("Name: " + station.personnelList.get(0).getName() + "\nSurname: " + station.personnelList.get(0).getSurname() + "\n");
					flag = true;
					break;
				} else {
					System.out.println("Not enough gasoline in the station!");
				}
			}
		}
		if (!flag) {
			System.out.println("No station found with the given ID!");
		}
	}

	public static void sellDiesel(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to sell Diesel: ");
		int ID = sc.nextInt();
		sc.nextLine();
		System.out.println();
		boolean flag = false;
		for (Station station : stationArray) {
			if (station != null && station.getID() == ID) {
				System.out.print("Please enter the car plate: ");
				String plate = sc.nextLine();
				System.out.print("Please enter the diesel liter: ");
				double liter = sc.nextDouble();
				sc.nextLine();
				if (station.getTotalDieselInStation() - liter >= 0) {
					System.out.print("Please enter if you want discounted anti-freeze (y/n): ");
					boolean promotion = ("y".equalsIgnoreCase(sc.nextLine()) ? true : false);
					int count = 0;
					if (promotion) {
						System.out.print("Please enter how many anti-freeze you want: ");
						count = sc.nextInt();
						sc.nextLine();
					}
					DieselService dS = new DieselService(plate, liter, promotion, count);
					dS.makeTransaction(station.averageDieselPrice);
					station.setTotalDieselInStation(station.getTotalDieselInStation() - liter);
					station.addToServiceList(dS);
					Collections.shuffle(station.personnelList);
					station.personnelList.get(0).setJobCount(station.personnelList.get(0).getJobCount() + 1);
					System.out.println("Personnel helped during this service: ");
					System.out.print("Name: " + station.personnelList.get(0).getName() + "\nSurname: " + station.personnelList.get(0).getSurname() + "\n");
					flag = true;
					break;
				} else {
					System.out.println("Not enough diesel in the station!");
				}
			}
		}
		if (!flag) {
			System.out.println("No station found with the given ID!");
		}
	}

	public static void displayServices(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to display: ");
		int ID = sc.nextInt();
		System.out.println();
		boolean flag = false;
		for (Station station : stationArray) {
			if (station != null && station.getID() == ID) {
				System.out.println("Displaying the sold services of Station #" + station.getID());
				Collections.sort(station.serviceArray);
				for (Service s : station.serviceArray) {
					if (s != null) {
						s.displayServiceInfo();
					}
				}
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("No station found with the given ID!");
		}
	}

	public static void sellCarWash(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to sell car wash: ");
		int ID = sc.nextInt();
		System.out.println();
		boolean flag = false;
		for (Station station : stationArray) {
			if (station != null && station.getID() == ID) {
				System.out.print("Please enter the car plate: ");
				sc.nextLine();
				String carPlate = sc.nextLine();
				CarWash carWash = new CarWash(carPlate);
				carWash.makeTransaction(10);
				station.serviceArray.add(carWash);
				Collections.shuffle(station.personnelList);
				station.personnelList.get(0).setJobCount(station.personnelList.get(0).getJobCount() + 1);
				System.out.println("Personnel helped during this service: ");
				System.out.print("Name: " + station.personnelList.get(0).getName() + "\nSurname: " + station.personnelList.get(0).getSurname() + "\n");
			flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("No station found with the given ID!");
		}
	}

    public static void addPerson(Station[] stationArray) {

		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add a personnel\n2. Add a manager");
		int pmChoice = sc.nextInt();
		System.out.print("Please enter the ID of the Station you want to add a person: ");
		int ID = sc.nextInt();
		System.out.println();
		boolean flag = false;
		for (Station station : stationArray) {
			if (station != null && station.getID() == ID && pmChoice == 1) {
				System.out.print("Please enter a name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Please enter a surname: ");
				String surname = sc.nextLine();
				Personnel personnel = new Personnel(name, surname);
				station.personnelList.add(personnel);
				flag = true;
				break;
			}
			if (station != null && station.getID() == ID && pmChoice == 2) {
				System.out.print("Please enter a name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Please enter a surname: ");
				String surname = sc.nextLine();
				System.out.print("Please enter how many years the manager is working: ");
				int jobYear = sc.nextInt();
				Manager manager = new Manager(name, surname, jobYear);
				station.managerList.add(manager);
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("No station found with the given ID!");
		}
    }

    public static void calculateNetProfit(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to calculate net profit: ");
		int ID = sc.nextInt();
		System.out.println();
		double profit = 0;
		for (Station station : stationArray) {
			if (station != null && station.getID() == ID) {
				for (Personnel personnel : station.personnelList) {
					System.out.print("Person: " + personnel.calculate() + ("\n"));
					profit += personnel.calculate();
				}
				for (Manager manager : station.managerList) {
					System.out.print("Person: " + manager.calculate() + ("\n"));
					profit += manager.calculate();
				}
				for (Service service : station.serviceArray) {
					System.out.print("Service: " + service.calculate() + ("\n"));
					profit += service.calculate();
				}
				System.out.print("Net profit of station is: " + profit + "\n");
				break;
			}
			
		}
    }

	public static void displayServices2(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the ID of the Station you want to display: ");
		int ID = sc.nextInt();
		System.out.println();
		boolean flag = false;
		for (Station station : stationArray) {
			if (station != null && station.getID() == ID) {
				System.out.println("Displaying the sold services of Station #" + station.getID());
				station.serviceArray.sort(Comparator.naturalOrder());  
				for (Service s : station.serviceArray) {
					if (s != null) {
						s.displayServiceInfo();
					}
				}
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("No station found with the given ID!");
		}
	}
}
