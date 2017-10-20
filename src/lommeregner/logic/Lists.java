package lommeregner.logic;

import java.util.ArrayList;

public class Lists {
	Character[] check = { '*', '/', '-', '+', '(', ')' };
	

	public void operators(String input, ArrayList<String> inputArrayList) {
		
		if (input.contains("=")) {
			String number = "";
			for (Character i : input.toCharArray()) {
				number +=  "" + i;
				for (Character c : check) {
					
					if (c == i) {
						inputArrayList.add(i.toString());
						number = "";
					}
				}
				if(isInt(number)) {
					inputArrayList.add(number);
				}else {
					number = "";
				}
			}
		}
	}
	
	public boolean isInt(String i) {
		try {
			Integer.valueOf(i);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
		
	}
}
