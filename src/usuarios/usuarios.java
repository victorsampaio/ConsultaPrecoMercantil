
package usuarios;

public class usuarios {

    /**
     * @return the r_nome
     */
    public static String getR_nome() {
        return r_nome;
    }

    /**
     * @param aR_nome the r_nome to set
     */
    public static void setR_nome(String aR_nome) {
        r_nome = aR_nome;
    }

    /**
     * @return the r_login
     */
    public static String getR_login() {
        return r_login;
    }

    /**
     * @param aR_login the r_login to set
     */
    public static void setR_login(String aR_login) {
        r_login = aR_login;
    }

    /**
     * @return the r_senha
     */
    public static String getR_senha() {
        return r_senha;
    }

    /**
     * @param aR_senha the r_senha to set
     */
    public static void setR_senha(String aR_senha) {
        r_senha = aR_senha;
    }

    private int id;
    private String nome;
    private String login;
    private String senha;
    private static String r_nome;    
    private static String r_login;
    private static String r_senha;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
