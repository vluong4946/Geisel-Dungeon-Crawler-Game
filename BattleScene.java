import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;
import java.io.*;

public class BattleScene{
	
	//fields
	static StackPane battleStack;
	static Scene battle;
	
	Button win = new Button("Defeat Enemy");
	
	public static Scene battleStart(){
		Button win = new Button("Defeat Enemy");
		battleStack = new StackPane();

		win.setOnAction(e -> GameGui.window.setScene(GameGui.scene));
		battleStack.getChildren().addAll(win);
		battle = new Scene(battleStack,600,300);

		return battle;
	}
}