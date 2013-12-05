/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produtos;

/**
 *
 * @author Laegleuson
 */
public class produtos {
    private Integer id;
    private String nome;
    private String especificacao;
    private Float preco;
    private String obs;
    private Integer id_merc;
    private String nm_merc;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
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
     * @return the especificacao
     */
    public String getEspecificacao() {
        return especificacao;
    }

    /**
     * @param especificacao the especificacao to set
     */
    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    /**
     * @return the preco
     */
    public Float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Float preco) {
        this.preco = preco;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the id_merc
     */
    public Integer getId_merc() {
        return id_merc;
    }

    /**
     * @param id_merc the id_merc to set
     */
    public void setId_merc(Integer id_merc) {
        this.id_merc = id_merc;
    }

    /**
     * @return the nm_merc
     */
    public String getNm_merc() {
        return nm_merc;
    }

    /**
     * @param nm_merc the nm_merc to set
     */
    public void setNm_merc(String nm_merc) {
        this.nm_merc = nm_merc;
    }
}
