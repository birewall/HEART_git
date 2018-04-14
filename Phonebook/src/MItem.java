
public class MItem {
	public static enum Menu{
		Americano,
		Capuccino,
		Latte,
		Caffemocca
	}
	
	private String name;
	private int raw_price;
	private int price;
	private double profit_rate;
	
	public MItem(Menu menu) {
		switch(menu) {
		case Americano:
			name = "Americano";
			price = 2000;
			raw_price = 600;
			profit_rate = 0.2;
		case Capuccino:
			name = "Capuccino";
			price = 2500;
			raw_price = 1300;
			profit_rate = 0.15;
		case Latte:
			name = "Latte";
			price = 2500;
			raw_price = 1300;
			profit_rate = 0.15;
		case Caffemocca:
			name = "Caffemocca";
			price = 3000;
			raw_price = 1400;
			profit_rate = 0.25;
		default:
			name = "Null";
			price = 0;
			raw_price = 0;
			profit_rate = 0;	
		}
	}

	public String getName() {
		return name;
	}

	public int getRaw_price() {
		return raw_price;
	}

	public int getPrice() {
		return price;
	}

	public double getProfit_rate() {
		return profit_rate;
	}	
}
