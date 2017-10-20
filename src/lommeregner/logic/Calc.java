package lommeregner.logic;

import java.util.ArrayList;

public class Calc {

	public void pCalc(ArrayList<Input> operators, ArrayList<String> inputArrayList) {

		while (inputArrayList.contains(")")) {
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
						int index = inputArrayListTemp.indexOf("*");
						operators.add(new Gange());
						dos(operators, inputArrayListTemp, index);
					}
					while (inputArrayListTemp.contains("/")) {
						int index = inputArrayListTemp.indexOf("/");
						operators.add(new Divider());
						dos(operators, inputArrayListTemp, index);
					}
					while (inputArrayListTemp.contains("-")) {
						int index = inputArrayListTemp.indexOf("-");
						operators.add(new Minus());
						dos(operators, inputArrayListTemp, index);
					}
					while (inputArrayListTemp.contains("+")) {
						int index = inputArrayListTemp.indexOf("+");
						operators.add(new Plus());
						dos(operators, inputArrayListTemp, index);
					}

					inputArrayList.subList(left, right + 1).clear();
					inputArrayList.add(left, inputArrayListTemp.get(0));
				}
			}
		}
	}
	
	
	public void calcUP(ArrayList<Input> operators, ArrayList<String> inputArrayList) {
		while (inputArrayList.contains("*")) {
			int index = inputArrayList.indexOf("*");
			operators.add(new Gange());
			dos(operators, inputArrayList, index);
		}
		while (inputArrayList.contains("/")) {
			int index = inputArrayList.indexOf("/");
			operators.add(new Divider());
			dos(operators, inputArrayList, index);
		}
		while (inputArrayList.contains("-")) {
			int index = inputArrayList.indexOf("-");
			operators.add(new Minus());
			dos(operators, inputArrayList, index);
		}
		while (inputArrayList.contains("+")) {
			int index = inputArrayList.indexOf("+");
			operators.add(new Plus());
			dos(operators, inputArrayList, index);
		}
		
	}
	
	public void dos(ArrayList<Input> operators, ArrayList<String> inputArrayListTemp, int index) {
		BinaryOperator g = (BinaryOperator) operators.get(0);
		g.setA(Double.valueOf(inputArrayListTemp.get(index - 1)));
		g.setB(Double.valueOf(inputArrayListTemp.get(index + 1)));
		inputArrayListTemp.subList(index - 1, index + 2).clear();
		inputArrayListTemp.add(index - 1, String.valueOf(g.getValue()));
		operators.remove(0);
	}
}
