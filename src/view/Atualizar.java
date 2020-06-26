package view;


import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Atualizar {


	public void  start(Stage stage) throws Exception {
		Pane pan = new Pane();
		Scene scn = new Scene(pan, 600, 400);
		
		
		
		Label lblLogin = new Label("Atualizar produto");
		lblLogin.relocate(100, 40);
		// lblLogin.setStyle("-fx-font-size: 30");
		Font fnt = new Font(30);
		lblLogin.setFont(fnt);
		
		Label lblNome = new Label("Nome Produto");
		lblNome.relocate(50, 120);
		
		TextField txtNome = new TextField();
		txtNome.relocate(175, 120);
		
		Label lblMarca = new Label("Marca:");
		lblMarca.relocate(100, 170);
		
		TextField txtMarca = new TextField();
		txtMarca.relocate(175, 170);
		
		Label lblCodigo = new Label("Codigo:");
		lblCodigo.relocate(100, 220);
		
		TextField txtCodigo = new TextField();
		txtCodigo.relocate(175, 220);
		
		Label lblValor = new Label("Valor:");
		lblValor.relocate(100, 270);
		
		TextField txtValor = new TextField();
		txtValor.relocate(175, 270);
		
		Button btnAtualizar = new Button("Atualizar");
		btnAtualizar.relocate(375, 370);
		
		 stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	            @Override
	            public void handle(WindowEvent t) {
	                t.consume();

	                // Coloque aqui o código a ser executado ao fechar o sistema.

	                stage.close();
	                Platform.exit();
	                System.exit(0);
	            }
	        });
		
		  pan.getChildren().addAll(lblLogin, lblNome, lblMarca, lblCodigo, lblValor, 
					txtNome, txtMarca, txtCodigo, txtValor, btnAtualizar);
		    
		    
			stage.setTitle("Atualizar Produto");
			stage.setScene(scn);
			stage.show();
		

	}





}