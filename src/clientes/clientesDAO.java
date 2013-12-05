
package clientes;


import conexao.conexaoSisCMP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class clientesDAO {
    private Connection Connection;
    
    public clientesDAO(){
        this.Connection = new conexaoSisCMP().getConexao();
    }
    
    public void adicionar (clientes cli) throws SQLException{
        String sql = "insert into tbclientes(nome,cpf,rua,numero,"
                + "cep,telefone, dtnasc, renda) values (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getCpf());
            stmt.setString(3, cli.getRua());
            stmt.setString(4, cli.getNum());
            stmt.setString(5, cli.getCep());
            stmt.setString(6, cli.getTel());
            stmt.setDate(7, cli.getDataNasc());
            stmt.setFloat(8, cli.getRenda());            
            stmt.execute();
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Cliente inserido com sucesso");
            
           }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void remover (clientes cli) throws SQLException{
            String sql = "delete from tbclientes where id = ?";
            try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);
            stmt.setInt(1, cli.getId());              
            stmt.execute();            
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Cliente removido com sucesso");
            }catch (SQLException e){
            System.out.println(e);
        }
    }
    
    public void alterar (clientes cli) throws SQLException{
        String sql = "update tbclientes set nome = ?,cpf = ?,rua = ?,"
                + "numero = ?,cep = ?,telefone = ?,"
                + "dtnasc = ?,renda = ? where id = ?";
        try{
            PreparedStatement stmt = (PreparedStatement) Connection.prepareStatement(sql);            
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getCpf());
            stmt.setString(3, cli.getRua());
            stmt.setString(4, cli.getNum());
            stmt.setString(5, cli.getCep());
            stmt.setString(6, cli.getTel());
            stmt.setDate(7, cli.getDataNasc());
            stmt.setFloat(8, cli.getRenda());
            stmt.setInt(9, cli.getId());            
            stmt.execute();
            stmt.close(); 
            JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso");
            
           }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void localizar (clientes cli) throws SQLException {
        try {
            String sql = "select * from tbcliente where cpf = ?";
            PreparedStatement stmt = (PreparedStatement) this.Connection.prepareStatement(sql);
            stmt.setString(1, cli.getCpf());             
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {                  
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setRua(rs.getString("rua"));
                cli.setNum(rs.getString("numero"));
                cli.setCep(rs.getString("cep"));
                cli.setTel(rs.getString("telefone"));
                cli.setDataNasc(rs.getDate("dtnasc"));
                cli.setRenda(rs.getFloat("renda"));                
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void verificar (clientes cli) throws SQLException {
        try {
            String sql = "select * from tbclientes where cpf = ?";
            PreparedStatement stmt = (PreparedStatement) this.Connection.prepareStatement(sql);
            stmt.setString(1, cli.getCpf());         
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {             
                cli.setCpf(rs.getString("cpf"));               
            }else{
                cli.setCpf("");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<clientes> getLista(String sql){
       List<clientes> all_cliente = new ArrayList<clientes>();
       try {
       PreparedStatement stm = (PreparedStatement) Connection.prepareStatement(sql);
           ResultSet rs = stm.executeQuery();
           
           while(rs.next()){
               clientes cli = new clientes();
               cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setRua(rs.getString("rua"));
                cli.setNum(rs.getString("numero"));
                cli.setCep(rs.getString("cep"));
                cli.setTel(rs.getString("telefone"));
                cli.setDataNasc(rs.getDate("dtnasc"));
                cli.setRenda(rs.getFloat("renda"));                            
               
               all_cliente.add(cli);
               
           }
       rs.close();
       stm.close();
       return all_cliente;
       
       
       } catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
           throw new RuntimeException(e);
       }                 
        
    }
    
}
