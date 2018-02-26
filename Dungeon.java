import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;




public class Dungeon extends Application{

int[][] arena = ArenaArray.createArenaArray();
	
	private ArrayList<Shape> nodes;
	
	private Parent createContent() {
		nodes = new ArrayList<>();
		GridPane root = new GridPane();
		root.setPrefSize(1500, 1000);
		human = initHuman();
		
		
		for (int x = 0; x < arena.length; x++){
		    for (int y = 0; y < arena[x].length; y++){
		    	if (arena[x][y]==3) {
		    		root.add(new Rectangle(10, 10, Color.BLACK), x, y);
		    		nodes.add(new Rectangle(10, 10, Color.BLACK));}
		    	else if (arena[x][y]==2) {
			    	root.add(new Rectangle(10, 10, Color.WHITE), x, y);
		    		nodes.add(new Rectangle(10, 10, Color.WHITE));}
		    	else if (arena[x][y]==1) {
			    	root.add(new Rectangle(10, 10, Color.WHITE), x, y);
		    		nodes.add(new Rectangle(10, 10, Color.WHITE));}
		    	else {
		    	root.add(new Rectangle(10, 10, Color.WHITE), x, y);
		    	nodes.add(new Rectangle(10, 10, Color.WHITE));}
		    }
		}
		
		root.add(human,75,50);
		return root;
	}
	
	private Node human;

	
	private Node initHuman(){
		Rectangle human = new Rectangle(10, 10, Color.AQUA);
		return human;
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.centerOnScreen();
		primaryStage.show();
		
		
		primaryStage.getScene().setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case W:
				//if(ArenaArray.getAbove()!=WALL) {
				//	if(ArenaArray.getAbove()==ENEMY) {
				//		System.out.println("You enter battle");
				//	}
				//	if(ArenaArray.getAbove()==ITEM) {
				//		System.out.println("You pick up an item");
				//	}
				if(ArenaArray.getAbove(arena) != ArenaArray.WALL) {
				if(ArenaArray.getAbove(arena) == ArenaArray.ENEMY)
						System.out.println("You enter battle");
				if(ArenaArray.getAbove(arena) == ArenaArray.ITEM)
						System.out.println("You pick up an item");
					ArenaArray.playerPosition[1] += 1;	
					human.setTranslateY(human.getTranslateY()-10);
					}
				break;
				
				//}
				
			case S:
				//if(ArenaArray.getBelow()!=3) {
				//	if(ArenaArray.getBelow()==2) {
				//		System.out.println("You enter battle");
				//	}
				//	if(ArenaArray.getBelow()==4) {
				//		System.out.println("You ascend to the next floor");
				//	}
				if(ArenaArray.getBelow(arena) != ArenaArray.WALL) {
					switch(ArenaArray.getBelow(arena)) {
					case ArenaArray.ENEMY: System.out.println("You enter battle"); break; //will put encounter methods here
					case ArenaArray.ITEM: System.out.println("You pick up an item"); break;
					case ArenaArray.EMPTY_SPACE: break;
					}
					ArenaArray.playerPosition[1] -= 1;	
					human.setTranslateY(human.getTranslateY()+10);
				}
				//human.setTranslateY(human.getTranslateY()+10);//}
				break;
			case A:
				//if(ArenaArray.getLeft()!=3) {
				//	if(ArenaArray.getLeft()==2) {
				//		System.out.println("You enter battle");
				//	}
				//	if(ArenaArray.getLeft()==4) {
				//		System.out.println("You ascend to the next floor");
				//	}
				human.setTranslateX(human.getTranslateX()-10);//}
				break;
			case D:
				//if(ArenaArray.getRight()!=3) {
				//	if(ArenaArray.getRight()==2) {
				//		System.out.println("You enter battle");
				//	}
				//	if(ArenaArray.getRight()==4) {
				//		System.out.println("You ascend to the next floor");
				//	}
				human.setTranslateX(human.getTranslateX()+10);//}
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
