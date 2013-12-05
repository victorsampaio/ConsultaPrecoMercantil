
package usuarios;

import conexao.conexaoSisCMP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class usuariosDAO {
    private Connection Connection;
    
    public usuariosDAO(){
        this.Connection = new conexaoSisCMP().getConexao();
    }
    public void adicionar (usuarios usu) throws SQLException{
        String sql = "insert into tbusuarios(nome,login,senha) values (?,?,?)";
        try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setString(1, usu.getNome());   
            stmt.setString(2, usu.getLogin()); 
            stmt.setString(3, usu.getSenha());             
            stmt.execute();
            stmt.close();     
            JOptionPane.showMessageDialog(null,"Usuário inserido com sucesso");
            
           }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void remover (usuarios usu) throws SQLException{
            String sql = "delete from tbusuarios where id = ?";
            try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setInt(1, usu.getId());              
            stmt.execute();            
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Usuário removido com sucesso");
            }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void alterar (usuarios usu) throws SQLException{
        String sql = "update tbusuarios set nome = ?,login = ?,senha = ? where id = ?";
        try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setString(1, usu.getNome());
            stmt.setString(2, usu.getLogin()); 
            stmt.setString(3, usu.getSenha()); 
            stmt.setInt(4, usu.getId());            
            stmt.execute();
            stmt.close();  
            JOptionPane.showMessageDialog(null,"Usuário alterado com sucesso");            
           }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void login (usuarios usu) throws SQLException{
        String sql = "select * from tbusuarios where login = ? and senha = ?";
        try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setString(1, usu.getLogin());
            stmt.setString(2, usu.getSenha());            
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();
                        
            if(rs.first()){
                usuarios.setR_nome(rs.getString("nome"));
                usuarios.setR_senha(rs.getString("senha"));
                usuarios.setR_login(rs.getString("login"));
                JOptionPane.showMessageDialog(null,"Login feito com sucesso!");                
            }else{                
                usu.setNome("");
                usu.setSenha(""); 
                JOptionPane.showMessageDialog(null,"Nome ou Senha errado!");
            }
            
            stmt.close(); 
                        
           }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void localizar (usuarios usu) throws SQLException {
        try {
            String sql = "select * from tbusuarios where nome = ?";
            PreparedStatement stmt = (PreparedStatement) this.Connection.prepareStatement(sql);
            stmt.setString(1, usu.getNome());            
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {                  
                usu.setId(rs.getInt("id"));
                usu.setNome(rs.getString("nome"));
                usu.setLogin(rs.getString("login"));                
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void verificar (usuarios usu) throws SQLException {
        try {
            String sql = "select * from tbusuarios where login = ?";
            PreparedStatement stmt = (PreparedStatement) this.Connection.prepareStatement(sql);
            stmt.setString(1, usu.getLogin());             
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {             
                usu.setNome(rs.getString("login"));               
            }else{
                usu.setNome("");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        
    public List<usuarios> getLista(String sql){
       List<usuarios> all_usuario = new ArrayList<usuarios>();
       try {
       PreparedStatement stm = (PreparedStatement) Connection.prepareStatement(sql);
           ResultSet rs = stm.executeQuery();
           
           while(rs.next()){
               usuarios usu = new usuarios();
               usu.setId(rs.getInt("id"));
               usu.setNome(rs.getString("nome"));
               usu.setLogin(rs.getString("login"));   
               usu.setSenha(rs.getString("senha"));
               
               all_usuario.add(usu);
               
           }
            rs.close();
            stm.close();
            return all_usuario;       
       
       } catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
           throw new RuntimeException(e);
       }                 
        
    }
}
