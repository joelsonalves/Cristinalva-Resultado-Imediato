package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import view.LoginAdministrador;
import view.LoginEstudante;
import view.TelaPrincipal;

public class TelaPrincipalController implements Initializable {

	@FXML
    private Menu menuModulo;

    @FXML
    private MenuItem menuModuloEstudante;

    @FXML
    private MenuItem menuModuloDocente;

    @FXML
    private MenuItem menuModuloCoordenador;

    @FXML
    private MenuItem menuModuloAdministrador;

    @FXML
    private Menu menuAjuda;

    @FXML
    private MenuItem menuAjudaSobre;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		menuModuloEstudante.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				LoginEstudante loginEstudante = new LoginEstudante();
				try {
					loginEstudante.start(TelaPrincipal.getStage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		menuModuloAdministrador.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				LoginAdministrador loginAdministrador = new LoginAdministrador();
				try {
					loginAdministrador.start(TelaPrincipal.getStage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
