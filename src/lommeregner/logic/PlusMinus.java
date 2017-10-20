package lommeregner.logic;

public class PlusMinus implements UnaryOperator {
	private double a;

	public void setA(double a) {
		this.a = a;
	}

	public double getValue() {
		return a * -1;
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
