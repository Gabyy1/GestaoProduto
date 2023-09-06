package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import entity.Produto;

public class ProdutoDAO {
	
	GenericDAO c = new GenericDAO();
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public void cadastrarProduto(Produto objproduto) throws SQLException, ClassNotFoundException {

		String sql = "insert into Produto values (?, ?)";
		conn = new GenericDAO().getConnection();

		try {
			    ps = conn.prepareStatement(sql);
				
				ps.setString(1, objproduto.getNome());
				ps.setString(2, objproduto.getData());
				
				ps.execute();
				JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!!");
				ps.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "ProdutoDAO Cadastrar " + e);
		}
	}
	

	public void editarProduto(Produto objproduto) throws ClassNotFoundException, SQLException {
		String sql = "update Produto set nome = ?, data = ? where codigo = ?";
		conn = new GenericDAO().getConnection();
		
		try {
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, objproduto.getNome());
		ps.setString(2, objproduto.getData());
		ps.setInt(3, objproduto.getCodigo());
		

		ps.execute();
		JOptionPane.showMessageDialog(null, "Produto Editado com Sucesso!!");
		ps.close();

} catch (Exception e) {

	JOptionPane.showMessageDialog(null, "ProdutoDAO Editar " + e);
}
	}

	public void excluirProduto(Produto objproduto) throws ClassNotFoundException, SQLException {
		String sql = "delete from Produto where codigo = ?";
		conn = new GenericDAO().getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, objproduto.getCodigo());

			ps.execute();
			JOptionPane.showMessageDialog(null, "Produto Excluido com Sucesso!!");
			ps.close();

	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "ProdutoDAO Excluir " + e);
	}
	
}
}





