package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Registromodel;


public class RegistroDAO {
	private static final String URL = "jdbc:sqlite:C:\\Users\\3green\\eclipse-workspace\\Teceletro\\db\\banco.db";
    private Connection con;
    
	public RegistroDAO() { 
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			alertError("Erro de database", "Erro ao carregar a classe JDBC", e.getMessage());
		}
	}

	private void alertError(String title, String header, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	public void registrar(Registromodel r) { 
		try {
			Connection con = DriverManager.getConnection(URL);
			String sql = "INSERT INTO Registro (codigoreg, nome, email, senha) "
					+ "VALUES  (null, ?, ?, ?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, r.getNome());
			stm.setString(2, r.getEmail());
			stm.setString(3, r.getSenha());
			stm.executeUpdate();
			
			
			con.close();
		} catch (SQLException e) {
			alertError("Erro de database", "Erro ao acessar o banco de dados", e.getMessage());
		}
	}
	public Registromodel login(String nome ,String  senha) { 
		try {
			Connection con = DriverManager.getConnection(URL);
			String sql = "SELECT * FROM Registro WHERE nome like ? and senha like ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + nome + "%");
			stm.setString(2, "%" + senha + "%");
			ResultSet rs = stm.executeQuery();
			if (rs.next()) { 
				Registromodel r = new Registromodel();
				r.setNome(rs.getString("nome"));
				r.setSenha(rs.getString("senha"));
				return r;
			}
		
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
