package lommeregner.logic;

public class Sqrt implements UnaryOperator{
	private double a;

	public void setA(double a) {
		this.a = a;
	}

	public double getValue() {
		return Math.sqrt(a);
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
