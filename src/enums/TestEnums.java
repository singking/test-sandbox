package enums;

public class TestEnums {

	enum DenySameGameRestriction {
		NO, // no restrictions apply
		MAINPERIOD, // restrictions apply to main periods only
		ALLPERIODS // restrictions apply to all periods
	}

	public static void main(String[] args) {
		try {
			DenySameGameRestriction.valueOf("2");
		} catch (IllegalArgumentException e) {
			
			String denyValues = "";
			for (DenySameGameRestriction denyValue : DenySameGameRestriction.values()){
				denyValues += denyValue + " ";
				System.out.println("enum value: "+denyValues);
			}
		
			System.out.println("bad enum value. Should be either: " + DenySameGameRestriction.values().toString());
			System.out.println("bad enum value. Should be either: " + denyValues);
		}
		
		try {
			DenySameGameRestriction.valueOf("MAINPERIOD");
			System.out.println("good enum value ");
		} catch (IllegalArgumentException e) {
			System.out.println("bad enum value: ");
		}
	}
}
