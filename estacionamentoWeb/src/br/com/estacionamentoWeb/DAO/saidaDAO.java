package br.com.estacionamentoWeb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estacionamentoWeb.domain.entrada;
import br.com.estacionamentoWeb.factory.conexãoBD;

public class saidaDAO {
	// Classe de visualização onde é selecionado somente com o começo do dado selecionado
	public void seleclLike(String modelo, String marca, String cor, String placa) throws ClassNotFoundException, SQLException {  
		 boolean verifica = false; // verifica recebendo falso
		Connection conexao = conexãoBD.conectar();	//saida.seleclLike(like, like2, like3, like4);

		try {
			// visualização dos dados inseridos no banco com o like onde pode ser digitado somente o começo do texto ou numero
			String sql = "select * from  estacionamento.entrada where car_modelo like ? or car_marca like ? or car_cor like ? or car_placa like ?";
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, "%" + modelo + "%"); // like do modelo
			ps.setString(2, "%" + marca + "%"); // like da marca
			ps.setString(3, "%" + cor + "%"); // like da cor
			ps.setString(4, "%" + placa + "%"); // like da placa

			ResultSet buscar = ps.executeQuery();  // o preparedStatement executa a query do codigo -- resultSet recebe a query executada onde verifica se foi selecionado ou não

			while (buscar.next()) {  // com o While o result set pula para o proximo para executar a verificação

				verifica = true; // verifica se é verdade a infomação
				int idPark = buscar.getInt("car_id"); // parametro que recebe o inteiro que recebe do banco
				String modeloPark = buscar.getString("car_modelo"); // parametro que recebe a string que recebe do banco
				String marcaPark = buscar.getString("car_marca");  // parametro que recebe a string que recebe do banco
				String corPark = buscar.getString("car_cor");  // parametro que recebe a string que recebe do banco
				String placaPark = buscar.getString("car_placa"); // parametro que recebe a string que recebe do banco
				
				System.out.println("||ID: " + idPark + "|" + "Modelo: " + modeloPark + "|" + "Marca: " + marcaPark + "|"
						+ "Cor: " + corPark + "|" + "Placa: " + placaPark + "||");
				// exemplo de onde mostra o que está sendo pego pelo select like	
			}
			if (verifica) {
				// se for verdadeiro 
				System.out.println("\nOs dados foram encontrados.!");

			} else {
				// se for falso
				System.out.println("\nOs dados não foram encontrados.!");

			}

			buscar.close(); // fechamento do resultSet
			ps.close(); // fechamento preparedStatement

		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println("ERRO" + e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		saidaDAO saida = new saidaDAO();
		entrada entrada = new entrada();
		String like = null, like2 = null, like3 = null, like4 = null;

		like = entrada.setModelo("f");
		like2 = entrada.setMarca("");
		like3 = entrada.setCor("");
		like4 = entrada.setPlaca("");

		saida.seleclLike(like, like2, like3, like4);
	}

}
