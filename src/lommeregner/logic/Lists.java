package lommeregner.logic;

import java.util.ArrayList;

public class Lists {
	Character[] check = { '*', '/', '-', '+', '(', ')' };

	public void operators(String input, ArrayList<String> inputArrayList) {
		if (input.contains("=")) {
			String[] s = input.split(
					"(?<=\\+)|(?=\\+)|(?=\\*)|(?<=\\*)|(?=\\/)|(?<=\\/)|(?=\\-)|(?<=\\-)|(?=\\()|(?<=\\()|(?=\\))|(?<=\\))|=|(?=Sin��)|(?<=Sin��)");
			for (String g : s) {
				inputArrayList.add(g);
			}
		}

	}

}
