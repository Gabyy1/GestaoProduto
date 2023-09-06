package entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DAO.ProdutoDAO;

public class FrmProduto {
	public static void main(String[] args) {

		ProdutoDAO pDao = new ProdutoDAO();
		Produto objproduto = new Produto();

		JFrame f = new JFrame();
		f.setTitle("Cadastro de Produtos");
		f.setSize(600, 200);
		f.setLocation(700, 300);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		
		JLabel laa = new JLabel("                                                                                                                                                                                    ");
		p.add(laa);

		JLabel l = new JLabel("Código:");
		p.add(l);

		JTextField t = new JTextField(9);
		p.add(t);

		JLabel l1 = new JLabel("Nome:");
		p.add(l1);


		JTextField t1 = new JTextField(15);
		p.add(t1);

		JLabel l2 = new JLabel("Data de validade:");
		p.add(l2);

		JTextField t2 = new JTextField(9);
		p.add(t2);
		
		JLabel laaa = new JLabel("                                                                                                                                                                                    ");
		p.add(laaa);
		

		JButton bcad = new JButton("CADASTRAR");
		bcad.setLocation(200,500);
		bcad.setSize(100,100);

		JButton bexclui = new JButton("EXCLUIR");
		bexclui.setLocation(200,500);
		bexclui.setSize(100,100);
		
		JButton bedita = new JButton("EDITAR");
		bedita.setLocation(200,500);
		bedita.setSize(100,100);
		
		JButton blimpa = new JButton("LIMPAR");
		blimpa.setLocation(200,500);


			bcad.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {

				String nome = t1.getText();
				String data = t2.getText();
				
				objproduto.setNome(nome);
				objproduto.setData(data);
				try {
					pDao.cadastrarProduto(objproduto);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}

			}

		});

			bexclui.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					Integer codigo = Integer.parseInt(t.getText());
					
					objproduto.setCodigo(codigo);
					
					try {
						pDao.excluirProduto(objproduto);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			});
			
			bedita.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					Integer codigo = Integer.parseInt(t.getText());
					String nome = t1.getText();
					String data = t2.getText();
					
					objproduto.setCodigo(codigo);
					objproduto.setNome(nome);
					objproduto.setData(data);
					
					
					try {
						pDao.editarProduto(objproduto);
		
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			});
			
			blimpa.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					 t.setText("");
					 t1.setText("");
					 t2.setText("");

				}

			});

	

		p.add(bcad);
		p.add(bexclui);
		p.add(bedita);
		p.add(blimpa);
		f.add(p);
		f.setVisible(true);



}

}
