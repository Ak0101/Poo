package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Produto;

public class MenuControl {

	private static final String URL = "jdbc:sqlite:C:\\Users\\3green\\eclipse-workspace\\Teceletro\\bd\\banco.db";
	private Connection con;

	public MenuControl() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			alertError("Erro de database", "Erro ao carregar a classe JDBC",
					e.getMessage());
		}
	}

	private void alertError(String title, String header, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	public void adicionar(Produto p) {
		try {
			Connection con = DriverManager.getConnection(URL);
			String sql = "INSERT INTO produto (codigopro, nome, marca, valor) "
					+ "VALUES  (null, ?, ?, ?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, p.getNome());
			stm.setString(2, p.getMarca());
			stm.setInt(3, p.getValor());
			stm.executeUpdate();

			con.close();
		} catch (SQLException e) {
			alertError("Erro de database", "Erro ao acessar o banco de dados",
					e.getMessage());
		}
	}

	public Produto pesquisarPorNome(String nome) {
		try {
			Connection con = DriverManager.getConnection(URL);
			String sql = "SELECT * FROM produto WHERE nome like ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + nome + "%");
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				Produto p = new Produto();
				p.setCodigopro(rs.getLong("codigopro"));
				p.setNome(rs.getString("nome"));
				p.setMarca(rs.getString("marca"));
				p.setValor(rs.getInt("valor"));
				con.close();
				return p;
				
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Produto deletarPorNome(String nome) {
		try {
			Connection con = DriverManager.getConnection(URL);
			System.out.print(nome);
			String sql = "DELETE FROM produto WHERE produto.nome = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, nome);
			stm.execute();
			// stm.close();
			con.close();
			Produto p = new Produto();
			return p;

		} catch (SQLException e) {
		}
		return null;
	}

	public Produto atualizar(Produto p) {
		try {
			Connection con = DriverManager.getConnection(URL);
			
			String sql = "UPDATE produto SET nome = ?, marca = ?, valor = ? WHERE codigopro = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, p.getNome());
			stm.setString(2, p.getMarca());
			stm.setInt(3, p.getValor());
			stm.setLong(4, p.getCodigopro());
			System.out.print(stm.toString());
			stm.executeUpdate();
			con.close();
			//Produto q = pesquisarPorNome(p.getNome());
			
			return p;
		} catch (SQLException e) {
			alertError("Erro de database", "Erro ao acessar o banco de dados",
					e.getMessage());
		}
		return null;
	}

}