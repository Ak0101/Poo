package model;

public class Login {
  private int codigo;
  public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public int getSenha() {
	return senha;
}
public void setSenha(int senha) {
	this.senha = senha;
}
private String userid;
  private int senha;
}
