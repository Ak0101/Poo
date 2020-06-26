package view;

import controller.MenuControl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Produto;


public class Menu extends Application implements EventHandler<ActionEvent> {
	private TextField txtValor = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtCodigopro = new TextField();
	private TextField txtMarca = new TextField();
	
	private Button btnSalvar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnAtualizar = new Button("Atualizar");
	
	private MenuControl control = new MenuControl();
	public void start(Stage stage) throws Exception {
		Pane pan = new Pane();
		Scene scn = new Scene(pan, 600, 400);

		Label lblLogin = new Label("Registro do produto");
		lblLogin.relocate(100, 40);
		// lblLogin.setStyle("-fx-font-size: 30");
		Font fnt = new Font(30);
		lblLogin.setFont(fnt);

		Label lblNome = new Label("Nome Produto");
		lblNome.relocate(50, 120);

		
		txtNome.relocate(175, 120);

		Label lblMarca = new Label("Marca:");
		lblMarca.relocate(100, 170);

		
		txtMarca.relocate(175, 170);

		Label lblCodigo = new Label("Codigo:");
		lblCodigo.relocate(100, 220);

		
		txtCodigopro.relocate(175, 220);

		Label lblValor = new Label("Valor:");
		lblValor.relocate(100, 270);

		
		txtValor.relocate(175, 270);

		Label lblPesquisar = new Label(
				"Insira o código, e o nome e clique em pesquisar:");
		lblPesquisar.relocate(100, 320);
		Font fnt2 = new Font(20);
		lblPesquisar.setFont(fnt2);

		
		btnSalvar.relocate(100, 370);

		
		btnPesquisar.relocate(175, 370);

		
		btnExcluir.relocate(250, 370);

		
		btnAtualizar.relocate(375, 370);
		btnAtualizar.setOnAction((a) -> {
			Atualizar at = new Atualizar();
			try {
				at.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		btnSalvar.setOnAction(this);
		btnPesquisar.setOnAction(this);
		btnExcluir.setOnAction(this);
		btnAtualizar.setOnAction(this);

		pan.getChildren().addAll(lblLogin, lblNome, lblMarca, lblCodigo,
				lblValor, lblPesquisar, txtNome, txtMarca, txtCodigopro,
				txtValor, btnSalvar, btnPesquisar, btnAtualizar, btnExcluir);

		stage.setTitle("Cadastro Produto");
		stage.setScene(scn);
		stage.show();
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getTarget() == btnSalvar) { 
			Produto p = boundaryToEntity();
			control.adicionar(p);
			entityToBoundary(new Produto());
		} else if (e.getTarget() == btnPesquisar){ 
			String nome = txtNome.getText();
			Produto p = control.pesquisarPorNome(nome);
			entityToBoundary(p);
		} else if (e.getTarget() == btnExcluir) {
			String nome = txtNome.getText();
			Produto p = control.deletarPorNome(nome);
			entityToBoundary(p);
		}
	}

	private void entityToBoundary(Produto p) {
		txtCodigopro.setText( String.valueOf(p.getCodigopro()) );
		txtNome.setText( p.getNome() );
		txtMarca.setText( p.getMarca() );
		txtValor.setText( String.valueOf(p.getValor()) );
		
	}

	private Produto boundaryToEntity() {
		Produto p = new Produto();
		try { 
			p.setCodigopro( Long.parseLong(txtCodigopro.getText()) );
			p.setNome( txtNome.getText() );
			p.setMarca( txtMarca.getText() );
			p.setValor(Double.parseDouble(txtValor.getText()) );
			
		} catch (Exception ex) { 
			System.out.println("Erro ao computar os dados");
		}
		return p;
	}

	public static void main(String[] args) {
		Application.launch(Menu.class, args);
	}
}
