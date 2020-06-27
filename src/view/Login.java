package view;





import controller.RegistroDAO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Registromodel;


public class Login extends Application implements EventHandler<ActionEvent> {
	
	private TextField txtNome = new TextField();
	private TextField txtSenha = new TextField();
	
	private Button btnLogin = new Button("Login");
	private Button btnRegistration = new Button("Registration");
	private RegistroDAO control = new RegistroDAO();
	
	public void  start(Stage stage) throws Exception {
		Pane pan = new Pane();
		Scene scn = new Scene(pan, 600, 400);
		
		
		
		
	    
		//*Label lblImg = new Label();
		//*lblImg.setStyle("-fx-background-image: url('file:C:/Users/3green/eclipse-workspace/Teceletro/src/view/logo.png')");
		
		
		
		Label lblLogin = new Label("Login no Sistema");
		lblLogin.relocate(100, 40);
		// lblLogin.setStyle("-fx-font-size: 30");
		Font fnt = new Font(30);
		lblLogin.setFont(fnt);
		
		Label lblNome = new Label("User ID:");
		lblNome.relocate(100, 120);
		
		
		txtNome.relocate(175, 120);
		
		Label lblSenha = new Label("Password:");
		lblSenha.relocate(100, 200);
		
		
		txtSenha.relocate(175, 200);
		
		
		
		
		btnRegistration.relocate(250, 370);
		
		btnRegistration.setOnAction(this);
		btnLogin.setOnAction(this);
		
	    pan.getChildren().addAll(lblLogin, lblNome, lblSenha, 
				txtNome, txtSenha, btnLogin, btnRegistration);

		stage.setTitle("Login");
		stage.setScene(scn);
		stage.show();
		
		btnLogin.relocate(375, 370);
		btnLogin.setOnAction((a) -> {
			//if(txtNome.getText().equals(txtNome) && txtSenha.getText().equals(txtSenha)) {
			Menu m = new Menu();
			try {
				m.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//}
		});
	}
	
	
	@Override
	public void handle(ActionEvent e) {
		if (e.getTarget() == btnRegistration) { 
			Registromodel r = boundaryToEntity();
			control.registrar(r);
			entityToBoundary(new Registromodel());
		} else if (e.getTarget() == btnLogin){ 
			Registromodel r = boundaryToEntity();
			Registromodel rm = control.login(r);
			//if (rm.getCodigoreg() == )
			System.out.print(rm.getEmail());
			
		}
	}
		
		
	private void entityToBoundary(Registromodel r) {
		txtNome.setText( r.getNome() );
		txtSenha.setText( r.getSenha() );
		
			
		}



	private Registromodel boundaryToEntity() {
		Registromodel r = new Registromodel();
		try { 
			r.setNome( txtNome.getText() );
			r.setSenha( txtSenha.getText() );
			
		} catch (Exception ex) { 
			System.out.println("Erro ao computar os dados");
		}
		return r;
	}



	

	public static void main(String[] args) {
		Application.launch(Login.class, args);
		
		
	}
	
}