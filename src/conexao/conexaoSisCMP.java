
package conexao;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexaoSisCMP {
    public Statement statement;
    public ResultSet resultset;
    
    public Connection getConexao(){
        System.out.println("Conectando ao Banco");
        
        try{
            return (Connection) DriverManager.getConnection("jdbc:mysql://"
                    + "localhost/siscmp","root","victor");           
        } catch (SQLException e){
            throw new RuntimeException(e);             
        }        
    }  
    
    public void executeSQL(String sql) {
        try {
            statement = (Statement) getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException sqlex) {
            System.out.println("executeSQL: NÃO FOI POSSIVEL " + "EXECUTAR O COMANDO sql " + sqlex + " , o sql passado foi: \n" + sql);
        }
    }
}
