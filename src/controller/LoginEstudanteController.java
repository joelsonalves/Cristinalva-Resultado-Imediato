package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javax.persistence.PersistenceException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import model.DAO.EstudanteDAO;
import model.entidade.Estudante;
import model.utilidades.JpaUtil;
import view.TelaPrincipal;
import view.VerificarEstudante;

public class LoginEstudanteController implements Initializable {
	
	@FXML
    private BorderPane borderPanePrincipal;
	
	@FXML
    private Label labelMatricula;

    @FXML
    private TextField textFieldMatricula;

    @FXML
    private Button buttonEntrar;
    
    @FXML
    private Label labelStatus;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		buttonEntrar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				try {
					
					Long matricula = Long.parseLong(textFieldMatricula.getText());
					EstudanteDAO estudanteDAO = new EstudanteDAO(JpaUtil.getEntityManager());
					Estudante estudante = estudanteDAO.buscar(matricula);
					estudante.getMatricula();
					
					VerificarEstudante tela = new VerificarEstudante(estudante);
					tela.start(TelaPrincipal.getStage());
					
				} catch(NumberFormatException e) {
					
					labelStatus.setTextFill(Color.RED);
					labelStatus.setText("Verifique o valor digitado no campo matrícula.");
					textFieldMatricula.requestFocus();
					
				} catch(PersistenceException e) {
					
					labelStatus.setTextFill(Color.RED);
					labelStatus.setText("Não foi possível conectar ao banco de dados.");
					
				} catch(NullPointerException e) {
					
					labelStatus.setTextFill(Color.RED);
					labelStatus.setText("Não foi possível localizar um estudante com essa matrícula.");
					textFieldMatricula.requestFocus();
					
				} catch(Exception e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		}); 
		
		textFieldMatricula.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent event) {
				
				labelStatus.setTextFill(Color.BLACK);
				labelStatus.setText("Digite a Matrícula, Tecle Enter e Aguarde...");
				
			}
			
		}); 
		
		buttonEntrar.setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				try {
					
					labelStatus.setTextFill(Color.BLACK);
					labelStatus.setText("Tentando entrar no sistema. Aguarde...");
					
				} catch(Exception e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		}); 

	}

}
