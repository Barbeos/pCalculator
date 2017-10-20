package lommeregner.logic;

public class Cosinus implements UnaryOperator {
	private double a;

	public void setA(double a) {
		this.a = a;
	}

	public double getValue() {
		return Math.cos(Math.toRadians(a));
	}
	@Override
	public int getPrecedence() {
		return 0;
	}

	@Override
	public boolean isReady() {
		return false;
	}
}

