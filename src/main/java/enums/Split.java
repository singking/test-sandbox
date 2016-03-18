package enums;

public class Split {
	public static void main(String[] args) {
		String s = "SPORT;SPO;SPB;33866643;;33866643;492705620;;;;EUR;2013-12-10 19:55:18,000;CLOSE;C;0";
		System.out.println(s.split(";").length);
	}
}
