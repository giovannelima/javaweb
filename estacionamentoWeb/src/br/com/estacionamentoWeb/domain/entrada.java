package br.com.estacionamentoWeb.domain;

public class entrada {
	private int id;
	private String modelo;
	private String marca;
	private String cor;
	private String placa;

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}

	public String getModelo() {
		return this.modelo;
	}

	public String setModelo(String modelo) {
		return this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String setMarca(String marca) {
		return this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public String setCor(String cor) {
		return this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public String setPlaca(String placa) {
		return this.placa = placa;
	}

}
