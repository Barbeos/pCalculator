package lommeregner.logic;

public interface UnaryOperator extends Input {
public void setA(double a);
public int getPrecedence();
public boolean isReady();
}
