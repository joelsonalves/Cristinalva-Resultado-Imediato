package view;

import controller.LoginAdministradorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginAdministrador extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Cristinalva Resultado Imediato [Módulo Administrador] - Login");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/layout/LoginAdministrador.fxml"));
		loader.setController(new LoginAdministradorController());
		Pane root = loader.load();
		
		Scene scene = new Scene(root, 800, 400);
		
		stage.setScene(scene);
		TelaPrincipal.setStage(stage);
		TelaPrincipal.getStage().show();
	}

}
