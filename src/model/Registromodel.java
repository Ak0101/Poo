package model;

public class Registromodel {
     private int codigoreg;
     public int getCodigoreg() {
		return codigoreg;
	}
	public void setCodigoreg(int codigoreg) {
		this.codigoreg = codigoreg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	
	private String nome;
     private String email;
     private String senha;
     
	
	
	public void setSenha(String senha) {
		this.senha=senha;
	}
	
}
