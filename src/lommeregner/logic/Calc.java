package lommeregner.logic;

import java.util.ArrayList;

public class Calc {

	public void pCalc(ArrayList<Input> operators, ArrayList<String> inputArrayList) {
		// While løkken håndtere parenteser i udregningen
		while (inputArrayList.contains("(")) {
			int left = 0;
			int right= 0;
			for (int x = 0; x < inputArrayList.size(); x++) {
				ArrayList<String> inputArrayListTemp = new ArrayList<String>();
				
				if (inputArrayList.get(x).equals("(")) {
					left = x;
				}
				if (inputArrayList.get(x).equals(")")) {
					right = x;
					
					inputArrayListTemp.addAll(inputArrayList.subList(left+ 1, right));

					while (inputArrayListTemp.contains("*")) {
						operators.add(new Gange());
						dos(operators, inputArrayListTemp, "*");
					}
					while (inputArrayListTemp.contains("/")) {
						operators.add(new Divider());
						dos(operators, inputArrayListTemp, "/");
					}
					while (inputArrayListTemp.contains("-")) {
						operators.add(new Minus());
						dos(operators, inputArrayListTemp, "-");
					}
					while (inputArrayListTemp.contains("+")) {
						operators.add(new Plus());
						dos(operators, inputArrayListTemp, "+");
					}

					inputArrayList.subList(left, right + 1).clear();
					inputArrayList.add(left, inputArrayListTemp.get(0));
				}
			}
		}
	}
	
	//her regner vi uden parenteser
	public void calcUP(ArrayList<Input> operators, ArrayList<String> inputArrayList) {
		while (inputArrayList.contains("*")) {
			operators.add(new Gange());
			dos(operators, inputArrayList, "*");
		}
		while (inputArrayList.contains("/")) {
			operators.add(new Divider());
			dos(operators, inputArrayList, "/");
		}
		while (inputArrayList.contains("-")) {
			operators.add(new Minus());
			dos(operators, inputArrayList, "-");
		}
		while (inputArrayList.contains("+")) {
			operators.add(new Plus());
			dos(operators, inputArrayList, "+");
		}
	}
	
	public void dos(ArrayList<Input> operators, ArrayList<String> inputArrayListTemp, String operator) {
		int index = inputArrayListTemp.indexOf(operator);
		BinaryOperator g = (BinaryOperator) operators.get(0);
		g.setA(Double.valueOf(inputArrayListTemp.get(index - 1)));
		g.setB(Double.valueOf(inputArrayListTemp.get(index + 1)));
		inputArrayListTemp.subList(index - 1, index + 2).clear();
		inputArrayListTemp.add(index - 1, String.valueOf(g.getValue()));
		operators.remove(0);
	}
}
