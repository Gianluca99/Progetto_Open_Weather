package it.univpm.ProgettoGoffiCorso;

public class Input {
	public String Nome;
	public String Data;
	public Input(String nome, String data) {
		this.Nome = nome;
		this.Data = data;
	}
	public String getNome() {
		return this.Nome;
	}
	public void setNome(String nome) {
		if(nome != "") 
		this.Nome = nome;
		else {
			throw new IllegalArgumentException();
		}
	}
	public String getData() {
		return this.Data;
	}

	public void setData(String data) {
		if(data != "")
		this.Data = data;
		else {
			throw new IllegalArgumentException();
		}
	}
}
