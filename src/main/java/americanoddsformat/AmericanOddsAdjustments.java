package americanoddsformat;
public class AmericanOddsAdjustments {
	public static int slide(final int price, int adjustment) {
		int newPrice = price;
		if (price >= 100) {
			int reminder = price - 100;
			newPrice = 0 - (adjustment - reminder);
		} else {
			newPrice = price - adjustment;

		}

		return newPrice;
	}

	public static int slideAll(final int price, int adjustment) {
		int newPrice = price;
		if (price >= 100) {
			int reminder = price - 100;
			newPrice = 0 - (adjustment - reminder);
		} else if (price < -100) {
			newPrice = price - adjustment;
		} else if (price > 0) {

		}

		return newPrice;
	}

	public static void main(String[] args) {

		int price = -110;
		int adjustment = 50;
		System.out.println(String.format(
				"price[%d] adjustment[%d] newprice[%d]", price, adjustment,
				slide(price, adjustment)));

		price = 110;
		adjustment = 50;
		System.out.println(String.format(
				"price[%d] adjustment[%d] newprice[%d]", price, adjustment,
				slide(price, adjustment)));

		price = 120;
		adjustment = 100;
		System.out.println(String.format(
				"price[%d] adjustment[%d] newprice[%d]", price, adjustment,
				slide(price, adjustment)));

		price = 100;
		adjustment = 100;
		System.out.println(String.format(
				"price[%d] adjustment[%d] newprice[%d]", price, adjustment,
				slide(price, adjustment)));

		price = 80;
		adjustment = 100;
		System.out.println(String.format(
				"price[%d] adjustment[%d] newprice[%d]", price, adjustment,
				slide(price, adjustment)));
	}

}
