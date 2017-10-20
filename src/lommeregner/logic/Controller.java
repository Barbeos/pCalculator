package lommeregner.logic;

import java.util.ArrayList;

import javafx.scene.control.TextField;;

public class Controller {

	Lists l = new Lists();
	Calc c = new Calc();

	public String con(String inputString) {

		ArrayList<Input> operators = new ArrayList<Input>();
		ArrayList<String> inputArrayList = new ArrayList<String>();

		if (inputString.contains("=")) {
			l.operators(inputString, inputArrayList);
			System.out.println(inputArrayList + "before");
			if(inputString.contains("(")&&inputString.contains(")")) {
			c.pCalc(operators, inputArrayList);
			System.out.println(inputArrayList + "after");
			}else if(inputString.contains("(") && !inputString.contains(")")||!inputString.contains("(") && inputString.contains(")")) {
				return "not valid input";
			}
			System.out.println(inputArrayList);
			
			c.calcUP(operators, inputArrayList);
			System.out.println(inputArrayList);
			return inputArrayList.get(0);
		}
		return "";
	}
	
	// 3+(4-5*2)+3-(3+4+(5*3)+3)-3
}
