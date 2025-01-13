package aplication;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class prueba extends Application {

	@Override
	public void start(Stage primaryStage) {
	  try {
	  FXMLLoader loader = new FXMLLoader();
		loader.setLocation(prueba.class.getResource("/views/VentanaPrincipal.fxml"));
		
      Pane ventana = (Pane) loader.load();
      Scene scene = new Scene(ventana);
      //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.show(); 
      } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
	}

	public static void main(String[] args) {
		launch(args);
	}
}
