
public enum MenuItem {

	M1("1. Create a new station"), M2("2. Add gasoline to a station inventory"),
	M3("3. Add diesel to a station inventory"), M4("4. Display a station inventory"),
	M5("5. Sell gasoline to customer"), M6("6. Sell diesel to customer"), M7("7. Sell car wash"),
	M8("8. Display sold services so far"), M9("9. Add personnel/manager to a station"), M10("10. Calculate net profit to a station"), M11("11. Display sold services"), M12("0. Exit");

	private String menuString;

	private MenuItem(String menuString) {
		this.menuString = menuString;
	}

	public String getMenuString() {
		return menuString;
	}

	public static void printMenu() {
		for (MenuItem item : MenuItem.values()) {
			System.out.println(item.getMenuString());
		}
	}

}
