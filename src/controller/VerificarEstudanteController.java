package controller;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entidade.Estudante;
import view.LoginEstudante;
import view.TelaPrincipal;

public class VerificarEstudanteController implements Initializable {

	private Estudante estudante;
	
	public VerificarEstudanteController(Estudante estudante) {
		this.estudante = estudante;
	}
	
	@FXML
    private Label labelNome;

    @FXML
    private TextField textFieldNome;

    @FXML
    private Label labelDataNascimento;
    
    @FXML
    private TextField textFieldDataNascimento;

    @FXML
    private Button buttonEstaCorreto;

    @FXML
    private Button buttonVoltar;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		textFieldNome.setText(estudante.getNome());
		textFieldDataNascimento.setText(estudante.getDataNascimento().format(
				DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		buttonVoltar.setOnAction(new EventHandler<ActionEvent>() {

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
		
		buttonEstaCorreto.setOnAction(new EventHandler<ActionEvent>() {

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
		
	}

}
