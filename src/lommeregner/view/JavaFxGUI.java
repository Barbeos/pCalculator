package lommeregner.view;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import lommeregner.logic.BinaryOperator;
import lommeregner.logic.Controller;
import lommeregner.logic.*;

public class JavaFxGUI extends Application implements EventHandler<ActionEvent> {
	// display skabes som textfield udenfor "start" because reasons
	TextField display = new TextField();
	TextField secondDisplay = new TextField();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Lommeregner");

		// Grid skabes og styles
		GridPane grid = new GridPane();
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(20, 20, 20, 20));
		//grid.setGridLinesVisible(true);

		// Displayet styles
		display.setPrefSize(0, 50);
		grid.add(display, 0, 1, 6, 1);
		display.setAlignment(Pos.CENTER_RIGHT);
		display.setStyle("-fx-base: white");
		display.setFont(Font.font("Batang", FontWeight.NORMAL, 30));
		//display.setEditable(false);

		// Andet Display laves og styles
		secondDisplay.setPrefSize(0, 30);
		grid.add(secondDisplay, 0, 0, 6, 1);
		secondDisplay.setAlignment(Pos.CENTER_RIGHT);
		secondDisplay.setStyle("-fx-base: #4b4345");
		secondDisplay.setFont(Font.font("Batang", FontWeight.NORMAL, 20));
		secondDisplay.setEditable(false);

		// Knapper med tallene 0-9 skabes, styles og tilføjes til array "numbers"
		ArrayList<Button> numbers = new ArrayList<Button>();
		for (int x = 0; x < 10; x++) {
			numbers.add(new Button("" + x));
			numbers.get(x).setFont(Font.font("Berlin sans fb", FontWeight.NORMAL, 35));
			numbers.get(x).setStyle("-fx-base: #2d4262");
			numbers.get(x).setPrefSize(80, 80);
			numbers.get(x).setOnAction(this);
		}

		// andre knapper skabes og tilføjes til arrayet "otherButts"
		ArrayList<Button> otherButts = new ArrayList<Button>();
		Button ce = new Button("CE");
		otherButts.add(ce);
		Button s = new Button("(");
		otherButts.add(s);
		Button pi = new Button(")");
		otherButts.add(pi);
		Button iAnden = new Button("x²");
		otherButts.add(iAnden);
		Button sqrt = new Button("√x");
		otherButts.add(sqrt);
		Button divider = new Button("/");
		otherButts.add(divider);
		Button sin = new Button("Sin");
		otherButts.add(sin);
		Button arcSin = new Button("Sin¯¹");
		otherButts.add(arcSin);
		Button gange = new Button("*");
		otherButts.add(gange);
		Button cos = new Button("Cos");
		otherButts.add(cos);
		Button arcCos = new Button("Cos¯¹");
		otherButts.add(arcCos);
		Button minus = new Button("-");
		otherButts.add(minus);
		Button tan = new Button("Tan");
		otherButts.add(tan);
		Button arcTan = new Button("Tan¯¹");
		otherButts.add(arcTan);
		Button plusMinus = new Button("±");
		otherButts.add(plusMinus);
		Button komma = new Button(".");
		otherButts.add(komma);

		// knapperne i arrayet "otherButts" styles
		for (Button z : otherButts) {
			z.setPrefSize(80, 80);
			z.setStyle("-fx-base: #2d4262");
			z.setFont(Font.font("Calibri", FontWeight.NORMAL, 22));
			z.setOnAction(this);

		}
		minus.setFont(Font.font("Calibri", FontWeight.NORMAL, 40));
		plusMinus.setFont(Font.font("Calibri", FontWeight.NORMAL, 40));
		komma.setFont(Font.font("Calibri", FontWeight.NORMAL, 40));

		// = og + knapperne skabes og styles
		Button ligMed = new Button("=");
		Button plus = new Button("+");

		ligMed.setPrefSize(165, 80);
		ligMed.setStyle("-fx-base: #2d4262");
		ligMed.setFont(Font.font("Calibri", FontWeight.NORMAL, 30));
		ligMed.setOnAction(this);
		plus.setPrefSize(80, 165);
		plus.setStyle("-fx-base: #2d4262");
		plus.setFont(Font.font("Calibri", FontWeight.NORMAL, 40));
		plus.setOnAction(this);
		// knapper (otherButts, +, =) tilføjes til grid
		grid.add(ce, 0, 2);
		grid.add(s, 1, 2);
		grid.add(pi, 2, 2);
		grid.add(iAnden, 3, 2);
		grid.add(sqrt, 4, 2);
		grid.add(divider, 5, 2);
		grid.add(sin, 3, 3);
		grid.add(arcSin, 4, 3);
		grid.add(gange, 5, 3);
		grid.add(cos, 3, 4);
		grid.add(arcCos, 4, 4);
		grid.add(minus, 5, 4);
		grid.add(tan, 3, 5);
		grid.add(arcTan, 4, 5);
		grid.add(plusMinus, 0, 6);
		grid.add(komma, 2, 6);
		grid.add(plus, 5, 5, 1, 2);
		grid.add(ligMed, 3, 6, 3, 1);

		// knapper 1-9 tilføjes til grid
		int index = 9;
		for (int y = 3; y < 6; y++) {
			for (int x = 2; x >= 0; x--) {

				grid.add(numbers.get(index), x, y);
				index -= 1;
			}
		}

		// knap 0 tilføjes til grid
		grid.add(numbers.get(0), 1, 6);

		// scenen instantieres, styles og vises
		Scene scene = new Scene(grid);
		grid.setStyle("-fx-base: cornflowerblue");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	Controller controller = new Controller();

	// eventhandling
	@Override
	public void handle(ActionEvent e) {
		Object obj = e.getSource();
		Button button = (Button) obj;
		String text = button.getText();

		display.setText(display.getText() + text);
		
		
		String result = controller.con(display.getText());
		
		if(text.equals("=")) {
			display.setText(display.getText().concat(result));
			System.out.println("settext"+ result);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}