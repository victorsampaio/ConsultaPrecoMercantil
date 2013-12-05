/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produtos;


import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author M4RC05
 */
public class produtosTabela extends AbstractTableModel{
    
    private static final long serialVersionUID = 1L;
    // linsta de pessoas obtidas através da consulta ao banco
    private List<produtos> produto;

    // esse construtor precisa de uma lista de pessoas
    // ao invés do construtor poderia ter utilizado um setPessoas...
    public produtosTabela(final List<produtos> end) {
        this.produto = end;
    }

    @Override
    public int getColumnCount() {
        return 7;  // a Table que utilizar este modelo só terá seis colunas
    }

    @Override
    public String getColumnName(final int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "nome";   
            case 2:
                return "id_mercantil"; 
            case 3:
                return "mercantil";
            case 4:
                return "especificacao";
            case 5:
                return "preco";
            case 6:
                return "obs";                   
            default:
                return "?"; // nunca vai cair aqui
        }
    }

    @Override
    public int getRowCount() {
        return produto.size();
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        produtos end = produto.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return end.getId();
            case 1: 
                return end.getNome();  
            case 2:
                return end.getId_merc();
            case 3:
                return end.getNm_merc();
            case 4:
                return end.getEspecificacao();
            case 5:
                return end.getPreco();
            case 6:
                return end.getObs();     
            default:
                return null; // nunca vai cair aqui, pois só tem 11 colunas
        }
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        return false;
    }

    public void setData(List<produtos> end2) {

        //Esta classe altera os dados mostrados de acordo com a consulta!
        
        this.produto.clear();
        this.produto.addAll(end2);
        super.fireTableDataChanged();
    }
    
    
}
