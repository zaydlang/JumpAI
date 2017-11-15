import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import javafx.event.*;
 
public class test extends Application {
    private int num = 100;
    private Button btn;
    private Button btsn;
    private StackPane root;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game");
        Text t = new Text ("Press the game " + num + " times to win!");
        t.setTranslateY(-20);
        btsn = new Button();
        btsn.setText("Red");
        btsn.setTranslateY(20);
        btsn.setStyle("-fx-background-color: #FF0000; ");
        btsn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                red();
            }
        });
        btn = new Button();
        btn.setText("Green");
        btn.setTranslateY(40);
        btn.setStyle("-fx-background-color: #228B22; ");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                green();
            }
        });
        
        root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(t);
        root.getChildren().add(btsn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    public void green() {
       if (num == 2) {
          btn.setStyle("-fx-background-color: #FF0000; ");
          btsn.setStyle("-fx-background-color: #228B22; ");
       }
       
       if (num == 1) {
          System.exit(0);
       }
       
       num--;
       
       Text t = new Text ("Press the game " + num + " times to win!");
       
        root.getChildren().add(btn);
        root.getChildren().add(t);
        root.getChildren().add(btsn);
    }
    
    public void red() {
       if (num > 1) {
          System.exit(0);
       }
       
       num--;
       
       Text t = new Text ("YOU WIN!");
       
        root.getChildren().add(btn);
        root.getChildren().add(t);
        root.getChildren().add(btsn);
    }
}