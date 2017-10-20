package lommeregner.logic;

public class Acos implements UnaryOperator{
	private double a;

	public void setA(double a) {
		this.a = a;
	}

	public double getValue() {
		return Math.toDegrees(Math.acos(a));
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