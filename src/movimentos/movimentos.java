
package movimentos;

import java.sql.Date;


public class movimentos {
    private Integer id;
    private Integer id_prod;
    private Date data;        
    private Float preco;
    private String nm_prod;
    private String nm_merc;
    private String obs;

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
     * @return the id_prod
     */
    public Integer getId_prod() {
        return id_prod;
    }

    /**
     * @param id_prod the id_prod to set
     */
    public void setId_prod(Integer id_prod) {
        this.id_prod = id_prod;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
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
     * @return the nm_prod
     */
    public String getNm_prod() {
        return nm_prod;
    }

    /**
     * @param nm_prod the nm_prod to set
     */
    public void setNm_prod(String nm_prod) {
        this.nm_prod = nm_prod;
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
