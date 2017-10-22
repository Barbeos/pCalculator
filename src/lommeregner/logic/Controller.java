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
			if(inputString.contains("(")&&inputString.contains(")")) {
			c.pCalc(operators, inputArrayList);
			}else if(inputString.contains("(") && !inputString.contains(")")||!inputString.contains("(") && inputString.contains(")")) {
				return "not valid input";
			}
			
			c.calcUP(operators, inputArrayList);
			return inputArrayList.get(0);
		}
		return "";
	}
	
	// 3+(4-5*2)+3-(3+4+(5*3)+3)-3
}
