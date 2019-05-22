package br.com.estacionamentoWeb.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexãoBD {
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String URL = "jdbc:mysql://localhost:3306/estacionamento";

	public static Connection conectar() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conn;
	}

	public static void main(String[] args) {
		try {
			Connection conexao = conexãoBD.conectar();
			System.out.println("Conectado com sucesso!! ");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Conexão falhou!!");
		}
	}

}
