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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import model.DAO.DocenteDAO;
import model.DAO.LoginDAO;
import model.entidade.Docente;
import model.entidade.Login;
import model.exception.CpfException;
import model.exception.LoginException;
import model.exception.SenhaException;
import model.utilidades.JpaUtil;
import model.utilidades.ValidadorCPF;

public class LoginAdministradorController implements Initializable {
	
	@FXML
    private BorderPane borderPanePrincipal;
	
	@FXML
    private Label labelCpf;

    @FXML
    private TextField textFieldCpf;
    
    @FXML
    private Label labelSenha;
    
    @FXML
    private PasswordField passwordFieldSenha;

    @FXML
    private Button buttonEntrar;
    
    @FXML
    private Label labelStatus;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		textFieldCpf.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				
				if (textFieldCpf.getText().length() < 11) {
					
					labelStatus.setTextFill(Color.BLUE);
					labelStatus.setText("Digite apenas os 11 (onze) dígitos do seu CPF.");
					
				} else if (textFieldCpf.getText().length() > 11) {
					
					labelStatus.setTextFill(Color.RED);
					labelStatus.setText("Não existe CPF com mais de 11 (onze) dígitos.");
					textFieldCpf.requestFocus();
					
				} else {
					
					labelStatus.setTextFill(Color.BLACK);
					labelStatus.setText("");
					passwordFieldSenha.requestFocus();
					
				}

				for (char c : textFieldCpf.getText().toCharArray()) {
						
					if (c < '0' || c > '9') {
							
						labelStatus.setTextFill(Color.RED);
						labelStatus.setText("Deve haver apenas números no campo CPF.");
						textFieldCpf.requestFocus();
						break;
							
					}
						
				}
				
			}
			
			
			
		});
		
		buttonEntrar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				try {
					
					String cpf = textFieldCpf.getText();
					String senha = passwordFieldSenha.getText();
					
					if (!ValidadorCPF.isValido(cpf)) {
						throw new CpfException();
					}
					
					if (senha.equals("")) {
						throw new SenhaException();
					}
					
					DocenteDAO docenteDAO = new DocenteDAO(JpaUtil.getEntityManager());
					LoginDAO loginDAO = new LoginDAO(JpaUtil.getEntityManager());
					
					Docente docente = docenteDAO.buscar(cpf);
					
					
					docente.getCpf();
					
					Login login = loginDAO.buscarPorDocente(docente);
					
					if (!login.getSenha().equals(senha)
					|| !login.isAtivo()
					|| !login.isAdministrador()) {
						throw new LoginException();
					}
					
				} catch(CpfException e) {
					
					labelStatus.setTextFill(Color.RED);
					labelStatus.setText("Valor inválido para CPF.");
					textFieldCpf.requestFocus();
					
				} catch(SenhaException e) {
					
					labelStatus.setTextFill(Color.RED);
					labelStatus.setText("A senha não pode ser vazia.");
					passwordFieldSenha.requestFocus();
					
				} catch(PersistenceException e) {
					
					labelStatus.setTextFill(Color.RED);
					labelStatus.setText("Não foi possível conectar ao Banco de Dados.");
					passwordFieldSenha.requestFocus();
					
				} catch(NullPointerException e) {
					
					labelStatus.setTextFill(Color.RED);
					labelStatus.setText("Não foi possível fazer login. Verifique suas credenciais.");
					textFieldCpf.requestFocus();
					
				} catch(LoginException e) {
					
					labelStatus.setTextFill(Color.RED);
					labelStatus.setText("Não foi possível fazer login. Verifique suas credenciais.");
					passwordFieldSenha.requestFocus();
					
				} catch(Exception e) {
					
					e.printStackTrace();
					
				} 
				
			}
			
		}); 
		
		

	}

}
