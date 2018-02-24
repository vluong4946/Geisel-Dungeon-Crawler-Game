import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Dungeon extends Application{

	private Pane root;
	
	private Parent createContent() {
		root = new Pane();
		root.setPrefSize(800, 600);
		human = initHuman();
		root.getChildren().add(human);
		return root;
	}
	
	private Node human;
	
	private Node initHuman(){
		Rectangle rectangle = new Rectangle(5, 10, Color.BLACK);
		rectangle.setTranslateY(600 - 10);
		rectangle.setTranslateX(0);
		return rectangle;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
		
		primaryStage.getScene().setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case W:
				human.setTranslateY(human.getTranslateY()-5);
				break;
			case S:
				human.setTranslateY(human.getTranslateY()+5);
				break;
			case A:
				human.setTranslateX(human.getTranslateX()-5);
				break;
			case D:
				human.setTranslateX(human.getTranslateX()+5);
				break;
			default:
				break;
			}
		});
		
	}

	public static void main(String[] args) {
		launch(args);
	}	
	
}