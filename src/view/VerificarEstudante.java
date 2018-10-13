package view;

import controller.VerificarEstudanteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.entidade.Estudante;

public class VerificarEstudante extends Application {
	
	private Estudante estudante;
	
	public VerificarEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Cristinalva Resultado Imediato [Módulo Estudante] - Verificar");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/layout/VerificarEstudante.fxml"));
		loader.setController(new VerificarEstudanteController(estudante));
		Pane root = loader.load();
		
		Scene scene = new Scene(root, 800, 400);
		
		stage.setScene(scene);
		TelaPrincipal.setStage(stage);
		TelaPrincipal.getStage().show();
	}

}
