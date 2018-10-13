package view;

import controller.LoginEstudanteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginEstudante extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Cristinalva Resultado Imediato [Módulo Estudante] - Login");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/layout/LoginEstudante.fxml"));
		loader.setController(new LoginEstudanteController());
		Pane root = loader.load();
		
		Scene scene = new Scene(root, 800, 400);
		
		stage.setScene(scene);
		TelaPrincipal.setStage(stage);
		TelaPrincipal.getStage().show();
	}

}
