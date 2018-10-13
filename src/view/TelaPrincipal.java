package view;

import controller.TelaPrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaPrincipal extends Application {
	
	/* 
	 * Armazena a Janela
	 */
	private static Stage stage;

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		TelaPrincipal.stage = stage;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Cristinalva Resultado Imediato");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/layout/TelaPrincipal.fxml"));
		loader.setController(new TelaPrincipalController());
		Pane root = loader.load();
		
		Scene scene = new Scene(root, 800, 400);
		
		stage.setScene(scene);
		
		setStage(stage);
		getStage().show();
	}

	
}
