/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produtos;

import conexao.conexaoSisCMP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Laegleuson
 */
public class produtosDAO {
    private Connection Connection;
    
    public produtosDAO(){
        this.Connection = new conexaoSisCMP().getConexao();
    }
    
    public void adicionar (produtos pro) throws SQLException{
        String sql = "insert into tbprodutos(nome,especificacao,preco, obs"
                + ", id_mercantil) values (?,?,?,?,?)";
        try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setString(1, pro.getNome());
            stmt.setString(2, pro.getEspecificacao());            
            stmt.setFloat(3, pro.getPreco());
            stmt.setString(4, pro.getObs());
            stmt.setInt(5, pro.getId_merc());
            stmt.execute();
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso");
            
           }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void remover (produtos pro) throws SQLException{
            String sql = "delete from tbprodutos where id = ?";
            try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setInt(1, pro.getId());              
            stmt.execute();            
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Produto removido com sucesso");
            }catch (SQLException e){
            System.out.println(e);
        }
    }
    
    public void alterar (produtos pro) throws SQLException{
        String sql = "update tbprodutos set nome = ?,especificacao = ?,preco = ?,"
                + "obs = ?, id_mercantil = ? where id = ?";
        try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);            
            stmt.setString(1, pro.getNome());
            stmt.setString(2, pro.getEspecificacao());
            stmt.setFloat(3, pro.getPreco());
            stmt.setString(4, pro.getObs());
            stmt.setInt(5, pro.getId_merc());            
            stmt.setInt(6, pro.getId());           
            stmt.execute();
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Produto alterado com sucesso");
            
           }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void localizar (produtos pro) throws SQLException {
        try {
            String sql = "select * from tbprodutos p, tbmercantil m where p.id_mercantil = m.id and p.nome = ?";
            PreparedStatement stmt = (PreparedStatement) this.Connection.prepareStatement(sql);
            stmt.setString(1, pro.getNome());             
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {   
                pro.setId(rs.getInt("p.id"));
                pro.setNome(rs.getString("p.nome"));
                pro.setEspecificacao(rs.getString("p.especificacao"));
                pro.setPreco(rs.getFloat("p.preco"));
                pro.setObs(rs.getString("p.obs"));
                pro.setId_merc(rs.getInt("p.id_mercantil"));
                pro.setNm_merc(rs.getString("m.nome"));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void verificar (produtos pro) throws SQLException {
        try {
            String sql = "select nome from tbprodutos where nome = ? and especificacao = ? and id_mercantil = ?";
            PreparedStatement stmt = (PreparedStatement) this.Connection.prepareStatement(sql);
            stmt.setString(1, pro.getNome());
            stmt.setString(2, pro.getEspecificacao()); 
            stmt.setInt(3, pro.getId_merc());
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) { 
                pro.setNome(rs.getString("nome"));
            }else{
                pro.setNome("");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<produtos> getLista(String sql){
       List<produtos> all_produto = new ArrayList<produtos>();
       try {
       PreparedStatement stm = (PreparedStatement) Connection.prepareStatement(sql);
           ResultSet rs = stm.executeQuery();
           
           while(rs.next()){
               produtos pro = new produtos();
                pro.setId(rs.getInt("p.id"));
                pro.setNome(rs.getString("p.nome"));
                pro.setEspecificacao(rs.getString("p.especificacao"));
                pro.setPreco(rs.getFloat("p.preco"));
                pro.setObs(rs.getString("p.obs"));
                pro.setId_merc(rs.getInt("p.id_mercantil"));
                pro.setNm_merc(rs.getString("m.nome"));              
               all_produto.add(pro);
               
           }
       rs.close();
       stm.close();
       return all_produto;       
       
       } catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
           throw new RuntimeException(e);
       }                 
        
    }
    
}
