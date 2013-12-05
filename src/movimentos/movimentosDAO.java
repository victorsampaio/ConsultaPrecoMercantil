
package movimentos;


import conexao.conexaoSisCMP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class movimentosDAO {
    private Connection Connection;
    
    public movimentosDAO(){
        this.Connection = new conexaoSisCMP().getConexao();
    }
    
    public void adicionar (movimentos mov) throws SQLException{
        String sql = "insert into tbmovimentos(id_produto,data,preco,obs) values (?,?,?,?)";
        try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setInt(1, mov.getId_prod());
            stmt.setDate(2, mov.getData());            
            stmt.setFloat(3, mov.getPreco());
            stmt.setString(4, mov.getObs());
            stmt.execute();
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Pesquisa salva com sucesso");
            
           }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void remover (movimentos mov) throws SQLException{
            String sql = "delete from tbmovimentos where id = ?";
            try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setInt(1, mov.getId());              
            stmt.execute();            
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Pesquisa removida com sucesso");
            }catch (SQLException e){
            System.out.println(e);
        }
    }
    
    public void alterar (movimentos mov) throws SQLException{
        String sql = "update tbmovimentos set id_produto = ?,data = ?,preco = ?,"
                + "obs = ? where id = ?";
        try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);            
            stmt.setInt(1, mov.getId_prod());
            stmt.setDate(2, mov.getData());
            stmt.setFloat(3, mov.getPreco());
            stmt.setString(4, mov.getObs());            
            stmt.setInt(5, mov.getId());           
            stmt.execute();
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Pesquisa alterada com sucesso");
            
           }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void localizarProd (movimentos mov) throws SQLException {
        try {
            String sql = "select * from tbprodutos p, tbmercantil m where p.id_mercantil = m.id and p.nome = ?";
            PreparedStatement stmt = (PreparedStatement) this.Connection.prepareStatement(sql);
            stmt.setString(1, mov.getNm_prod());             
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {   
                mov.setId(rs.getInt("p.id"));
                mov.setNm_prod(rs.getString("p.nome"));
                mov.setPreco(rs.getFloat("p.preco"));
                mov.setNm_merc(rs.getString("m.nome"));
                mov.setObs(rs.getString("p.obs"));                
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void localizarMerc (movimentos mov) throws SQLException {
        try {
            String sql = "select * from tbprodutos p, tbmercantil m where p.id_mercantil = m.id and m.nome = ?";
            PreparedStatement stmt = (PreparedStatement) this.Connection.prepareStatement(sql);
            stmt.setString(1, mov.getNm_merc());             
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {   
                mov.setId(rs.getInt("p.id"));
                mov.setNm_prod(rs.getString("p.nome"));
                mov.setPreco(rs.getFloat("p.preco"));
                mov.setNm_merc(rs.getString("m.nome"));
                mov.setObs(rs.getString("p.obs"));                
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<movimentos> getLista(String sql){
       List<movimentos> all_produto = new ArrayList<movimentos>();
       try {
       PreparedStatement stm = (PreparedStatement) Connection.prepareStatement(sql);
           ResultSet rs = stm.executeQuery();
           
           while(rs.next()){
               movimentos pro = new movimentos();
                pro.setId_prod(rs.getInt("p.id"));
                pro.setNm_prod(rs.getString("p.nome"));
                pro.setPreco(rs.getFloat("p.preco"));
                pro.setNm_merc(rs.getString("m.nome"));
                pro.setObs(rs.getString("p.obs"));                              
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
