package application;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class MenuItem extends StackPane {
	MenuItem(String name) {
		LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.GREEN),
				new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK), new Stop(1, Color.GREEN));

		Rectangle bg = new Rectangle(175, 40);
		bg.setOpacity(0.4);

		Text text = new Text(name);
		text.setFill(Color.WHITE);
		text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 22));

		setAlignment(Pos.CENTER);
		getChildren().addAll(bg, text);

		setOnMouseEntered(event -> {
			bg.setFill(gradient);
			text.setFill(Color.WHITE);
		});

		setOnMouseExited(event -> {
			bg.setFill(Color.BLACK);
			text.setFill(Color.WHITE);
		});

		setOnMousePressed(event -> {
			bg.setFill(Color.GREEN);
		});

		setOnMouseReleased(event -> {
			bg.setFill(gradient);
		});
	}
}

