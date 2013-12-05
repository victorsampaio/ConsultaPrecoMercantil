
package estabelecimentos;

import conexao.conexaoSisCMP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class estabelecimentosDAO {
    private Connection Connection;
    
    public estabelecimentosDAO(){
        this.Connection = new conexaoSisCMP().getConexao();
    }
    
    public void adicionar (estabelecimentos func) throws SQLException{
        String sql = "insert into tbmercantil(nome,cnpj,rua,numero,"
                + "cep,telefone,obs) values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getCnpj());
            stmt.setString(3, func.getRua());
            stmt.setString(4, func.getNum());
            stmt.setString(5, func.getCep());
            stmt.setString(6, func.getTelefone());
            stmt.setString(7, func.getObs());            
            stmt.execute();
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Estabelecimento inserido com sucesso");
            
           }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void remover (estabelecimentos func) throws SQLException{
            String sql = "delete from tbmercantil where cnpj = ?";
            try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setString(1, func.getCnpj());              
            stmt.execute();            
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Estabelecimento removido com sucesso");
            }catch (SQLException e){
            System.out.println(e);
        }
    }
    
    public void alterar (estabelecimentos func) throws SQLException{
        String sql = "update tbmercantil set nome = ?,cnpj = ?,rua = ?,"
                + "numero = ?,cep = ?,telefone = ?,"
                + "obs = ? where id = ?";
        try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);            
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getCnpj());
            stmt.setString(3, func.getRua());
            stmt.setString(4, func.getNum());
            stmt.setString(5, func.getCep());
            stmt.setString(6, func.getTelefone());
            stmt.setString(7, func.getObs());
            stmt.setInt(8, func.getId());            
            stmt.execute();
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Estabelecimento alterado com sucesso");
            
           }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void localizar (estabelecimentos func) throws SQLException {
        try {
            String sql = "select * from tbmercantil where cnpj = ?";
            PreparedStatement stmt = (PreparedStatement) this.Connection.prepareStatement(sql);
            stmt.setString(1, func.getCnpj());             
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {                  
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setCnpj(rs.getString("cnpj"));
                func.setRua(rs.getString("rua"));
                func.setNum(rs.getString("numero"));
                func.setCep(rs.getString("cep"));
                func.setTelefone(rs.getString("telefone"));
                func.setObs(rs.getString("obs"));                
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void verificar (estabelecimentos func) throws SQLException {
        try {
            String sql = "select * from tbmercantil where cnpj = ?";
            PreparedStatement stmt = (PreparedStatement) this.Connection.prepareStatement(sql);
            stmt.setString(1, func.getCnpj());         
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {             
                func.setCnpj(rs.getString("cnpj"));               
            }else{
                func.setCnpj("");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<estabelecimentos> getLista(String sql){
       List<estabelecimentos> all_estabelecimento = new ArrayList<estabelecimentos>();
       try {
       PreparedStatement stm = (PreparedStatement) Connection.prepareStatement(sql);
           ResultSet rs = stm.executeQuery();
           
           while(rs.next()){
               estabelecimentos est = new estabelecimentos();
                est.setId(rs.getInt("id"));
                est.setNome(rs.getString("nome"));
                est.setCnpj(rs.getString("cnpj"));
                est.setRua(rs.getString("rua"));
                est.setNum(rs.getString("numero"));
                est.setCep(rs.getString("cep"));
                est.setTelefone(rs.getString("telefone"));
                est.setObs(rs.getString("obs"));                           
               
               all_estabelecimento.add(est);
               
           }
       rs.close();
       stm.close();
       return all_estabelecimento;
       
       
       } catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
           throw new RuntimeException(e);
       }                 
        
    }
    
}
