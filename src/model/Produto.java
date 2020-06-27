package model;



public class Produto implements Comparable<Produto> {
	private long codigopro;

	public long getCodigopro() {
		return codigopro;
	}

	public void setCodigopro(long codigopro) {
		this.codigopro = codigopro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getValor() {
		return valor;
	}

	

	public String nome;
	private String marca;
	private int valor;

	
	public int compareTo(Produto p) {
		return getNome().compareTo(p.getNome());
	}

	public void setValor(int valor) {
		this.valor = valor;
		
	}

	

	
}
